
	/* File: server.c */

	#include <stdio.h>
	#include <sys/types.h>
	#include <sys/socket.h>
	#include <netinet/in.h>

	int main(int argc, char **argv)
	{
		int fd;
		int address_len;
		struct sockaddr_in address;
		int listenfd;

		//建立套接口
		fd = socket(AF_INET, SOCK_STREAM, 0);

		//绑定地址和端口
		address.sin_family = AF_INET;
		address.sin_addr.s_addr = htonl(INADDR_ANY);
		address.sin_port = htons(1234);
		address_len = sizeof(address);
		bind(fd, (struct sockaddr *)&address, address_len);

		//建立套接口队列
		listenfd = listen(fd, 64);

		while(1) {
			struct sockaddr_in client_address;
			int len;
			int client_sockfd;
			char *data = "Server to Client String!\n";
			char data2[100];
			pid_t pid;

			printf("waiting...");
			fflush(stdout);

			//等待
			len = sizeof(client_address);
			client_sockfd = accept(fd, 
				(struct sockaddr *)&client_address, &len);

			//建立子进程
			if( (pid = fork()) == 0){	//child
				close(listenfd);
				//接收数据
				bzero((void *)data2, 100);
				readline(client_sockfd, (void *)data2, 100);
				printf("server read line:%s", data2);

				//发送数据
				writen(client_sockfd,(void *)data,strlen(data));
				printf("server send line:%s", data);

				//关闭联接并且退出
				close(client_sockfd);
				exit(0);

			}
			close(client_sockfd);		//parent
		}
	}


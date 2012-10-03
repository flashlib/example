#include<windows.h>

#include<GL/gl.h>
#include<GL/glu.h>
#include<GL/glaux.h>

#pragma comment(lib,"opengl32")
#pragma comment(lib,"glu32")
#pragma comment(lib,"glaux")

void Init(void);
void CALLBACK Display(void);

void Init(void)
{
	//clear background to black
	glClearColor(1.0,1.0,1.0,0.0);
	glShadeModel(GL_FLAT);
}

void CALLBACK Display(void)
{
	//定义32*32的位图数据
	GLubyte fly[]={0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
		          ,0x03,0x08,0x01,0xc0,0x06,0xc0,0x03,0x60
				  ,0x04,0x60,0x06,0x20,0x04,0x30,0x0c,0x20
				  ,0x04,0x18,0x18,0x20,0x04,0x0c,0x30,0x20
				  ,0x04,0x06,0x60,0x20,0x44,0x03,0xc0,0x22
				  ,0x44,0x01,0x80,0x22,0x44,0x01,0x80,0x22
				  ,0x44,0x01,0x80,0x22,0x44,0x01,0x80,0x22
				  ,0x44,0x01,0x80,0x22,0x44,0x01,0x80,0x22
				  ,0x66,0x01,0x80,0x66,0x33,0x01,0x80,0xcc
				  ,0x19,0x81,0x81,0x98,0x0c,0xc1,0x83,0x30
				  ,0x07,0xe1,0x87,0xe0,0x03,0x3f,0xfc,0xc0
				  ,0x03,0x31,0x8c,0xc0,0x03,0x33,0xcc,0xc0
				  ,0x06,0x64,0x26,0x60,0x0c,0xcc,0x33,0x30
				  ,0x18,0xcc,0x33,0x18,0x10,0xc4,0x23,0x08
				  ,0x10,0x63,0xc6,0x08,0x10,0x30,0x0c,0x08
				  ,0x10,0x18,0x18,0x08,0x10,0x00,0x00,0x08
	};

	GLubyte half[]={0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
		           ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
				   ,0xff,0xff,0xff,0xff,0x55,0x55,0x55,0x55
	};

	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0,0.0,0.0);

	//绘制一个纯黑的矩形
	glRectf(25.0,25.0,125.0,125.0);

	//绘制两个图案填充的矩形
	glEnable(GL_POLYGON_STIPPLE);
	glPolygonStipple(fly);
	glRectf(125.0,25.0,225.0,125.0);
	glPolygonStipple(half);
	glRectf(225.0,25.0,325.0,125.0);
	glDisable(GL_POLYGON_STIPPLE);

	glFlush();
}

int main(int argc,char** argv)
{
	auxInitDisplayMode(AUX_SINGLE|AUX_RGB);
	auxInitPosition(0,0,350,150);
	auxInitWindow("Polygon Stippling");
	Init();
	auxMainLoop(Display);
	return(0);
}
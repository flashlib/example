<%@page contentType="text/html" pageEncoding="gbk"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
	<head>
		<title>添加用户</title>
	</head>
	<body>
<h1>添加用户</h1>
<h:form>
用户名：<h:inputText value="#{userBean.name}"/><br/>
电子邮件：<h:inputText value="#{userBean.email}" id="email">
	<!-- 将校验器绑定到托管Bean的属性 -->
	<f:validator binding="#{userBean.validator}"/>
</h:inputText>
<h:message for="email" style="color:red;font-weight:bold"/><br/>
<h:commandButton value="添加" action="#{userBean.add}"/>
</h:form>
	</body>
</html>
</f:view>

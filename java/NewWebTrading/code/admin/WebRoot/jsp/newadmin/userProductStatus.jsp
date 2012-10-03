<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.taifook.adminportal.common.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../js/checkurl.jsp"%>
<%@ include file="../js/openhelper.jsp"%>
<html>
<head>
<title>Create Product</title>
<link href="<%=request.getContextPath()%>/jsp/css/link.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/global.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/otherClass.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
function searchKeydowm(e){
    dkey = e.keyCode;
    if(dkey=="13"){
    	if(document.userProductForm.clntId.value=="" && document.userProductForm.clntLoginId.value==""){
            alert("ClinetID and ClientLoginID cannot empty in same time!");
            document.userProductForm.clntId.focus();
        }else{
       		searchA();
        }
    }
}
function searchA(){
	if(document.userProductForm.clntId.value=="" && document.userProductForm.clntLoginId.value==""){
        alert("ClinetID and ClientLoginID cannot empty in same time!");
        document.userProductForm.clntId.focus();
    }else{
	    document.userProductForm.action="listUserProductByClientId.do?method=listUserProductByClientId";
	    document.userProductForm.submit();
    }
}

function changeStatus(index){
var statusSel=document.getElementsByName("status")[index];
var allwRenlSel=document.getElementsByName("allwRenl")[index];
if(statusSel.value=="UNAVAIL"){
	allwRenlSel.value="N";
}else{
	if(document.getElementsByName("prodId")[index].value == "SHK"){
		allwRenlSel.value = "Y";
	}
}
}

function changeAllwRenl(index){
	var statusSel=document.getElementsByName("status")[index];
	var allwRenlSel=document.getElementsByName("allwRenl")[index];
	if(statusSel.value=="UNAVAIL"){
		allwRenlSel.value="N";	
	  }
	}
function clearAll(){
	document.userProductForm.clntId.value = "";
	document.userProductForm.clntLoginId.value = "";
}
</script>
</head>
<body>
<form
	action="updateUserProductStatusList.do?method=updateUserProductStatusList"
	name="userProductForm" method="post">
<table width="50%" align="left">
	<tr bgcolor="#A5B7C5">
		<td>Client ID:<html:text property="clntId" name="userProductForm"
			size="15" onkeypress="return searchKeydowm(event);"></html:text>
		</td>
		<td>Client Login ID:<html:text property="clntLoginId" name="userProductForm"
			size="15" onkeypress="return searchKeydowm(event);"></html:text>
		</td>
		<td>
			<input type="button" name="Submit" value="Search" onclick="searchA();">&nbsp;&nbsp;&nbsp;
			<input type="button" name="Reset" value="Reset" onclick="clearAll();">
		</td>
	</tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table align="left" width="50%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>Client ID:${clientId} &nbsp;&nbsp;|&nbsp;&nbsp; Client Login ID:${clientLoginId}</td>
	</tr>   
	<tr>
		<td >
			|&nbsp;&nbsp;<html:link action="listUserProductByClientId.do?method=listUserProductByClientId&clientIdss=${userProductForm.clntId}&clientLoginIdss=${userProductForm.clntLoginId}"><font color="blue">Change User Product Status</font></html:link>
			&nbsp;|&nbsp;&nbsp;<html:link action="listCancelUserProduct.do?method=listCancelUserProduct&clientIdss=${userProductForm.clntId}&clientLoginIdss=${userProductForm.clntLoginId}"><font color="blue">Cancel User Product</font></html:link>
			&nbsp;|&nbsp;&nbsp;<html:link action="listReserveProduct.do?method=listReserveProduct&clientIdss=${userProductForm.clntId}&clientLoginIdss=${userProductForm.clntLoginId}"><font color="blue">Reserve Product</font></html:link>
			&nbsp;|&nbsp;&nbsp;<html:link action="listUserProfile.do?method=listUserProfile&clientIdss=${userProductForm.clntId}&clientLoginIdss=${userProductForm.clntLoginId}"><font color="blue">Selected Service</font></html:link> 
		</td>
	</tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table align="left" width="50%" border="0" cellpadding="0"
	cellspacing="0">
	<tr bgcolor="#A5B7C5">
		<td width="15%">Client ID</td>
		<td width="25%">Client Login ID</td>
		<td width="30%">Default Debit Account</td>
		<td width="30%">China Discount Flag</td>
	</tr>
	<logic:present name="userProfile" scope="request">
		<tr>
			<td><bean:write name="userProfile" property="clientId" /></td>
			<td><bean:write name="userProfile" property="clientLoginId" /></td>
			<td><bean:write name="userProfile" property="defaultDebitAccount" /></td>
			<td><bean:write name="userProfile" property="chinaDiscountFlag" /></td>
		</tr>
	</logic:present>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table align="left" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr bgcolor="#A5B7C5">
		<td colspan="4" align="center"><STRONG> User Product
		List </STRONG></td>
	</tr>
	<tr bgcolor="#A5B7C5">
		<td>Product ID</td>
		<td>Client ID</td>
		<td>Status</td>
		<td>Allow Renewal</td>
	</tr>
	<logic:present name="userProductList">
		<logic:iterate indexId="ids" id="userProduct" name="userProductList">
			<tr>
				<td>${userProduct.id.prodId}<input type="hidden" value="${userProduct.id.prodId}" name="prodId" /></td>
				<td>${userProduct.id.clntId}</td>
				<td><html:select name="userProduct" property="status"
					onchange="changeStatus(${ids});">
					<html:optionsCollection name="statusList" />
				</html:select><input type="hidden" value="${userProduct.status}" name="statusOld" /></td>
				<td>
				<input type="hidden" value="${userProduct.allwRenl}"
							name="allwRenlOld" />
				<c:choose>
					<c:when test='${userProduct.id.prodId=="SHK"}'>
                         <html:text name="userProduct" property="allwRenl" size="1" readonly="true"></html:text>
					</c:when>
					<c:otherwise>
						<html:select name="userProduct" property="allwRenl"
							onchange="changeAllwRenl(${ids})">
							<html:optionsCollection name="allowRenList" />
						</html:select>
				    </c:otherwise>
				 </c:choose>
                </td>
			</tr>
		</logic:iterate>
		
		<tr>
			<td><input type="submit" value="Submit"></td>
			<td><input type="reset" value="Reset"></td>
		</tr>
	</logic:present>
</table>
</form>
</body>
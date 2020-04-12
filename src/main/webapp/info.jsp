<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>我的信息</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/emp/llu",
				type:"GET",
				success:function (msg) {
					$("#name").text(msg.ename),
					$("#age").text(msg.eage),
					$("#tel").text(msg.telephone),
					$("#hiredate").text(msg.hiredate),
					$("#IDCard").text(msg.pnum),
					$("#remark").text(msg.remark),
					$("#username").text(msg.username)

				}
			})

		})

    </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
	<tr>
		<td height="26" background="skin/images/newlinebg3.gif">
			<table width="58%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td >
						当前位置:我的信息>>我的信息
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;我的信息&nbsp;</td>
		</tr>
<%--		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
			<td  align='left' id="position" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${employee.position.name}</td>
		</tr>--%>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
			<td  align='left' id="name" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${employee.ename}</td>
		</tr>
<%--		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
			<c:if test="${msg.esex==0}">
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">女</td>
			</c:if>
			<c:if test="${msg.esex==1}">
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">男</td>
			</c:if>
		</tr>--%>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
			<td align='left' id="age" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${employee.eage}</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
			<td align='left' id="tel" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${employee.telephone}</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
			<td align='left' id="hiredate" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<fmt:formatDate value="${employee.hiredate}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
			<td align='left' id="IDCard" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${employee.pnum}</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
			<td align='left' bgcolor="#FFFFFF" id="status" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">正常</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">昵称：</td>
			<td align='left' bgcolor="#FFFFFF" id="username" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' id="remark" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				${employee.remark}
			</td>
		</tr>

	</table>

</form>


</body>
</html>
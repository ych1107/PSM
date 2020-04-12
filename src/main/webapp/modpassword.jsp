<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function commit() {
			$("#message").html("");
			$("#message1").html("");
			var val = $("#oldpwd").val();
			var val1 = $("#newpwd").val();

			var val2 = $("#renewpwd").val();

			var val3 = $("#password").val();
			var val4 = $("#eid").val();
			if (val!=val3){
				$("#message").html("<font style='color: #6fbfbf'>请输入正确密码!</font>")
				return ;
			}
			if (val1!=val2||val1.trim()==""||val1==null){
				$("#message1").html("<font style='color: #6fbfbf'>两次密码不一致且不能为空！!</font>")
				return ;
			}
			if (val1==val3){
				$("#message1").html("<font style='color: #6fbfbf'>密码不能重复！!</font>")
				return ;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/emp/changPwd",
				type:"post",
				data:{"eid":val4,"password":val2},
				success:function (msg) {
					if(msg.status==200){
						alert(msg.message)
						location.href = "${pageContext.request.contextPath}/login.jsp";
					}
				}
			})
		}
	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>

 <td height="26" background="skin/images/newlinebg3.gif" >
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:我的信息>>修改密码
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;修改密码&nbsp;</td>
</tr>
	<input type="hidden" id="eid" name="eid" value="${loginUser.eid}" />
	<input type="hidden" id="password" name="password" value="${loginUser.password}"/>


<tr >

	<td align="right" bgcolor="#FAFAF1" height="22">原密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="oldpwd"/><span id="message"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">新密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="password" id="newpwd" /> <span id="message1"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">重复密码：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="password" id="renewpwd"/></td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>
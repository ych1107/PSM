<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<link href="skin/css/base.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">


function logout() {
    $.ajax({
        type: "get",
        url:"${pageContext.request.contextPath}/emp/logout",
        success:function (msg) {
            if (msg.status == 200) {
                alert(msg.message);
                window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
            }
        }
    })
}

</script>
<style>
body { padding:0px; margin:0px; }
#tpa {
	color: #009933;
	margin:0px;
	padding:0px;
	float:right;
	padding-right:10px;
}

#tpa dd {
	margin:0px;
	padding:0px;
	float:left;
	margin-right:2px;
}

#tpa dd.ditem {
	margin-right:8px;
}

#tpa dd.img {
  padding-top:6px;
}

div.item
{
  text-align:center;
	background:url(skin/images/frame/topitembg.gif) 0px 3px no-repeat;
	width:82px;
	height:26px;
	line-height:28px;
}

.itemsel {
  width:80px;
  text-align:center;
  background:#226411;
	border-left:1px solid #c5f097;
	border-right:1px solid #c5f097;
	border-top:1px solid #c5f097;
	height:26px;
	line-height:28px;
}

*html .itemsel {
	height:26px;
	line-height:26px;
}

a:link,a:visited {
 text-decoration: underline;
}

.item a:link, .item a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	font-weight: bold;
	border-bottom:2px solid #E9FC65;
}

.itemsel a:link, .itemsel a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	border-bottom:2px solid #E9FC65;
}

.rmain {
  padding-left:10px;
  /* background:url(skin/images/frame/toprightbg.gif) no-repeat; */
}
</style>
</head>
<body bgColor='#ffffff'>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="skin/images/frame/topbg.gif">
  <tr>
    <td width='20%' height="60"><img src="skin/images/frame/logo.gif" /></td>
    <td width='80%' align="right" valign="bottom">
    	<table width="750" border="0" cellspacing="0" cellpadding="0">
      <tr>
      <td align="right" height="26" style="padding-right:10px;line-height:26px;">
        	您好：${loginUser.username}，欢迎使用项目平台管理系统！
        	
        	[<a href="index.jsp" target="_top">主页</a>]
        	[<a href="modpassword.jsp"  target="_blank">修改密码</a>]
        	[<a href="javascript:void(0);" onClick="logout()">注销退出</a>]&nbsp;
      </td>
      </tr>
      <tr>
        <td align="right" height="34" class="rmain">
		
		</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
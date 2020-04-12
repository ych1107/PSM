<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑附件</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			var id= location.href.split("=")[1];
			$.ajax({
				url:"${pageContext.request.contextPath}/attach/getOne",
				type: "get",
				data:{"id":id},
				success:function (msg) {
					$("#proname").val(msg.project.pname);
					$("#attname").val(msg.attname);
					$("#attdis").val(msg.attdis);
					$("#path").text(msg.path.substring(32))
					$("#remark").val(msg.remark)
					$("#fid").val(msg.id)

				}
			})
		})
		function commit() {
			var id = $("#fid").val();
			var attname = $("#attname").val();
			var attdis = $("#attdis").val();
			var remark = $("#remark").val();
			var file = $("#attachment")[0].files[0];
			var formdata = new FormData();
			formdata.append("id",id);
			formdata.append("attname", attname);
			formdata.append("attdis", attdis);
			formdata.append("remark", remark);
			formdata.append("file", file);
			$.ajax({
				url:"${pageContext.request.contextPath}/attach/edit",
				type:"post",
				data:formdata,
				cache:false, //不要有缓存
				processData: false, //表示不要让ajax处理data数据
				contentType:false, //
				success:function (msg) {
					alert(msg.message);
					location.href = "${pageContext.request.contextPath}/project-file.jsp";
				}
			})
		}
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
    当前位置:项目管理>>编辑附件
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" enctype="multipart/form-data" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<input name="id" id="fid" type="hidden"  />
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑附件&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">所属项目：</td>
	<td  align='left' id="proname" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">农业银行自助管理系统</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件名称：</td>
	<td  align='left'  bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="attname" name="attname" value="帐户管理功能分析图"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件信息描述：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="attdis" name="attdis" value="暂无"/></td>
</tr>


<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件1：</td>
	<td  align='left' bgcolor="#FFFFFF"  onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><span id="path">帐户管理功能分析图.jpg</span>
		<input name="file" id="attachment" type="file"/>&nbsp;&nbsp;&nbsp;<a>添加</a>&nbsp;&nbsp;&nbsp;<a>删除</a>
</tr >
	
<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea id="remark" name="remark"  rows=10 cols=130>暂无</textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
	<a href="javascript:history.back()" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>
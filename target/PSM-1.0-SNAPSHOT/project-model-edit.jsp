<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>编辑模块信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			var id = location.href.split("=")[1];
			$.ajax({
				url:"${pageContext.request.contextPath}/module/getOne",
				type: "get",
				data:{"id":id},
				success:function (msg) {
					$("#modname").val(msg.modname);
					$("#level").find("option").each(function () {
						if($(this).val()==msg.level){
							$(this).attr("selected", "selected");
						}
					})
					$("#simpledis").val(msg.simpledis);
					$("#detaileddis").val(msg.detaileddis);
					$("#remark").val(msg.remark);
					$("#mid").val(msg.id);
					$.ajax({
						url:"${pageContext.request.contextPath}/pneed/list",
						type: "get",
						success:function (result) {
							$(result).each(function(index,item) {
								if(item.proname==msg.proname){
									$("#proname").append("<option value='"+item.id+","+item.proname+"' selected>"+item.proname+"</option>");
									$("#anayneed").text(msg.analysis.title);
									$("#anayneed").val(msg.analysis.id);
								}else{
									$("#proname").append("<option value='"+item.id+","+item.proname+"'>"+item.proname+"</option>");
								}

							})
						}
					})
				}
			})
		})
		function changes(abj) {
			var pid = abj.split(",")[0];
			$.ajax({
				url:"${pageContext.request.contextPath}/pneed/getOne",
				data:{"id":pid},
				success:function (msg) {
					$("#anayneed").text(msg.title)
					$("#anayneed").val(msg.id)
				}
			})
		}
		function commit() {
			var paid = $("#proname").val();
			var forms = $("#form2").serialize();
			$.ajax({
				url:"${pageContext.request.contextPath}/module/edit/"+paid,
				type: "post",
				data:forms,
				success:function (msg) {
					alert(msg.message)
					location.href = "${pageContext.request.contextPath}/project-model.jsp";
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
    当前位置:项目管理>>编辑模块信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑模块&nbsp;</td>
</tr>
<tr >
	<input type="hidden" name="id" id="mid" />
	<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proname" name="pronameandid" onchange="changes(this.value)"  >
			<option>农业银行自助管理系统</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="analysisFk">
			<option id="anayneed">帐户管理需求分析</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">模块名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="modname" name="modname" value="帐户管理模块"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="level" name="level">
			<option>高</option>
			<option>中</option>
			<option>低</option>
			<option>暂缓</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea id="simpledis" name="simpledis"  rows=10 cols=130>管理农行帐户信息</textarea></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea id="detaileddis" name="detaileddis" rows=15 cols=130>帐户管理各功能的详细详细信息如下</textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea id="remark" name="remark" rows=10 cols=130>暂无</textarea>
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
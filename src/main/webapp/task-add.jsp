<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function () {
			//选择执行人
			$.ajax({
				url:"${pageContext.request.contextPath}/emp/getAll",
				type: "get",
				success:function (msg) {
					$(msg).each(function (index, item) {

						$("#empFk2").append("<option value='"+item.eid+"'>"+item.ename+"--"+item.position.name+"</option>");
					})
				}
			})
			//通过需求表查看项目信息和需求信息
			$.ajax({
				url:"${pageContext.request.contextPath}/pneed/list",
				type: "get",
				success:function (msg) {
					$(msg).each(function(index,item) {
						$("#proname").append("<option value='"+item.id+","+item.proname+"'>"+item.proname+"</option>");
					})
				}
			})
		})
		function changes(abj) {
			var pid = abj.split(",")[0];
			if(abj!=0){
				$.ajax({
					url:"${pageContext.request.contextPath}/pneed/getOne",
					data:{"id":pid},
					success:function (msg) {
						$("#analneed").attr("selected", "selected");
						$("#analneed").text(msg.title)
						$("#analneed").val(msg.id)
						//通过需求id确定他存在几个功能
								var cid = msg.id;
								$.ajax({
									url:"${pageContext.request.contextPath}/module/models",
									type: "get",
									data:{"cid": cid},
									success:function (result) {
										$("#modeleFk").find("option").remove();
										$("#functionsFk").find("option").remove();
										$("#modeleFk").append("<option value='0' selected>请选择</option>");
										$("#functionsFk").append("<option value='0' selected>请选择</option>");
										if(result.length==0){
											$("#modeleFk").append("<option>此项目暂无模块！</option>");
										}else{
											$(result).each(function (index, item) {
												$("#modeleFk").append("<option value='"+item.id+"'>"+item.modname+"</option>");
											})
										}

									}
								})
					}
				})
			}else{
				//当点击请选择的时候  移除后面模块添加的option
				$("#analneed").attr("selected", "selected");
				$("#analneed").text("请选择")
				$("#analneed").val(0)

				$("#modeleFk").find("option").remove();
				$("#functionsFk").find("option").remove();

				$("#modeleFk").append("<option value='0' selected>请选择</option>");
				$("#functionsFk").append("<option value='0' selected>请选择</option>");
			}
		}
		//模块选项变化是触发
		function changeFunc(abj) {
			if(abj!=0){
				$("#functionsFk").find("option").remove();
				$("#functionsFk").append("<option value='0' selected>请选择</option>");
				$.ajax({
					url:"${pageContext.request.contextPath}/fun/getFuncs",
					type: "post",
					data:{"id":abj},
					success:function (msg) {
						if(msg.length==0){
							$("#functionsFk").append("<option>此模块暂无模块！</option>");
						}else{
							$(msg).each(function (index, item) {
								$("#functionsFk").append("<option value='"+item.id+"'>"+item.functionname+"</option>");
							})
						}
					}
				})
			}else{
				$("#functionsFk").find("option").remove();
				$("#functionsFk").append("<option value='0' selected>请选择</option>");
			}
		}
		function commit() {
			var forms = $("#form2").serialize();
			$.ajax({
				url:"${pageContext.request.contextPath}/task/saveInfo",
				type: "post",
				data:forms,
				success:function (msg) {
					location.href = "${pageContext.request.contextPath}/task.jsp";
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
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<input name="status" value="0" type="hidden" />
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proname" onchange="changes(this.value)">
			<option value="0">请选择</option>
		</select>-
		<select>
			<option id="analneed" >请选择</option>
		</select>-
		<select id="modeleFk" onchange="changeFunc(this.value)">
			<option value=0>请选择</option>
		</select>-
		<select id="functionsFk" name="funFk">
			<option value=0>请选择</option>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="tasktitle" type="text"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input class="Wdate" name="starttime" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/></td></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input class="Wdate" name="endtime" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"/></td></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="empFk2" name="empFk2">
		</select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level">
			<option>高</option>
			<option>中</option>
			<option>低</option>
			<option>暂缓</option>
		</select></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="remark" rows=10 cols=130></textarea>
	</td>
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
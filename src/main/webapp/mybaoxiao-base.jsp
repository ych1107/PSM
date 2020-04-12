<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>附件管理</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data.js"></script></head>
	<script type="text/javascript">

		function pagesadd(msg){
			$(msg.map.page.list).each(function (index, item) {
				var stastus ="";
				if(item.bxstatus==0){
					stastus = "未审批";
				}else if (item.bxstatus==1){
					stastus = "驳回";
				} else{
					stastus = "已付款";
				}
				var tr  = 	"<tr name='addtr' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
						+"<td><input name='id' type='checkbox' id='id' value='"+item.bxid+"' class='np'></td>"
						+"<td>"+(index+1)+"</td>"
						+"<td>"+item.totalmoney+"</td>"
						+"<td align='center'>"+getMyDate(item.bxtime)+"</td>"
						+"<td>"+item.bxremark+"</td>"
						+"<td>"+stastus+"</td>"
						+"<td><a href='mybaoxiao-edit.jsp?bxid="+item.bxid +"'>编辑</a> </td>"
						+"</tr>"
				$("#mark").before(tr);
			})
			//添加分页
			var firstPage = "<a href='"+msg.map.requestURI+"?pageNum=1"+msg.map.queryStr+"'>首页</a>&nbsp;"
			var prePage = "<a href='"+msg.map.requestURI+"?pageNum="+(msg.map.page.pageNum-1)+msg.map.queryStr+"'>上一页</a>"
			$("#pages").append(firstPage).append(prePage);
			$(msg.map.page.navigatepageNums).each(function (index,num) {
				if(num==msg.map.page.pageNum){
					var a = "【"+num+"】";
				}else{
					var a = "<a href='"+msg.map.requestURI+"?pageNum="+(num)+msg.map.queryStr+"'>"+num+"</a>"
				}
				$("#pages").append(a);
			})
			var lastPage = "<a href='"+msg.map.requestURI+"?pageNum="+msg.map.page.total+msg.map.queryStr+"'>尾页</a>"
			var nextPage = "&nbsp;<a href='"+msg.map.requestURI+"?pageNum="+(msg.map.page.pageNum+1)+msg.map.queryStr+"'>下一页</a>&nbsp;"
			$("#pages").append(nextPage).append(lastPage)
			var tz = "跳转到：<input id='tzpage'   type='text' size='2px'/>"
			$("#pages").append(tz);
			$("#pages").find("[id=tzpage]").on("blur",function () {
				var pageNum = $(this).val();
				var reg = /^[1-9]\d*$/;
				if(!reg.test(pageNum)){
					alert("请输入正确页码");
					return ;
				}
				$("tr[name=addtr]").remove();
				$("#pages").html("");
				$.ajax({
					url:""+msg.map.requestURI+"?pageNum="+pageNum+msg.map.queryStr+"",
					success:function (msg) {
						pagesadd(msg)
					}
				})


			})
			$("#pages").find("a").on("click",function () {
				$("tr[name=addtr]").remove();
				$("#pages").html("");
				var path = this.href;
				$.ajax({
					url:path,
					success:function (msg) {
						pagesadd(msg)
					}
				})
				return false;
			})
		}
		$(function () {
			$.ajax({
				url:"${pageContext.request.contextPath}/bx/seachBypage",
				success:function (msg) {
					pagesadd(msg)
				}
			})
		})
			//搜索表单
			function search() {
				$("tr[name=addtr]").remove();
				$("#pages").html("");
				var search_cid = $("#search_cid").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/bx/seachBypage",
					data:{"search_cid":search_cid},
					success:function (msg) {
						pagesadd(msg)
					}
			})
		}

	</script>

</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:个人报销管理>>报销列表
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='mybaoxiao-add.jsp';" value='添加报销' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id='form3' action="javascript:void(0)" method='post'>
	<input type='hidden' name='dopost' value='' />
	<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
		<tr bgcolor='#EEF4EA'>
			<td background='skin/images/wbg.gif' align='center'>
				<table border='0' cellpadding='0' cellspacing='0'>
					<tr>
						<td width='90' align='center'>搜索条件：</td>
						<td width='160'>
							<select id="search_cid" name='search_cid' style='width:150px'>
								<option name="types"  value="0">未审批</option>
								<option name="types" value="1">驳回</option>
								<option name="types" value="2">已付款</option>
							</select>
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;<input onclick="search()" name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%"  cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="20%">编号</td>
	<td width="6%">总金额</td>
	<td width="10%">使用时间</td>
	<td width="40%">备注信息</td>
	<td width="10%">审批状态</td>
	<td width="10%">操作</td>
</tr>


<tr id="mark"></tr>
	<tr align="right" bgcolor="#EEF4EA">
		<td height="36" colspan="12" align="center">
			<div id="pages">

			</div>
		</td></tr>

</table>

</form>
  

</body>
</html>
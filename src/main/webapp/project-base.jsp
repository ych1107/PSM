<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>项目信息管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function (){
            $.ajax({
                url:"${pageContext.request.contextPath}/pro/list",
                type:"get",
                success:function (msg) {
                    var length = Object.keys(msg).length;
                    $(msg.reverse()).each(function (index, item) {
                   var ar ="<tr name='Infott' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                            +"<td><input name='id' type='checkbox' id='id' value='"+item.pid+"' class='np'></td>"
                            +"<td>"+(length-index)+"</td>"
                            +"<td align='left'><a href=''><u>"+item.pname+"</u></a></td>"
                            +" <td>"+item.customer.comname+"</td>"
                            +"<td>"+item.comper+"</td>"
                            +" <td>"+item.employee.ename+"</td>"
                            +" <td>"+item.empcount+"</td>"
                            +" <td>"+getMyDate(item.starttime)+"</td>"
                            +" <td>"+getMyDate(item.buildtime)+"</td>"
                            +" <td>"+getMyDate(item.endtime)+"</td>"
                            +" <td>进行中</td>"
                            +"<td><a href='project-base-edit.jsp?id="+item.pid+"'>编辑</a> | <a href='project-base-look.jsp?id="+item.pid+"'>查看详情</a></td>"
                            +"</tr>";
                        $("#titleId").after(ar);
                    })
                }
            })
        })
        function getMyDate(str){
            var oDate = new Date(str),
                oYear = oDate.getFullYear(),
                oMonth = oDate.getMonth()+1,
                oDay = oDate.getDate(),
                oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) ;//最后拼接时间
            return oTime;
        };
        function getzf(num){
            if(parseInt(num) < 10){
                num = '0'+num;
            }
            return num;
        }

        function quan() {
         $("[name=id]").attr("checked",true);
        }
        function fan() {
            var attr = $("[name=id]");
            $(attr).each(function () {
                $(this).attr("checked",!( $(this).attr("checked")))
            })
        }
        function batchdel() {
            var atr = $("[name=id]:checked");
            var ids=[];
            $(atr).each(function () {
                var id=  $(this).val();
                ids.push(id);
            })
           $.ajax({
               url:"${pageContext.request.contextPath}/pro/del",
               type:"post",
               data:{"_method":"delete","ids":ids},
               success:function (msg) {
                   location.href="${pageContext.request.contextPath}/project-base.jsp";
                   alert(msg.message)
               }
           })
        }
        function commit() {
            var cid = $("#cid").val();
            var keyword = $("#keyword").val();
            var orderby = $("#orderby").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/pro/search",
                type:"post",
                data:{"cid":cid,"keyword":keyword,"orderby":orderby},
                success:function (msg) {
                    $("#find_list").find("tr[name='Infott']").remove();
                    var length = Object.keys(msg).length;
                    $(msg.reverse()).each(function (index, item) {
                        var ar ="<tr name='Infott' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                            +"<td><input name='id' type='checkbox' id='id' value='"+item.pid+"' class='np'></td>"
                            +"<td>"+(length-index)+"</td>"
                            +"<td align='left'><a href=''><u>"+item.pname+"</u></a></td>"
                            +" <td>"+item.customer.comname+"</td>"
                            +"<td>"+item.comper+"</td>"
                            +" <td>"+item.employee.ename+"</td>"
                            +" <td>"+item.empcount+"</td>"
                            +" <td>"+getMyDate(item.starttime)+"</td>"
                            +" <td>"+getMyDate(item.buildtime)+"</td>"
                            +" <td>"+getMyDate(item.endtime)+"</td>"
                            +" <td>进行中</td>"
                            +"<td><a href='project-base-edit.jsp?id="+item.pid+"'>编辑</a> | <a href='project-base-look.jsp?id="+item.pid+"'>查看详情</a></td>"
                            +"</tr>";
                        $("#titleId").after(ar);
                    })
                }
            })
        }
        function excels() {
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/pro/excel",
                success:function (msgs) {
                    //成功的话弹出提示框
                    if (confirm("确定要导出到excel吗？")){
                        alert(msgs.success)
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
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>基本信息管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='project-base-add.jsp';" value='添加新项目' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form id='form3' action='javascript:void(0)' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select id='cid' style='width:150px'>
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>项目经理</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' id='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select id='orderby' style='width:120px'>
            <option value='0'>排序...</option>
            <option value='1'>立项时间</option>
            <option value='2'>计划完成时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" onclick="commit()" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table id="find_list" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
</tr>
<tr id="titleId" align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">项目名称</td>
	<td width="10%">客户公司名称</td>
	<td width="10%">客户方负责人</td>
	<td width="5%">项目经理</td>
	<td width="8%">开发人员数</td>
	<td width="6%">立项时间</td>
	<td width="8%">最近更新时间</td>
	<td width="8%">计划完成时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:quan()" class="coolbg">全选</a>
	<a href="javascript:fan()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchdel()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="javascript:excels()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>
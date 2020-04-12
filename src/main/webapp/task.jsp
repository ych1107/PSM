<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>任务信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data.js"></script></head>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/task/getAll",
                type: "get",
                success:function (msg) {
                    $(msg).each(function (index, item) {
                    var tr =  "<tr align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                            +"<td><input name='id' type='checkbox' id='id' value='101' class='np'></td>"
                         +"  <td>"+(index+1)+"</td>"
                         +"  <td>"+item.tasktitle+"</td>"
                         +"  <td align='center'>"+item.employee.ename+"</td>"
                         +"  <td align='center'>"+(item.status == 0 ? '未开始':(item.status == 1?'已开始':'已完成'))+"</td>"
                         +"  <td align='center'>"+item.level+"</td>"
                         +"  <td>"+getMyDate(item.starttime)+"</td>"
                         +"  <td>"+getMyDate(item.endtime)+"</td>"
                         +"  <td><a id='beg_"+item.id+"'  >开始任务</a> | <a >任务完成</a> | <a href='task-edit.jsp'>编辑</a> | <a href='task-look.jsp'>查看详情</a></td>"
                            +" </tr>"
                        $("#mark").before(tr);
                    })
                    $("a[id ^= beg_]").click(function () {
                        var tid = $(this).attr("id").split("_")[1];
                        var td = $(this).parent().parent().find("td:eq(4)");
                        $.ajax({
                            url:"${pageContext.request.contextPath}/task/updateStatus",
                            data:{"id":tid, "status": "1"},
                            success:function (msg) {
                                alert(msg.message);
                                td.text("已开始");
                            }
                        })
                    })
                }
            })
        })
        function quan() {
            $("[name=id]").attr("checked","checked");
        }
        function fan() {
            var checkbox = $("[name=id]");
            $(checkbox).each(function () {
                $(this).attr("checked",!($(this).attr("checked")));
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
    当前位置:任务管理>>任务信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr> <td width='90' align='center'>状态：</td>
          <td width='160'>
          <select name='cid' style='width:150px'>
          <option value='0'>请选择</option>
          	<option value='1'>未开始</option>
          	<option value='1'>进行中</option>
          	<option value='1'>已完成</option>
          </select>
        </td>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150px'>
          <option value='0'>选择类型...</option>
          	<option value='1'>任务标题</option>
          	<option value='1'>执行者</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>开始时间</option>
            <option value='pubdate'>结束时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table id="trs" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;任务信息&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">任务标题</td>
	<td width="10%">执行者</td>
	<td width="8%">状态</td>
	<td width="8%">优先级</td>
	<td width="8%">开始时间</td>
	<td width="8%">结束时间</td>
	<td width="15%">操作</td>
</tr>




<tr id="mark" bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:quan()" class="coolbg">全选</a>
	<a href="javascript:fan()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchdel()" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>
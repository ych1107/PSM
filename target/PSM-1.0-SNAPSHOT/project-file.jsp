<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>附件管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data.js"></script></head>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/attach/list",
            type:"get",
            success:function (msg) {
                $(msg).each(function (index, item) {
                    var tr ="<tr name='addtr' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                        +"<td><input name='id' type='checkbox' id='id' value='"+item.id+"' class='np'></td>"
                        +" <td>"+(index+1)+"</td>"
                        +" <td>"+item.attname+"</td>"
                        +" <td align='center'><a href=''><u>"+item.project.pname+"</u></a></td>"
                        +" <td>"+item.count+"</td>"
                        +" <td>2015-02-03</td>"
                        +" <td>2015-06-03</td>"
                        +" <td><a href='#'>下载</a> |<a href='project-file-edit.jsp?id="+item.id+"'>编辑</a> | <a href='project-file-look.jsp?id="+item.id+"'>查看详情</a></td>"
                        +" </tr>"
                    $("#mark").before(tr);
                })
            }
        })
    })
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
        alert(ids)
        $.ajax({
            url:"${pageContext.request.contextPath}/attach/batchdel",
            type:"post",
            data:{"_method":"delete","ids":ids},
            success:function (msg) {
                location.href="${pageContext.request.contextPath}/project-file.jsp";
                alert(msg.message)
            }
        })
    }

    function search() {
        var cid = $("#cid").val();
        var keyword = $("#keyword").val();
        var orderby = $("#orderby").val();
        $("[name=addtr]").remove()
        $.ajax({
            url:"${pageContext.request.contextPath}/attach/search",
            type:"post",
            data:{"cid":cid,"keyword":keyword,"orderby":orderby},
            success:function (msg) {
                $("#trs").find("tr[name=addtr]").remove();
                $(msg).each(function (index, item) {
                    var tr ="<tr name='addtr' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                        +"<td><input name='id' type='checkbox' id='id' value='"+item.id+"' class='np'></td>"
                        +" <td>"+(index+1)+"</td>"
                        +" <td>"+item.attname+"</td>"
                        +" <td align='center'><a href=''><u>"+item.project.pname+"</u></a></td>"
                        +" <td>"+item.count+"</td>"
                        +" <td>2015-02-03</td>"
                        +" <td>2015-06-03</td>"
                        +" <td><a href='#'>下载</a> |<a href='project-file-edit.jsp?id="+item.id+"'>编辑</a> | <a href='project-file-look.jsp?id="+item.id+"'>查看详情</a></td>"
                        +" </tr>"
                    $("#mark").before(tr);
                })
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
    当前位置:项目管理>>附件管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='project-file-add.jsp';" value='添加新附件' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='javascript:void(0)' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='1' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' id="cid" style='width:150px'>
          <option value='0'>选择类型...</option>
          	<option value='1'>附件名称</option>
          	<option value='2'>项目名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' id="keyword" value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' id="orderby" style='width:120px'>
            <option value='0'>排序...</option>
            <option value='0'>id升序</option>
            <option value='1'>id降序</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" onclick="search()" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table id="trs" width="98%" border="1" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">附件名称</td>
	<td width="10%">所属项目</td>
	<td width="10%">附件个数</td>
	<td width="8%">上传时间</td>
	<td width="8%">修改时间</td>
	<td width="13%">操作</td>
</tr>




<tr id="mark" bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:quan()" class="coolbg">全选</a>
	<a href="javascript:fan()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchdel()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>
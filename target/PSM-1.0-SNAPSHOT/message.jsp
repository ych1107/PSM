<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>发件箱</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/data.js"></script></head>
<script type="text/javascript">

    function pagesadd(msg){
        $(msg.map.page.list).each(function (index, item) {

            var tr  = 	"<tr align='center' name='addtr' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >" +
                "<td><input name='id' type='checkbox' id='"+item.id+"' value='101' class='np' /></td>" +
                "<td>"+(index+1)+"</td>" +
                "<td>"+item.title+"</td>" +
                "<td align='center'><span>absufb</span></td>" +
                "<td>"+item.ename+"</td>" +
                "<td>"+item.sendtime+"</td>" +
                "<td><a >删除</a></td>" +
                "</tr>";
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
            url:"${pageContext.request.contextPath}/info/seachBypage",
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
            url:"${pageContext.request.contextPath}/info/seachBypage",
            data:{"search_cid":search_cid},
            success:function (msg) {
                pagesadd(msg)
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
    当前位置:信息箱>>发件箱
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='javascript:void(0)' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='search_cid' style='width:150px'>
          <option value='1'>选择类型...</option>
          	<option value='1'>标题</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='search_like_keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='search_orderby' style='width:120px'>
            <option value='0'>排序...</option>
            <option value='1'>发送时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input onclick="search()" name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
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
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;发件箱&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">标题</td>
	<td width="10%">内容</td>
	<td width="10%">收件人</td>
	<td width="8%">发送时间</td>
	<td width="8%">操作</td>
</tr>



<tr id="mark" bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
    <tr align="right" bgcolor="#EEF4EA">
        <td height="36" colspan="12" align="center">
            <div id="pages"></div>
        </td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>
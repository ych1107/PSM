<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>客户信息管理</title>
    <style>
        #uploadImg{
            font-size:16px;
            overflow:hidden;
            position:absolute
        }
        #file{
            position:absolute;
            z-index:100;
            margin-left:-180px;
            font-size:60px;
            opacity:0;
            filter:alpha(opacity=0); margin-top:-5px;
        }
    </style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>

    <script>
        //全选
        function quan(){
           /* //1、获取所有复选框对象
            var arr = document.getElementsByClassName("itemSelect");
            //2、设置其状态为选中    checked：true(被选中) false(不被选中)
            for(var i=0;i<arr.length;i++){
                arr[i].checked = true;
            }*/
           $("[name=id]").prop("checked",true);
        }
        //反选
        function fan(){
            /*//1、获取所有复选框对象
            var arr = document.getElementsByClassName("itemSelect");
            for(var i=0;i<arr.length;i++){
                //方式一
                /!*if(arr[i].checked){
                    arr[i].checked = false;
                }else{
                    arr[i].checked = true;
                }*!/
                //方式二
                arr[i].checked = !arr[i].checked;
            }*/
            var name = $("[name=id]");
            $.each(name,function (){
                $(this).prop("checked",!($(this).prop("checked")));
            })
        }
        
        function batchDelete() {
            var cc = "";
            var s = $("[name=id]:checked");
            $(s).each(function () {

                cc=cc+$(this).val()+",";
            })
            var cid = cc.substring(0,cc.length-1);
            $.ajax({

                url:"${pageContext.request.contextPath}/cust/batchDelete/"+cid,
                type:"post",
                success:function (msg) {
                    if(msg.status==200){
                        alert(msg.message)
                        location.href="${pageContext.request.contextPath}/cust/list";
                    }else {
                        alert(msg.message)
                    }
                }
            })
        }
        function exportExcel() {
            var ids=[]
            $("#trs").find("[name=id]").each(function () {
                ids.push($(this).val());
            })
            $.ajax({
                url:"${pageContext.request.contextPath}/cust/exportExcel",
                type:"get",
                data:{"ids":ids},
                success:function (msg) {
                    alert(msg.message);
                }
            })
        }
        //上传Excel
        function importExcel() {
            var formData = new FormData();
            var interval = setInterval(function () {
                var file = $("#file")[0].files[0];
                if(file != undefined){
                    formData.append("file",file);
                    //取消定时器
                    clearInterval(interval);
                    $.ajax({
                        type:"POST",
                        url:"${pageContext.request.contextPath}/cust/import",
                        data:formData,
                        processData: false,
                        contentType:false,
                        cache:false,
                        success:function (msg) {
                            if(msg.statusCode == 200){
                                alert(msg.message);
                            }
                        }
                    });
                }
            },1000);

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
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/customer-add.jsp';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form id='form3' action="${pageContext.request.contextPath}/cust/searchBypage" method='post'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='search_cid' style='width:150px'>
          <option name="types"  value="0">选择类型...</option>
          	<option name="types" value="1">客户所在公司名称</option>
          	<option name="types" value="2">联系人姓名</option>
          </select>
        </td>
        <td width='70' >
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='search_like_keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='search_orderby'  style='width:120px'>
            <option value='0'>排序...</option>
            <option value='0'>按id升序</option>
            <option value='1'>按id降序</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
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
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>
<c:forEach items="${page.list}" var="customer" varStatus="index">
    <tr align='center'  bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
        <td><input name="id" type="checkbox" id="id" value="${customer.id}" class="np itemSelect"></td>
        <td>${index.count}</td>
        <td>${customer.companyperson}</td>
        <td align="center">${customer.comname}</td>
        <td>
            <fmt:formatDate value="${customer.addtime}" pattern="yyyy-MM-dd" />
        </td>
        <td>${customer.comphone}</td>
        <td><a href="${pageContext.request.contextPath}/cust/edit/${customer.id}">编辑</a> | <a href="${pageContext.request.contextPath}/cust/detail/${customer.id}">查看详情</a></td>
    </tr>

</c:forEach>


<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:quan()" class="coolbg">全选</a>
	<a href="javascript:fan()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchDelete()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="javascript:exportExcel()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
    <span id="uploadImg">
       <input type="file" id="file" size="1"onclick="importExcel()" >
       <a href="javascript:void(0)" >上传Excel</a>
    </span>
</td>
</tr>
<jsp:include page="page.jsp"></jsp:include>
</table>

</form>
  

</body>
</html>
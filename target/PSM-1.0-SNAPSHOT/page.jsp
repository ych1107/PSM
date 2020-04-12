<%--
  Created by IntelliJ IDEA.
  User: 78027
  Date: 2019/12/3
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<tr align="right" bgcolor="#EEF4EA">
    <td height="36" colspan="12" align="center">

        <c:if test="${!page.isFirstPage}">
            <a href="${requestURI}?pageNum=1${queryStr}">首页</a>
            <a href="${requestURI}?pageNum=${page.pageNum-1}${queryStr}">上一页</a>
        </c:if>
        <c:forEach items="${page.navigatepageNums}" var="num">
            <c:if test="${page.pageNum==num}">
                【${num}】
            </c:if>
            <c:if test="${page.pageNum!=num}">
                <a href="${requestURI}?pageNum=${num}${queryStr}">${num}</a>
            </c:if>
        </c:forEach>

        <c:if test="${!page.isLastPage}">
            <a href="${requestURI}?pageNum=${page.pageNum+1}${queryStr}">下一页</a>
            <a href="${requestURI}?pageNum=${page.total}${queryStr}">尾页</a>&nbsp;&nbsp;&nbsp;
        </c:if>

        跳转到：<input id="pages" type="text" size="2px"/>
        <script type="text/javascript">
            $("#pages").blur(function () {
                var pageNum = $(this).val();
                var reg = /^[1-9]\d*$/;
                if(!reg.test(pageNum)){
                    alert("请输入正确页码");
                    return ;
                }
                window.location.href="${requestURI}?pageNum="+pageNum+"${queryStr}";

            })
        </script>
    </td>
</tr>
</html>

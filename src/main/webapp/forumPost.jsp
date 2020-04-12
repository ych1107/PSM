<%--
  Created by IntelliJ IDEA.
  User: 78027
  Date: 2019/12/5
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" charset="utf-8" src="static/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="static/js/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="static/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function () {
        var ue = UE.getEditor('editor');
        $("#btn").click(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/forumpost/saveInfo",
                type:"post",
                data: $("#form2").serialize(),
                success:function (msg) {
                    if (msg.map.status == 200) {
                        location.href="${pageContext.request.contextPath}/main.jsp";
                    }
                }
            })
        })

    })
</script>
<body>
<form id="form2" >

    标题：<input type="text" name="forumtitle" />
    <script id="editor" name="forumcontent" type="text/plain" style="width:1024px;height:500px;"></script>
    <input type="button" value="保存" id="btn" />

        </form>
    </body>
</html>

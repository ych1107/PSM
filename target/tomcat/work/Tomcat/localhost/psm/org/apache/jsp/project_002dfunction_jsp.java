/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-21 08:44:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class project_002dfunction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\r\n");
      out.write("<title>功能管理</title>\r\n");
      out.write("   <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin/css/base.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.7.2.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/fun/list\",\r\n");
      out.write("                type: \"get\",\r\n");
      out.write("                success:function (msg) {\r\n");
      out.write("                    $(msg).each(function (index, item) {\r\n");
      out.write("                        var tr = \"<tr name='addtr' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >\"\r\n");
      out.write("                           +\" <td><input name='id' type='checkbox' id='id' value='\"+item.id+\"' class='np'></td>\"\r\n");
      out.write("                        +\" <td>\"+(index+1)+\"</td>\"\r\n");
      out.write("                        +\"  <td align='center'><a href=''><u>\"+item.functionname+\"</u></a></td>\"\r\n");
      out.write("                        +\" <td align='center'><a href=''><u>\"+item.module.modname+\"</u></a></td>\"\r\n");
      out.write("                        +\" <td align='center'><a href=''><u>\"+item.analysisname+\"</u></a></td>\"\r\n");
      out.write("                        +\" <td align='center'><a href=''><u>\"+item.proname+\"</u></a></td>\"\r\n");
      out.write("                        +\"  <td>\"+item.level+\"</td>\"\r\n");
      out.write("                        +\"  <td>2015-02-03</td>\"\r\n");
      out.write("                        +\"  <td>2015-06-03</td>\"\r\n");
      out.write("                        +\"  <td><a href='project-function-edit.jsp?id=\"+item.id+\"'>编辑</a> | <a href='project-function-look.jsp?id=\"+item.id+\"'>查看详情</a></td>\"\r\n");
      out.write("                        +\"  </tr>\"\r\n");
      out.write("                        $(\"#mark\").before(tr);\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("        function quan() {\r\n");
      out.write("            $(\"[name=id]\").attr(\"checked\",true);\r\n");
      out.write("        }\r\n");
      out.write("        function fan() {\r\n");
      out.write("            var attr = $(\"[name=id]\");\r\n");
      out.write("            $(attr).each(function () {\r\n");
      out.write("                $(this).attr(\"checked\",!( $(this).attr(\"checked\")))\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("        function batchdel() {\r\n");
      out.write("            var atr = $(\"[name=id]:checked\");\r\n");
      out.write("            var ids=[];\r\n");
      out.write("            $(atr).each(function () {\r\n");
      out.write("                var id=  $(this).val();\r\n");
      out.write("                ids.push(id);\r\n");
      out.write("            })\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/fun/batchdel\",\r\n");
      out.write("                type:\"post\",\r\n");
      out.write("                data:{\"_method\":\"delete\",\"ids\":ids},\r\n");
      out.write("                success:function (msg) {\r\n");
      out.write("                    alert(msg.message)\r\n");
      out.write("                    location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/project-function.jsp\";\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function search() {\r\n");
      out.write("            var cid = $(\"#cid\").val();\r\n");
      out.write("            var keyword = $(\"#keyword\").val();\r\n");
      out.write("            var orderby = $(\"#orderby\").val();\r\n");
      out.write("            $(\"[name=addtr]\").remove()\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/fun/search\",\r\n");
      out.write("                type:\"post\",\r\n");
      out.write("                data:{\"cid\":cid,\"keyword\":keyword,\"orderby\":orderby},\r\n");
      out.write("                success:function (msg) {\r\n");
      out.write("                    $(\"#trs\").find(\"tr[name=addtr]\").remove();\r\n");
      out.write("                    $(msg).each(function (index, item) {\r\n");
      out.write("                        var tr = \"<tr name='addtr' align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >\"\r\n");
      out.write("                            +\" <td><input name='id' type='checkbox' id='id' value='\"+item.id+\"' class='np'></td>\"\r\n");
      out.write("                            +\" <td>\"+(index+1)+\"</td>\"\r\n");
      out.write("                            +\"  <td align='center'><a href=''><u>\"+item.functionname+\"</u></a></td>\"\r\n");
      out.write("                            +\" <td align='center'><a href=''><u>\"+item.module.modname+\"</u></a></td>\"\r\n");
      out.write("                            +\" <td align='center'><a href=''><u>\"+item.analysisname+\"</u></a></td>\"\r\n");
      out.write("                            +\" <td align='center'><a href=''><u>\"+item.proname+\"</u></a></td>\"\r\n");
      out.write("                            +\"  <td>\"+item.level+\"</td>\"\r\n");
      out.write("                            +\"  <td>2015-02-03</td>\"\r\n");
      out.write("                            +\"  <td>2015-06-03</td>\"\r\n");
      out.write("                            +\"  <td><a href='project-function-edit.jsp?id=\"+item.id+\"'>编辑</a> | <a href='project-function-look.jsp?id=\"+item.id+\"'>查看详情</a></td>\"\r\n");
      out.write("                            +\"  </tr>\"\r\n");
      out.write("                        $(\"#mark\").before(tr);\r\n");
      out.write("                    })\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"8\" topmargin=\"8\" background='skin/images/allbg.gif'>\r\n");
      out.write("\r\n");
      out.write("<!--  快速转换位置按钮  -->\r\n");
      out.write("<table width=\"98%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#D1DDAA\" align=\"center\">\r\n");
      out.write("<tr>\r\n");
      out.write(" <td height=\"26\" background=\"skin/images/newlinebg3.gif\">\r\n");
      out.write("  <table width=\"58%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("  <td >\r\n");
      out.write("    当前位置:项目管理>>功能管理\r\n");
      out.write(" </td>\r\n");
      out.write("  <td>\r\n");
      out.write("    <input type='button' class=\"coolbg np\" onClick=\"location='project-function-add.jsp';\" value='添加新功能' />\r\n");
      out.write(" </td>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<!--  搜索表单  -->\r\n");
      out.write("<form id='form3' action='javascript:void(0)' method='get'>\r\n");
      out.write("<input type='hidden' name='dopost' value='' />\r\n");
      out.write("<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align=\"center\" style=\"margin-top:8px\">\r\n");
      out.write("  <tr bgcolor='#EEF4EA'>\r\n");
      out.write("    <td background='skin/images/wbg.gif' align='center'>\r\n");
      out.write("      <table border='0' cellpadding='0' cellspacing='0'>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width='90' align='center'>搜索条件：</td>\r\n");
      out.write("          <td width='160'>\r\n");
      out.write("          <select name='cid' id=\"cid\" style='width:150px'>\r\n");
      out.write("          <option value='0'>选择类型...</option>\r\n");
      out.write("          \t<option value='1'>项目名称</option>\r\n");
      out.write("          \t<option value='2'>需求名称</option>\r\n");
      out.write("          \t<option value='3'>功能名称</option>\r\n");
      out.write("          </select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width='70'>\r\n");
      out.write("          关键字：\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width='160'>\r\n");
      out.write("          \t<input type='text' name='keyword' id=\"keyword\" value='' style='width:120px' />\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width='110'>\r\n");
      out.write("    \t\t<select name='orderby' id=\"orderby\" style='width:120px'>\r\n");
      out.write("            <option value='0'>排序...</option>\r\n");
      out.write("            <option value='0'>id升序</option>\r\n");
      out.write("            <option value='1'>id降序</option>\r\n");
      out.write("      \t</select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>\r\n");
      out.write("          &nbsp;&nbsp;&nbsp;<input name=\"imageField\" onclick=\"search()\" type=\"image\" src=\"skin/images/frame/search.gif\" width=\"45\" height=\"20\" border=\"0\" class=\"np\" />\r\n");
      out.write("        </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<!--  内容列表   -->\r\n");
      out.write("<form name=\"form2\">\r\n");
      out.write("\r\n");
      out.write("<table id=\"trs\" width=\"98%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D1DDAA\" align=\"center\" style=\"margin-top:8px\">\r\n");
      out.write("<tr bgcolor=\"#E7E7E7\">\r\n");
      out.write("\t<td height=\"24\" colspan=\"12\" background=\"skin/images/tbg.gif\">&nbsp;功能列表&nbsp;</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr align=\"center\" bgcolor=\"#FAFAF1\" height=\"22\">\r\n");
      out.write("\t<td width=\"4%\">选择</td>\r\n");
      out.write("\t<td width=\"6%\">序号</td>\r\n");
      out.write("\t<td width=\"10%\">功能名称</td>\r\n");
      out.write("\t<td width=\"10%\">模块名称</td>\r\n");
      out.write("\t<td width=\"10%\">需求名称</td>\r\n");
      out.write("\t<td width=\"10%\">项目名称</td>\r\n");
      out.write("\t<td width=\"10%\">优先级</td>\r\n");
      out.write("\t<td width=\"8%\">添加时间</td>\r\n");
      out.write("\t<td width=\"8%\">修改时间</td>\r\n");
      out.write("\t<td width=\"10%\">操作</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr id=\"mark\" bgcolor=\"#FAFAF1\">\r\n");
      out.write("<td height=\"28\" colspan=\"12\">\r\n");
      out.write("\t&nbsp;\r\n");
      out.write("\t<a href=\"javascript:quan()\" class=\"coolbg\">全选</a>\r\n");
      out.write("\t<a href=\"javascript:fan()\" class=\"coolbg\">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<a href=\"javascript:batchdel()\" class=\"coolbg\">&nbsp;删除&nbsp;</a>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr align=\"right\" bgcolor=\"#EEF4EA\">\r\n");
      out.write("\t<td height=\"36\" colspan=\"12\" align=\"center\"><!--翻页代码 --></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

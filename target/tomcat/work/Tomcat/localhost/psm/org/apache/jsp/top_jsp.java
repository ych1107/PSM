/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-21 08:44:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>top</title>\r\n");
      out.write("<link href=\"skin/css/base.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"skin/js/frame/menu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.7.2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function logout() {\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        type: \"get\",\r\n");
      out.write("        url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/emp/logout\",\r\n");
      out.write("        success:function (msg) {\r\n");
      out.write("            if (msg.status == 200) {\r\n");
      out.write("                alert(msg.message);\r\n");
      out.write("                window.parent.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login.jsp\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("body { padding:0px; margin:0px; }\r\n");
      out.write("#tpa {\r\n");
      out.write("\tcolor: #009933;\r\n");
      out.write("\tmargin:0px;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tpadding-right:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tpa dd {\r\n");
      out.write("\tmargin:0px;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin-right:2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tpa dd.ditem {\r\n");
      out.write("\tmargin-right:8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tpa dd.img {\r\n");
      out.write("  padding-top:6px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.item\r\n");
      out.write("{\r\n");
      out.write("  text-align:center;\r\n");
      out.write("\tbackground:url(skin/images/frame/topitembg.gif) 0px 3px no-repeat;\r\n");
      out.write("\twidth:82px;\r\n");
      out.write("\theight:26px;\r\n");
      out.write("\tline-height:28px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itemsel {\r\n");
      out.write("  width:80px;\r\n");
      out.write("  text-align:center;\r\n");
      out.write("  background:#226411;\r\n");
      out.write("\tborder-left:1px solid #c5f097;\r\n");
      out.write("\tborder-right:1px solid #c5f097;\r\n");
      out.write("\tborder-top:1px solid #c5f097;\r\n");
      out.write("\theight:26px;\r\n");
      out.write("\tline-height:28px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("*html .itemsel {\r\n");
      out.write("\theight:26px;\r\n");
      out.write("\tline-height:26px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link,a:visited {\r\n");
      out.write(" text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".item a:link, .item a:visited {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itemsel a:hover {\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tborder-bottom:2px solid #E9FC65;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itemsel a:link, .itemsel a:visited {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itemsel a:hover {\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\tborder-bottom:2px solid #E9FC65;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rmain {\r\n");
      out.write("  padding-left:10px;\r\n");
      out.write("  /* background:url(skin/images/frame/toprightbg.gif) no-repeat; */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgColor='#ffffff'>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"skin/images/frame/topbg.gif\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width='20%' height=\"60\"><img src=\"skin/images/frame/logo.gif\" /></td>\r\n");
      out.write("    <td width='80%' align=\"right\" valign=\"bottom\">\r\n");
      out.write("    \t<table width=\"750\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("      <td align=\"right\" height=\"26\" style=\"padding-right:10px;line-height:26px;\">\r\n");
      out.write("        \t您好：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("，欢迎使用项目平台管理系统！\r\n");
      out.write("        \t\r\n");
      out.write("        \t[<a href=\"index.jsp\" target=\"_top\">主页</a>]\r\n");
      out.write("        \t[<a href=\"modpassword.jsp\"  target=\"_blank\">修改密码</a>]\r\n");
      out.write("        \t[<a href=\"javascript:void(0);\" onClick=\"logout()\">注销退出</a>]&nbsp;\r\n");
      out.write("      </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" height=\"34\" class=\"rmain\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
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

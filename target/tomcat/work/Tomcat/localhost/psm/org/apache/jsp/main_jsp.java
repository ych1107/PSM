/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-22 07:03:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("<title>main</title>\r\n");
      out.write("<base target=\"_self\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"skin/css/base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"skin/css/main.css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.7.2.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/data.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function () {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notice/getNews\",\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\tsuccess:function (msg) {\r\n");
      out.write("\t\t\t\t\t$(msg.map.list).each(function (index, item) {\r\n");
      out.write("\t\t\t\t\t\tvar li = \"<li class='ue-clear'>\" +\r\n");
      out.write("\t\t\t\t\t\t\t\t\"<span>\"+getMyDate(item.ndate)+\"</span>&nbsp;&nbsp;&nbsp;<a onclick='showWindow(\"+item.nid+\")' href='#' class='notice-title'>\"+item.ntitle+\"</a>\" +\r\n");
      out.write("\t\t\t\t\t\t\t\t\"</li>\"+\r\n");
      out.write("\t\t\t\t\t\t\t\t\"<p>\";\r\n");
      out.write("\t\t\t\t\t\t$(\"#notices\").append(li);\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/task/taskStatus\",\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\tsuccess:function (msg) {\r\n");
      out.write("\t\t\t\t\t$(\"#taskStatus\").text(msg);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\tfunction showWindow(obj) {\r\n");
      out.write("\t\t\tvar nid = obj;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notice/getOne\",\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\tdata:{\"nid\": nid},\r\n");
      out.write("\t\t\t\tsuccess:function (msg) {\r\n");
      out.write("\t\t\t\t\t$(\"#content\").text(msg.remark);\r\n");
      out.write("\t\t\t\t\t$(\"#ntitle\").text(msg.ntitle);\r\n");
      out.write("\t\t\t\t\t//显示弹窗\r\n");
      out.write("\t\t\t\t\t$(\"#showdiv\").show();\r\n");
      out.write("\t\t\t\t\t//显示遮罩\r\n");
      out.write("\t\t\t\t\t$(\"#cover\").css({\"display\":\"block\",\"height\":window.screen.availHeight+\"px\"})\r\n");
      out.write("\t\t\t\t\t$(\"#cover\").show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction closeWindow() {\r\n");
      out.write("\t\t\t$(\"#showdiv\").hide();\r\n");
      out.write("\t\t\t//显示遮罩\r\n");
      out.write("\t\t\t$(\"#cover\").css({\"display\":\"display\"})\r\n");
      out.write("\t\t\t$(\"#cover\").hide();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"8\" topmargin='8'>\r\n");
      out.write("\r\n");
      out.write("<!-- 遮罩层 -->\r\n");
      out.write("<div id=\"cover\" style=\"background: #000; position: absolute; left: 0px; top: 0px; width: 100%; filter: alpha(opacity=30); opacity: 0.3; display: none; z-index: 2 \">\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 弹窗 -->\r\n");
      out.write("<div id=\"showdiv\" style=\"width: 60%; margin: 0 auto; height:500px; border: 1px solid #999; display: none; position: absolute; top: 20%; left: 20%; z-index: 3; background: #fff\">\r\n");
      out.write("\t<!-- 标题 -->\r\n");
      out.write("\t<div id=\"ntitle\" style=\"background: #F8F7F7; width: 100%; height: 2rem; font-size: 0.65rem; line-height: 2rem; border: 1px solid #999; text-align: center;\" >\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 内容 -->\r\n");
      out.write("\t<div id=\"content\" style=\"text-indent: 50px; height: 4rem; font-size: 0.5rem; padding: 0.5rem; line-height: 1rem; \">\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 按钮 -->\r\n");
      out.write("\t<div style=\"background: green; width: 10%; margin: 0 auto; height: 1.5rem; line-height: 1.5rem; text-align: center;color: #fff;margin-top: 28rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem;font-size: .59733rem;\" onclick=\"closeWindow()\">\r\n");
      out.write("\t\t关闭\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\"\r\n");
      out.write("\t\tcellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><div style='float: left'>\r\n");
      out.write("\t\t\t\t\t<img height=\"14\" src=\"skin/images/frame/book1.gif\" width=\"20\" />&nbsp;欢迎使用项目平台管理系统\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style='float: right; padding-right: 8px;'>\r\n");
      out.write("\t\t\t\t\t<!--  //保留接口  -->\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"1\" background=\"skin/images/frame/sp_bg.gif\"\r\n");
      out.write("\t\t\t\tstyle='padding: 0px'></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("    <table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"4\"\r\n");
      out.write("\t\tcellspacing=\"1\" bgcolor=\"#CBD8AC\" style=\"margin-bottom: 8px\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" background=\"skin/images/frame/wbg.gif\"\r\n");
      out.write("\t\t\t\tbgcolor=\"#EEF4EA\" class='title'>\r\n");
      out.write("\t\t\t\t<div style='float: left'>\r\n");
      out.write("\t\t\t\t\t<span>快捷操作</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style='float: right; padding-right: 10px;'></div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t<td height=\"30\" colspan=\"2\" align=\"center\" valign=\"bottom\"><table\r\n");
      out.write("\t\t\t\t\twidth=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"15%\" height=\"31\" align=\"center\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"skin/images/frame/qc.gif\" width=\"90\" height=\"30\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"85%\" valign=\"bottom\"><div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/addnews.gif' width='16' height='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='project-base.jsp'><u>查看项目信息</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/menuarrow.gif' width='16'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\theight='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='task.jsp'><u>查看任务</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/manage1.gif' width='16' height='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='task-add.jsp'><u>发布任务</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/file_dir.gif' width='16'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\theight='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='message.jsp'><u>收件箱</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/part-index.gif' width='16'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\theight='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='info.jsp'><u>个人信息</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='icoitem'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='ico'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<img src='skin/images/frame/manage1.gif' width='16' height='16' />\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class='txt'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href='modpassword.jsp'><u>修改密码</u></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"3\"\r\n");
      out.write("\t\tcellspacing=\"1\" bgcolor=\"#CBD8AC\"\r\n");
      out.write("\t\tstyle=\"margin-bottom: 8px; margin-top: 8px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td background=\"skin/images/frame/wbg.gif\" bgcolor=\"#EEF4EA\"\r\n");
      out.write("\t\t\t\tclass='title'><span>待完成任务</span></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t<td>您有<a href=\"\"><font color=\"red\" id=\"taskStatus\">2</font></a>个任务未完成……&nbsp;\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"3\"\r\n");
      out.write("\t\tcellspacing=\"1\" bgcolor=\"#CBD8AC\"\r\n");
      out.write("\t\tstyle=\"margin-bottom: 8px; margin-top: 8px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td background=\"skin/images/frame/wbg.gif\" bgcolor=\"#EEF4EA\"\r\n");
      out.write("\t\t\t\tclass='title'><span>未读消息</span></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t<td>您有<a href=\"\"><font color=\"red\">10</font></a>条未读消息……&nbsp;\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"3\"\r\n");
      out.write("\t\tcellspacing=\"1\" bgcolor=\"#CBD8AC\"\r\n");
      out.write("\t\tstyle=\"margin-bottom: 8px; margin-top: 8px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td background=\"skin/images/frame/wbg.gif\" bgcolor=\"#EEF4EA\"\r\n");
      out.write("\t\t\t\tclass='title'><span>通知公告</span></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<ul class=\"notice-list\" id=\"notices\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("    <table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"3\"\r\n");
      out.write("\t\tcellspacing=\"1\" bgcolor=\"#CBD8AC\"\r\n");
      out.write("\t\tstyle=\"margin-bottom: 8px; margin-top: 8px;\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td background=\"skin/images/frame/wbg.gif\" bgcolor=\"#EEF4EA\"\r\n");
      out.write("\t\t\t\tclass='title'><span>员工论坛</span></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<ul class=\"notice-list\">\r\n");
      out.write("\t\t\t\t\t<li class=\"ue-clear\">\r\n");
      out.write("\t\t\t\t\t     <span><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/tx.png\" height=\"50px\" width=\"50px\"/></span> 发布时间：2018-12-25\r\n");
      out.write("\t\t\t\t\t     <a href=\"role.jsp\"class=\"notice-title\">招租信息</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<li class=\"ue-clear\">\r\n");
      out.write("\t\t\t\t\t     <span><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/tx.png\" height=\"50px\" width=\"50px\"/></span> 发布时间：2018-12-25\r\n");
      out.write("\t\t\t\t\t     <a href=\"role.jsp\"class=\"notice-title\">招租信息</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<li class=\"ue-clear\">\r\n");
      out.write("\t\t\t\t\t     <span><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/tx.png\" height=\"50px\" width=\"50px\"/></span> 发布时间：2018-12-25\r\n");
      out.write("\t\t\t\t\t     <a href=\"role.jsp\"class=\"notice-title\">招租信息</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<li class=\"ue-clear\">\r\n");
      out.write("\t\t\t\t\t     <span><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/tx.png\" height=\"50px\" width=\"50px\"/></span> 发布时间：2018-12-25\r\n");
      out.write("\t\t\t\t\t     <a href=\"role.jsp\"class=\"notice-title\">招租信息</a>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-02-15 03:16:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.sysadmin.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("    <title>系统登录</title>\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/layui.css\" media=\"all\" />\r\n");
      out.write("    <style>\r\n");
      out.write("        .cus01{font-family:微软雅黑;text-align:center;}\r\n");
      out.write("        .cus02{margin-top:35px;}\r\n");
      out.write("        .cus03{width: 150px;}\r\n");
      out.write("        .cus04{width: 350px;}\r\n");
      out.write("    </style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body bgcolor=\"#d2d2d2\">\r\n");
      out.write("\t\t<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<div style=\"height:100px;line-height: 100px;\">\r\n");
      out.write("    <p class=\"cus01\" style=\"font-size:36px\">物流管理系统登录</p>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"layui-col-md6 layui-col-md-offset3\" style=\"height:400px; background-color:#00AACC;border-radius:5px;\">\r\n");
      out.write("    <div class=\"layui-col-md10 layui-col-md-offset1\" style=\"height:380px; background-color:#2F4056;margin-top:10px;border-radius:5px;\">\r\n");
      out.write("        <form class=\"layui-form\" action=\"\">\r\n");
      out.write("            <div class=\"layui-col-md11\">\r\n");
      out.write("                <div class=\"layui-form-item cus02\">\r\n");
      out.write("                    <label class=\"layui-form-label\"><p class=\"cus01\" style=\"font-size:20px;color:#f2f2f2\">账号</p></label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"caccount\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入账号\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item cus02\">\r\n");
      out.write("                    <label class=\"layui-form-label\"><p class=\"cus01\" style=\"font-size:20px;color:#f2f2f2\">密码</p></label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"password\" name=\"cpassword\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入密码\" class=\"layui-input\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item cus02 layui-row layui-col-space5\">\r\n");
      out.write("                    <div class=\"layui-col-md7\">\r\n");
      out.write("                        <label class=\"layui-form-label\"><p class=\"cus01\" style=\"font-size:20px;color:#f2f2f2\">验证码</p></label>\r\n");
      out.write("                        <div class=\"layui-input-block\">\r\n");
      out.write("                            <input type=\"text\" name=\"vali\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入验证码\" class=\"layui-input\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-col-md5\">\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-col-md10 layui-col-md-offset3 cus02\">\r\n");
      out.write("                    <div class=\"layui-col-md6\">\r\n");
      out.write("                        <button class=\"layui-btn btn cus03\" lay-submit=\"\" lay-filter=\"demo2\">\r\n");
      out.write("                            <p class=\"cus01\" style=\"font-size:20px\">登录</p>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"layui-col-md6\">\r\n");
      out.write("                        <button class=\"layui-btn btn cus03\" onclick=\"window.open('regist.html')\" lay-filter=\"demo2\">\r\n");
      out.write("                            <p class=\"cus01\" style=\"font-size:20px\">注册</p>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.all.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/pages/sysadmin/login/login2.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/sysadmin/login/login2.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/sysadmin/login/login2.jsp(3,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
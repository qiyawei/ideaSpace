package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<input type=\"text\" id=\"username\" />\r\n");
      out.write("<button id=\"btn\">button</button>\r\n");
      out.write("<body>\r\n");
      out.write("<script>\r\n");
      out.write("    (function(){\r\n");
      out.write("        function creatXmlHttp(){\r\n");
      out.write("            var xmlHttp = null;\r\n");
      out.write("            if(window.ActiveXObject){\r\n");
      out.write("                xmlHttp = new ActiveXObject(\"MicroSoft.XMLHTTP\")\r\n");
      out.write("            }else{\r\n");
      out.write("                xmlHttp = new XMLHttpRequest();\r\n");
      out.write("            }\r\n");
      out.write("            return xmlHttp;\r\n");
      out.write("        }\r\n");
      out.write("        var btn = document.querySelector(\"#btn\");\r\n");
      out.write("        var name = document.querySelector(\"#username\");\r\n");
      out.write("        btn.onclick  = function(){\r\n");
      out.write("            var xmlHttp = creatXmlHttp();\r\n");
      out.write("            xmlHttp.open(\"post\",\"/ajax.do\")\r\n");
      out.write("            xmlHttp.setRequestHeader(\"Content-Type\",\"application/x-www-form-urlencoded\");\r\n");
      out.write("            xmlHttp.onreadystatechange = function(){\r\n");
      out.write("                if(xmlHttp.readyState == 4){\r\n");
      out.write("                    if(xmlHttp.status == 200){\r\n");
      out.write("                        var result = xmlHttp.responseText;\r\n");
      out.write("                        alert(result);\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            xmlHttp.send(\"username=\"+ name.value);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    })();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

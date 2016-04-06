package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jq2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"text\" id=\"url\"/>\r\n");
      out.write("<button id=\"btn\">button</button>\r\n");
      out.write("<div id=\"container\"></div>\r\n");
      out.write("<script src=\"/js/jquery-1.10.1.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("  $(function(){\r\n");
      out.write("      var div = $(\"#container\");\r\n");
      out.write("      $(\"#btn\").click(function(){\r\n");
      out.write("          var url = $(\"#url\").val();\r\n");
      out.write("          console.log(123)\r\n");
      out.write("          $.ajax({\r\n");
      out.write("              url:\"/rss.do\",\r\n");
      out.write("              method:\"get\",\r\n");
      out.write("              data:{\"url\":url},\r\n");
      out.write("              success:function(data){\r\n");
      out.write("                var items = $(data).find(\"item\");\r\n");
      out.write("                  items.each(function(){\r\n");
      out.write("                      var title = $(this).find(\"title\").text();\r\n");
      out.write("                      var link = $(this).find(\"link\").text();\r\n");
      out.write("                      var html = \"<h3><a href=\\\"\"+link+\"\\\" target=\\\"_blank\\\">\"+title+\"</a></h3>\";\r\n");
      out.write("                      div.append(html);\r\n");
      out.write("                  })\r\n");
      out.write("              },\r\n");
      out.write("              beforeSend:function(){\r\n");
      out.write("                    $(\"#btn\").text(\"读取中\")\r\n");
      out.write("              },\r\n");
      out.write("              error:function(){\r\n");
      out.write("                  alert(\"请求异常\")\r\n");
      out.write("              },\r\n");
      out.write("              complete:function(){\r\n");
      out.write("                  $(\"#btn\").text(\"button\")\r\n");
      out.write("              }\r\n");
      out.write("          });\r\n");
      out.write("      });\r\n");
      out.write("  });\r\n");
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

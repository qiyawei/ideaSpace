package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class readrss_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<input type=\"text\" id=\"url\"/>\r\n");
      out.write("<button id=\"btn\">Read</button>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    (function(){\r\n");
      out.write("        function createXmlHttp() {\r\n");
      out.write("            var xmlHttp = null;\r\n");
      out.write("            if(window.ActiveXObject) {\r\n");
      out.write("                xmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("            } else {\r\n");
      out.write("                xmlHttp = new XMLHttpRequest();\r\n");
      out.write("            }\r\n");
      out.write("            return xmlHttp;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var btn = document.querySelector(\"#btn\");\r\n");
      out.write("        var url = document.querySelector(\"#url\");\r\n");
      out.write("        var div = document.querySelector(\"#content\");\r\n");
      out.write("\r\n");
      out.write("        btn.onclick = function(){\r\n");
      out.write("            div.innerHTML = \"\";\r\n");
      out.write("            var xmlHttp = createXmlHttp();\r\n");
      out.write("            xmlHttp.open(\"get\",\"/rss.do?url=\"+url.value);\r\n");
      out.write("            xmlHttp.onreadystatechange = function(){\r\n");
      out.write("                if(xmlHttp.readyState == 4) {\r\n");
      out.write("                    if(xmlHttp.status == 200) {\r\n");
      out.write("                        var doc = xmlHttp.responseXML;\r\n");
      out.write("\r\n");
      out.write("                        var items = doc.getElementsByTagName(\"item\");\r\n");
      out.write("                        for(var i = 0;i < items.length;i++) {\r\n");
      out.write("                            var item = items[i];\r\n");
      out.write("                            var title = item.getElementsByTagName(\"title\")[0].childNodes[0].nodeValue;\r\n");
      out.write("                            var link = item.getElementsByTagName(\"link\")[0].childNodes[0].nodeValue;\r\n");
      out.write("\r\n");
      out.write("                            var h3 = document.createElement(\"h3\");\r\n");
      out.write("                            var a = document.createElement(\"a\");\r\n");
      out.write("                            var text = document.createTextNode(title);\r\n");
      out.write("\r\n");
      out.write("                            a.setAttribute(\"target\",\"_blank\");\r\n");
      out.write("                            a.setAttribute(\"href\",link);\r\n");
      out.write("\r\n");
      out.write("                            a.appendChild(text);\r\n");
      out.write("                            h3.appendChild(a);\r\n");
      out.write("                            div.appendChild(h3);\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    } else {\r\n");
      out.write("                        alert(\"请求异常：\" + xmlHttp.status)\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            };\r\n");
      out.write("            xmlHttp.send();\r\n");
      out.write("        };\r\n");
      out.write("    })();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

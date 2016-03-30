<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<input type="text" id="url"/>
<button id="btn">Read</button>
<div id="content">

</div>

<script>

    (function(){
        function createXmlHttp() {
            var xmlHttp = null;
            if(window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        var btn = document.querySelector("#btn");
        var url = document.querySelector("#url");
        var div = document.querySelector("#content");

        btn.onclick = function(){
            div.innerHTML = "";
            var xmlHttp = createXmlHttp();
            xmlHttp.open("get","/rss.do?url="+url.value);
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState == 4) {
                    if(xmlHttp.status == 200) {
                        var doc = xmlHttp.responseXML;

                        var items = doc.getElementsByTagName("item");
                        for(var i = 0;i < items.length;i++) {
                            var item = items[i];
                            var title = item.getElementsByTagName("title")[0].childNodes[0].nodeValue;
                            var link = item.getElementsByTagName("link")[0].childNodes[0].nodeValue;

                            var h3 = document.createElement("h3");
                            var a = document.createElement("a");
                            var text = document.createTextNode(title);

                            a.setAttribute("target","_blank");
                            a.setAttribute("href",link);

                            a.appendChild(text);
                            h3.appendChild(a);
                            div.appendChild(h3);
                        }

                    } else {
                        alert("请求异常：" + xmlHttp.status)
                    }
                }
            };
            xmlHttp.send();
        };
    })();


</script>

</body>
</html>
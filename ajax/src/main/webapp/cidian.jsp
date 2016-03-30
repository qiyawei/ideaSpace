<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<input type="text" id="word"/> <button id="btn">Query</button>
<h3 id="result"></h3>
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
        var word = document.querySelector("#word");
        var result = document.querySelector("#result");

        btn.onclick = function(){

            var xmlHttp = createXmlHttp();
            xmlHttp.open("get","/cidian.do?q="+word.value);
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState == 4) {
                    if(xmlHttp.status == 200) {
                        var xml = xmlHttp.responseXML;
                        var translation = xml.getElementsByTagName("translation")[0];
                        var paragraph = translation.getElementsByTagName("paragraph")[0].childNodes[0].nodeValue;
                        result.innerText = paragraph;
                    }
                }
            };
            xmlHttp.send();


        };


    })();
</script>

</body>
</html>
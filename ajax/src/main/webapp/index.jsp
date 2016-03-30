<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<input type="text" id="username" />
<button id="btn">button</button>
<body>
<script>
    (function(){
        function creatXmlHttp(){
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("MicroSoft.XMLHTTP")
            }else{
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }
        var btn = document.querySelector("#btn");
        var name = document.querySelector("#username");
        btn.onclick  = function(){
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("post","/ajax.do")
            xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState == 4){
                    if(xmlHttp.status == 200){
                        var result = xmlHttp.responseText;
                        alert(result);
                    }
                }
            }
            xmlHttp.send("username="+ name.value);
        }

    })();


</script>
</body>
</html>

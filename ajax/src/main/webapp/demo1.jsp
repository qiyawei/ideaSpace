<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<button id="btn">button</button>
<script>
    (function(){
        function creatXmlhttp(){
            var xmlhttp = null;
            if(window.ActiveXObject){
                xmlhttp = new ActiveXObject("MicroSoft.XMLHTTP");
            }else{
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        var btn = document.querySelector("#btn");
        btn.onclick = function(){
            var xmlhttp = creatXmlhttp();
            xmlhttp.open("get","/ajax.do");
            // xmlhttp.open("get","/ajax.do?t=" + new Date().getTime());
            xmlhttp.send();
        }













    })();
</script>
</body>
</html>
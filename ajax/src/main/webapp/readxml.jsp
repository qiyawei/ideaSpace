
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button id="btn">button</button>
<div id="container"></div>
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
    var div = document.querySelector("#container")
    btn.onclick = function(){
      var xmlhttp = creatXmlHttp();
      xmlhttp.open("get","/student.do");
      xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState == 4){
          if(xmlhttp.status == 200){
            var doc = xmlhttp.responseXML;
            var students = doc.getElementsByTagName("student");
            for(var index=0;index<students.length;index++){
              var student = students[index];
              var id = student.getAttribute("id");
              //var name = student.getElementsByTagName("name")[0].childNodes[0].nodeValue;
              var name = student.getElementsByTagName("name")[0].innerHTML
              var score = student.getElementsByTagName("score")[0].childNodes[0].nodeValue;
              console.log("id:" + id + " name:" + name + " score:" + score)
              var h3 = document.createElement("h3");
              h3.innerText = "id:" + id + " name:" + name + " score:" + score;
              div.appendChild(h3);
            }
          }
        }
      }
      xmlhttp.send()
    }
  })();
</script>
</body>
</html>

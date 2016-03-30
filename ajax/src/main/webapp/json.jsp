<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button id="btn">button</button>
<script src="/js/ajax.js"></script>
<script>

  (function(){
    var btn = document.querySelector("#btn");
    btn.onclick = function(){
      ajaxGet("/student.json",function(xmlhttp){
       var text = xmlhttp.responseText;
        var array = JSON.parse(text);
        //console.log(json.length);
        for(var index in array){
          var obj = json[index];
          console.log(obj.name)
        }
      });
    };
  })();

</script>
</body>
</html>

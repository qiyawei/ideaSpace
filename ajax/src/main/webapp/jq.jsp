
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<button id="btn">button</button>
<div id="container"></div>
<script src="/js/jquery-1.10.1.min.js"></script>
<script>
  $(function(){
      $("#btn").click(function(){
        $.get("/student.json",function(data){
            for(var index in data){
              var obj = data[index];
              $("#container").append("<h3>"+obj.name+"</h3>");
            }
        });
      })
  });


</script>
</body>
</html>

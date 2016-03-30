
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<input type="text" id="name"/><span id="content"></span>
<button id="btn">button</button>
<script src="/js/jquery-1.10.1.min.js"></script>
<script>
  $(function(){
      $("#btn").click(function(){
        var name = $("#name").val();
          $.post("/ajax.do",{"name":name},function(data){
              if(data == "yes"){
                  $("#content").text("对");
              }else{
                  $("#content").text("cuo");
              }
          });
      })
  });


</script>
</body>
</html>

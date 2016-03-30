
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<input type="text" id="url"/>
<button id="btn">button</button>
<div id="container"></div>
<script src="/js/jquery-1.10.1.min.js"></script>
<script>
  $(function(){
      var div = $("#container");
      $("#btn").click(function(){
          var url = $("#url").val();
          console.log(123)
          $.ajax({
              url:"/rss.do",
              method:"get",
              data:{"url":url},
              success:function(data){
                var items = $(data).find("item");
                  items.each(function(){
                      var title = $(this).find("title").text();
                      var link = $(this).find("link").text();
                      var html = "<h3><a href=\""+link+"\" target=\"_blank\">"+title+"</a></h3>";
                      div.append(html);
                  })
              },
              beforeSend:function(){
                    $("#btn").text("读取中")
              },
              error:function(){
                  alert("请求异常")
              },
              complete:function(){
                  $("#btn").text("button")
              }
          });
      });
  });


</script>
</body>
</html>

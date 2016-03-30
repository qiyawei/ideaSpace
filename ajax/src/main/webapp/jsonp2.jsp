<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<Button id="btn">Button</Button>

<script src="/js/jquery-1.10.1.min.js"></script>
<script>
    $(function(){
        $("#btn").click(function(){

            $.getJSON("/jsonp.do?cb=?",function(data){
                alert("UserName:" + data.name);
            });


        });
    });
</script>


</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <div style="background-color: royalblue;display: none;cursor: pointer" id="msg">
        你有<span id="count"></span>条未读消息
    </div>
    <div class="container">
        <c:forEach items="${weiboList}" var="weibo">
            <h3>${weibo.id} : ${weibo.message}</h3>
        </c:forEach>
    </div>


    <script src="/js/jquery-1.10.1.min.js"></script>
    <script src="/js/handlebars-v3.0.3.js"></script>
    <script type="text/template-x" id="template">
        <h3>{{id}} : {{message}}</h3>
    </script>
    <script>
        $(function(){

            var maxId = ${maxId};
            var objJson = null;

            setInterval(function(){
                $.get("/weibopush.do",{"start":maxId},function(data){
                    console.log("data:" + data);
                    var objSize = data.length;
                    if(objSize > 0) {
                        objJson = data;
                        $("#msg").show();
                        $("#count").text(objSize);
                    }
                })
            },5000);

            $("#msg").click(function(){
                var source = $("#template").html();
                var template = Handlebars.compile(source);

                for(var i = 0;i < objJson.length;i++) {
                    var obj = objJson[i];
                    var html = template(obj);

                    $(html).insertBefore($(".container h3:first"));

                }

                $("#msg").hide();
                maxId = objJson[objJson.length-1].id;

            });


        });
    </script>

</body>
</html>
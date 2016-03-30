<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<button id="btn">Button</button>
<div id="container">

</div>
<script type="kaishengit/template" id="template">
    <div class="xyz">
        <h3 style="color:red">Hello:$name$</h3>
        <p>{{content}}</p>
    </div>
</script>
<script src="/js/jquery-1.10.1.min.js"></script>
<script>
    $(function(){
        var $btn = $("#btn");
        var $con = $("#container");

        $btn.click(function(){
            var html = $("#template").html();
            html = html.replace("$name$","title-" + new Date().getTime());
            html = html.replace("{{content}}","content -" + + new Date().getTime());
            $con.append(html);
        });
    });
</script>



</body>
</html>
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
<script type="text/x-handlebars-template" id="template">

    <div class="xyz">
        <h3 style="color:red">Hello:{{name}}</h3>
        {{#unless isVip}}
            <span>VIP</span>
        {{else}}
            <span>No VIP</span>
        {{/unless}}
        <p>{{{content}}}</p>

        <ul>
            {{#each commens}}
            <li>{{title}}</li>
            {{/each}}
        </ul>
    </div>

</script>
<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/handlebars-v3.0.3.js"></script>
<script>
    $(function(){
        var $btn = $("#btn");
        var $con = $("#container");

        $btn.click(function(){

            var source = $("#template").html();
            var template = Handlebars.compile(source);

            var data = {
                "name":"title-"+new Date().getTime(),
                "isVip":false,
                "content":"<h5>haha</h5>",
                "commens":[{"title":"aaa"},{"title":"bbb"},{"title":"ccc"}]
            };
            var html = template(data);

            $con.append(html);
        });
    });
</script>



</body>
</html>
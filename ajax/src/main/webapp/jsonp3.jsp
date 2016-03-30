<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<input type="text" id="word"/><button id="btn">Query</button>
<div id="result"></div>
<script src="/js/jquery-1.10.1.min.js"></script>
<script>
    $(function(){

        var $btn = $("#btn");
        var $word = $("#word");
        var $result = $("#result");

        $btn.click(function(){
            var word = $word.val();
            var url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&&callback=?&version=1.1";
            $.getJSON(url,{"q":word},function(data){
                $result.text(data.translation);
            });
        });











    });
</script>

</body>
</html>
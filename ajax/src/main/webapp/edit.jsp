<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/js/editer/styles/simditor.css"/>
</head>
<body>

<form action="/save.do" method="post">
    <textarea id="editer" name="text" autofocus placeholder="这里输入内容"></textarea>
    <button>保存</button>
</form>

<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/editer/scripts/module.min.js"></script>
<script src="/js/editer/scripts/hotkeys.min.js"></script>
<script src="/js/editer/scripts/uploader.min.js"></script>
<script src="/js/editer/scripts/simditor.min.js"></script>
<script>
    $(function(){

        var editer = new Simditor({
            textarea:$("#editer"),
            defaultImage:'/js/editer/images/image.png',
            upload:{
                url:"http://upload.qiniu.com/",
                fileKey:'file',
                params:{"token":"${token}"}
            }
        });

    });
</script>



</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>


<script>
    function abc(data) {
        alert("Hello,JSONP : " + data.name);
    }
</script>
<script src="/jsonp.do?cb=abc"></script>

</body>
</html>
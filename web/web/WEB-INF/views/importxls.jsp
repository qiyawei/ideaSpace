
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>
  <div class="container">
    <form action="/importxls.do" method="post" enctype="multipart/form-data">
        <legend>导入文件</legend>
        <input type="file" name="upfile"/>
        <div class="form-actions">
            <button class="btn btn-primary">上传</button>
        </div>
    </form>
  </div>

</body>
</html>

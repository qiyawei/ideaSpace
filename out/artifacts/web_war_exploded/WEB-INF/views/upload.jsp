
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>
  <div class="container">
    <form action="/upload.do" method="post" enctype="multipart/form-data">
        <label>请输入姓名</label>
        <input type="text" name="name"/>
        <label>请输入身份证号</label>
        <input type="text" name="cardnum"/><br/>
        <input type="file" name="upfile"/>
        <div class="form-actions">
            <button class="btn btn-primary">上传</button>
        </div>
        <a href="/download.do?file=1.jpg&open=true">文件下载</a>
    </form>

  </div>

</body>
</html>

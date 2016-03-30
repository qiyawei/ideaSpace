
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>
    <div class="container">
        <form action="http://upload.qiniu.com" method="post" enctype="multipart/form-data">
            <legend>直接上传到七牛</legend>
            <input type="hidden" name="token" value="${token}" />
            <input type="file" name="file"/>
            <div class="form-actions">
                <button class="btn btn-primary">上传</button>
            </div>
        </form>
        <img src="http://7xq3kx.com1.z0.glb.clouddn.com/${key}-pic"/>
    </div>

</body>
</html>

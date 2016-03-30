<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/js/webuploder/webuploader.css"/>
    <style type="text/css">
        .pic {
            float: left;
            margin-left: 20px;
        }
    </style>
</head>
<body>


<button id="picker">选择文件</button>
<button id="upload">开始上传</button>
<div class="help"></div>
<div class="pics">

</div>
<ul id="files" style="display: none">

</ul>



<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/webuploder/webuploader.min.js"></script>
<script>
    $(function(){

        var uploader = WebUploader.create({
            swf:"/js/webuploader/Uploader.swf",
            server:"/upload.do",
            pick:"#picker",
            fileVal:"img",
           // auto:true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });

        uploader.on("fileQueued",function(file){
            $("<li>"+file.name + " : " + file.id +"</li>").appendTo($("#files"));
            uploader.makeThumb(file,function(error,src){
                if(error) {
                    alert("不能预览");
                } else {
                    $("<img>").attr("class","pic").attr("src",src).appendTo($(".pics"));
                }
            },200,200);
        });

        uploader.on("uploadProgress",function(){
            $(".help").text("文件上传中....");
        });

        uploader.on("uploadSuccess",function(){
            $(".help").text("文件上传成功");
        })

        uploader.on("uploadError",function(){
            $(".help").text("文件上传错误");
        })

        uploader.on("uploadComplete",function(){

        })

        $("#upload").click(function(){
            uploader.upload();
        });


    });
</script>



</body>
</html>
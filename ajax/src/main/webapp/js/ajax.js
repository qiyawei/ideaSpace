function createXmlHttp() {
    var xmlHttp = null;
    if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        xmlHttp = new XMLHttpRequest();
    }
    return xmlHttp;
}

function ajaxGet(url,fn) {
    var xmlHttp = createXmlHttp();
    xmlHttp.open("get", url);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                fn(xmlHttp);
            } else {
                alert("请求异常:" + xmlHttp.status);
            }
        }

    };
    xmlHttp.send();
}
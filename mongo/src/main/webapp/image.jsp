<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    <c:url value="/file" var="imgUrl"/>
<img alt="my image" src="${imgUrl}"> 
<a href="${imgUrl}">img</a> 
hiiiiiiiiiii
<!-- <c:url value="/getImage" var="imgUrl"/>
<img src="data:image/jpg;base64,<s:property value='byteArrayString'/>"
height="180" width="160" /> -->
</body>
</html>
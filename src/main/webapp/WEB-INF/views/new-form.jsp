<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
<body>

<!-- 상대경로 사용, (재활용하기위해서)[현재 URL이 속한 계층 경로 + /save]
절대경로 사용하는게 더 좋음 !!!
-->

<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>
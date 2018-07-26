<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <form action="login">
            <input type="text" name="code" placeholder="请输入验证码">
            <img id="codeImg" src="kaptcha">
            <input type="submit"value="登录" >
        </form>
    </body>
</html>

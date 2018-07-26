<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form class="m-t" role="form"  id="loginform" method="post" action="">
          <div class="form-group"><input class="form-control"  name="userAccount" placeholder="用户名" required=""></div>
          <div class="form-group"><input type="password" class="form-control"   name="userPwd"  placeholder="密码" required=""></div>
          <input type="text" class="form-control login-yan-w" id="kaptcha" name="kaptcha" placeholder="验证码">
          <span class="login-w"><img id="kaptchaImage" src="kaptcha"></span>
          <input type="button"  class="btn btn-primary block full-width m-b" onclick="login()"  value="登 录">
      </form>
  </body>
</html>

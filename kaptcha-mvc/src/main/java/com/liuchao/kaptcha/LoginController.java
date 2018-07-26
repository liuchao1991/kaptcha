package com.liuchao.kaptcha;

import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginController
 *
 * @author liuchao
 * @date 2018/7/26 11:31
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        //从session中取出servlet生成的验证码text值
        String kaptchaExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //获取用户页面输入的验证码
        String kaptchaReceived = request.getParameter("code");
        //校验验证码是否正确
        if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)){
            //setError("kaptcha", "Invalid validation code.");
        }
    }
}

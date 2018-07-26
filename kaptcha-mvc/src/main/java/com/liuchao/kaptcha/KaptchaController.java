package com.liuchao.kaptcha;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * KaptchaController
 *
 * @author liuchao
 * @date 2018/7/26 10:23
 */
@Controller
public class KaptchaController {

    @Autowired
    private Producer kaptchaProducer;

    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        String capText = kaptchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //向客户端写出
        BufferedImage bi = kaptchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }


    /*@RequestMapping(value = "/image", method = RequestMethod.GET)
    @Params
    public Object getImageCode(RequestContext context){
        String capText = kaptchaProducer.createText();
        cacheClient.set(Constants.KAPTCHA_SESSION_KEY+"-"+capText, capText, 60);
        BufferedImage bi = kaptchaProducer.createImage(capText);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        HttpHeaders headers = null;
        headers = new HttpHeaders();
        headers.setDate("Expires", 0);
        headers.set("Pragma", "no-cache");
        headers.set("Cache-Control", "no-cache");
        headers.setContentType(MediaType.IMAGE_JPEG);
        try {
            ImageIO.write(bi, "jpg", out);
            return new ResponseEntity<byte[]>(out.toByteArray(), headers,
                    HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(out);
        }
        return null;
    }*/
}

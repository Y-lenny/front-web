package com.dafycredit.giveu.mall.common.config;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* <br>动态生成验证码</br>
*
* @class  ServletConfig
* @author  lennylv
* @date    2017/4/11 23:44
* @version 1.0
* @since  1.0
*/

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean registrationKaptchaServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new KaptchaServlet(), "/kaptcha.jpg");
        bean.addInitParameter("kaptcha.session.key", com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        bean.addInitParameter("kaptcha.border", "no");
        bean.addInitParameter("kaptcha.textproducer.font.color", "black");
        bean.addInitParameter("kaptcha.textproducer.char.space", "5");
        return bean;
    }
}

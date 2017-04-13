package com.dafycredit.giveu.mall.common.base.controller;

import com.dafycredit.giveu.mall.common.util.CustomTimestampEditor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * <br>基础控制器，提供一些常见操作</br>
 *
 * @author lennylv
 * @version 1.0
 * @class BaseController
 * @date 2017/4/11 23:45
 * @since 1.0
 */

@Controller
public class BaseController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    /**
     * 注册自定义数据绑定器
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, "startTime", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, "endTime", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    /**
     * 清空Session值
     *
     * @param req
     */
    public static void clearSession(HttpServletRequest req) {
        Enumeration<String> er = req.getSession().getAttributeNames();
        while (er.hasMoreElements()) {
            String attributeName = er.nextElement();
            req.getSession().removeAttribute(attributeName);
        }
        req.getSession().invalidate();
    }

    public String getRealIp(HttpServletRequest req) {
        String ip = req.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip))
            return ip;
        return req.getRemoteAddr();
    }

    public static void printRequestBrief(final HttpServletRequest req) {
        log.info("Invoke: " + req.getRequestURL());
        log.info("Params: ");
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            log.info("\t" + name + ": [" + req.getParameter(name) + "]");
        }
        log.info("From:   " + req.getRemoteAddr());
    }
}

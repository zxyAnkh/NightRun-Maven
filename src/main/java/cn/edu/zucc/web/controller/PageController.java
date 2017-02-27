package cn.edu.zucc.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通用界面处理
 * Created by zxy on 2016/7/6.
 * @author zxyAnkh
 * @since 2016-07-06
 */
@Controller("pageController")
@RequestMapping("/page")
public class PageController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    /**
     * 登录页
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.info("/page/login");
        return "login";
    }

    /*
    * 登录后跳转页面 根据权限跳转至不同url
     */
    @RequestMapping("/index")
    public String indexAdmin(){
        logger.info("/page/index");
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin"))
            return "redirect:/ntr/admin/main?page=1";
        else if(subject.hasRole("user"))
            return "redirect:/ntr/user/main";
        return "login";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

}

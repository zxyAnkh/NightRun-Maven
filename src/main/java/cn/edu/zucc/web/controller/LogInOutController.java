package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.LogInService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 登录登出
 * Created by zxy on 11/13/2016.
 */
@Controller("logInOutController")
public class LogInOutController {

    private static final Log logger = LogFactory.getLog(LogInOutController.class);

    @Autowired
    private LogInService logInService;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ModelAndView login(@Valid User user, BindingResult result, Model model, HttpSession httpSession) {
        try {
            Subject subject = SecurityUtils.getSubject();
            logger.info("user " + user.getUsername() + " try to log in.");
            if (subject.isAuthenticated()) {
                return new ModelAndView(new RedirectView("/ntr/page/index"));
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return new ModelAndView("login");
            }
            subject.login(new UsernamePasswordToken(user.getUserno(), user.getPassword()));
            final User authUserInfo = logInService.selectByUserno(user.getUserno());
            httpSession.setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            model.addAttribute("error", "用户名或密码错误 ！");
            return new ModelAndView("login");
        }
        return new ModelAndView(new RedirectView("/ntr/page/index"));
    }

    @RequestMapping(value = "/user/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("userInfo");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView(new RedirectView("redirect:/ntr/page/login"));
    }

}

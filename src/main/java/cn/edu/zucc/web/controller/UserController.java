package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.RunService;
import cn.edu.zucc.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionContext;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.serviceloader.ServiceFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 用户界面处理
 * Created by zxy on 2016/7/6.
 * @author zxyAnkh
 * @since 2016-07-06
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RunService runService;

    /**
     * 用户登录
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, Model model, HttpSession httpSession) {
        try {
            logger.info("login post");
            Subject subject = SecurityUtils.getSubject();
            // 已登录则跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/ntr/page/index";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            logger.info(user.getPassword());
            subject.login(new UsernamePasswordToken(user.getUserno(), user.getPassword()));
            logger.info("login success");
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUserno(user.getUserno());
            httpSession.setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            // 身份验证失败
            logger.info("login error");
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "redirect:/ntr/page/index";
    }

    /**
    *  用户首页
    *  
    */
    @RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
    @RequiresRoles(value = RoleSign.USER)
    public String main(HttpSession session, Model model) {
        User user = (User) session.getAttribute("userInfo");
        List<ViewRun> list = runService.selectRunsByUserid(user.getId());
        model.addAttribute("userRunList", list);
        return "user/main";
    }

    /**
     * 用户添加跑步记录
     * @param run
     * @return
     */
    @RequestMapping(value = "/run", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.RUN_CREATE)
    public boolean run(@RequestParam Run run) {
        return runService.insert(run) == 1;
    }

    /**
     * 用户更新个人密码
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.USER_UPDATE)
    public boolean update(@RequestParam User user){
        return userService.updateByRecord(user) == 1;
    }


    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        logger.info("logout");
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/ntr/page/login";
    }
}

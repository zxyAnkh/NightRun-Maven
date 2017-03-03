package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.json.UserPwdPojo;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    /**
    *  用户首页
    *  
    */
    @RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
    @RequiresRoles(value = RoleSign.USER)
    @ResponseBody
    public String main() {
        logger.info("User logined.");
        return "{\"logined\":true}";
    }

    /**
     * 用户更新个人密码
     * @param userno
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.USER_UPDATE)
    @ResponseBody
    public String update(@RequestParam("no") String userno, @RequestParam("oldpwd") String oldpwd, @RequestParam("newpwd") String newpwd, HttpSession session){
        if(userno == null || "".equals(userno)){
            return "{\"result\":false}";
        }
        if(oldpwd == null || "".equals(oldpwd)){
            return "{\"result\":false}";
        }
        if(newpwd == null || "".equals(newpwd)){
            return "{\"result\":false}";
        }
        UserPwdPojo user = new UserPwdPojo(userno, oldpwd, newpwd);
        logger.info("Receive update user personal information request, user = " + user.toString());
        if(userService.updateUserPassword(user) == 1){
            session.removeAttribute("userInfo");
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return "{\"result\":true}";
        }
        return "{\"result\":false}";
    }
}

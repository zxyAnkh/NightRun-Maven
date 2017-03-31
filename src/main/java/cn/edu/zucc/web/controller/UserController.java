package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.json.UpdateUserDataRequest;
import cn.edu.zucc.web.json.UserPwdPojo;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.PhoneUIDService;
import cn.edu.zucc.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户界面处理
 * Created by zxy on 2016/7/6.
 *
 * @author zxyAnkh
 * @since 2016-07-06
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @Resource
    private UserService userService;
    @Resource
    private PhoneUIDService phoneUIDService;

    /**
     * 用户首页
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
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.USER_UPDATE)
    @ResponseBody
    public String update(@RequestBody UpdateUserDataRequest json, HttpSession session) {
        if (json.getNo() == null || "".equals(json.getNo())) {
            return "{\"result\":false}";
        }
        if (json.getOldpwd() == null || "".equals(json.getOldpwd())) {
            return "{\"result\":false}";
        }
        if (json.getNewpwd() == null || "".equals(json.getNewpwd())) {
            return "{\"result\":false}";
        }
        String phoneuid = phoneUIDService.getPhoneUID(json.getNo());
        if (phoneuid != null && json.getPhoneuid() != null && phoneuid.equals(json.getPhoneuid())) {
            UserPwdPojo user = new UserPwdPojo(json.getNo(), json.getOldpwd(), json.getNewpwd());
            logger.info("Receive update user personal information request, user = " + user.toString());
            if (userService.updateUserPassword(user) == 1) {
                session.removeAttribute("userInfo");
                Subject subject = SecurityUtils.getSubject();
                subject.logout();
                return "{\"result\":true}";
            }
        }
        return "{\"result\":false}";
    }
}

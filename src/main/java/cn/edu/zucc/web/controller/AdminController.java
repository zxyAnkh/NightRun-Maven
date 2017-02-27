package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.form.UserInfoForm;
import cn.edu.zucc.web.model.*;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 管理员页面处理
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since 2016-07-07
 */
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 判断用户是否已存在
     *
     * @param userno
     * @return 1:不存在  0:存在
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String checkUser(@RequestBody String userno) {
        logger.info("admin/checkUser");
        return String.valueOf(userService.selectByUserno(userno) == null ? 1 : 0);
    }

    /**
     * 管理员查看并修改个人信息
     *
     * @param userInfoForm 用户个人信息表单
     * @return
     */
    @RequestMapping(value = "/info", method = {RequestMethod.POST, RequestMethod.GET})
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.ADMIN_UPDATE)
    public String updateInfo(Model model, HttpSession httpSession, UserInfoForm userInfoForm) {
        logger.info("/admin/info");
        User user = (User) httpSession.getAttribute("userInfo");
        try {
            if (userInfoForm.getOldpassword() != null && PasswordHash.validatePassword(userInfoForm.getOldpassword(), user.getPassword())) {
                if (userInfoForm.getNewpassword2() != null && !"".equals(userInfoForm.getNewpassword2()))
                    user.setPassword(userInfoForm.getNewpassword2());
                user.setUsername(userInfoForm.getUsername());
                if (userService.updateByRecord(user) == 1) {
                    httpSession.setAttribute("userInfo", user);
                }
                return "admin/info";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "admin/info";
    }

}

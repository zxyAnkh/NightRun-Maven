package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        logger.debug("User logined.");
        return "{\"logined\":true}";
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
        logger.debug("Receive update user personal information request, user = " + user.getInfo());
        return userService.updateByRecord(user) == 1;
    }
}

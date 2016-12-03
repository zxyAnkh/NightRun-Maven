package cn.edu.zucc.web.controller;

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
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
}

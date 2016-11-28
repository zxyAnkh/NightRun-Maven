package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.LoadUserDataService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zxy on 11/28/2016.
 */
@Controller("loadUserDataController")
public class LoadUserDataController {

    @Autowired
    private LoadUserDataService loadUserDataService;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public ModelAndView users(Model model, @RequestParam("page") int page) {
        if (page <= 0) {
            return new ModelAndView("admin/users?page=1");
        }
        int size = 50;
        List<User> users = loadUserDataService.getUserDataByPage((page - 1) * 50, size, false);
        model.addAttribute("usersAList", users);
        return new ModelAndView("admin/users");
    }

    @RequestMapping(value = "/admin/usersAll", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public ModelAndView usersAll(Model model, @RequestParam("page") int page) {
        if (page <= 0) {
            return new ModelAndView("admin/usersAll?page=1");
        }
        int size = 50;
        List<User> users = loadUserDataService.getUserDataByPage((page - 1) * 50, size, true);
        model.addAttribute("usersNAList", users);
        return new ModelAndView("admin/usersAll");
    }

}

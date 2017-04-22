package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.LoadUserDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxy on 11/28/2016.
 */
@Controller("loadUserDataController")
public class LoadUserDataController {

    private static final Log logger = LogFactory.getLog(LoadUserDataController.class);

    @Resource
    private LoadUserDataService loadUserDataService;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public ModelAndView users(Model model, @RequestParam("page") int page) {
        logger.info("Receive load user data request, page = " + page);
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
        logger.info("Receive load all user data request, page = " + page);
        if (page <= 0) {
            return new ModelAndView("admin/usersAll?page=1");
        }
        int size = 50;
        List<User> users = loadUserDataService.getUserDataByPage((page - 1) * 50, size, true);
        model.addAttribute("usersNAList", users);
        return new ModelAndView("admin/usersAll");
    }

    @RequestMapping(value = "/admin/getUsersPage", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public
    @ResponseBody
    String getUsersPage() {
        Integer page = loadUserDataService.getActiveUserLength();
        if (page == null) {
            page = 1;
        }
        if (page <= 50) {
            page = 1;
        } else {
            page /= 50;
        }
        return "{\"page\":" + page + "}";
    }

    @RequestMapping(value = "/admin/getUsersAllPage", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public
    @ResponseBody
    String getUsersAllPage() {
        Integer page = loadUserDataService.getAllUserLength();
        if (page == null) {
            page = 1;
        }
        if (page <= 50) {
            page = 1;
        } else {
            page /= 50;
        }
        return "{\"page\":" + page + "}";
    }
}

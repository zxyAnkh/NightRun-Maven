package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.util.ReadExcel;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.json.StudentNoPojo;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.ManagerUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zxy on 11/29/2016.
 */
@Controller("manageUserController")
public class ManageUserController {

    @Autowired
    private ManagerUserService managerUserService;

    @RequestMapping(value = "/admin/userAdd", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public ModelAndView userAdd() {
        return new ModelAndView("admin/userAdd");
    }

    @RequestMapping(value = "/admin/userAdd", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public ModelAndView userAdd(UserForm userForm) {
        managerUserService.insertUser(userForm);
        return new ModelAndView(new RedirectView("users?page=1"));
    }

    @RequestMapping(value = "/admin/usersAdd", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public ModelAndView usersAdd() {
        return new ModelAndView("admin/usersAdd");
    }

    @RequestMapping(value = "/admin/usersAdd", method = RequestMethod.POST)
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public ModelAndView usersAdd(HttpSession httpSession, @RequestParam("file") MultipartFile multipartFile) {
        String path = httpSession.getServletContext().getRealPath("/app/upload");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = simpleDateFormat.format(new Date());
        File file = new File(path, fileName + ".xls");
        try {
            multipartFile.transferTo(file);
            List<UserForm> formList = new ReadExcel().readExcel(file.getPath());
            if (formList != null) {
                for (UserForm userForm : formList) {
                    managerUserService.insertUser(userForm);
                }
            }
            return new ModelAndView(new RedirectView("users?page=1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView(new RedirectView("users?page=1"));
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_DELETE)
    public String deleteUser(@RequestBody StudentNoPojo pojo) {
        for (String no : pojo.getNos()) {
            managerUserService.deleteUser(no);
        }
        return "";
    }

    @RequestMapping(value = "/admin/restore", method = RequestMethod.PUT)
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    @RequiresPermissions(value = PermissionSign.USER_RESTORE)
    public String restoreUser(@RequestBody StudentNoPojo pojo) {
        for (String no : pojo.getNos()) {
            managerUserService.restoreUser(no);
        }
        return "";
    }

}

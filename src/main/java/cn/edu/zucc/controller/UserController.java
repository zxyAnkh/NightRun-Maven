package cn.edu.zucc.controller;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.form.BeanuserForm;
import cn.edu.zucc.handle.ReadExcel;
import cn.edu.zucc.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zxy on 6/5/2016.
 */
@Controller("userController")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/view/user/signin")
    public String doLogin(String no, String pwd) {
        if (userService.doLogin(no, pwd))
            return "redirect:main";
        else
            return "user/signin";
    }

    @RequestMapping("/view/user/modify")
    public String modify(int id, String pwd) {
        userService.modifyPwd(id, pwd);
        return "redirect:main";
    }

    @RequestMapping(value = "/view/admin/userAdd")
    public String userAdd() {
        return "/admin/userAdd";
    }

    @RequestMapping(value = "/view/admin/usersAdd")
    public String usersAdd() {
        return "/admin/usersAdd";
    }

    @RequestMapping(value = "/view/admin/add")
    public String add(BeanuserForm beanuserForm, HttpSession httpSession) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            if (beanadminEntity.getAbranch() == Integer.parseInt(beanuserForm.getNo().substring(4, 5)) && userService.addUser(beanuserForm))
                return "redirect:users";
            else
                return "redirect:users";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/adds")
    public String adds(HttpSession httpSession, @RequestParam("file") MultipartFile multipartFile) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String path = httpSession.getServletContext().getRealPath("/upload");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = simpleDateFormat.format(new Date());
            File file = new File(path, fileName + ".xls");
            try {
                multipartFile.transferTo(file);
                List<BeanuserForm> formList = new ReadExcel().readExcel(file.getPath());
                if (formList != null) {
                    for (BeanuserForm beanuserForm : formList) {
                        userService.addUser(beanuserForm);
                        System.out.println(beanuserForm.getNo());
                    }
                    return "redirect:users";
                }
                return "redirect:users";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/delete")
    public String deleteuser(HttpSession httpSession, @RequestBody String snolist) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            for (int i = 0; i < snolist.length() - 1; i += 8) {
                String str = snolist.substring(i, i + 8);
                userService.deleteUser(str, beanadminEntity.getAbranch());
            }
            return "redirect:users";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/restore")
    public String restoreUser(HttpSession httpSession, @RequestBody String snolist) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            for (int i = 0; i < snolist.length() - 1; i += 8) {
                String str = snolist.substring(i, i + 8);
                userService.modifyDel(str, beanadminEntity.getAbranch());
            }
            return "redirect:users";
        }
        return "admin/signin";
    }
}

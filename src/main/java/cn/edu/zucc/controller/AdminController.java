package cn.edu.zucc.controller;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.form.BeanadminForm;
import cn.edu.zucc.service.AdminService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * Created by zxy on 5/12/2016.
 */
@Controller("adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @RequestMapping(value = "/view/admin/signin")
    public String doLogin(@Valid BeanadminEntity admin, Model model, BindingResult bindingResult, HttpSession httpSession) {
        logger.info("signin");
        BeanadminEntity beanadminEntity = adminService.doLogin(admin.getAno(), admin.getApwd());
        if (bindingResult.hasErrors()) {
            return "admin/signin";
        }
        if (beanadminEntity != null) {
            model.addAttribute("beanadminEntity", beanadminEntity);
            httpSession.setAttribute("beanadminEntity", beanadminEntity);
            return "redirect:main";
        } else
            return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/signout")
    public String doSignOut(HttpSession httpSession) {
        httpSession.removeAttribute("beanadminEntity");
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/admin")
    public String admin() {
        return "/admin/admin";
    }

    @RequestMapping(value = "/view/admin/modify")
    public String modify(HttpSession httpSession, BeanadminForm beanadminForm, Model model) {
        logger.info("modify");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            model.addAttribute("beanadminForm", beanadminForm);
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            if (beanadminForm.getOldpwd() != null && beanadminForm.getOldpwd().equals(beanadminEntity.getApwd())) {
                if (!"".equals(beanadminForm.getNewpwd2()))
                    beanadminEntity.setApwd(beanadminForm.getNewpwd2());
                beanadminEntity.setAname(beanadminForm.getName());
                if (adminService.modifyAdmin(beanadminEntity))
                    return "redirect:main"; //修改完之后url为/modify 在线等 over hhhh
                else {
                    return "admin/admin";
                }
            }
        }
        return "admin/signin";
    }

}
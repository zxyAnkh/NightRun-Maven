package cn.edu.zucc.controller;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import cn.edu.zucc.form.BeanadminForm;
import cn.edu.zucc.form.BeanuserForm;
import cn.edu.zucc.handle.ReadExcel;
import cn.edu.zucc.service.AdminService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
@Controller("adminController")
@RequestMapping("/view/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
//    @Autowired
//    private CacheManager cacheManager;

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @RequestMapping(value = "/signin")
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

    @RequestMapping(value = "/signout")
    public String doSignOut(HttpSession httpSession) {
        httpSession.removeAttribute("beanadminEntity");
        return "admin/signin";
    }

    //由于登录后url仍为admin_login 所以不知道怎么跳转到这里 admin_login返回时添加redirect
    @RequestMapping(value = "/main")
    public String mainPage(Model model, HttpSession httpSession) {
        logger.info("mainPage");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsRunEntity> viewJsRunEntityList = adminService.loadRun(ano, 1);
            model.addAttribute("viewJsRunEntityList", viewJsRunEntityList);
            return "admin/main";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model, HttpSession httpSession) {
        logger.info("mainPageFuzzyQuery");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            if ("rkeyword".equals(type) || "rtime".equals(type)) {
                List<ViewJsRunEntity> runSearchResult = adminService.findRun(type, keyword, 1);
                model.addAttribute("runSearchResult", runSearchResult);
            } else if ("skeyword".equals(type)) {
                List<ViewJsAsEntity> viewJsAsEntities = adminService.findUser(keyword,1);
                model.addAttribute("viewJsAsEntities",viewJsAsEntities);
            }else if("statistics".equals(type)){
                List<ViewJsTotalEntity> viewJsTotalEntities = adminService.findTotal(keyword,1);
                model.addAttribute("viewJsTotalEntities",viewJsTotalEntities);
            }
            logger.info(keyword);
            return "admin/search";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "/admin/admin";
    }

    @RequestMapping(value = "/modify")
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

    @RequestMapping(value = "/users")
    public String showUser(Model model, HttpSession httpSession) {
        logger.info("users");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsAsEntity> viewJsAsEntityList = adminService.loadUser(ano, Boolean.FALSE);
            model.addAttribute("viewJsAsEntityList", viewJsAsEntityList);
            return "admin/users";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/usersAll")
    public String showAllUser(Model model, HttpSession httpSession) {
        logger.info("usersAll");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsAsEntity> viewJsAsEntities = adminService.loadUser(ano, Boolean.TRUE);
            model.addAttribute("viewJsAsEntities", viewJsAsEntities);
            return "admin/usersAll";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/userAdd")
    public String userAdd() {
        return "/admin/userAdd";
    }

    @RequestMapping(value = "/usersAdd")
    public String usersAdd() {
        return "/admin/usersAdd";
    }

    @RequestMapping(value = "/add")
    public String add(BeanuserForm beanuserForm, HttpSession httpSession) {
        logger.info("add");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            if (beanadminEntity.getAbranch() == Integer.parseInt(beanuserForm.getNo().substring(4, 5)) && adminService.addUser(beanuserForm))
                return "redirect:users";
            else
                return "redirect:users";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/adds")
    public String adds(HttpSession httpSession, @RequestParam("file") MultipartFile multipartFile) {
        logger.info("adds");
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
                        adminService.addUser(beanuserForm);
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

    @RequestMapping(value = "/delete")
    public String deleteuser(HttpSession httpSession, @RequestBody String snolist) {
        logger.info("deleteuser");
        if (httpSession.getAttribute("beanadminEntity") != null) {
            BeanadminEntity beanadminEntity = (BeanadminEntity) httpSession.getAttribute("beanadminEntity");
            for (int i = 0; i < snolist.length() - 1; i += 8) {
                String str = snolist.substring(i, i + 8);
                adminService.deleteUser(str, beanadminEntity.getAbranch());
            }
            return "redirect:users";
        }
        return "admin/signin";
    }
}
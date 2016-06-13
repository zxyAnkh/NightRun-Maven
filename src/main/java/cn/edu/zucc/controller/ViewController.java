package cn.edu.zucc.controller;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import cn.edu.zucc.handle.WriteExcel;
import cn.edu.zucc.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 6/13/2016.
 */
@Controller("viewController")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/view/admin/main")
    public String mainPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsRunEntity> viewJsRunEntityList = viewService.loadRun(ano, 1);
            model.addAttribute("viewJsRunEntityList", viewJsRunEntityList);
            return "admin/main";
        }
        return "admin/signin";
    }

    @RequestMapping("/view/user/main")
    public String main(String sno, Model model) {
        String no = "31301413";
        List<Map<String, String>> list = viewService.loadRun(no);
        model.addAttribute("list", list);
        return "user/main";
    }

    @RequestMapping(value = "/view/admin/users")
    public String showUser(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsAsEntity> viewJsAsEntityList = viewService.loadUser(ano, Boolean.FALSE);
            model.addAttribute("viewJsAsEntityList", viewJsAsEntityList);
            return "admin/users";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/usersAll")
    public String showAllUser(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            String ano = ((BeanadminEntity) httpSession.getAttribute("beanadminEntity")).getAno();
            List<ViewJsAsEntity> viewJsAsEntities = viewService.loadUser(ano, Boolean.TRUE);
            model.addAttribute("viewJsAsEntities", viewJsAsEntities);
            return "admin/usersAll";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/export")
    public String export(HttpSession httpSession, HttpServletResponse response) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            List<ViewJsRunEntity> viewJsRunEntityList = viewService.loadRun("admin", 1);
            String path = httpSession.getServletContext().getRealPath("/download/");
            String fileName = new WriteExcel().createRunExcel(viewJsRunEntityList, path);
            File file = new File(path, fileName + ".xls");
            if (file.exists()) {
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
                byte[] buffer = new byte[1024];
                try {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    os.flush();
                    return "redirect:main";
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "redirect:main";
        }
        return "admin/signin";
    }

    @RequestMapping(value = "/view/admin/search", method = RequestMethod.GET)
    public String search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("beanadminEntity") != null) {
            if ("rkeyword".equals(type) || "rtime".equals(type)) {
                List<ViewJsRunEntity> runSearchResult = viewService.findRun(type, keyword, 1);
                model.addAttribute("runSearchResult", runSearchResult);
            } else if ("skeyword".equals(type)) {
                List<ViewJsAsEntity> viewJsAsEntities = viewService.findUser(keyword, 1);
                model.addAttribute("viewJsAsEntities", viewJsAsEntities);
            } else if ("statistics".equals(type)) {
                List<ViewJsTotalEntity> viewJsTotalEntities = viewService.findTotal(keyword, 1);
                model.addAttribute("viewJsTotalEntities", viewJsTotalEntities);
            } else if ("all".equals(type)) {
                List<ViewJsRunEntity> runSearchResult = viewService.findRun("rkeyword", keyword, 1);
                model.addAttribute("runSearchResult", runSearchResult);
                List<ViewJsAsEntity> viewJsAsEntities = viewService.findUser(keyword, 1);
                model.addAttribute("viewJsAsEntities", viewJsAsEntities);
                List<ViewJsTotalEntity> viewJsTotalEntities = viewService.findTotal(keyword, 1);
                model.addAttribute("viewJsTotalEntities", viewJsTotalEntities);
            }
            return "admin/search";
        }
        return "admin/signin";
    }
}

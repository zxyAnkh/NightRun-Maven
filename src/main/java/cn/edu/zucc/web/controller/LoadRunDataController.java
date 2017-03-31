package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.LoadRunDataService;
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
 * Created by zxy on 11/19/2016.
 */
@Controller("loadRunDataController")
public class LoadRunDataController {

    private static final Log logger = LogFactory.getLog(LoadRunDataController.class);

    @Resource
    private LoadRunDataService loadRunDataService;

    @RequestMapping(value = "/admin/main", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public ModelAndView loadDataForAdmin(Model model, @RequestParam("page") int page) {
        logger.info("Receive load data request, page = " + page);
        if (page <= 0) {
            return new ModelAndView("admin/main?page=1");
        }
        int size = 50;
        List<ViewRun> dataList = loadRunDataService.getRunDataByPageSize((page - 1) * size, size);
        model.addAttribute("viewRunList", dataList);
        return new ModelAndView("admin/main");
    }

    @RequestMapping(value = "/admin/getRunPage")
    @RequiresRoles(value = RoleSign.ADMIN)
    public
    @ResponseBody
    String getRunPage() {
        Integer page = loadRunDataService.getPage();
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

    @RequestMapping(value = "/user/loadRunData", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.USER)
    @ResponseBody
    public String loadDataForUser(@RequestParam("no") String no) {
        logger.info("Receive load data request, student no  = " + no);
        if (null == no || "".equals(no)) {
            return "{\"data\":\"\"}";
        }
        return loadRunDataService.getRunDataByUserNo(no);
    }

}

package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.SearchService;
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
 * Created by zxy on 11/20/2016.
 */
@Controller("searchController")
public class SearchController {

    private static final Log logger = LogFactory.getLog(SearchController.class);

    @Resource
    private SearchService searchService;

    @RequestMapping(value = "/admin/search", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public ModelAndView search(@RequestParam("type") String type, @RequestParam("keyword") String keyword, @RequestParam("page") int page, Model model) {
        if (page <= 0) {
            return new ModelAndView("admin/search?type=" + type + "&keyword=" + keyword + "&page=1");
        }
        int size = 50;
        if ("all".equals(type)) {
            List<User> result = searchService.selectByKeyword(keyword, (page - 1) * size, size);
            model.addAttribute("searchResult", result);
        } else if ("details".equals(type)) {
            List<ViewRun> result_list = searchService.selectRunsByUserno(keyword, (page - 1) * size, size);
            ViewTotal result_total = searchService.selectRunByUserno(keyword);
            model.addAttribute("searchDetailsList", result_list);
            model.addAttribute("searchDetailsTotal", result_total);
        }
        return new ModelAndView("admin/search");
    }

    @RequestMapping(value = "/admin/getSearchPage", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    @ResponseBody
    public String getSearchPage(@RequestParam("type") String type, @RequestParam("keyword") String keyword) {
        Integer page = 0;
        if ("all".equals(type)) {
            page = searchService.getPageAll(keyword);
        } else if ("details".equals(type)) {
            page = searchService.getPageDetails(keyword);
        }

        if (page == null) {
            page = 1;
        }
        if (page <= 50) {
            page = 1;
        } else {
            page /= 50;
        }
        logger.info("get search page, type=" + type + ",keyword=" + keyword + ",page=" + page);
        return "{\"page\":" + page + "}";
    }

}

package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.AsyncDataService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zxy on 11/20/2016.
 */
@Controller("asyncDataController")
public class AsyncDataController {

    @Autowired
    private AsyncDataService asyncDataService;

    @RequestMapping(value = "/user/async", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.USER)
    public String asyncData(@RequestParam("user") String userno) {
        if (null == userno || "".equals(userno)) {
            return "{}";
        }
        return asyncDataService.getUserData(userno);
    }

}

package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.AsyncDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by zxy on 11/20/2016.
 */
@Controller("asyncDataController")
public class AsyncDataController {

    private static final Log logger = LogFactory.getLog(AsyncDataController.class);

    @Resource
    private AsyncDataService asyncDataService;

    @RequestMapping(value = "/user/async", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.USER)
    public String asyncData(@RequestParam("user") String userno) {
        logger.info("Receive async data request, student no = " + userno);
        if (null == userno || "".equals(userno)) {
            return "{}";
        }
        return asyncDataService.getUserData(userno);
    }

}

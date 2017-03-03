package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.json.RunDataPojo;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.AddRunDataService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zxy on 12/3/2016.
 */
@Controller("addRunDataController")
public class AddRunDataController {

    private static final Log logger = LogFactory.getLog(AddRunDataController.class);

    @Autowired
    private AddRunDataService addRunDataService;

    @RequestMapping("/user/run")
    @ResponseBody
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.RUN_CREATE)
    public String addRunData(@RequestBody RunDataPojo pojo) {
        logger.info("Receive add run data request, pojo = " + pojo.toString());
        boolean bool = addRunDataService.insert(pojo);
        logger.info("Add run data " + bool);
        return bool ? "{\"result\":true}" :  "{\"result\":false}";
    }

}

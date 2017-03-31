package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.json.AddRunRequest;
import cn.edu.zucc.web.json.RunDataPojo;
import cn.edu.zucc.web.security.PermissionSign;
import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.AddRunDataService;
import cn.edu.zucc.web.service.PhoneUIDService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zxy on 12/3/2016.
 */
@Controller("addRunDataController")
public class AddRunDataController {

    private static final Log logger = LogFactory.getLog(AddRunDataController.class);

    @Resource
    private AddRunDataService addRunDataService;
    @Resource
    private PhoneUIDService phoneUIDService;

    @RequestMapping("/user/run")
    @ResponseBody
    @RequiresRoles(value = RoleSign.USER)
    @RequiresPermissions(value = PermissionSign.RUN_CREATE)
    public String addRunData(@RequestBody AddRunRequest json) {
        String phoneuid = phoneUIDService.getPhoneUID(json.getNo());
        if (json.getPhoneuid() != null && phoneuid != null && phoneuid.equals(json.getPhoneuid())) {
            RunDataPojo pojo = new RunDataPojo();
            pojo.setSno(json.getNo());
            pojo.setMeter(Double.parseDouble(json.getMeter()));
            pojo.setStime(Long.parseLong(json.getStarttime()));
            pojo.setEtime(Long.parseLong(json.getEndtime()));
            logger.info("Receive add run data request, pojo = " + json.toString());
            boolean bool = addRunDataService.insert(pojo);
            logger.info("Add run data " + bool);
            return bool ? "{\"result\":true}" : "{\"result\":false}";
        }
        return "{\"result\":false}";
    }

}

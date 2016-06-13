package cn.edu.zucc.controller;

import cn.edu.zucc.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zxy on 6/13/2016.
 */
@Controller("runController")
public class RunController {

    @Autowired
    private RunService runService;

    @RequestMapping("/view/user/run")
    public String run(String sno, String starttime, String endtime) {
        runService.addRun(sno, starttime, endtime);
        return "redirect:main";
    }
}

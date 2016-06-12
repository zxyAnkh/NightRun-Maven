package cn.edu.zucc.controller;

import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 6/5/2016.
 */
@Controller("userController")
@RequestMapping("/view/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signin")
    public String doLogin(String no, String pwd) {
        if (userService.doLogin(no, pwd))
            return "redirect:main";
        else
            return "user/signin";
    }

    @RequestMapping("/main")
    public String main(String sno, Model model) {
        String no = "31301413";
        List<Map<String, String>> list = userService.loadRun(no);
        model.addAttribute("list", list);
        return "user/main";
    }

    @RequestMapping("/run")
    public String run(String sno, String starttime, String endtime) {
        userService.addRun(sno, starttime, endtime);
        return "redirect:main";
    }

    @RequestMapping("/modify")
    public String modify(int id, String pwd) {
        userService.modifyPwd(id, pwd);
        return "redirect:main";
    }

}

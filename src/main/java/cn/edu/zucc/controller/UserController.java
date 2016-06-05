package cn.edu.zucc.controller;

import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("signin")
    public String doLogin(String no, String pwd) {
        if (userService.doLogin(no, pwd))
            return "redirect:main";
        else
            return "/user/signin";
    }

    @RequestMapping("main")
    public String main() {
        String no = "31301413";
        Map map = new HashMap();
        List<ViewJsRunEntity> list = userService.loadRun(no);
        int count = 0;
        for (ViewJsRunEntity viewJsRunEntity : list) {
            map.put(++count, viewJsRunEntity);
        }
        JSONObject json = new JSONObject(map);
        return null;
    }

}

package cn.edu.zucc.controller;

import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.UserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void doLogin() throws Exception {
        System.out.println(userService.doLogin("31301413", "123456"));
    }

    @Test
    public void main() throws Exception {
        List<Map<String, String>> viewJsRunEntityList = userService.loadRun("31301413");
        for (Map<String, String> map : viewJsRunEntityList){
            System.out.println(map.get("sno"));
        }
    }

    @Test
    public void run() throws Exception {
        System.out.println(userService.addRun("31301413","2016-06-11 10:11:11","2016-06-11 10:11:11"));
    }

    @Test
    public void modify() throws Exception {
        System.out.println(userService.modifyPwd(1,"123456"));
    }

}
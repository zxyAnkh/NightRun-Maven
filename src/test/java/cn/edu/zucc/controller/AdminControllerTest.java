package cn.edu.zucc.controller;

import cn.edu.zucc.service.AdminService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/6/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminControllerTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void deleteuser() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("1", "31301001");
        jsonObject.put("2", "31301002");
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= jsonObject.length(); i++) {
            list.add(jsonObject.getString(String.valueOf(i)));
            System.out.println(list.get(i - 1));
        }
        if(adminService.deleteUser(list,1))
            System.out.println("success");
    }

}
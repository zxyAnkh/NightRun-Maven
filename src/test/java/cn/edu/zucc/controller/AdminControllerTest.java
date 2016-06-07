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
    }

}
package cn.edu.zucc.controller;

import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.service.AdminService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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
    public void showUser(){
        List<ViewJsAsEntity> list = adminService.loadUser("admin",Boolean.FALSE);
        for(ViewJsAsEntity viewJsAsEntity : list){
            System.out.println(viewJsAsEntity.getSno());
        }
    }
    @Test
    public void showUser2(){
        List<ViewJsAsEntity> list = adminService.loadUser("admin",Boolean.FALSE);
        for(ViewJsAsEntity viewJsAsEntity : list){
            System.out.println(viewJsAsEntity.getSno());
        }
    }

}
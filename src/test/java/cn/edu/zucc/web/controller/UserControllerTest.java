package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() throws Exception {

    }

}
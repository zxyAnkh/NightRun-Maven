package cn.edu.zucc.controller;

import cn.edu.zucc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void deleteuser() throws Exception {
        System.out.println(userService.deleteUser("31301413",1));
    }

    @Test
    public void restoreUser() throws Exception {
        System.out.println(userService.modifyDel("31301413",1));
    }

}
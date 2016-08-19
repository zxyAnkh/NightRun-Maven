package cn.edu.zucc.web.controller;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/11.
 */
public class AdminControllerTest extends TestSupport{

    @Autowired
    private UserService userService;

    @Test
    public void checkUser() throws Exception {
        System.out.println(userService.selectByUserno("31301108") == null ? 1 : 0);
    }

}
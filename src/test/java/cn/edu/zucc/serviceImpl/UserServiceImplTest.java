package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addRun() throws Exception {
        System.out.println(userService.addRun("31301413","2016-06-10 11:00:00","2016-06-10 11:16:00"));
    }

}
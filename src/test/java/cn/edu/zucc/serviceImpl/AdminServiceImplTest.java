package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/6/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void deleteUser() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("31301001");
        list.add("31301002");
        if(adminService.deleteUser(list,1))
            System.out.println("success");
    }

}
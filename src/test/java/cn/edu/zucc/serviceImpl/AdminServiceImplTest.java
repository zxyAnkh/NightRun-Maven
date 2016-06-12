package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.entity.ViewJsAsEntity;
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
    public void findUser() {
        List<ViewJsAsEntity> list = adminService.findUser("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : list)
            System.out.println(viewJsAsEntity.getSno());
    }

    @Test
    public void findUser2() {
        List<ViewJsAsEntity> list = adminService.findUser("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : list)
            System.out.println(viewJsAsEntity.getSno());
    }

    @Test
    public void findUser3() {
        List<ViewJsAsEntity> list = adminService.findUser("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : list)
            System.out.println(viewJsAsEntity.getSno());
    }

    @Test
    public void findUser4() {
        List<ViewJsAsEntity> list = adminService.findUser("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : list)
            System.out.println(viewJsAsEntity.getSno());
    }

    @Test
    public void findUser5() {
        List<ViewJsAsEntity> list = adminService.findUser("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : list)
            System.out.println(viewJsAsEntity.getSno());
    }
}
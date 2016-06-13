package cn.edu.zucc.controller;

import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import cn.edu.zucc.service.ViewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class ViewControllerTest {

    @Autowired
    private ViewService viewService;

    @Test
    public void search() throws Exception {
        List<ViewJsAsEntity> viewJsAsEntities = viewService.findUser("1413", 1);
        List<ViewJsRunEntity> list = viewService.findRun("rkeyword", "1413", 1);
        List<ViewJsTotalEntity> totalEntities = viewService.findTotal("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : viewJsAsEntities)
            System.out.println(viewJsAsEntity.getSno());
        for (ViewJsRunEntity viewJsRunEntity : list)
            System.out.println(viewJsRunEntity.getSno());
        for (ViewJsTotalEntity viewJsTotalEntity : totalEntities)
            System.out.println(viewJsTotalEntity.getCount());
    }

    @Test
    public void search2() throws Exception {
        System.out.println();
        List<ViewJsAsEntity> viewJsAsEntities = viewService.findUser("1413", 1);
        List<ViewJsRunEntity> list = viewService.findRun("rkeyword", "1413", 1);
        List<ViewJsTotalEntity> totalEntities = viewService.findTotal("1413", 1);
        for (ViewJsAsEntity viewJsAsEntity : viewJsAsEntities)
            System.out.println(viewJsAsEntity.getSno());
        for (ViewJsRunEntity viewJsRunEntity : list)
            System.out.println(viewJsRunEntity.getSno());
        for (ViewJsTotalEntity viewJsTotalEntity : totalEntities)
            System.out.println(viewJsTotalEntity.getCount());
    }

}
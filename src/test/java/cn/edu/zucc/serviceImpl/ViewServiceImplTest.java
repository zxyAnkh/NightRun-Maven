package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.viewDao.ViewJsAsDao;
import cn.edu.zucc.dao.viewDao.ViewJsRunDao;
import cn.edu.zucc.dao.viewDao.ViewJsTotalDao;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class ViewServiceImplTest {

    @Autowired
    private ViewJsAsDao viewJsAsDao;
    @Autowired
    private ViewJsTotalDao viewJsTotalDao;
    @Autowired
    private ViewJsRunDao viewJsRunDao;

    @Test
    public void findUser() throws Exception {
        List<ViewJsAsEntity> list = viewJsAsDao.findUser("1413");
        for (ViewJsAsEntity viewJsAsEntity:list)
            System.out.println(viewJsAsEntity.getSno());
    }

    @Test
    public void findRun() throws Exception {
        List<ViewJsRunEntity> list = viewJsRunDao.findRun("rkeyword","1413");
        for (ViewJsRunEntity viewJsRunEntity:list)
            System.out.println(viewJsRunEntity.getSno());
    }

    @Test
    public void findTotal() throws Exception {
        List<ViewJsTotalEntity> list = viewJsTotalDao.findTotal("1413");
        for (ViewJsTotalEntity viewJsTotalEntity:list)
            System.out.println(viewJsTotalEntity.getSno());
    }

}
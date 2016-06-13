package cn.edu.zucc.daoImpl.viewDaoImpl;

import cn.edu.zucc.dao.viewDao.ViewJsAsDao;
import cn.edu.zucc.entity.ViewJsAsEntity;
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
public class ViewJsAsDaoImplTest {

    @Autowired
    private ViewJsAsDao viewJsAsDao;

    @Test
    public void findUser() throws Exception {
        List<ViewJsAsEntity> list = viewJsAsDao.findUser("1413");
        for (ViewJsAsEntity viewJsAsEntity:list)
            System.out.println(viewJsAsEntity.getSno());
    }

}
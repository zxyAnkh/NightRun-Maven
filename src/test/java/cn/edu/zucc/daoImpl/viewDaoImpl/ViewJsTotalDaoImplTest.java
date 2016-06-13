package cn.edu.zucc.daoImpl.viewDaoImpl;

import cn.edu.zucc.dao.viewDao.ViewJsTotalDao;
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
public class ViewJsTotalDaoImplTest {

    @Autowired
    private ViewJsTotalDao viewJsTotalDao;

    @Test
    public void findTotal() throws Exception {
        List<ViewJsTotalEntity> list = viewJsTotalDao.findTotal("1413");
        for (ViewJsTotalEntity viewJsTotalEntity:list)
            System.out.println(viewJsTotalEntity.getSno());
    }

}
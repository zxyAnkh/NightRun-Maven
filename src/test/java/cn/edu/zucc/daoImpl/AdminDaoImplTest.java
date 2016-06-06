package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.ViewJsAsEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by zxy on 6/6/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class AdminDaoImplTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void findByNo() throws Exception {

    }

    @Test
    public void findByNo1() throws Exception {

    }

    @Test
    public void loadUser() throws Exception {

    }

    @Test
    public void loadRun() throws Exception {

    }

    @Test
    public void findRun() throws Exception {

    }

    @Test
    public void modify() throws Exception {

    }

    @Test
    public void addUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {
        int id = 9;
        if(adminDao.deleteUser(id)) {
            System.out.println("delelte success");
            ViewJsAsEntity viewJsAsEntity = adminDao.findByNo("31301002", 1);
            System.out.println(viewJsAsEntity.getDeltime());
        }
    }
}
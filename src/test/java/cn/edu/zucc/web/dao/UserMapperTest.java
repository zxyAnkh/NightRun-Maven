package cn.edu.zucc.web.dao;

import cn.edu.zucc.core.feature.test.TestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/9.
 */
public class UserMapperTest extends TestSupport{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByUserid() throws Exception {
        System.out.println(userMapper.deleteByUserid(11));
        System.out.println(userMapper.deleteByUserid(10));
        System.out.println(userMapper.deleteByUserid(8));
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void selectByKeyword() throws Exception {

    }

    @Test
    public void updateByRecord() throws Exception {

    }

    @Test
    public void authentication() throws Exception {

    }

    @Test
    public void selectPwdByUserno() throws Exception {

    }

    @Test
    public void selectByUserno() throws Exception {

    }

    @Test
    public void selectUsers() throws Exception {

    }

}
package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/6.
 */
public class UserServiceImplTest extends TestSupport{

    @Autowired
    private UserService userService;

    @Test
    public void deleteByUserid() throws Exception{
        userService.deleteByUserid(9);
    }

    @Test
    public void selectByKeyword()throws Exception {
        List<User> list = userService.selectByKeyword("%"+"110"+"%");
        for (User user:list)
            System.out.println(user.getUserno());
    }

    @Test
    public void updateByRecord() throws Exception{
    }


    @Test
    public void authentication() throws Exception {
        User user = userService.authentication(new User("admin01", "123456"));
        if (user == null)
            System.out.println("user is null");
        else
            System.out.println(user.getUsername());
    }

    @Test
    public void selectByUserno()throws Exception{
        User user = userService.selectByUserno("admin01");
        if (user == null)
            System.out.println("user is null");
        else
            System.out.println(user.getUsername());
    }

    @Test
    public void insert() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setUserno("31301008");
        userForm.setUsername("学生测试");
        userService.insert(userForm);
    }

}
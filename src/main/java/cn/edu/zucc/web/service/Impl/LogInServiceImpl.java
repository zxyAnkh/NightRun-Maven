package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxy on 11/13/2016.
 */
@Service("logInService")
public class LogInServiceImpl implements LogInService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserno(String userno){
        return userMapper.selectByUserno(userno);
    }
}

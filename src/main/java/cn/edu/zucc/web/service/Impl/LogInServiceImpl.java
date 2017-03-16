package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.LogInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zxy on 11/13/2016.
 */
@Service("logInService")
public class LogInServiceImpl implements LogInService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByUserno(String userno){
        return userMapper.selectByUserno(userno);
    }
}

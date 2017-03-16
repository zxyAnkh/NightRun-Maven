package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.service.PhoneUIDService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zxy on 3/16/2017.
 */
@Service
public class PhoneUIDServiceImpl implements PhoneUIDService{

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean updatePhoneUID(String no, String uid) {
        return userMapper.updatePhoneUID(no, uid) == 1;
    }

    @Override
    public String getPhoneUID(String no) {
        return userMapper.getPhoneUID(no);
    }
}

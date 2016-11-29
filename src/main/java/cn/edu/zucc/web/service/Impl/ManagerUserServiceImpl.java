package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxy on 11/29/2016.
 */
@Service("managerUserService")
public class ManagerUserServiceImpl implements ManagerUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserForm user) {
        return false;
    }

    @Override
    public boolean deleteUser(String no) {
        return false;
    }

    @Override
    public boolean restoreUser(String no) {
        return false;
    }
}

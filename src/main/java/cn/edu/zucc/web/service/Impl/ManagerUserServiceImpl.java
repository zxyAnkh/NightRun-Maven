package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.ManagerUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zxy on 11/29/2016.
 */
@Service("managerUserService")
public class ManagerUserServiceImpl implements ManagerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserForm user) {
        User u = new User();
        u.setUserno(user.getUserno());
        u.setUsername(user.getUsername());

        // return true if effective row is 1 row
        return userMapper.insert(u) == 1;
    }

    @Override
    public boolean deleteUser(String no) {
        int id = userMapper.selectByUserno(no).getId();

        return userMapper.deleteByUserid(id) == 1;
    }

    @Override
    public boolean restoreUser(String no) {
        int id = userMapper.selectByUserno(no).getId();

        return userMapper.updateDelByUserid(id) == 1;
    }
}

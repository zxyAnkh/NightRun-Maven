package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.ManagerUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by zxy on 11/29/2016.
 */
@Service("managerUserService")
public class ManagerUserServiceImpl implements ManagerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insertUser(UserForm user) {
        User u = userMapper.selectByUserno(user.getUserno());
        if (u != null) {
            return false;
        }
        u.setUserno(user.getUserno());
        u.setUsername(user.getUsername());
        u.setUserbranch(String.valueOf(user.getUserno().charAt(4)));
        u.setUsergrade(user.getUserno().substring(1, 3));
        try {
            u.setPassword(PasswordHash.createHash("123"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

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

package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.core.generic.GenericServiceImpl;
import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.form.UserInfoForm;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 2016/7/6.
 * @author zxyAnkh
 * @since  2016-07-06
 */
@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public GenericDao<User, Integer> getDao() {
        return userMapper;
    }

    @Override
    public int insert(UserForm record) {
        User user = new User();
        try {
            user.setUserno(record.getUserno());
            user.setUsername(record.getUsername());
            user.setPassword(PasswordHash.createHash("123456"));
            user.setUserbranch(record.getUserno().substring(4, 5));
            user.setUsergrade(record.getUserno().substring(1, 3));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return userMapper.insert(user);
    }

    @Override
    public int deleteByUserid(int id) {
        return userMapper.deleteByUserid(id);
    }

    @Override
    public int updateDelByUserid(int id) {
        return userMapper.updateDelByUserid(id);
    }

    @Override
    public List<User> selectByKeyword(String keyword) {
        return userMapper.selectByKeyword("%" + keyword + "%");
    }

    @Override
    public int updateByRecord(User record) {
        try {
            record.setPassword(PasswordHash.createHash(record.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return userMapper.updateByRecord(record);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    public String selectPwdByUserno(String userno) {
        return userMapper.selectPwdByUserno(userno);
    }

    @Override
    public User selectByUserno(String userno) {
        return userMapper.selectByUserno(userno);
    }

    @Override
    public List<User> selectNActiveUsers() {
        List<User> list = userMapper.selectNActiveUsers();
        List<User> result = new ArrayList<User>();
        for (User user : list) {
            user.setPassword(null);
            result.add(user);
        }
        return result;
    }

    @Override
    public List<User> selectActiveUsers() {
        List<User> list = userMapper.selectActiveUsers();
        List<User> result = new ArrayList<User>();
        for (User user : list) {
            if (user.getDeltime() == null) {
                user.setPassword(null);
                result.add(user);
            }
        }
        return result;
    }

}
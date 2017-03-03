package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.json.UserPwdPojo;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by zxy on 2016/7/6.
 *
 * @author zxyAnkh
 * @since 2016-07-06
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

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
    public int updateUserPassword(UserPwdPojo record) {
        User user = userMapper.selectByUserno(record.getNo());
        if (user == null) {
            return 0;
        }

        try {

            if(user.getPassword() == null){
                return 0;
            }
            if (!PasswordHash.validatePassword(record.getOldPwd(), user.getPassword())) {
                return 0;
            }
            user.setPassword(PasswordHash.createHash(record.getNewPwd()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return userMapper.updateByRecord(user);
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

}

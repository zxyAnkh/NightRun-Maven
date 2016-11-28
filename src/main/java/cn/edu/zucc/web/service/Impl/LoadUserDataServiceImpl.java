package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.LoadUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zxy on 11/28/2016.
 */
@Service("loadUserDataService")
public class LoadUserDataServiceImpl implements LoadUserDataService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserDataByPage(int start, int offset, boolean all) {
        if (all) {
            List<User> users = userMapper.selectNActiveUsers(start, start + offset);
            for (User user : users) {
                user.setPassword(null);
            }
            return users;
        } else {
            List<User> users = userMapper.selectActiveUsers(start, start + offset);
            for (User user : users) {
                user.setPassword(null);
            }
            return users;
        }
    }
}
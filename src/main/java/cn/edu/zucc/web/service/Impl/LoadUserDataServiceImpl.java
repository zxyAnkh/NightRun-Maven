package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.LoadUserDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 读取用户数据Service实现
 * Created by zxy on 11/28/2016.
 */
@Service("loadUserDataService")
public class LoadUserDataServiceImpl implements LoadUserDataService {

    @Resource
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

    @Override
    public Integer getAllUserLength() {
        return userMapper.getAllUserLength();
    }

    @Override
    public Integer getActiveUserLength() {
        return userMapper.getActiveUserLength();
    }
}

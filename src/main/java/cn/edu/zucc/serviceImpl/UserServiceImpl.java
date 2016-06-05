package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zxy on 5/14/2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // success: true
    @Override
    public Boolean doLogin(String sno, String pwd) {
        return userDao.doLogin(sno, pwd) != null;
    }

    @Override
    public List<ViewJsRunEntity> loadRun(String sno) {
        return userDao.loadRun(sno);
    }
}

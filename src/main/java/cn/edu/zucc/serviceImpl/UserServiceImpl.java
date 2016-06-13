package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.form.BeanuserForm;
import cn.edu.zucc.service.UserService;
import com.googlecode.ehcache.annotations.TriggersRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @TriggersRemove(cacheName = "userServiceCache",removeAll = true)
    @Override
    public Boolean modifyPwd(int id, String pwd){
        try {
            return userDao.modifyPwd(id,pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @TriggersRemove(cacheName = "userServiceCache",removeAll = true)
    @Override
    public Boolean modifyDel(String sno, int branch){
        ViewJsAsEntity viewJsAsEntity = userDao.findByNo(sno);
        int id = viewJsAsEntity.getsId();
        try {
            return userDao.modifyDel(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @TriggersRemove(cacheName = "userServiceCache",removeAll = true)
    @Override
    public Boolean addUser(BeanuserForm beanuserForm) {
        BeanuserEntity beanuserEntity = new BeanuserEntity();
        beanuserEntity.setSno(beanuserForm.getNo());
        beanuserEntity.setSname(beanuserForm.getName());
        beanuserEntity.setSpwd("123456");
        beanuserEntity.setSbranch(Integer.parseInt(beanuserForm.getNo().substring(4, 5)));
        beanuserEntity.setSgrade(Integer.parseInt(beanuserForm.getNo().substring(1, 3)));
        beanuserEntity.setAddtime(new Date());
        try {
            if (userDao.findByNo(beanuserEntity.getSno()) == null)
                return userDao.addUser(beanuserEntity);
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @TriggersRemove(cacheName = "userServiceCache",removeAll = true)
    @Override
    public Boolean deleteUser(String sno, int branch) {
        ViewJsAsEntity viewJsAsEntity = userDao.findByNo(sno);
        int id = viewJsAsEntity.getsId();
        return userDao.deleteUser(id);
    }

}

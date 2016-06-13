package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.*;
import cn.edu.zucc.form.BeanuserForm;
import cn.edu.zucc.service.AdminService;
import com.googlecode.ehcache.annotations.TriggersRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public BeanadminEntity doLogin(String no, String pwd) {
        BeanadminEntity beanadminEntity = adminDao.findByNo(no);
        if (beanadminEntity != null && pwd.equals(beanadminEntity.getApwd()))
            return beanadminEntity;
        else
            return null;
    }



    @TriggersRemove(cacheName = "adminServiceCache",removeAll = true)
    @Override
    public Boolean modifyAdmin(BeanadminEntity beanadminEntity) {
        return adminDao.modifyAdmin(beanadminEntity);
    }


}

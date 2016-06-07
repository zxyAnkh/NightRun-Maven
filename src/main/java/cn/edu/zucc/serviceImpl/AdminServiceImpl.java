package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.form.BeanuserForm;
import cn.edu.zucc.handle.ReadExcel;
import cn.edu.zucc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    @Override
//    @Cacheable(value = "mCache", key = "user")
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        return adminDao.loadUser(ano, isAll);
    }

    @Override
//    @Cacheable(value = "mCache", key = "run")
    public List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll) {
        return adminDao.loadRun(ano, branch, isAll);
    }

    @Override
    public List<ViewJsRunEntity> findRun(String type, String keyword, int branch, Boolean isAll) {
        if (keyword != null && !"".equals(keyword)) {
            return adminDao.findRun(type, keyword, branch, isAll);
        }
        return null;
    }

    @Override
    public Boolean modify(BeanadminEntity beanadminEntity) {
        return adminDao.modify(beanadminEntity);
    }

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
            if (adminDao.findByNo(beanuserEntity.getSno(), beanuserEntity.getSbranch()) == null)
                return adminDao.addUser(beanuserEntity);
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteUser(String sno, int branch) {
        ViewJsAsEntity viewJsAsEntity = adminDao.findByNo(sno, branch);
        int id = viewJsAsEntity.getsId();
        return adminDao.deleteUser(id);
    }
}

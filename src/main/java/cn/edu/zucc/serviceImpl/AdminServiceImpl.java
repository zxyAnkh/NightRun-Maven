package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        return adminDao.loadUser(ano, isAll);
    }

    @Override
    public List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll) {
        return adminDao.loadRun(ano, branch, isAll);
    }

    @Override
    public List<ViewJsRunEntity> fuzzyQuery(String type,String keyword, int branch, Boolean isAll) {
        if (keyword != null && !"".equals(keyword)){
            return adminDao.fuzzyQuery(type,keyword, branch, isAll);
        }
        return null;
    }
    @Override
    public Boolean modify(BeanadminEntity beanadminEntity) {
        return adminDao.modify(beanadminEntity);
    }
}

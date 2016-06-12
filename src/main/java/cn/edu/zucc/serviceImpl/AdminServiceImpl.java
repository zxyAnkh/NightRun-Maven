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

    @Cacheable(value = "adminServiceCache")
    @Override
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        return adminDao.loadUser(ano, isAll);
    }

    @Cacheable(value = "adminServiceCache")
    @Override
    public List<ViewJsRunEntity> loadRun(String ano, int branch) {
        return adminDao.loadRun(ano, branch);
    }

    @Cacheable(value = "adminServiceCache")
    @Override
    public List<ViewJsRunEntity> findRun(String type, String keyword, int branch) {
        if (keyword != null && !"".equals(keyword)) {
            return adminDao.findRun(type, keyword, branch);
        }
        return null;
    }

    @Cacheable(value = "adminServiceCache")
    @Override
    public List<ViewJsAsEntity> findUser(String keyword, int branch) {
        if(keyword != null && !"".equals(keyword))
            return adminDao.findUser(keyword,branch);
        return null;
    }

    @Cacheable(value = "adminServiceCache")
    @Override
    public List<ViewJsTotalEntity> findTotal(String keyword, int branch) {
        if(keyword != null && !"".equals(keyword))
            return adminDao.findTotal(keyword,branch);
        return null;
    }

    @TriggersRemove(cacheName = "adminServiceCache",removeAll = true)
    @Override
    public Boolean modifyAdmin(BeanadminEntity beanadminEntity) {
        return adminDao.modifyAdmin(beanadminEntity);
    }

    @TriggersRemove(cacheName = "adminServiceCache",removeAll = true)
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

    @TriggersRemove(cacheName = "adminServiceCache",removeAll = true)
    @Override
    public Boolean deleteUser(String sno, int branch) {
        ViewJsAsEntity viewJsAsEntity = adminDao.findByNo(sno, branch);
        int id = viewJsAsEntity.getsId();
        return adminDao.deleteUser(id);
    }
}

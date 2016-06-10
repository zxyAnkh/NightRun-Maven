package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.*;
import com.googlecode.ehcache.annotations.TriggersRemove;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

    @Override
    public BeanadminEntity findByNo(String ano) {
        String hql = "from BeanadminEntity where ano=?";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, ano);
        return (BeanadminEntity) query.uniqueResult();
    }

    // not found: true
    @Override
    public ViewJsAsEntity findByNo(String sno, int branch) {
        String hql = "from ViewJsAsEntity where sno=? order by sno";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, sno);
        return (ViewJsAsEntity) query.uniqueResult();
    }

    @TriggersRemove(cacheName = "adminDaoCache",removeAll = true)
    @Override
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        String hql = "from ViewJsAsEntity where ano=?";
        if (isAll == Boolean.FALSE)
            hql += " and deltime is null";
        else
            hql += " and deltime is not null";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql + " order by sno");
        query.setString(0, ano);
        return query.list();
    }

    @TriggersRemove(cacheName = "adminDaoCache",removeAll = true)
    @Override
    public List<ViewJsRunEntity> loadRun(String ano, int branch) {
        String hql = "from ViewJsRunEntity order by starttime";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @TriggersRemove(cacheName = "adminDaoCache",removeAll = true)
    @Override
    public List<ViewJsRunEntity> findRun(String type, String keyword, int branch) {
        String hql = "from ViewJsRunEntity";
        if ("rkeyword".equals(type)) {
            hql += " where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        } else if ("rtime".equals(type)) {
            hql += " where starttime > '" + keyword.substring(0, 4) + "-" + keyword.substring(4, 6) + "-" + keyword.substring(6, 8)
                    + "' and endtime < '" + keyword.substring(8, 12) + "-" + keyword.substring(12, 14) + "-" + keyword.substring(14) + "'";
        }
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<ViewJsAsEntity> findUser(String keyword, int branch) {
        String hql = "from ViewJsAsEntity where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        Session session = getCurrentSession();
        return session.createQuery(hql).list();
    }

    @Override
    public List<ViewJsTotalEntity> findTotal(String keyword, int branch) {
        String hql = "from ViewJsTotalEntity where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        Session session = getCurrentSession();
        return session.createQuery(hql).list();
    }

    @Override
    public Boolean modifyAdmin(BeanadminEntity beanadminEntity) {
        String hql = "update BeanadminEntity set aname = '" + beanadminEntity.getAname() + "' ,apwd = '"
                + beanadminEntity.getApwd() + "' where aId = " + beanadminEntity.getaId();
        int result = getCurrentSession().createQuery(hql).executeUpdate();
        return result == 1;
    }

    @Override
    public Boolean addUser(BeanuserEntity beanuserEntity) throws Exception {
        try {
            getCurrentSession().save(beanuserEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(int id) {
        String hql = "update BeanuserEntity set deltime = now() where sId = " + id;
        int result = getCurrentSession().createQuery(hql).executeUpdate();
        return result == 1;
    }
}

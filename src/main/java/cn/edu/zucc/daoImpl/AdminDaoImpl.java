package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
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
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BeanadminEntity findByNo(String ano) {
        String hql = "from BeanadminEntity where ano=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, ano);
        return (BeanadminEntity) query.uniqueResult();
    }

    @Override
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        String hql = "from ViewJsAsEntity where ano=?";
        if (isAll == Boolean.FALSE)
            hql += " and deltime is null";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, ano);
        return query.list();
    }

    @Override
    public List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll) {
        String hql = "from ViewJsRunEntity";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<ViewJsRunEntity> fuzzyQuery(String type, String keyword, int branch, Boolean isAll) {
        String hql = "from ViewJsRunEntity";
        if ("keyword".equals(type)) {
            hql += " where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        } else if ("time".equals(type)) {
            hql += " where starttime > '" + keyword.substring(0, 4) + "-" + keyword.substring(4, 6) + "-" + keyword.substring(6, 8)
                    + "' and endtime < '" + keyword.substring(8, 12) + "-" + keyword.substring(12, 14) + "-" + keyword.substring(14) + "'";
        }
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public Boolean modify(BeanadminEntity beanadminEntity) {
        String hql = "update BeanadminEntity set aname = '" + beanadminEntity.getAname() + "' ,apwd = '"
                + beanadminEntity.getApwd() + "' where aId = " + beanadminEntity.getaId();
        int result = sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
        return result == 1;
    }

    @Override
    public Boolean addUser(BeanuserEntity beanuserEntity) throws  Exception{
        try{
            sessionFactory.getCurrentSession().save(beanuserEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

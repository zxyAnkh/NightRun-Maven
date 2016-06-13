package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.AdminDao;
import cn.edu.zucc.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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

    @Override
    public Boolean modifyAdmin(BeanadminEntity beanadminEntity) {
        String hql = "update BeanadminEntity set aname = '" + beanadminEntity.getAname() + "' ,apwd = '"
                + beanadminEntity.getApwd() + "' where aId = " + beanadminEntity.getaId();
        int result = getCurrentSession().createQuery(hql).executeUpdate();
        return result == 1;
    }
}

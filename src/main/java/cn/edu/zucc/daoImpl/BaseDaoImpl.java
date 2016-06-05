package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zxy on 6/5/2016.
 */
@Repository("baseDao")
public class BaseDaoImpl implements BaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

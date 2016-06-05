package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxy on 5/14/2016.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

    @Override
    public BeanuserEntity doLogin(String sno, String pwd) {
        String hql = "from BeanuserEntity where sno=? and spwd=? and deltime is null";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0,sno);
        query.setString(1,pwd);
        return (BeanuserEntity)query.uniqueResult();
    }

    @Override
    public List<ViewJsRunEntity> loadRun(String sno) {
        String hql = "from ViewJsRunEntity where sno=?";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0,sno);
        return query.list();
    }
}

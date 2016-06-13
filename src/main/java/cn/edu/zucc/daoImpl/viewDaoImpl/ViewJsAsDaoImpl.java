package cn.edu.zucc.daoImpl.viewDaoImpl;

import cn.edu.zucc.dao.viewDao.ViewJsAsDao;
import cn.edu.zucc.daoImpl.BaseDaoImpl;
import cn.edu.zucc.entity.ViewJsAsEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
@Repository("viewJsAsDao")
public class ViewJsAsDaoImpl extends BaseDaoImpl implements ViewJsAsDao{

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


    @Override
    public List<ViewJsAsEntity> findUser(String keyword) {
        String hql = "from ViewJsAsEntity where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        Session session = getCurrentSession();
        return session.createQuery(hql).list();
    }
}

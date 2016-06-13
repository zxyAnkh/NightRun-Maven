package cn.edu.zucc.daoImpl.viewDaoImpl;

import cn.edu.zucc.dao.viewDao.ViewJsRunDao;
import cn.edu.zucc.daoImpl.BaseDaoImpl;
import cn.edu.zucc.entity.ViewJsRunEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
@Repository("viewJsRunDao")
public class ViewJsRunDaoImpl extends BaseDaoImpl implements ViewJsRunDao{

    @Override
    public List<ViewJsRunEntity> loadAdminRun(String ano) {
        String hql = "from ViewJsRunEntity order by starttime";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<ViewJsRunEntity> findRun(String type, String keyword) {
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
    public List<ViewJsRunEntity> loadUserRun(String sno) {
        String hql = "from ViewJsRunEntity where sno=?";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, sno);
        return query.list();
    }
}

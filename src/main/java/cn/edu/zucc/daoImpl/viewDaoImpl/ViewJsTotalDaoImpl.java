package cn.edu.zucc.daoImpl.viewDaoImpl;

import cn.edu.zucc.dao.viewDao.ViewJsTotalDao;
import cn.edu.zucc.daoImpl.BaseDaoImpl;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
@Repository("viewJsTotalDao")
public class ViewJsTotalDaoImpl extends BaseDaoImpl implements ViewJsTotalDao{

    @Override
    public List<ViewJsTotalEntity> findTotal(String keyword) {
        String hql = "from ViewJsTotalEntity where sno like '%" + keyword + "%' or sname like '%" + keyword + "%'";
        Session session = getCurrentSession();
        return session.createQuery(hql).list();
    }
}

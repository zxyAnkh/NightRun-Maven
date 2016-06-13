package cn.edu.zucc.daoImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


/**
 * Created by zxy on 5/14/2016.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public ViewJsAsEntity findByNo(String sno) {
        String hql = "from ViewJsAsEntity where sno=? order by sno";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, sno);
        return (ViewJsAsEntity) query.uniqueResult();
    }

    @Override
    public BeanuserEntity doLogin(String sno, String pwd) {
        String hql = "from BeanuserEntity where sno=? and spwd=? and deltime is null";
        Session session = getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString(0, sno);
        query.setString(1, pwd);
        return (BeanuserEntity) query.uniqueResult();
    }

    @Override
    public Boolean modifyPwd(int id, String pwd) throws Exception {
        String hql = "update BeanuserEntity set spwd = '" + pwd + "' where sId=" + id;
        return getCurrentSession().createQuery(hql).executeUpdate() == 1;
    }

    @Override
    public Boolean modifyDel(int id) throws Exception {
        String hql = "update BeanuserEntity set deltime = null where sId=" + id;
        return getCurrentSession().createQuery(hql).executeUpdate() == 1;
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

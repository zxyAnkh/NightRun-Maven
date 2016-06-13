package cn.edu.zucc.daoImpl;


import cn.edu.zucc.dao.RunDao;
import cn.edu.zucc.entity.BeanrunEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by zxy on 6/13/2016.
 */
@Repository("runDao")
public class RunDaoImpl extends BaseDaoImpl implements RunDao {

    @Override
    public Boolean addRun(BeanrunEntity beanrunEntity) throws Exception {
        try {
            getCurrentSession().save(beanrunEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

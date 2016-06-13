package cn.edu.zucc.dao;

import cn.edu.zucc.entity.*;


/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminDao {
    BeanadminEntity findByNo(String ano);
    Boolean modifyAdmin(BeanadminEntity beanadminEntity);
}

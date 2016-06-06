package cn.edu.zucc.dao;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;

import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminDao {
    BeanadminEntity findByNo(String ano);
    ViewJsAsEntity findByNo(String sno,int branch);
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll);
    List<ViewJsRunEntity> findRun(String type, String keyword, int branch, Boolean isAll);
    Boolean modify(BeanadminEntity beanadminEntity);
    Boolean addUser(BeanuserEntity beanuserEntity) throws Exception;
    Boolean deleteUser(int id);
}

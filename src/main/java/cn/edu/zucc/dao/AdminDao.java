package cn.edu.zucc.dao;

import cn.edu.zucc.entity.*;

import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminDao {
    BeanadminEntity findByNo(String ano);
    ViewJsAsEntity findByNo(String sno,int branch);
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsRunEntity> loadRun(String ano, int branch);
    List<ViewJsRunEntity> findRun(String type, String keyword, int branch);
    List<ViewJsAsEntity> findUser(String keyword, int branch);
    List<ViewJsTotalEntity> findTotal(String keyword, int branch);
    Boolean modifyAdmin(BeanadminEntity beanadminEntity);
    Boolean addUser(BeanuserEntity beanuserEntity) throws Exception;
    Boolean deleteUser(int id);
}

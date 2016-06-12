package cn.edu.zucc.dao;

import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;

import java.util.List;

/**
 * Created by zxy on 5/14/2016.
 */
public interface UserDao {
    BeanuserEntity doLogin(String sno,String pwd);
    List<ViewJsRunEntity> loadRun(String sno);
    Boolean modifyPwd(int id,String pwd) throws Exception;
    ViewJsAsEntity findByNo(String sno, int branch);
    Boolean addRun(BeanrunEntity beanrunEntity) throws Exception;
}

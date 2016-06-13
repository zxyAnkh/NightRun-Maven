package cn.edu.zucc.dao;

import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;

/**
 * Created by zxy on 5/14/2016.
 */
public interface UserDao {
    ViewJsAsEntity findByNo(String sno);
    BeanuserEntity doLogin(String sno,String pwd);
    Boolean modifyPwd(int id,String pwd) throws Exception;
    Boolean modifyDel(int id) throws Exception;
    Boolean addUser(BeanuserEntity beanuserEntity) throws Exception;
    Boolean deleteUser(int id);
}

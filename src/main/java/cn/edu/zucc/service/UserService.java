package cn.edu.zucc.service;

import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 5/14/2016.
 */
public interface UserService {
    Boolean doLogin(String sno, String pwd);
    Boolean modifyPwd(int id,String pwd);
    List<Map<String,String>> loadRun(String sno);
    Boolean addRun(String sno,String stime,String etime);
}

package cn.edu.zucc.service;

import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.form.BeanuserForm;

import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 5/14/2016.
 */
public interface UserService {
    Boolean doLogin(String sno, String pwd);
    Boolean modifyPwd(int id,String pwd);
    Boolean modifyDel(String sno,int branch);
    Boolean addUser(BeanuserForm beanuserForm);
    Boolean deleteUser(String sno,int branch);
}

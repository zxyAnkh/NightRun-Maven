package cn.edu.zucc.service;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.form.BeanuserForm;

import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminService {
    BeanadminEntity doLogin(String no, String pwd);
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll);
    List<ViewJsRunEntity> fuzzyQuery(String type, String keyword, int branch, Boolean isAll);
    Boolean modify(BeanadminEntity beanadminEntity);
    Boolean addUser(BeanuserForm beanuserForm);
}

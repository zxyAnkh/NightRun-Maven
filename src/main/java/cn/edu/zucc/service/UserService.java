package cn.edu.zucc.service;

import cn.edu.zucc.entity.ViewJsRunEntity;

import java.util.List;

/**
 * Created by zxy on 5/14/2016.
 */
public interface UserService {
    Boolean doLogin(String sno, String pwd);
    List<ViewJsRunEntity> loadRun(String sno);
}

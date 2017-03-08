package cn.edu.zucc.web.service;

import cn.edu.zucc.web.model.User;

import java.util.List;

/**
 * 读取用户数据Service
 * Created by zxy on 11/28/2016.
 */
public interface LoadUserDataService {

    List<User> getUserDataByPage(int start, int offset,boolean all);

    Integer getAllUserLength();

    Integer getActiveUserLength();
}

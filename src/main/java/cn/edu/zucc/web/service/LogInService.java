package cn.edu.zucc.web.service;

import cn.edu.zucc.web.model.User;

/**
 * Created by zxy on 11/13/2016.
 */
public interface LogInService{

    User selectByUserno(String userno);
}

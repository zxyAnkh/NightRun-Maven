package cn.edu.zucc.web.service;

import cn.edu.zucc.web.form.UserForm;


public interface ManagerUserService{
    boolean insertUser(UserForm user);

    boolean deleteUser(String no);

    boolean restoreUser(String no);
}

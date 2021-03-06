package cn.edu.zucc.web.service;

import cn.edu.zucc.web.form.UserForm;
import cn.edu.zucc.web.json.UserPwdPojo;
import cn.edu.zucc.web.model.User;

import java.util.List;

/**
 * 用户相关处理
 * Created by zxy on 2016/7/6.
 * @author zxyAnkh
 * @since  2016-07-06
 */
public interface UserService{


    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteByUserid(int id);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(UserForm record);

    /**
     * 通过关键词模糊查询
     * @param keyword
     * @return
     */
    List<User> selectByKeyword(String keyword);

    /**
     * 更新用户数据
     * @param record
     * @return
     */
    int updateByRecord(User record);

    /**
     * 更新用户密码
     * @param recode
     * @return
     */
    int updateUserPassword(UserPwdPojo recode);


    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 通过学号获取密码
     * @param userno
     * @return
     */
    String selectPwdByUserno(String userno);
    /**
     * 根据用户名查询用户
     *
     * @param userno
     * @return
     */
    User selectByUserno(String userno);

}

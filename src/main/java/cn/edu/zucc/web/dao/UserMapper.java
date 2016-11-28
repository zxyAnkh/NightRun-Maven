package cn.edu.zucc.web.dao;

import cn.edu.zucc.web.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper  {

    /**
     * 通过用户id删除用户 软删除
     *
     * @param id
     * @return
     */
    int deleteByUserid(int id);

    /**
     * 通过用户id恢复用户
     *
     * @param id
     * @return
     */
    int updateDelByUserid(int id);

    /**
     * 添加用户
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 通过关键词模糊查询
     *
     * @param keyword
     * @return
     */
    List<User> selectByKeyword(String keyword);

    List<User> selectByKeywordPage(@Param("keyword") String keyword, @Param("start") int start, @Param("end") int end);

    /**
     * 更新用户信息
     *
     * @param record
     * @return
     */
    int updateByRecord(User record);

    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 通过学号获取密码
     *
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

    /**
     * 获取活跃用户
     *
     * @return
     */
    List<User> selectActiveUsers(@Param("start") int start, @Param("end") int end);

    /**
     * 获取非活跃用户
     *
     * @return
     */
    List<User> selectNActiveUsers(@Param("start") int start, @Param("end") int end);


}
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
     * @param id 用户Id
     * @return 操作影响的数据库行数
     */
    int deleteByUserid(int id);

    /**
     * 通过用户id恢复用户
     *
     * @param id 用户Id
     * @return 操作影响的数据库行数
     */
    int updateDelByUserid(int id);

    /**
     * 添加用户
     *
     * @param record 用户数据
     * @return 操作影响的数据库行数
     */
    int insert(User record);

    /**
     * 通过关键词模糊查询
     *
     * @param keyword 关键词
     * @return
     */
    List<User> selectByKeyword(String keyword);

    List<User> selectByKeywordPage(@Param("keyword") String keyword, @Param("start") int start, @Param("end") int end);

    /**
     * 更新用户信息
     *
     * @param record 用户数据
     * @return 操作影响的数据库行数
     */
    int updateByRecord(User record);

    /**
     * 用户登录验证查询
     *
     * @param record 用户数据
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 通过学号获取密码
     *
     * @param userno 用户学号
     * @return
     */
    String selectPwdByUserno(String userno);

    /**
     * 根据用户学号查询用户
     *
     * @param userno 用户学号
     * @return
     */
    User selectByUserno(String userno);

    /**
     * 获取活跃用户
     *
     * @return 活跃用户列表
     */
    List<User> selectActiveUsers(@Param("start") int start, @Param("end") int end);

    /**
     * 获取非活跃用户
     *
     * @return 非活跃用户列表
     */
    List<User> selectNActiveUsers(@Param("start") int start, @Param("end") int end);

    Integer getAllUserLength();

    Integer getActiveUserLength();

    Integer updatePhoneUID(@Param("no") String no, @Param("phoneuid") String phoneuid);

    String getPhoneUID(@Param("no") String no);

}
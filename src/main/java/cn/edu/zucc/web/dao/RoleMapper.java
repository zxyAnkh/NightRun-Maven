package cn.edu.zucc.web.dao;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.web.model.Role;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("roleMapper")
public interface RoleMapper extends GenericDao<Role, Integer> {
    /**
     * 通过用户id 查询用户 拥有的角色
     *
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(int userId);
}
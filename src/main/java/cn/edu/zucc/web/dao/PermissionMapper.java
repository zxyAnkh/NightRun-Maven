package cn.edu.zucc.web.dao;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.web.model.Permission;
import cn.edu.zucc.web.model.PermissionExample;
import java.util.List;

import cn.edu.zucc.web.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("permissionMapper")
public interface PermissionMapper extends GenericDao<Permission, Integer> {
    /**
     * 通过角色id 查询角色 拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(int roleId);
}
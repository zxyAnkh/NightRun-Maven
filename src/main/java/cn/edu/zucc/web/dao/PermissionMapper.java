package cn.edu.zucc.web.dao;

import cn.edu.zucc.web.model.Permission;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("permissionMapper")
public interface PermissionMapper  {
    /**
     * 通过角色id 查询角色 拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(int roleId);
}
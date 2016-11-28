package cn.edu.zucc.web.service;

import cn.edu.zucc.web.model.Permission;

import java.util.List;

/**
 * 用户权限相关处理
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
public interface PermissionService{

    /**
     * 通过角色id 查询角色 拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(int roleId);

}

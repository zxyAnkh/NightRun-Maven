package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.core.generic.GenericServiceImpl;
import cn.edu.zucc.web.dao.PermissionMapper;
import cn.edu.zucc.web.model.Permission;
import cn.edu.zucc.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
@Service("permissionService")
public class PermissionServiceImpl extends GenericServiceImpl<Permission,Integer> implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public GenericDao<Permission, Integer> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(int roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}

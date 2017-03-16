package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.PermissionMapper;
import cn.edu.zucc.web.model.Permission;
import cn.edu.zucc.web.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
@Service("permissionService")
public class PermissionServiceImpl  implements PermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectPermissionsByRoleId(int roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}

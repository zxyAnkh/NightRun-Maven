package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.dao.PermissionMapper;
import cn.edu.zucc.web.model.Permission;
import cn.edu.zucc.web.service.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/7.
 */
public class PermissionServiceImplTest extends TestSupport{

    @Autowired
    private PermissionService permissionService;

    @Test
    public void selectPermissionsByRoleId() throws Exception {
        List<Permission> list = permissionService.selectPermissionsByRoleId(1);
        for(Permission permission:list)
            System.out.println(permission.getPermissionname());
    }

}
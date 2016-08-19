package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.model.Role;
import cn.edu.zucc.web.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/7.
 */
public class RoleServiceImplTest extends TestSupport{

    @Autowired
    private RoleService roleService;

    @Test
    public void selectRolesByUserId() throws Exception {
        List<Role> list = roleService.selectRolesByUserId(16);
        for(Role role:list)
            System.out.println(role.getRolename());
    }

}
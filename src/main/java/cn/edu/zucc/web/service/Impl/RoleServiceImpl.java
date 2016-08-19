package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.core.generic.GenericServiceImpl;
import cn.edu.zucc.web.dao.RoleMapper;
import cn.edu.zucc.web.model.Role;
import cn.edu.zucc.web.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
@Service("roleService")
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, Integer> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(int userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

}

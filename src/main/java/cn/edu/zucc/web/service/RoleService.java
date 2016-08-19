package cn.edu.zucc.web.service;

import cn.edu.zucc.core.generic.GenericService;
import cn.edu.zucc.web.model.Role;

import java.util.List;

/**
 * 用户角色相关处理
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
public interface RoleService extends GenericService<Role, Integer> {
    /**
     * 通过用户id 查询用户 拥有的角色
     *
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(int userId);
}


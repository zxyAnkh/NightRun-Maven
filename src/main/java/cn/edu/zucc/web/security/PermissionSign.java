package cn.edu.zucc.web.security;

/**
 * 用户权限 类
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
public class PermissionSign {

    /**
     * 用户新增权限 标识
     */
    public static final String USER_CREATE = "user:create";

    /**
     * 用户删除权限 标识
     */
    public static final String USER_DELETE = "user:delete";

    /**
     * 用户恢复权限 标识
     */
    public static final String USER_RESTORE = "user:restore";
    /**
     * 用户更新权限 标识
     */
    public static final String USER_UPDATE  = "user:update";
    /**
     * 新增夜跑权限 标识
     */
    public static final String RUN_CREATE   = "run:create";
    /**
     * 管理员更新权限 标识
     */
    public static final String ADMIN_UPDATE = "admin:update";
}

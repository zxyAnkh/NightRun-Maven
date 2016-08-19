package cn.edu.zucc.web.security;

/**
 * 用户权限 类
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since 2016-07-07
 */
public class OperationType {
    /**
     * 添加
     */
    public static final String CREATE = "create";
    /**
     * 更新
     */
    public static final String UPDATE = "update";
    /**
     * 读取
     */
    public static final String READ = "read";
    /**
     * 删除
     */
    public static final String DELETE = "delete";

    /**
     * 所有
     */
    public static final String ALL = "*";
}

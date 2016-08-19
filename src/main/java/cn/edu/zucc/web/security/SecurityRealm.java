package cn.edu.zucc.web.security;

import cn.edu.zucc.core.util.PasswordHash;
import cn.edu.zucc.web.model.Permission;
import cn.edu.zucc.web.model.Role;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.service.PermissionService;
import cn.edu.zucc.web.service.RoleService;
import cn.edu.zucc.web.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * shiro处理函数
 * Created by zxy on 2016/7/6.
 * @author zxyAnkh
 * @since 2016-07-06
 */
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    /*
    * 用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userno = String.valueOf(principalCollection.getPrimaryPrincipal());

        final User user = userService.selectByUserno(userno);
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            // 添加角色
            System.err.println(role);
            authorizationInfo.addRole(role.getRolesign());

            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                // 添加权限
                System.err.println(permission);
                authorizationInfo.addStringPermission(permission.getPermissionsign());
            }
        }
        return authorizationInfo;
    }

    /*
    * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userno = String.valueOf(authenticationToken.getPrincipal());
        String password = new String((char[]) authenticationToken.getCredentials());
        // 通过数据库进行验证
        try {
            if(PasswordHash.validatePassword(password,userService.selectPwdByUserno(userno))) {
                final User authentication = userService.authentication(new User(userno, userService.selectPwdByUserno(userno)));
                if (authentication == null) {
                    throw new AuthenticationException("用户名或密码错误.");
                }
                return new SimpleAuthenticationInfo(authentication.getUserno(),
                        password, authentication.getUsername());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}

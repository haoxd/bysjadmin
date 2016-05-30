package com.hxd.shiro;
import java.util.ArrayList;  
import java.util.List;  
  
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;  
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UsernamePasswordToken;  
import org.apache.shiro.authz.AuthorizationException;  
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;  
import org.apache.shiro.realm.AuthorizingRealm;  
import org.apache.shiro.subject.PrincipalCollection;  

import org.springframework.web.context.ContextLoader;
 
import com.hxd.model.Admin;

import com.hxd.service.adminService;
import com.hxd.service.adminServiceImpl;
  
 
  
/** 
 * @author chenlf 
 *  
 *         2014-3-24 
 */  
public class ShiroRealm extends AuthorizingRealm {  
	adminService asi = new adminServiceImpl();
  
    /* 
     * 
     * 用于授权
     * (non-Javadoc) 
     *  
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection) 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        // 根据用户配置用户与权限  
        if (principals == null) {  
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");  
        }  
        String name = (String) getAvailablePrincipal(principals);  
        List<String> roles = new ArrayList<String>();  
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);  
        Admin admin  = asi.queryAdminInfoByPhone(name);
       /*  
        Role role = new Role("number");
        admin.setRole(role);  
        if (admin.getAdminPhone().equals(name)) {  
            if (admin.getRole() != null) {  
                roles.add(admin.getRole().toString());  
            }  
        } else {  
            throw new AuthorizationException();  
        }  */
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 增加角色  
        info.addRoles(roles);  
        return info;  
    }  
  
    /* 
     * 用语认证
     * (non-Javadoc) 
     *  
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken) 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)  
            throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        // 简单默认一个用户,实际项目应User user = userService.getByAccount(token.getUsername());  
        Admin admin  = asi.queryAdminInfoByPhone(token.getUsername());
         
        if (admin == null) {  
            throw new AuthorizationException();  
        }  
        SimpleAuthenticationInfo info = null;  
        if (admin.getAdminPhone().equals(token.getUsername())) {  
            info = new SimpleAuthenticationInfo(admin.getAdminPhone() ,admin.getAdminPassword(), getName());  
        }  
        return info;  
    }  
}  

package design.suifeng.shiro.security;

import design.suifeng.common.entity.SysUserEntity;
import design.suifeng.common.utils.ShiroUtils;
import design.suifeng.shiro.manager.SysUserManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 认证
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月8日 下午3:42:17
 */
public class UserRealm extends AuthorizingRealm {
    
	@Autowired
	private SysUserManager sysUserManager;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Long userId = ShiroUtils.getUserId();
		//用户角色
		Set<String> rolesSet = sysUserManager.listUserRoles(userId);
		//用户权限
		Set<String> permsSet = sysUserManager.listUserPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(rolesSet);
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询用户信息
        SysUserEntity user = sysUserManager.getByUserName(username);
        
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        
        //账号锁定
        if(user.getStatus() == 0){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
	}

}

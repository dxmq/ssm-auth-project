package design.suifeng.shiro.service;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.R;
import design.suifeng.common.entity.SysUserEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月11日 上午11:45:42
 */
public interface SysUserService {

	Page<SysUserEntity> listUser(Map<String, Object> params);
	
	R saveUser(SysUserEntity user);
	
	R getUserById(Long userId);
	
	R updateUser(SysUserEntity user);
	
	R batchRemove(Long[] id);
	
	R listUserPerms(Long userId);
	
	R updatePswdByUser(SysUserEntity user);
	
	R updateUserEnable(Long[] id);
	
	R updateUserDisable(Long[] id);
	
	R updatePswd(SysUserEntity user);
	
}

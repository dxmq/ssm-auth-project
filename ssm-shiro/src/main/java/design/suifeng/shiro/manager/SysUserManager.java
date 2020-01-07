package design.suifeng.shiro.manager;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.common.entity.SysUserEntity;

import java.util.List;
import java.util.Set;

/**
 * 系统用户
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月11日 上午11:43:01
 */
public interface SysUserManager {

	SysUserEntity getByUserName(String username);
	
	List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);
	
	int saveUser(SysUserEntity user);
	
	SysUserEntity getById(Long userId);
	
	int updateUser(SysUserEntity user);
	
	int batchRemove(Long[] id);
	
	Set<String> listUserPerms(Long userId);
	
	Set<String> listUserRoles(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserEnable(Long[] id);
	
	int updateUserDisable(Long[] id);
	
	int updatePswd(SysUserEntity user);
	
	SysUserEntity getUserById(Long userId);
	
}

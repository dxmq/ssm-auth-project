package design.suifeng.shiro.service;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.R;
import design.suifeng.shiro.entity.SysRoleEntity;

import java.util.Map;

/**
 * 系统角色
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月12日 上午12:40:42
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);
	
	R listRole();
	
	R updateRoleAuthorization(SysRoleEntity role);
	
}

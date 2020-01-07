package design.suifeng.shiro.manager;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.shiro.entity.SysRoleEntity;

import java.util.List;

/**
 * 系统角色
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月12日 上午12:39:07
 */
public interface SysRoleManager {

	List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search);
	
	int saveRole(SysRoleEntity role);
	
	SysRoleEntity getRoleById(Long id);
	
	int updateRole(SysRoleEntity role);
	
	int batchRemove(Long[] id);
	
	List<SysRoleEntity> listRole();
	
	int updateRoleAuthorization(SysRoleEntity role);
	
}

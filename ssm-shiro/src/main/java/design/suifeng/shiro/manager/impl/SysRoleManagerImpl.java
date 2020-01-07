package design.suifeng.shiro.manager.impl;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.shiro.dao.SysRoleMapper;
import design.suifeng.shiro.dao.SysRoleMenuMapper;
import design.suifeng.shiro.dao.SysUserRoleMapper;
import design.suifeng.shiro.entity.SysRoleEntity;
import design.suifeng.shiro.manager.SysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统角色
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月12日 上午12:39:48
 */
@Component("sysRoleManager")
public class SysRoleManagerImpl implements SysRoleManager {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search) {
		return sysRoleMapper.listForPage(page, search);
	}

	@Override
	public int saveRole(SysRoleEntity role) {
		return sysRoleMapper.save(role);
	}

	@Override
	public SysRoleEntity getRoleById(Long id) {
		SysRoleEntity role = sysRoleMapper.getObjectById(id);
		List<Long> menuId = sysRoleMenuMapper.listMenuId(id);
		role.setMenuIdList(menuId);
		return role;
	}

	@Override
	public int updateRole(SysRoleEntity role) {
		return sysRoleMapper.update(role);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysRoleMapper.batchRemove(id);
		sysUserRoleMapper.batchRemoveByRoleId(id);
		sysRoleMenuMapper.batchRemoveByRoleId(id);
		return count;
	}

	@Override
	public List<SysRoleEntity> listRole() {
		return sysRoleMapper.list();
	}

	@Override
	public int updateRoleAuthorization(SysRoleEntity role) {
		Long roleId = role.getRoleId();
		sysRoleMenuMapper.remove(role.getRoleId());
		Query query = new Query();
		query.put("roleId", roleId);
		query.put("menuIdList", role.getMenuIdList());
		int count = sysRoleMenuMapper.save(query);
		return count;
	}
	
}

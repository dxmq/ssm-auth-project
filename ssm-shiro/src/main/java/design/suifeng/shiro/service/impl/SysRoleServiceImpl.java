package design.suifeng.shiro.service.impl;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.common.entity.R;
import design.suifeng.common.utils.CommonUtils;
import design.suifeng.shiro.entity.SysRoleEntity;
import design.suifeng.shiro.manager.SysRoleManager;
import design.suifeng.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统角色
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月12日 上午12:41:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;

	@Override
	public Page<SysRoleEntity> listRole(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRoleEntity> page = new Page<>(query);
		sysRoleManager.listRole(page, query);
		return page;
	}

	@Override
	public R saveRole(SysRoleEntity role) {
		int count = sysRoleManager.saveRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getRoleById(Long id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return CommonUtils.msg(role);
	}

	@Override
	public R updateRole(SysRoleEntity role) {
		int count = sysRoleManager.updateRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysRoleManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R listRole() {
		List<SysRoleEntity> roleList = sysRoleManager.listRole();
		return CommonUtils.msgNotNull(roleList);
	}

	@Override
	public R updateRoleAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleAuthorization(role);
		return CommonUtils.msg(count);
	}
	
}

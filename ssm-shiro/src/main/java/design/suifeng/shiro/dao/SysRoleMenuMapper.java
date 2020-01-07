package design.suifeng.shiro.dao;

import design.suifeng.common.dao.BaseMapper;
import design.suifeng.shiro.entity.SysRoleMenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统角色与菜单关系
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月13日 下午8:32:26
 */
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	int batchRemoveByMenuId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
	List<Long> listMenuId(Long id);
	
}

package design.suifeng.shiro.manager;

import design.suifeng.common.entity.Query;
import design.suifeng.shiro.entity.SysMenuEntity;

import java.util.List;

/**
 * 系统菜单
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月10日 上午10:34:59
 */
public interface SysMenuManager {
	
	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);
	
	List<SysMenuEntity> listMenu(Query search);
	
	List<SysMenuEntity> listNotButton();
	
	int saveMenu(SysMenuEntity menu);

	SysMenuEntity getMenuById(Long id);
	
	int updateMenu(SysMenuEntity menu);
	
	int batchRemove(Long[] id);
	
}

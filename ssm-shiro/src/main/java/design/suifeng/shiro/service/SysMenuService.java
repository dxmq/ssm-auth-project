package design.suifeng.shiro.service;

import design.suifeng.common.entity.R;
import design.suifeng.shiro.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月10日 上午10:35:58
 */
public interface SysMenuService {
	
	R listUserMenu(Long userId);
	
	List<SysMenuEntity> listMenu(Map<String, Object> params);
	
	R listNotButton();
	
	R saveMenu(SysMenuEntity menu);

	R getMenuById(Long id);
	
	R updateMenu(SysMenuEntity menu);
	
	R batchRemove(Long[] id);

}

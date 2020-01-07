package design.suifeng.shiro.dao;

import design.suifeng.common.dao.BaseMapper;
import design.suifeng.shiro.entity.SysMenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 系统菜单dao
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月10日 上午12:21:34
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
	
	List<SysMenuEntity> listParentId(Long parentId);
	
	List<SysMenuEntity> listNotButton();
	
	List<String> listUserPerms(Long userId);

}

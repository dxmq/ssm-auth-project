package design.suifeng.shiro.dao;

import design.suifeng.common.dao.BaseMapper;
import design.suifeng.shiro.entity.SysRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统角色
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月12日 上午12:35:51
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Long userId);
	
}

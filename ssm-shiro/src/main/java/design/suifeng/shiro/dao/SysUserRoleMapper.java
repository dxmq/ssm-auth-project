package design.suifeng.shiro.dao;

import design.suifeng.common.dao.BaseMapper;
import design.suifeng.shiro.entity.SysUserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户与角色关系
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月13日 上午1:01:55
 */
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	List<Long> listUserRoleId(Long userId);
	
	int batchRemoveByUserId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}

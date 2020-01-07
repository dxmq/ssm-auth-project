package design.suifeng.shiro.dao;

import design.suifeng.common.dao.BaseMapper;
import design.suifeng.common.entity.Query;
import design.suifeng.common.entity.SysUserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统用户dao
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月8日 下午3:26:05
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePswd(SysUserEntity user);
	
}

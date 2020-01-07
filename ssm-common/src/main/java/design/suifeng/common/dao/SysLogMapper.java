package design.suifeng.common.dao;

import design.suifeng.common.entity.SysLogEntity;
import org.springframework.stereotype.Repository;

/**
 * 系统日志 
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月14日 下午8:19:01
 */
@Repository
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}

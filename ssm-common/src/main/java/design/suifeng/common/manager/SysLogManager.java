package design.suifeng.common.manager;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.common.entity.SysLogEntity;

import java.util.List;

/**
 * 系统日志
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月14日 下午8:43:06
 */
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}

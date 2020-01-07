package design.suifeng.common.service;

import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.R;
import design.suifeng.common.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月14日 下午8:40:52
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}

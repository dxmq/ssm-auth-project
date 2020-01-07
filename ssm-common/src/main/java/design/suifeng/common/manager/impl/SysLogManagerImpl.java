package design.suifeng.common.manager.impl;

import design.suifeng.common.dao.SysLogMapper;
import design.suifeng.common.entity.Page;
import design.suifeng.common.entity.Query;
import design.suifeng.common.entity.SysLogEntity;
import design.suifeng.common.manager.SysLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统日志
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月14日 下午8:43:15
 */
@Component("sysLogManager")
public class SysLogManagerImpl implements SysLogManager {

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public void saveLog(SysLogEntity log) {
		sysLogMapper.save(log);
	}

	@Override
	public List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query) {
		return sysLogMapper.listForPage(page, query);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return sysLogMapper.batchRemoveAll();
	}

}

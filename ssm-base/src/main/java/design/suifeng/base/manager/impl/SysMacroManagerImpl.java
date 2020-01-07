package design.suifeng.base.manager.impl;

import design.suifeng.base.dao.SysMacroMapper;
import design.suifeng.base.entity.SysMacroEntity;
import design.suifeng.base.manager.SysMacroManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通用字典
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月15日 下午12:49:26
 */
@Component("sysMacroManager")
public class SysMacroManagerImpl implements SysMacroManager {

	@Autowired
	private SysMacroMapper sysMacroMapper;
	
	@Override
	public List<SysMacroEntity> listMacro() {
		return sysMacroMapper.list();
	}

	@Override
	public List<SysMacroEntity> listNotMacro() {
		return sysMacroMapper.listNotMacro();
	}

	@Override
	public int saveMacro(SysMacroEntity macro) {
		return sysMacroMapper.save(macro);
	}

	@Override
	public SysMacroEntity getObjectById(Long id) {
		return sysMacroMapper.getObjectById(id);
	}

	@Override
	public int updateMacro(SysMacroEntity macro) {
		return sysMacroMapper.update(macro);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysMacroMapper.batchRemove(id);
	}

}

package design.suifeng.base.manager;

import java.util.List;

import design.suifeng.base.entity.SysMacroEntity;

/**
 * 通用字典
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月15日 下午12:49:14
 */
public interface SysMacroManager {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	int saveMacro(SysMacroEntity macro);
	
	SysMacroEntity getObjectById(Long id);
	
	int updateMacro(SysMacroEntity macro);
	
	int batchRemove(Long[] id);
	
}

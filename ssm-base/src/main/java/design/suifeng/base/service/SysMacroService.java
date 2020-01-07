package design.suifeng.base.service;

import design.suifeng.base.entity.SysMacroEntity;
import design.suifeng.common.entity.R;

import java.util.List;

/**
 * 通用字典
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月15日 下午12:51:35
 */
public interface SysMacroService {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	R saveMacro(SysMacroEntity macro);
	
	R getObjectById(Long id);
	
	R updateMacro(SysMacroEntity macro);
	
	R batchRemove(Long[] id);
	
}

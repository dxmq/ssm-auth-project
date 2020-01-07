package design.suifeng.base.dao;

import java.util.List;

import design.suifeng.base.entity.SysMacroEntity;
import design.suifeng.common.dao.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 通用字典
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月15日 下午12:46:31
 */
@MapperScan
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	List<SysMacroEntity> listNotMacro();
	
}

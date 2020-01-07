package design.suifeng.base.controller;

import design.suifeng.base.entity.SysMacroEntity;
import design.suifeng.base.service.SysMacroService;
import design.suifeng.common.annotation.SysLog;
import design.suifeng.common.controller.AbstractController;
import design.suifeng.common.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通用字典
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月15日 下午12:54:33
 */
@RestController
@RequestMapping("/sys/macro")
public class SysMacroController extends AbstractController {

	@Autowired
	private SysMacroService sysMacroService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysMacroEntity> list() {
		return sysMacroService.listMacro();
	}
	
	/**
	 * 树形列表
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysMacroEntity> select() {
		return sysMacroService.listNotMacro();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping("/save")
	public R save(@RequestBody SysMacroEntity macro) {
		return sysMacroService.saveMacro(macro);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R info(@RequestBody Long id) {
		return sysMacroService.getObjectById(id);
	}
	
	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	@SysLog("修改字典")
	@RequestMapping("/update")
	public R update(@RequestBody SysMacroEntity macro) {
		return sysMacroService.updateMacro(macro);
	}
	
	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysMacroService.batchRemove(id);
	}
	
}

package design.suifeng.shiro.entity;


import java.io.Serializable;

/**
 * 用户与角色对应关系
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月10日 上午10:48:55
 */
public class SysUserRoleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 */
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 角色id
	 */
	private Long roleId;

	public SysUserRoleEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}

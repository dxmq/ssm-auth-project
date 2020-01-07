package design.suifeng.shiro.security;

import design.suifeng.common.entity.R;
import design.suifeng.common.utils.WebUtils;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shiro ajax 认证
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月13日 下午3:09:22
 */
public class AjaxAuthenticationFilter extends AuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if(WebUtils.isAjax(httpReq)) {
			System.err.println("ajax 登录验证");
			HttpServletResponse httpRes = (HttpServletResponse) response;
			R r = R.error(401, "未登录");
			WebUtils.write(httpRes, r);
		}
		return false;
	}


	
}

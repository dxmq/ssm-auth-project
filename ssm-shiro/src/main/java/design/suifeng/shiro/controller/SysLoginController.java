package design.suifeng.shiro.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import design.suifeng.common.annotation.SysLog;
import design.suifeng.common.entity.R;
import design.suifeng.common.utils.MD5Utils;
import design.suifeng.common.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 用户controller
 *
 * @author dxmq
 * @email spvm@foxmail.com
 * @url www.suifeng.design
 * @date 2019年9月8日 下午2:48:50
 */
@Controller
@RequestMapping("/sys")
public class SysLoginController {

	@Autowired
	private Producer producer;
	
	/**
	 * 验证码
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/captcha.jpg")
	public void captcha(HttpServletResponse response)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
	}
	
	/**
	 * 登录
	 */
	@SysLog("登录")
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha) {
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
		
		try{
			Subject subject = ShiroUtils.getSubject();
			//sha256加密
			password = MD5Utils.encrypt(username, password);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
		}catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
			return R.error(e.getMessage());
		} catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@SysLog("退出系统")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
	
}

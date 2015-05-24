package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.components.ActionError;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.biz.KaoqinBiz;
import com.biz.UserBiz;
import com.opensymphony.xwork2.ActionSupport;
import com.vo.SUser;

public class UserAction extends ActionSupport implements ServletRequestAware{
private HttpServletRequest request;
	private UserBiz userBiz;
	private KaoqinBiz kaoqinBiz;
	private SUser user;
	public String   login(){
		SUser loginUser= userBiz.login(user);
		if(loginUser!=null){
			request.getSession().setAttribute("user", loginUser);
			//登录成功添加考勤记录
			kaoqinBiz.addKaoqin(loginUser,null);
			return "ok";
		}else{
			addActionError("用户名或者密码错误!");
			return INPUT;
		}
		
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String logout(){
		request.getSession().removeAttribute("user");
		return INPUT;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;	
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public SUser getUser() {
		return user;
	}

	public void setUser(SUser user) {
		this.user = user;
	}

	public KaoqinBiz getKaoqinBiz() {
		return kaoqinBiz;
	}

	public void setKaoqinBiz(KaoqinBiz kaoqinBiz) {
		this.kaoqinBiz = kaoqinBiz;
	}
	
	

}

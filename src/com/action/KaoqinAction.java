package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.biz.KaoqinBiz;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DateUtil;
import com.vo.SUser;
import com.vo.TKaoqin;

public class KaoqinAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	private KaoqinBiz kaoqinBiz;
	private String mth;//查询考勤的月份
	private String kqday;//补考勤的日期
	public String show(){
		TKaoqin t=new TKaoqin();
		//获取session中的用户信息
		 SUser u= (SUser) request.getSession().getAttribute("user");
		 //格式化日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		//根据uid以及日期查找考勤记录
		List<TKaoqin> mykq=null;
		if(StringUtils.isEmpty(mth)){
			mykq=kaoqinBiz.findKaoqin(u.getUid(), sdf.format(new Date()));
		}else{
			mykq=kaoqinBiz.findKaoqin(u.getUid(), mth);
		}
		request.setAttribute("mykq", mykq);
		//查询月份到页面
		List list=kaoqinBiz.findAllGmth();
		request.getSession().setAttribute("gmth", list);
		return "showkq";
	}
	
	/**
	 * 补考勤
	 * @return
	 */
	public String bkq(){
		//获取session中的用户信息
		 SUser u= (SUser) request.getSession().getAttribute("user");
		 Date now =new Date();
		 Date selectDate= DateUtil.str2Date04(kqday);
		if(StringUtils.isEmpty(kqday)){
			addActionError("你没有选择日期");
			return "showkq";
		}else if(selectDate.after(now)){
			addActionError("你选择的日期有误");
			return "showkq";
		}
		else{
			kaoqinBiz.addKaoqin(u, selectDate);
		}
		return "showkq";
	}
	
	/**
	 * 添加补考勤原因
	 * @return
	 */
	public String addE(){
		int kqid=Integer.parseInt(request.getParameter("kqid"));
		TKaoqin kaoqin= kaoqinBiz.findkaoqinById(kqid);
		request.setAttribute("kq", kaoqin);
		return "addExp";
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


	public KaoqinBiz getKaoqinBiz() {
		return kaoqinBiz;
	}


	public void setKaoqinBiz(KaoqinBiz kaoqinBiz) {
		this.kaoqinBiz = kaoqinBiz;
	}


	public String getMth() {
		return mth;
	}


	public void setMth(String mth) {
		this.mth = mth;
	}

	public String getKqday() {
		return kqday;
	}

	public void setKqday(String kqday) {
		this.kqday = kqday;
	}

	
	
}

package com.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.dao.TKaoqinDAO;
import com.util.DateUtil;
import com.vo.SUser;
import com.vo.TKaoqin;

public class KaoqinBiz {
	private TKaoqinDAO kaoqinDAO;
	
	
	/**
	 *根据指定的用户和日期查询考勤记录
	 * @param kaoqin
	 * @return
	 */
	public List<TKaoqin> findKaoqin(Integer uid,String kd){
		DetachedCriteria dc=DetachedCriteria.forClass(TKaoqin.class);
		dc.add(Restrictions.eq("uid", uid));
		dc.add(Restrictions.like("kd", kd,MatchMode.START));
		dc.addOrder(Order.desc("kid"));
		return kaoqinDAO.queryByCriteria(dc, false, 0, 0);
	}
	
	/**
	 * 添加当前用户的考勤记录
	 */
	public void addKaoqin(SUser user,Date d){
		//1.查询当前用户今天的考勤记录
		DetachedCriteria dc=DetachedCriteria.forClass(TKaoqin.class);
		//判断是否补卡
		boolean isbk=false;
		if(d==null){
			d=new Date();
			isbk=true;
		}
		dc.add(Restrictions.eq("uid", user.getUid()));
		dc.add(Restrictions.eq("kd", DateUtil.date2Str(4, d)));
		List list=kaoqinDAO.queryByCriteria(dc, false, 0, 0);
		//如果没有数据，则添加考勤
		if(list.isEmpty()){
			TKaoqin kaoqin=new TKaoqin();
			kaoqin.setUid(user.getUid());
			kaoqin.setKd(DateUtil.date2Str(4, d));
			//如果是补卡不用设置打卡时间,补卡时间为当前时间
			if(isbk=false){
				kaoqin.setKt(DateUtil.date2Str(3, d));
				kaoqin.setKqdate(new Timestamp(d.getTime()));
				kaoqinDAO.save(kaoqin);
				return;
			}
			kaoqin.setKqdate(new Timestamp(new Date().getTime()));
			kaoqinDAO.save(kaoqin);
		}
	}
	
	public TKaoqin findkaoqinById(int kid){
	    return kaoqinDAO.findById(kid);
	}
	
	public List findAllGmth(){
	    return kaoqinDAO.findAllGmth();
	}
	
	public TKaoqinDAO getKaoqinDAO() {
		return kaoqinDAO;
	}

	public void setKaoqinDAO(TKaoqinDAO kaoqinDAO) {
		this.kaoqinDAO = kaoqinDAO;
	}
	
	
}

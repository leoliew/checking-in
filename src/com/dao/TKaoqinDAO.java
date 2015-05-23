package com.dao;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.vo.TKaoqin;

public class TKaoqinDAO extends BaseDao<TKaoqin> {
	private static final Logger log = LoggerFactory.getLogger(TKaoqinDAO.class);
	
	public List findAllGmth(){
		String hql=" select DISTINCT subStr(kd,1,7) from t_kaoqin  ";
	    return queryBySql(hql);
	}
	
}
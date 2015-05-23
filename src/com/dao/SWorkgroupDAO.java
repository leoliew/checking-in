package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vo.SWorkgroup;



public class SWorkgroupDAO extends BaseDao<SWorkgroup> {
	private static final Logger log = LoggerFactory
			.getLogger(SWorkgroupDAO.class);

}
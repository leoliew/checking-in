package com.biz;

import java.util.List;

import com.dao.SUserDAO;
import com.vo.SUser;

public class UserBiz {
	private SUserDAO userDAO;
	
	public SUser login(SUser user){
		List<SUser> list= userDAO.findByExample(user);
		return list.isEmpty()?null:list.get(0);
	}

	public SUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(SUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	
}

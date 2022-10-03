package com.upwork.service;

import com.upwork.dao.IUserDao;
import com.upwork.dao.UserDaoImpl;
import com.upwork.model.User;

public class UserServiceImpl implements IUserService{
	
	IUserDao userDao=new UserDaoImpl();
	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName, password);
	}

	@Override
	public int changePassword(String userName,String password) {
		// TODO Auto-generated method stub
		return userDao.changePassword(userName,password);
	}

}

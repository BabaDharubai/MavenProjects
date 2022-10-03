package com.upwork.dao;

import com.upwork.model.User;

public interface IUserDao {
	String addUser(User user);
	User findByUserName(String userName,String password);
	int changePassword(String userName,String password);
	
}

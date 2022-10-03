package com.upwork.service;


import com.upwork.model.User;

public interface IUserService {
	String register(User user);
	User login(String userName,String password);
	int changePassword(String userName,String password);
	
}

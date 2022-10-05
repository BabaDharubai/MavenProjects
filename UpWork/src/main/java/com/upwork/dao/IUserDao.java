package com.upwork.dao;

import com.upwork.model.User;

public interface IUserDao {
	
	/**
	 * @param user to add user details into table
	 * @return a auto generated password
	 */
	String addUser(User user);
	/**
	 * @param username to search user based on username
	 * @param password to search user based on password
	 * @return user detais from the table
	 */
	User findByUserName(String username,String password);
	/**
	 * @param username to search user based on username
	 * @param password to search user based on password
	 * @return 1-if password of user is changed
	 * 			0-if user is not found in table
	 */
	int changePassword(String username,String password);
	
	/**
	 * @param user to add user details to table
	 * @param freelancerId to search freelancer based on id
	 * @return 1-if the freelancer is booked
	 * 			0-if the freelancer is not booked
	 */
	int bookFreelancer(User user,int freelancerId);
}

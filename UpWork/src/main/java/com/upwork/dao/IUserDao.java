package com.upwork.dao;

import java.util.List;

import com.upwork.model.Freelancer;
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
	
	/**
	 * @param user to serach booking details of employer
	 * @return a list of freelancers if employer booked any freelancers in the past
	 * 			empty List-if employer not booked any freelancer
	 */
	List<Freelancer> bookingDetails(User user);
}

package com.upwork.service;


import com.upwork.exception.IdNotFoundException;
import com.upwork.exception.UserNotFoundException;
import com.upwork.model.User;

/**
 * @author BabaFakruddinDharubai
 *
 */
public interface IUserService {
	
	/**
	 * @param user to add user details to table
	 * @return string auto-generated password to the user
	 */
	String register(User user);
	/**
	 * @param username to search user based on username
	 * @param password to match previous setted password
	 * @return user if available in the table
	 * @throws UserNotFoundException if user is not found
	 */
	User login(String username,String password) throws UserNotFoundException;
	/**
	 * @param username to search user based on username
	 * @param password to match password of user
	 * @return 1-if password of user is changed
	 * 			0-if user is not found in table
	 * @throws UserNotFoundException if user is not found
	 */
	int changePassword(String username,String password) throws UserNotFoundException;
	/**
	 * @param user to add user details to bookings table
	 * @param freelancerId to get detail of freelancer from freelancer table and add to bookings table
	 * @return 1-if freelancer is booked
	 * @throws IdNotFoundException if freelancer is not found
	 */
	int bookFreelaner(User user,int freelancerId) throws IdNotFoundException;
}

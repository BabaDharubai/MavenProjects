package com.upwork.service;

import com.upwork.dao.IUserDao;
import com.upwork.dao.UserDaoImpl;
import com.upwork.exception.IdNotFoundException;
import com.upwork.exception.UserNotFoundException;
import com.upwork.model.User;

/**
 * @author BabaFakruddinDharubai
 *
 */
public class UserServiceImpl implements IUserService{
	
	IUserDao userDao=new UserDaoImpl();
	
	/**
	 * @param user to add user details to table
	 * @return string auto-generated password to the user
	 */
	@Override
	public String register(User user) {
		return userDao.addUser(user);
	}

	/**
	 * @param username to search user based on username
	 * @param password to match previous setted password
	 * @return user if available in the table
	 * @throws UserNotFoundException if user not found in database
	 */
	@Override
	public User login(String username, String password) {
		User user=userDao.findByUserName(username, password);
		if(user==null)
			throw new UserNotFoundException("User Not Found");
		return user;
	}
	
	/**
	 * @param username to search user based on username
	 * @param password to match password of user
	 * @return 1-if password of user is changed
	 * 			0-if user is not found in table
	 * @throws UserNotFoundException if user is not found
	 */
	@Override
	public int changePassword(String username,String password) {
		return userDao.changePassword(username,password);
	}

	/**
	 * @param user to add user details to bookings table
	 * @param freelancerId to get detail of freelancer from freelancer table and add to bookings table
	 * @return 1-if freelancer is booked
	 * @throws IdNotFoundException if freelancer is not found
	 */
	@Override
	public int bookFreelaner(User user, int freelancerId) throws IdNotFoundException {
		int result=userDao.bookFreelancer(user, freelancerId);
		return result;
	}

}

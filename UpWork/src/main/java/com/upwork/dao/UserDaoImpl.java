package com.upwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.upwork.model.Freelancer;
import com.upwork.model.User;
import com.upwork.utility.DbConnection;
import com.upwork.utility.PasswordGenerator;
import com.upwork.utility.Queries;

public class UserDaoImpl implements IUserDao {

	/**
	 * @param user to add user details into table
	 * @return a auto generated password
	 */
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		String password=PasswordGenerator.randomPassword();
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYADDUSER);){
			statement.setString(1, user.getUserName());
			statement.setString(2,user.getName());
			statement.setLong(3, user.getMobile());
			statement.setString(4,user.getEmail());
			statement.setString(5,password);
			statement.setString(6, user.getCity());
			statement.setString(7, user.getType());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * @param username to search user based on username
	 * @param password to search user based on password
	 * @return user detais from the table
	 */
	@Override
	public User findByUserName(String username, String password) {
		User user=null;
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYLOGIN);){
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			user=new User();
			while(resultSet.next()) {
				user.setUserId(resultSet.getInt(1));
				user.setUserName(resultSet.getString(2));
				user.setName(resultSet.getString(3));
				user.setMobile(resultSet.getLong(4));
				user.setEmail(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));
				user.setCity(resultSet.getString(7));
				user.setType(resultSet.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}

	/**
	 * @param username to search user based on username
	 * @param password to search user based on password
	 * @return 1-if password of user is changed
	 * 			0-if user is not found in table
	 */
	@Override
	public int changePassword(String username,String password) {
		
		int result=0;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYCHANGEPASSWORD);){
			statement.setString(1, password);
			statement.setString(2, username);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param user to add user details to table
	 * @param freelancerId to search freelancer based on id
	 * @return 1-if the freelancer is booked
	 * 			0-if the freelancer is not booked
	 */
	@Override
	public int bookFreelancer(User user, int freelancerId) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement statement=null;
		Freelancer freelancer=null;
		try (Connection connection=DbConnection.openConnection();
				){
			statement=connection.prepareStatement(Queries.QUERYBYID);
			statement.setInt(1, freelancerId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				freelancer=new Freelancer();
				freelancer.setFreelancerId(resultSet.getInt(1));
				freelancer.setFreelancerName(resultSet.getString(2));
				freelancer.setCategory(resultSet.getString(3));
				freelancer.setSkill(resultSet.getString(4));
				freelancer.setExperience(resultSet.getInt(5));
				freelancer.setCost(resultSet.getDouble(6));
				freelancer.setType(resultSet.getString(7));
				freelancer.setLocation(resultSet.getString(8));
				
				statement=connection.prepareStatement(Queries.QUERYBOOKING);
				statement.setInt(1, user.getUserId());
				statement.setString(2, user.getUserName());
				statement.setInt(3, freelancer.getFreelancerId());
				statement.setString(4,freelancer.getFreelancerName());
				statement.setString(5,freelancer.getCategory());
				statement.setString(6,freelancer.getSkill());
				statement.setDouble(7,freelancer.getCost());
				statement.setInt(8, freelancer.getExperience());
				statement.setString(9, freelancer.getLocation());
				result=statement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

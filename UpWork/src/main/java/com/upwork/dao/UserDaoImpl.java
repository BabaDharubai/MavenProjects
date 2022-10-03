package com.upwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.upwork.model.User;
import com.upwork.utility.DbConnection;
import com.upwork.utility.PasswordGenerator;
import com.upwork.utility.Queries;

public class UserDaoImpl implements IUserDao {

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

	@Override
	public User findByUserName(String userName, String password) {
		User user=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYLOGIN);){
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet=statement.executeQuery();
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
		}
		
		return user;
	}

	@Override
	public int changePassword(String userName,String password) {
		
		int result=0;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYCHANGEPASSWORD);){
			statement.setString(1, userName);
			statement.setString(2, password);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

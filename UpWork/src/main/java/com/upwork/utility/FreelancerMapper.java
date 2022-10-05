package com.upwork.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upwork.model.Freelancer;

public class FreelancerMapper implements IRowMapper{
	@Override
	public List<Freelancer> mapRow(ResultSet resultSet) throws SQLException {
		List<Freelancer> freelancerList=new ArrayList<>();
		try {
			while(resultSet.next()) {
				Freelancer freelancer=new Freelancer();
				freelancer.setFreelancerId(resultSet.getInt(1));
				freelancer.setFreelancerName(resultSet.getString(2));
				freelancer.setCategory(resultSet.getString(3));
				freelancer.setSkill(resultSet.getString(4));
				freelancer.setExperience(resultSet.getInt(5));
				freelancer.setCost(resultSet.getDouble(6));
				freelancer.setType(resultSet.getString(7));
				freelancer.setLocation(resultSet.getString(8));
				freelancerList.add(freelancer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freelancerList;
	}
}

package com.upwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upwork.model.Freelancer;
import com.upwork.utility.DbConnection;
import com.upwork.utility.FreelancerMapper;
import com.upwork.utility.IRowMapper;
import com.upwork.utility.Queries;

public class FreelancerDaoImpl implements IFreelancerDao{
	IRowMapper rowMapper=new FreelancerMapper();
	/**
	 * @param freelancer for passing freelancer to add into database
	 */
	@Override
	public void addFreelancer(Freelancer freelancer) {

		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYADD);)
		{
			statement.setInt(1,freelancer.getFreelancerId());
			statement.setString(2, freelancer.getFreelancerName());
			statement.setString(3,freelancer.getCategory());
			statement.setString(4, freelancer.getSkill());
			statement.setInt(5,freelancer.getExperience());
			statement.setDouble(6,freelancer.getCost());
			statement.setString(7, freelancer.getType());
			statement.setString(8,freelancer.getLocation());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param freelancerId used to delete the freelancer in the database
	 * @return 1-if freelancer deleted from the table
	 *			0-if freelancer if not deleted from table
	 */
	@Override
	public int deleteFreelancer(int freelancerId) {


		int result=0;
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYDELETE);) 
		{
			statement.setInt(1, freelancerId);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param cost to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	@Override
	public int updateFreelancer(int freelancerId, double cost) {

		int result=0;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYUPDATECOST);)
		{
			statement.setInt(2, freelancerId);
			statement.setDouble(1, cost);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param skill to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	@Override
	public int updateFreelancer(int freelancerId, String skill) {
		int result=0;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYUPDATESKILL);)
		{
			statement.setInt(2, freelancerId);
			statement.setString(1, skill);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param experience to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	@Override
	public int updateFreelancer(int freelancerId, int experience) {
		int result=0;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYUPDATEEXPERIENCE);)
		{
			statement.setInt(2, freelancerId);
			statement.setInt(1, experience);
			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @return freelancer-if the freelancer is available in the table
	 * 			null	-if the freelancer is not found
	 */
	@Override
	public Freelancer findById(int freelancerId) {
		Freelancer freelancer=null;
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYID);)
		{
			statement.setInt(1, freelancerId);
			resultSet=statement.executeQuery();
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
			}
		} catch (SQLException e) {
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
		return freelancer;
	}

	/**
	 * @param category to find the freelancers based on category
	 * @return freelancers List-if found with required category
	 * 			emptyList-if there are no freelancers found
	 */
	@Override
	public List<Freelancer> findByCategoryContain(String category) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCAT);)
		{
			statement.setString(1, category);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		}
		return freelancerList;
	}

	/**
	 * @param skill to search freelancer based on skill
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	@Override
	public List<Freelancer> findBySkillContain(String skill) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYSKILL);)
		{
			statement.setString(1, skill);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	/**
	 * @param name to search freelancer based on name
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	@Override
	public List<Freelancer> findByName(String name) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAME);){
			statement.setString(1, name);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search freelancer based on skill
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	@Override
	public List<Freelancer> findByCatSkillContain(String category, String skill) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATSKILL);){
			statement.setString(1, category);
			statement.setString(2, skill);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search freelancer based on skill
	 * @param type to search based on full-time and part-time
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	@Override
	public List<Freelancer> findByCatSkillTypeContain(String category, String skill, String type) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATSKILLTYPE);){
			statement.setString(1, category);
			statement.setString(2, skill);
			statement.setString(3, type);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param experience to search based on experience
	 * @return freelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	@Override
	public List<Freelancer> findByCatExpContain(String category, int experience) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATEXP);) {
			statement.setString(1, category);
			statement.setInt(2, experience);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param cost to search based on cost
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	@Override
	public List<Freelancer> findByCatSkillCostContain(String category, String skill, double cost) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATSKILLCOST);){
			statement.setString(1, category);
			statement.setString(2, skill);
			statement.setDouble(3, cost);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param experience to search based on experience
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	@Override
	public List<Freelancer> findByCatSkillExpContain(String category, String skill, int experience) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATSKILL);){
			statement.setString(1, category);
			statement.setString(2, skill);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param location to search based on location
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	@Override
	public List<Freelancer> findByCatLocationContain(String category, String location) {
		List<Freelancer> freelancerList=new ArrayList<>();
		ResultSet resultSet=null;
		try (Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYLOCATION);){
			statement.setString(1, category);
			statement.setString(2, location);
			resultSet=statement.executeQuery();
			freelancerList=rowMapper.mapRow(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return freelancerList;
	}

	
}

package com.upwork.dao;

import java.util.List;

import com.upwork.model.Freelancer;

public interface IFreelancerDao {
	
	/**
	 * @param freelancer for passing freelancer to add into database
	 */
	void addFreelancer(Freelancer freelancer);
	
	/**
	 * @param freelancerId used to delete the freelancer in the database
	 * @return 1 if freelancer deleted from the table
	 *			0 if freelancer if not deleted from table
	 */
	int deleteFreelancer(int freelancerId);

	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param cost to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	int updateFreelancer(int freelancerId, double cost);
	
	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param skill to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	int updateFreelancer(int freelancerId, String skill);
	
	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @param experience to update the skill of freelancer
	 * @return	1-if the freelancer is updated
	 *			0-if the freelancer is not found/not updated
	 */
	int updateFreelancer(int freelancerId, int experience);
	
	/**
	 * @param freelancerId to check the freelancer with required Id
	 * @return freelancer-if the freelancer is available in the table
	 * 			null	-if the freelancer is not found
	 */
	Freelancer findById(int freelancerId);

	/**
	 * @param category to find the freelancers based on category
	 * @return freelancers List-if found with required category
	 * 			emptyList-if there are no freelancers found
	 */
	List<Freelancer> findByCategoryContain(String category);

	/**
	 * @param skill to search freelancer based on skill
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	List<Freelancer> findBySkillContain(String skill);

	/**
	 * @param name to search freelancer based on name
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	List<Freelancer> findByName(String name);

	/**
	 * @param category to search based on category
	 * @param skill to search freelancer based on skill
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	List<Freelancer> findByCatSkillContain(String category, String skill);

	/**
	 * @param category to search based on category
	 * @param skill to search freelancer based on skill
	 * @param type to search based on full-time and part-time
	 * @return freelancers List-if found with required parameters
	 * 			emptyList-if there are no freelancers found
	 */
	List<Freelancer> findByCatSkillTypeContain(String category, String skill, String type);

	/**
	 * @param category to search based on category
	 * @param experience to search based on experience
	 * @return freelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	List<Freelancer> findByCatExpContain(String category, int experience);

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param cost to search based on cost
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	List<Freelancer> findByCatSkillCostContain(String category, String skill, double cost);
	
	
	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param experience to search based on experience
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	List<Freelancer> findByCatSkillExpContain(String category, String skill, int experience);
	
	/**
	 * @param category to search based on category
	 * @param location to search based on location
	 * @return reelancer List-if found with required parameters
	 * 			empty List-if no data found
	 */
	List<Freelancer> findByCatLocationContain(String category,String location);
}

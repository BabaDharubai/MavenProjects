package com.upwork.service;

import java.util.List;

import com.upwork.exception.FreelancerNotFoundException;
import com.upwork.exception.IdNotFoundException;
import com.upwork.model.Freelancer;

/**
 * @author BabaFakruddinDharubai
 *
 */
public interface IFreelancerService {
	
	/** 
	 * @param freelancer to add freelancer to table
	 */
	void addFreelancer(Freelancer freelancer);

	/**
	 * @param freelancerId to search freelancer
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	int deleteFreelancer(int freelancerId) throws IdNotFoundException;

	/**
	 * @param freelancerId to search freelancer
	 * @param cost to update cost of freelancer
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	int updateFreelancer(int freelancerId, double cost) throws IdNotFoundException;
	
	/**
	 * @param freelancerId to search freelancer
	 * @param skill to update freelancer skill
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	int updateFreelancer(int freelancerId, String skill) throws IdNotFoundException;
	
	/**
	 * @param freelancerId to search freelancer
	 * @param experience to update freelancer experience
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	int updateFreelancer(int freelancerId, int experience) throws IdNotFoundException;
	
	/**
	 * @param freelancerId to search for freelancer
	 * @return freelancer if available
	 * @throws IdNotFoundException if freelancer not found/not available
	 */
	Freelancer getById(int freelancerId) throws IdNotFoundException;

	/**
	 * @param category to search freelancers with category
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCategoryContain(String category) throws FreelancerNotFoundException;

	/**
	 * @param skill to search freelancers with skill
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getBySkillContain(String skill) throws FreelancerNotFoundException;

	/**
	 * @param name to search freelancers with name
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByName(String name) throws FreelancerNotFoundException;

	/**
	 * @param category to search freelancers with category
	 * @param skill to search freelancers with skill
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatSkillContain(String category, String skill) throws FreelancerNotFoundException;

	/**
	 * @param category to search freelancers with category
	 * @param skill to search freelancers with skill
	 * @param type to search freelancer based on full-time or part-time
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatSkillTypContain(String category, String skill, String type) throws FreelancerNotFoundException;

	/**
	 * @param category to search freelancers based on category
	 * @param experience to search freelancers  based on experience
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatExpContain(String category, int experience) throws FreelancerNotFoundException;

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param cost to search based on cost
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatSkillCostContain(String category, String skill, double cost) throws FreelancerNotFoundException;
	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param experience to search based on experience
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatSkillExpContain(String category, String skill, int experience) throws FreelancerNotFoundException;
	
	/**
	 * @param category to search based on category
	 * @param Location to search based on location
	* @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	List<Freelancer> getByCatLocationContain(String category,String Location) throws FreelancerNotFoundException;

}

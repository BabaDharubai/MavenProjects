package com.upwork.dao;

import java.util.List;

import com.upwork.model.Freelancer;

public interface IFreelancerDao {
	
	void addFreelancer(Freelancer freelancer);

	int deleteFreelancer(int freelancerId);

	int updateFreelancer(int freelancerId, double cost);
	
	int updateFreelancer(int freelancerId, String skill);
	
	int updateFreelancer(int freelancerId, int experience);
	
	Freelancer findById(int freelancerId);

	List<Freelancer> findByCategoryContain(String category);

	List<Freelancer> findBySkillContain(String skill);

	List<Freelancer> findByName(String name);

	List<Freelancer> findByCatSkillContain(String category, String skill);

	List<Freelancer> findByCatSkillTypeContain(String category, String skill, String type);

	List<Freelancer> findByCatExpContain(String category, int experience);

	List<Freelancer> findByCatSkillCostContain(String category, String skill, double cost);
	
	List<Freelancer> findByCatSkillExpContain(String category, String skill, int experience);
	
	List<Freelancer> findByCatLocationContain(String category,String Location);

}

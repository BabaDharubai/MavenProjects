package com.upwork.service;

import java.util.List;

import com.upwork.exception.FreelancerNotFoundException;
import com.upwork.exception.IdNotFoundException;
import com.upwork.model.Freelancer;

public interface IFreelancerService {
	
	void addFreelancer(Freelancer freelancer);

	int deleteFreelancer(int freelancerId) throws IdNotFoundException;

	int updateFreelancer(int freelancerId, double cost) throws IdNotFoundException;
	
	int updateFreelancer(int freelancerId, String skill) throws IdNotFoundException;
	
	int updateFreelancer(int freelancerId, int experience) throws IdNotFoundException;
	
	Freelancer getById(int freelancerId) throws IdNotFoundException;

	List<Freelancer> getByCategoryContain(String category) throws FreelancerNotFoundException;

	List<Freelancer> getBySkillContain(String skill) throws FreelancerNotFoundException;

	List<Freelancer> getByName(String name) throws FreelancerNotFoundException;

	List<Freelancer> getByCatSkillContain(String category, String skill) throws FreelancerNotFoundException;

	List<Freelancer> getByCatSkillTypContain(String category, String skill, String type) throws FreelancerNotFoundException;

	List<Freelancer> getByCatExpContain(String category, int experience) throws FreelancerNotFoundException;

	List<Freelancer> getByCatSkillCostContain(String category, String skill, double cost) throws FreelancerNotFoundException;
	
	List<Freelancer> getByCatSkillExpContain(String category, String skill, int experience) throws FreelancerNotFoundException;
	
	List<Freelancer> getByCatLocationContain(String category,String Location) throws FreelancerNotFoundException;

}

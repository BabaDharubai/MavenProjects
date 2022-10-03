package com.upwork.service;

import java.util.Collections;
import java.util.List;

import com.upwork.dao.IFreelancerDao;
import com.upwork.exception.FreelancerNotFoundException;
import com.upwork.exception.IdNotFoundException;
import com.upwork.dao.FreelancerDaoImpl;
import com.upwork.model.Freelancer;

public class FreelancerServiceImpl implements IFreelancerService{

	IFreelancerDao freelancerDao=new FreelancerDaoImpl();
	@Override
	public void addFreelancer(Freelancer freelancer) {
		freelancerDao.addFreelancer(freelancer);
//		generate password -> create a class PasswordGenerator in util packege
//		generatePassword()
		
	}

	@Override
	public int deleteFreelancer(int freelancerId) throws IdNotFoundException{
		int result=freelancerDao.deleteFreelancer(freelancerId);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	@Override
	public int updateFreelancer(int freelancerId, double cost) throws IdNotFoundException{
		int result=freelancerDao.updateFreelancer(freelancerId, cost);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
		
	}
	
	@Override
	public int updateFreelancer(int freelancerId, String skill) throws IdNotFoundException {
		int result=freelancerDao.updateFreelancer(freelancerId, skill);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	@Override
	public int updateFreelancer(int freelancerId, int experience) throws IdNotFoundException {
		int result=freelancerDao.updateFreelancer(freelancerId, experience);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}
	

	@Override
	public Freelancer getById(int freelancerId) throws IdNotFoundException{
		Freelancer freelancer=freelancerDao.findById(freelancerId);
		if(freelancer==null)
			throw new IdNotFoundException("Id Not Found");
		else
			return freelancer;
	}

	@Override
	public List<Freelancer> getByCategoryContain(String category) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCategoryContain(category);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getBySkillContain(String skill) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findBySkillContain(skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList; 
	}

	@Override
	public List<Freelancer> getByName(String name) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByName(name);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getByCatSkillContain(String category, String skill) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillContain(category,skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList; 
	}

	@Override
	public List<Freelancer> getByCatSkillTypContain(String category, String skill, String type) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillContain(category, skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getByCatExpContain(String category, int experience) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatExpContain(category, experience);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getByCatSkillCostContain(String category, String skill, double cost) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillCostContain(category, skill, cost);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getByCatLocationContain(String category, String Location) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatLocationContain(category, Location);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	@Override
	public List<Freelancer> getByCatSkillExpContain(String category, String skill, int experience) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillExpContain(category, skill, experience);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort( freelancerList);
			return freelancerList;
	}

	


	

}

package com.upwork.service;

import java.util.Collections;
import java.util.List;

import com.upwork.dao.IFreelancerDao;
import com.upwork.exception.FreelancerNotFoundException;
import com.upwork.exception.IdNotFoundException;
import com.upwork.dao.FreelancerDaoImpl;
import com.upwork.model.Freelancer;

/**
 * @author BabaFakruddinDharubai
 *
 */
public class FreelancerServiceImpl implements IFreelancerService{

	IFreelancerDao freelancerDao=new FreelancerDaoImpl();
	
	
	/** 
	 * @param freelancer to add freelancer to table
	 */
	@Override
	public void addFreelancer(Freelancer freelancer) {
		freelancerDao.addFreelancer(freelancer);
		
	}

	/**
	 * @param freelancerId to search freelancer
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	@Override
	public int deleteFreelancer(int freelancerId) throws IdNotFoundException{
		int result=freelancerDao.deleteFreelancer(freelancerId);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	/**
	 * @param freelancerId to search freelancer
	 * @param cost to update cost of freelancer
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	@Override
	public int updateFreelancer(int freelancerId, double cost) throws IdNotFoundException{
		int result=freelancerDao.updateFreelancer(freelancerId, cost);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
		
	}
	
	/**
	 * @param freelancerId to search freelancer
	 * @param skill to update freelancer skill
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	@Override
	public int updateFreelancer(int freelancerId, String skill) throws IdNotFoundException {
		int result=freelancerDao.updateFreelancer(freelancerId, skill);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}

	/**
	 * @param freelancerId to search freelancer
	 * @param experience to update freelancer experience
	 * @return 1-if freelancer is available 
	 * @throws IdNotFoundException if freelancer is not available
	 */
	@Override
	public int updateFreelancer(int freelancerId, int experience) throws IdNotFoundException {
		int result=freelancerDao.updateFreelancer(freelancerId, experience);
		if(result==0)
			throw new IdNotFoundException("Id Not Found");
		else
			return result;
	}
	

	/**
	 * @param freelancerId to search for freelancer
	 * @return freelancer if available
	 * @throws IdNotFoundException if freelancer not found/not available
	 */
	@Override
	public Freelancer getById(int freelancerId) throws IdNotFoundException{
		Freelancer freelancer=freelancerDao.findById(freelancerId);
		if(freelancer==null)
			throw new IdNotFoundException("Id Not Found");
		else
			return freelancer;
	}

	/**
	 * @param category to search freelancers with category
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCategoryContain(String category) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCategoryContain(category);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param skill to search freelancers with skill
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getBySkillContain(String skill) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findBySkillContain(skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList; 
	}

	/**
	 * @param name to search freelancers with name
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByName(String name) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByName(name);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param category to search freelancers with category
	 * @param skill to search freelancers with skill
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCatSkillContain(String category, String skill) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillContain(category,skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList; 
	}

	/**
	 * @param category to search freelancers with category
	 * @param skill to search freelancers with skill
	 * @param type to search freelancer based on full-time or part-time
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCatSkillTypContain(String category, String skill, String type) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillContain(category, skill);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param category to search freelancers based on category
	 * @param experience to search freelancers  based on experience
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCatExpContain(String category, int experience) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatExpContain(category, experience);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param cost to search based on cost
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCatSkillCostContain(String category, String skill, double cost) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatSkillCostContain(category, skill, cost);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param Location to search based on location
	* @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
	@Override
	public List<Freelancer> getByCatLocationContain(String category, String Location) throws FreelancerNotFoundException{
		List<Freelancer> freelancerList=freelancerDao.findByCatLocationContain(category, Location);
		if(freelancerList.isEmpty())
			throw new FreelancerNotFoundException("Freelancer Not Found");
		else
			Collections.sort(freelancerList);
			return freelancerList;
	}

	/**
	 * @param category to search based on category
	 * @param skill to search based on skill
	 * @param experience to search based on experience
	 * @return list of freelancers if found based on parameters
	 * @throws FreelancerNotFoundException if freelancer is not available
	 */
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

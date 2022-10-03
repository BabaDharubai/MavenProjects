package com.upwork.model;

public class Freelancer implements Comparable<Freelancer>{
	private Integer freelancerId;
	private String freelancerName;
	private String location;
	private int experience;
	private String type;
	private String category;
	private double cost;
	private String skill; //WebDeveloper, ContentWriter
	
	
	public Freelancer(){
		super();
		// TODO Auto-generated constructor stub
	}
	public Freelancer(Integer freelancerId, String freelancerName, String category, String skill, int experience,
			 double cost, String type,String location) {
		super();
		this.freelancerId=freelancerId;
		this.freelancerName = freelancerName;
		this.location = location;
		this.experience = experience;
		this.type = type;
		this.category = category;
		this.cost = cost;
		this.skill = skill;
	}
	
	
	public Integer getFreelancerId() {
		return freelancerId;
	}
	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}
	public String getFreelancerName() {
		return freelancerName;
	}
	public void setFreelancerName(String freelancerName) {
		this.freelancerName = freelancerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Freelancer [freelancerId=" + freelancerId + ", freelancerName=" + freelancerName + ", location="
				+ location + ", experience=" + experience + ", type=" + type + ", category=" + category + ", cost="
				+ cost + ", skill=" + skill + "]";
	}
	@Override
	public int compareTo(Freelancer freelancer) {
		// TODO Auto-generated method stub
		return this.getFreelancerName().compareToIgnoreCase(freelancer.getFreelancerName());
	}
	
	
	
		
}

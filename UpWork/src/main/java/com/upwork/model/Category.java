package com.upwork.model;

public enum Category {
	IT("Development & IT"),
	DESIGN("Design & Creative"),
	MARKETING("Sales & Marketing"),
	CONTENTWRITING("Writing & Translation"),
	ADMINSUPPORT("Admin & Customer Support"),
	HEALTH("Health & Medicine"),
	FINANCE("Finance & Accounting");
	
	
	public String type;
	private Category(String type) {
		this.type = type;
	}
	
}

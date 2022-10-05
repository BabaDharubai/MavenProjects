package com.upwork.model;

/**
 * @author BabaFakruddinDharubai
 *
 */
public enum Category {
	IT("Development & IT"),
	DESIGN("Design & Creative"),
	MARKETING("Sales & Marketing"),
	CONTENTWRITING("Writing & Translation"),
	ADMINSUPPORT("Admin & Customer Support"),
	HEALTH("Health & Medicine"),
	FINANCE("Finance & Accounting");
	
	
	public String type;
	/**
	 * @param type to define the type of category
	 */
	private Category(String type) {
		this.type = type;
	}
	
}

package com.upwork.model;

public enum Type {
	FULLTIME("Full-Time"),
	PARTTIME("Part-Time");
	public String type;

	private Type(String type) {
		this.type = type;
	}
	
}

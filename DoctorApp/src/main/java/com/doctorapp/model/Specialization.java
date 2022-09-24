package com.doctorapp.model;

public enum Specialization {
	
	ORTHO("Orthopeadician"),
	PEADO("Pediatrician"),
	DIABETIC("Diabetician"),
	CARDIO("Cardiologist"),
	PHYSICIAN("General Physician");
	
	
	public String type;
	private Specialization(String type) {
		this.type = type;
	}
	
}

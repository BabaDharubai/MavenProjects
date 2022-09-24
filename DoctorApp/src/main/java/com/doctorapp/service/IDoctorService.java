package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	
	void addDoctor(Doctor doctor);
	boolean updateDoctor(int doctorId,double fees) throws IdNotFoundException;
	
	Doctor getById(int doctorId) throws IdNotFoundException;
	boolean deleteDoctor(int doctorId) throws IdNotFoundException;
	
	List<Doctor> getAllDoctors()throws DoctorNotFoundException;
	List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndExp(String speciality,int experience) throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;
	List<Doctor> getByAvailable(LocalDateTime startTime) throws DoctorNotFoundException;
	
	
}

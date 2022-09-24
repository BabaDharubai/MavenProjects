package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	
	void addDoctor(Doctor doctor);

	boolean updateDoctor(int doctorId, double fees);

	Doctor getById(int doctorId);

	boolean deleteDoctor(int doctorId);

	List<Doctor> getAllDoctors();

	List<Doctor> getBySpeciality(String speciality);

	List<Doctor> getBySpecialityAndExp(String speciality, int experience);

	List<Doctor> getBySpecialityAndFees(String speciality, double fees);

	List<Doctor> getByAvailable(LocalDateTime startTime);
}

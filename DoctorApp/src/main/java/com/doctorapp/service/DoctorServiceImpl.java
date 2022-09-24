package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;


public class DoctorServiceImpl implements IDoctorService {
	
	IDoctorDao service=new DoctorDaoImpl();
	List<Doctor> doctorList=new ArrayList<>();
	@Override
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		service.addDoctor(doctor);
		
	}

	@Override
	public boolean updateDoctor(int doctorId, double fees) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if(service.updateDoctor(doctorId, fees)==false)
			throw new IdNotFoundException("Id not Found");
		else
			return true;
		
	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Doctor doctor=service.getById(doctorId);
		//Optional<Doctor> option=Optional.of(doctor);
		if(doctor==null)
			throw new IdNotFoundException("Id Not Found");
		else
			return doctor;
	}

	@Override
	public boolean deleteDoctor(int doctorId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if(service.deleteDoctor(doctorId)==false)
			throw new IdNotFoundException("Id Not Found");
		else
			return service.deleteDoctor(doctorId);
		
	}

	@Override
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		doctorList=service.getAllDoctors();
		if(doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor List is Empty");
		else
			Collections.sort(service.getAllDoctors());
			return doctorList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		doctorList=service.getBySpeciality(speciality);
		if(doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			Collections.sort(doctorList);
			return doctorList;
		}
		
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		doctorList=service.getBySpecialityAndExp(speciality, experience);
		if(doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			Collections.sort(doctorList);
			return doctorList;
		}
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		doctorList=service.getBySpecialityAndFees(speciality, fees);
		if(doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			Collections.sort(doctorList);
			return doctorList;
		}
	}

	@Override
	public List<Doctor> getByAvailable(LocalDateTime startTime) throws DoctorNotFoundException{
		// TODO Auto-generated method stub
		
		doctorList=service.getByAvailable(startTime);
		if(doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else
			return doctorList.stream()
					.sorted((d1,d2)->d1.getStartTime().compareTo(d2.getStartTime()))
					.collect(Collectors.toList());
		
	}

}


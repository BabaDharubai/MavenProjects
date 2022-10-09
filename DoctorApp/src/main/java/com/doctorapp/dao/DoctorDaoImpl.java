package com.doctorapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {
	
	@Override
	public void addDoctor(Doctor doctor) {
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.INSERTQUERY);
			statement.setString(1,doctor.getDoctorName());
			statement.setString(2, doctor.getSpeciality());
			statement.setInt(3,doctor.getExperience());
			statement.setDouble(4, doctor.getFees());
			statement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			statement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null) 
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateDoctor(int doctorId, double fees) {
		PreparedStatement statement=null;
		int check;
		boolean flag=false;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, fees);
			statement.setInt(2,doctorId);
			check=statement.executeUpdate();
			if(check==1)
				flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}

	@Override
	public Doctor getById(int doctorId) {
		PreparedStatement statement=null;
		Doctor doctor=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETBYID);
			statement.setInt(1, doctorId);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next()) {
				doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return doctor;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		PreparedStatement statement=null;
		int check;
		boolean flag=false;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.DELETEDOCTOR);
			statement.setInt(1, doctorId);
			check=statement.executeUpdate();
			if(check==1)
				flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETALLDOCTORS);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECIALITY);
			statement.setString(1, speciality);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECEXP);
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECFEE);
			statement.setString(1, speciality);
			statement.setDouble(2, fees);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getByAvailable(LocalDateTime startTime) {
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement statement=null;
		try {
			statement=DbConnection.getConnection().prepareStatement(Queries.GETBYAVAIL);
			statement.setTimestamp(1,Timestamp.valueOf(startTime));
			statement.setTimestamp(2, Timestamp.valueOf(startTime));
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSpeciality(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getDouble(5));
				doctor.setStartTime(resultSet.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultSet.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doctorList;
	}

}

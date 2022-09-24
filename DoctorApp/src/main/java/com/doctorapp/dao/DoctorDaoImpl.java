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
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.INSERTQUERY);
			ps.setString(1,doctor.getDoctorName());
			ps.setString(2, doctor.getSpeciality());
			ps.setInt(3,doctor.getExperience());
			ps.setDouble(4, doctor.getFees());
			ps.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			ps.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) 
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateDoctor(int doctorId, double fees) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps=null;
		int check;
		boolean flag=false;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.UPDATEQUERY);
			ps.setDouble(1, fees);
			ps.setInt(2,doctorId);
			check=ps.executeUpdate();
			if(check==1)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
		
	}

	@Override
	public Doctor getById(int doctorId) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETBYID);
			ps.setInt(1, doctorId);
			ResultSet rs=ps.executeQuery();
			Doctor doctor=new Doctor();
			while(rs.next()) {
				
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				return doctor;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int check;
		boolean flag=false;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.DELETEDOCTOR);
			ps.setInt(1, doctorId);
			check=ps.executeUpdate();
			if(check==1)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETALLDOCTORS);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECIALITY);
			ps.setString(1, speciality);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECEXP);
			ps.setString(1, speciality);
			ps.setInt(2, experience);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doctorList;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETBYSPECFEE);
			ps.setString(1, speciality);
			ps.setDouble(2, fees);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return doctorList;
	}

	@Override
	public List<Doctor> getByAvailable(LocalDateTime startTime) {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=new ArrayList<>();
		PreparedStatement ps=null;
		try {
			ps=DbConnection.getConnection().prepareStatement(Queries.GETBYAVAIL);
			ps.setTimestamp(1,Timestamp.valueOf(startTime));
			ps.setTimestamp(2, Timestamp.valueOf(startTime));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doctor=new Doctor();
				doctor.setDoctorId(rs.getInt(1));
				doctor.setDoctorName(rs.getString(2));
				doctor.setSpeciality(rs.getString(3));
				doctor.setExperience(rs.getInt(4));
				doctor.setFees(rs.getDouble(5));
				doctor.setStartTime(rs.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp(7).toLocalDateTime());
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return doctorList;
	}

}

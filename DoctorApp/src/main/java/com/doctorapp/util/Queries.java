package com.doctorapp.util;

public class Queries {
	
	public static final String CREATEQUERY="create table doctor(doctorId Integer PRIMARY KEY auto_increment,doctorName varchar(30),speciality varchar(30),experience INTEGER,fees double,startTime Timestamp,endTime Timestamp)";
	
	public static final String INSERTQUERY="insert into doctor(doctorName,speciality,experience,fees,startTime,endTime) values(?,?,?,?,?,?)";
	
	public static final String GETBYID="select * from doctor where doctorId=?";
	
	public static final String UPDATEQUERY="update doctor set fees=? where doctorId=?";
	
	public static final String DELETEDOCTOR="delete from doctor where doctorId=?";
	
	public static final String GETALLDOCTORS="select * from doctor";
	
	public static final String GETBYSPECIALITY="select * from doctor where speciality=?";
	
	public static final String GETBYSPECEXP="select * from doctor where speciality=? and experience>=?";
	
	public static final String GETBYSPECFEE="select * from doctor where speciality=? and fees<=?";
	
	public static final String GETBYAVAIL="select * from doctor where startTime>=? or endTime>=?";
}

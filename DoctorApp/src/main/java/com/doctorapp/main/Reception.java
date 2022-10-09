package com.doctorapp.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class Reception {
	public static void main(String[] args) {

		IDoctorService service = new DoctorServiceImpl();
		int loop = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Your Response");
			System.out.println(
					"1.Add Doctor\n2.UpdateFee\n3.Get Doctor BY Id\n4.Get all Doctors\n5.Delete Doctor\n6.Get by Speciality\n7.Get By Speciality & Experience\n8.Get By Availabity\n9.Get by speciality and fees");

			int type = sc.nextInt();
			switch (type) {
			case 1:
				System.out.println("Enter Doctor Details");
				sc.nextLine();
				System.out.println("Doctor Name : ");
				String doctorName = sc.nextLine();
				System.out.println("Enter Id : ");
				int doctorId = sc.nextInt();
				System.out.println("Enter Speciality\n1.ORTHO\n2.PEADO\n3.DIABETIC\n4.CARDIO\n5.PHYSICIAN");
				int choice=sc.nextInt();
				String speciality = Specialization.values()[choice-1].type;
				System.out.println("Enter Fees : ");
				double fees = sc.nextDouble();
				System.out.println("Enter experience : ");
				int experience = sc.nextInt();
				System.out.println("Enter startdate as YYYY-MM-DD");
				String startDate = sc.next();
				LocalDate startLocalDate = LocalDate.parse(startDate);
				System.out.println("Enter starttime in hh:mm:ss");
				String startTime = sc.next();
				LocalTime startLocalTime = LocalTime.parse(startTime);
				LocalDateTime startLocalDateTime = LocalDateTime.of(startLocalDate, startLocalTime);

				System.out.println("Enter end Date as YYYY-MM-DD");
				String endDate = sc.next();
				LocalDate endLocalDate = LocalDate.parse(endDate);
				System.out.println("Enter end time in hh:mm:ss");
				String endTime = sc.next();
				LocalTime endLocalTime = LocalTime.parse(endTime);
				LocalDateTime endLocalDateTime = LocalDateTime.of(endLocalDate, endLocalTime);
				service.addDoctor(new Doctor(doctorName, doctorId, speciality, fees, experience, startLocalDateTime,
						endLocalDateTime));
				break;
			case 2:
				System.out.println("Enter DoctorId and Updating fee");
				doctorId = sc.nextInt();
				fees = sc.nextDouble();
				if (service.updateDoctor(doctorId, fees))
					System.out.println("Updated");
				break;
			case 3:
				System.out.println("Enter Doctor ID");
				doctorId = sc.nextInt();
				System.out.println(service.getById(doctorId));
				break;
			case 4:
				service.getAllDoctors().forEach(System.out::println);
				break;
			case 5:
				System.out.println("Enter Doctor Id");
				doctorId = sc.nextInt();
				if (service.deleteDoctor(doctorId))
					System.out.println("Deleted");
				break;
			case 6:
				System.out.println("Enter Speciality\n1.ORTHO\n2.PEADO\n3.DIABETIC\n4.CARDIO\n5.PHYSICIAN");
				choice=sc.nextInt();
				speciality = Specialization.values()[choice-1].type;
				service.getBySpeciality(speciality).forEach(System.out::println);
				break;
			case 7:
				System.out.println("Enter Speciality\n1.ORTHO\n2.PEADO\n3.DIABETIC\n4.CARDIO\n5.PHYSICIAN");
				choice=sc.nextInt();
				speciality = Specialization.values()[choice-1].type;
				experience = sc.nextInt();
				service.getBySpecialityAndExp(speciality, experience).forEach(System.out::println);
				break;
			case 8:
				System.out.println("Enter date as YYYY-MM-DD");
				String date = sc.next();
				LocalDate localDate = LocalDate.parse(date);
				System.out.println("Enter time in hh:mm:ss");
				String time = sc.next();
				LocalTime localTime = LocalTime.parse(time);
				LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
				service.getByAvailable(localDateTime).forEach(System.out::println);
				break;

			case 9:
				System.out.println("Enter Speciality\n1.ORTHO\n2.PEADO\n3.DIABETIC\n4.CARDIO\n5.PHYSICIAN");
				choice=sc.nextInt();
				speciality = Specialization.values()[choice-1].type;
				fees = sc.nextDouble();
				service.getBySpecialityAndFees(speciality, fees).forEach(System.out::println);
				break;
			default:
				System.out.println("Invalid Entry");
			}
			System.out.println("continue-1\nExit-0");
			loop = sc.nextInt();
		} while (loop == 1);
		System.out.println("Take care of your Health");
		sc.close();
	}
}

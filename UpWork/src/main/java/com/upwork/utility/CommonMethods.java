package com.upwork.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.upwork.model.Category;
import com.upwork.model.Freelancer;
import com.upwork.model.Type;
import com.upwork.service.FreelancerServiceImpl;
import com.upwork.service.IFreelancerService;

public class CommonMethods {
	public static List<Freelancer> getMethods(int option) {
		Scanner sc=new Scanner(System.in);
		IFreelancerService freelancerService=new FreelancerServiceImpl();
		List<Freelancer> freelancerList=new ArrayList<>();
		switch(option) {
		case 1:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			String category=Category.values()[option-1].type;
			freelancerList=freelancerService.getByCategoryContain(category);
			break;
		case 2:
			System.out.println("Enter freelancerName");
			String freelancerName=sc.nextLine();
			freelancerList=freelancerService.getByName(freelancerName);
			break;
		case 3:
			System.out.println("Enter Skill");
			String skill=sc.nextLine();
			freelancerList=freelancerService.getBySkillContain(skill);
			break;
		case 4:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter Skill");
			skill=sc.nextLine();
			freelancerList=freelancerService.getByCatSkillContain(category, skill);
			break;
		case 5:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter Skill");
			skill=sc.nextLine();
			System.out.println("Enter Type\n1.Full Time\n2.Part Time");
			int timing=sc.nextInt();
			sc.nextLine();
			String timings=Type.values()[timing-1].type;
			freelancerList=freelancerService.getByCatSkillTypContain(category, skill, timings);
			break;
		case 6:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter Experience");
			int experience=sc.nextInt();
			sc.nextLine();
			freelancerList=freelancerService.getByCatExpContain(category, experience);
			break;
		case 7:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter Skill");
			skill=sc.nextLine();
			System.out.println("Enter cost");
			double cost=sc.nextDouble();
			freelancerList=freelancerService.getByCatSkillCostContain(category, skill, cost);
			break;
		case 8:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter Skill");
			skill=sc.nextLine();
			System.out.println("Enter cost");
			experience=sc.nextInt();
			sc.nextLine();
			freelancerList=freelancerService.getByCatSkillExpContain(category, skill, experience);
			break;
		case 9:
			System.out.println("Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
			option=sc.nextInt();
			sc.nextLine();
			category=Category.values()[option-1].type;
			System.out.println("Enter location");
			String location=sc.nextLine();
			freelancerList=freelancerService.getByCatLocationContain(category, location);
			break;
		default:
			System.out.println("Invalid Entry");
		}
		sc.close();
		return freelancerList;
		
	}
}

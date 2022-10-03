package com.upwork.main;

import com.upwork.service.IFreelancerService;
import com.upwork.service.IUserService;
import com.upwork.service.UserServiceImpl;
import com.upwork.utility.CommonMethods;
import com.upwork.model.Category;
import com.upwork.model.Freelancer;
import com.upwork.model.Type;
import com.upwork.model.User;
import com.upwork.service.FreelancerServiceImpl;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		IFreelancerService freelancerService = new FreelancerServiceImpl();
		IUserService userService = new UserServiceImpl();
		System.out.println("Enter your response");

		Scanner sc = new Scanner(System.in);
		System.out.println("1.Register\n2.Login");
		int type = sc.nextInt();
		sc.nextLine();
		User user = null;
		switch (type) {
		case 1:
			user = new User();
			System.out.println("Enter your Name");
			String name = sc.nextLine();
			user.setName(name);
			System.out.println("Enter your Mobile No");
			long mobile = sc.nextLong();
			sc.nextLine();
			user.setMobile(mobile);
			System.out.println("Enter email");
			String email = sc.nextLine();
			user.setEmail(email);
			System.out.println("Enter city");
			String city = sc.nextLine();
			user.setCity(city);
			System.out.println("Enter type freelancer or employer");
			String type1 = sc.nextLine();
			user.setType(type1);
			System.out.println("Enter UserName ");
			String userName = sc.nextLine();
			user.setUserName(userName);
			System.out.println(userService.register(user));

			System.out.println("Enter your userName");
			userName = sc.nextLine();
			System.out.println("Enter your password");
			String password = sc.nextLine();
			user = userService.login(userName, password);
			if (user.getType().equalsIgnoreCase("freelancer")) {
				System.out.println("Add freelancing Details");
				Freelancer freelancer = new Freelancer();
				System.out.println(
						"Enter Category\n1.IT\n2.DESIGN\n3.MARKETING\n4.CONTENTWRITING\n5.ADMINSUPPORT\n6.HEALTH\n7.FINANCE");
				int option = sc.nextInt();
				sc.nextLine();
				String category = Category.values()[option - 1].type;
				System.out.println("Enter Skill");
				String skill = sc.nextLine();
				System.out.println("Enter Experience");
				int experience = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Cost/hr");
				double cost = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter Type\n1.Full Time\n2.Part Time");
				int timing = sc.nextInt();
				sc.nextLine();
				String timings = Type.values()[timing - 1].type;
				freelancer.setFreelancerId(user.getUserId());
				freelancer.setFreelancerName(user.getName());
				freelancer.setLocation(user.getCity());
				freelancer.setCategory(category);
				freelancer.setSkill(skill);
				freelancer.setExperience(experience);
				freelancer.setCost(cost);
				freelancer.setType(timings);
				freelancerService.addFreelancer(freelancer);
			}
			break;
		case 2:
			System.out.println("Enter Login Details");
			System.out.println("Enter your UserName");
			userName = sc.nextLine();
			System.out.println("Enter your password");
			password = sc.nextLine();
			user = userService.login(userName, password);
			if(user!=null) {
				if (user.getType().equalsIgnoreCase("employer")) {
					int loop = 0;
					do {

						System.out.println(
								"1.Get By Category\n2.Get By Name\n3.Get By Skill\n4.Get By Category & Skill\n5.Get By Category, Skill & Type\n6.Get By Category & Experience\n7.Get Category, Skill & Cost\n8.Get By Category, Skill & Experience\n9.Get By Category & Location");
						int recruiter = sc.nextInt();
						sc.nextLine();
						CommonMethods.getMethods(recruiter).forEach(System.out::println);
						System.out.println("1.Continue\n0.Exit");
						loop = sc.nextInt();
						sc.nextLine();
					} while (loop == 1);
				} else if (user.getType().equalsIgnoreCase("freelancer")) {
					System.out.println("1.update your profie\n2.delete account\n3.Roam around website");
					int option = sc.nextInt();
					switch (option) {
					case 1:
						System.out.println(
								"Enter your updating parameter\n1.cost\n2.skill\n3.Experience\n4.Delete your Account");
						option = sc.nextInt();
						sc.nextLine();
						switch (option) {
						case 1:
							System.out.println("Enter cost");
							double cost = sc.nextDouble();
							freelancerService.updateFreelancer(user.getUserId(), cost);
							System.out.println("Updated");
							break;
						case 2:
							System.out.println("Enter skill");
							String skill = sc.nextLine();
							freelancerService.updateFreelancer(user.getUserId(), skill);
							System.out.println("Skill added");
							break;
						case 3:
							System.out.println("Enter Experience");
							int experience = sc.nextInt();
							sc.nextLine();
							freelancerService.updateFreelancer(user.getUserId(), experience);
							System.out.println("Experience updated");
							break;
						}
						break;
					case 2:
						System.out.println("Are u sure u want to Delete your account\n1.yes\n2.No");
						option = sc.nextInt();
						sc.nextLine();
						if (option == 1) {
							freelancerService.deleteFreelancer(user.getUserId());
						}
						break;
					case 3:
						int loop = 0;
						do {
							System.out.println(
									"1.Get By Category\n2.Get By Name\n3.Get By Skill\n4.Get By Category & Skill\n5.Get By Category, Skill & Type\n6.Get By Category & Experience\n7.Get Category, Skill & Cost\n8.Get By Category, Skill & Experience\n9.Get By Category & Location");

							int methodNo = sc.nextInt();
							sc.nextLine();
							CommonMethods.getMethods(methodNo).forEach(System.out::println);
							System.out.println("1.Continue\n0.Exit");
							loop = sc.nextInt();
							sc.nextLine();
						} while (loop == 1);
						break;
					}
				}
			}
		}
		sc.close();

	}

}

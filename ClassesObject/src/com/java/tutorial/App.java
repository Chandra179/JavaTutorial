package com.java.tutorial;

public class App {
	public static void main(String[] args) {
		// fill the staff array with three Employee objects
		MyEmployee[] staff = new MyEmployee[3];
		MyEmployee staffs = new MyEmployee("Carl bommer", 75000, 1987, 12, 15);
		MyEmployee staffss = new MyEmployee("Carl bommer", 75000, 1987, 12, 15);

		staff[0] = new MyEmployee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new MyEmployee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new MyEmployee("Tony Tester", 40000, 1990, 3, 15);

		// raise everyone's salary by 5%
		for (MyEmployee e : staff)
			e.raiseSalary(5);

		// print out information about all Employee objects
		System.out.println(staffs);
		System.out.println(staffss);
		for (MyEmployee e : staff)
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
	}
}
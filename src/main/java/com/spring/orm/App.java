package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		// Student student = new Student(1, "Gourav", "Delhi");
		// int r = studentDao.insert(student);
		// System.out.println("Done" + r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Boolean go = true;
		while (go) {
			System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
			System.out.println("PRESS 1 for add new student.");
			System.out.println("PRESS 2 for display all student.");
			System.out.println("PRESS 3 for get detail of single student.");
			System.out.println("PRESS 4 for delete student.");
			System.out.println("PRESS 6 for for exit.");
			System.out.println("Update");
			System.out.println("PRESS 5 for update student.");
			System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
			try {

				int input = Integer.parseInt(br.readLine());
				Scanner ob = new Scanner(System.in);
				switch (input) {
				case 1:

					System.out.println("Enter Your Id.");
					int id = ob.nextInt();
					System.out.println("Enter Your Name.");
					String name = ob.next();
					System.out.println("Enter Your City.");
					String city = ob.next();

					Student student = new Student(id, name, city);
					int sId = studentDao.insert(student);
					System.out.println("Student Added Successfully " + sId);
					break;
				case 2:
					List<Student> list = studentDao.getAllStudents();
					for (Student slist : list) {
						System.out.println(slist.getStudentName());
					}
					break;
				case 3:
					System.out.println("Enter ID.");
					int studentId = ob.nextInt();
					studentDao.getStudent(studentId);
					break;
				case 4:

					System.out.println("Enter ID.");
					int Sid = ob.nextInt();
					studentDao.deleteStudent(Sid);

					System.out.println("Student Delete Successfully.");

					break;
				case 5:
					System.out.println("Update Student.");
					break;
				case 6:
					System.out.println("Exit");
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invaild inpute try with another one ! ");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thank You Using My Application");
		System.out.println("See You Sooon Have A Gud Day..");
	}
}

package com.spring.orm;

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

		Scanner ob = new Scanner(System.in);
		Boolean go = true;
		while (go) {
			System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
			System.out.println("PRESS 1 for add new student.");
			System.out.println("PRESS 2 for display all student.");
			System.out.println("PRESS 3 for get detail of single student.");
			System.out.println("PRESS 4 for delete student.");
			System.out.println("PRESS 5 for update student.");
			System.out.println("PRESS 6 for for exit.");
			System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
			try {
				System.out.println("Choose Your Option.");
				int input = Integer.parseInt(ob.next());

				switch (input) {
				case 1:

					// ADD A NEW STUDENT
					// TAKING INPUTE FROM USERS

					System.out.println("Enter Your Id.");
					int id = ob.nextInt();
					System.out.println("Enter Your Name.");
					String name = ob.next();
					System.out.println("Enter Your City.");
					String city = ob.next();

					// CREATING STUDENT OBJECT
					Student student = new Student(id, name, city);

					// SAVING STUDENT OBJECT TO DATABASE BY CALLING INSERT OF STUDENT DAO
					int sId = studentDao.insert(student);
					System.out.println();
					System.out.println(sId + " Student Added Successfully ");
					System.out.println("*******************************************");
					System.out.println();
					break;
				case 2:
					// FETCH ALL STUDENT
					List<Student> list = studentDao.getAllStudents();
					for (Student slist : list) {
						System.out.println();
						System.out.println("Id : " + slist.getStudentId());
						System.out.println("Name : " + slist.getStudentName());
						System.out.println("City : " + slist.getStudentCity());
						System.out.println("---------------------------------------");
					}
					break;
				case 3:
					System.out.println("Enter ID.");
					int studentId = ob.nextInt();
					Student st =studentDao.getStudent(studentId);
					System.out.println();
					System.out.println("Id : " + st.getStudentId());
					System.out.println("Name : " + st.getStudentName());
					System.out.println("City : " + st.getStudentCity());
					System.out.println("---------------------------------------");
					break;
				case 4:

					System.out.println("Enter User ID.");
					int Sid = ob.nextInt();
					studentDao.deleteStudent(Sid);
					System.out.println();
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

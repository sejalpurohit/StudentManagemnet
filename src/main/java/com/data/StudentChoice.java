package com.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentChoice {

	public void choiceForStudent() throws SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome to Students PortalStudent\n" + "Choose Your Service"
				+ "\nTo view all students(press 1)" + "\nViewStudent by Id (press 2)");
		//int choice = sc.nextInt();
		/*JDBC jdbc = new JDBC();
		switch (choice) {
		case 1: {
			System.out.println("View All Students student");
			System.out.println("Enter Student Id");
			int sid = sc.nextInt();
			System.out.println(jdbc.getSpecificStudent(sid));
			break;
		}
		case 2: {
			System.out.println("View specific student");
			List<Students> students = jdbc.getAllStudents();
			System.out.println(students);
			break;
		}
		default:
			System.out.println("Invalid Choice");
		}
		sc.close();
		reader.close();*/
	}
}

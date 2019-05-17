package com.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherChoice {

	public void choiceForTeacher() throws IOException, SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcom to Staff Portal\nVerifying User...");
		System.out.println("Enter Staff UserName");
		/*String username = reader.readLine();
		System.out.println("Enter Staff Password");
		String password = reader.readLine();
		JDBC jdbc = new JDBC();
		TeacherJDBC t = new TeacherJDBC();
		int credential = t.verification(username, password);
		if (credential == 1) {
			System.out.println("Verification Sucessful.\nChoose your Service"+"\nto a Add Student Press 1"
					+ "\nto To delete a specifi Student Press 2" + "\nTo Delete all students Press 3"
					+ "\nEnter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Addes STUDENT");
				String filePath = "C:\\Users\\sejal.purohit\\Desktop\\Students.xlsx";
				ExcelRead read = new ExcelRead();
				read.readFromExcel(filePath);
				break;
			}
			case 2: {
				System.out.println("update student");
				break;
			}
			case 3: {
				System.out.println("delete specific");
				System.out.println("Enter teacher Id");
				int id = sc.nextInt();
				jdbc.deleteSpecificStudent(id);
				break;
			}
			case 4: {
				System.out.println("delete");
				jdbc.deleteAllStudent();
				break;
			}
			default:
				System.out.println("invalid choice");
			}// inner switch case close
		} // if close
		else {
			System.out.println("Invalid Staff credentials");
		}
		sc.close();
		reader.close();*/
	}

}

package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminChoice {
	private static String adminUserName = "admin";
	private static String adminPassword = "admin1234";
	private String filePathTeacher = "C:\\Users\\sejal.purohit\\Desktop\\Teacher.xlsx";

	public void choiceForAdmin() throws IOException, ClassNotFoundException, SQLException {

		ReadLoginChoice loginChoice = new ReadLoginChoice();
		ReadTeacherExcel readTeacher = new ReadTeacherExcel();
		System.out.println("Welcome to Admin Portal Choose your Service\n"
				+ "Verifying User\nUsername->reading from excel\n" + "Password->reading from excel");
		String filePathLogin = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";
		List<LoginChoice> list = loginChoice.readLoginChoice(filePathLogin);
		List<Teachers> teacher = readTeacher.readExcel(filePathTeacher);
		// TeacherJDBC teacherJdbc = new TeacherJDBC();
		for (int j = 0; j < list.size(); j++) {

			if (adminUserName.equals(list.get(j).getUserName()) && adminPassword.equals(list.get(j).getPassword())) {
				System.out.println("Login Successful" + "\nChoose your Service" + "\nAdd Teacher" + "\nView Teachers"
						+ "\nDelete Teachers" + "\nDelete Specific Teacher" + "\nEnter your choice");

				for (int index = 0; index < teacher.size(); index++) {

					switch (teacher.get(index).getAction()) {
					case "Add": {
						System.out.println("In add option ..........");
						// ReadTeacherExcel read = new ReadTeacherExcel();
						// read.readExcel(filePath);
						break;
					}
					case "View": {
						System.out.println("In view option");
						// List<Teachers> teachers = teacherJdbc.getTeachers();
						// System.out.println(teachers);
						break;
					}
					case "Delete": {
						System.out.println("In delete option");
						// teacherJdbc.deleteTeachers();
						break;
					}
					case "Delete All": {
						System.out.println("In delete all option");
						// System.out.println("Enter teacher Id");
						// int tid = sc.nextInt();
						// teacherJdbc.deleteSpecificTeacher(tid);
						break;
					} // case 4 close
					default:
						System.out.println("Invalid Choice");
					}// inner switch case close
				} // if close

			} // for inner
		} // for outer
			// else { System.out.println("Invalid Credential..!!!"); }
	}
}

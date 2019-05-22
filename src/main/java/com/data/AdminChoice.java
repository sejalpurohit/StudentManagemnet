package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminChoice {
	private static String adminUserName = "admin";
	private static String adminPassword = "admin1234";
	private static String adminName = "admin";
public static String filePathTeacher = "C:\\Users\\sejal.purohit\\Desktop\\Teacher.xlsx";

	public void choiceForAdmin() throws IOException, ClassNotFoundException, SQLException {

		ReadLoginChoice loginChoice = new ReadLoginChoice();
		ReadTeacherExcel readTeacher = new ReadTeacherExcel();
		System.out.println("Welcome to Admin Portal\n"
				+ "Verifying User\nUsername->reading from excel\n" + "Password->reading from excel");
		String filePathLogin = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";
		List<LoginChoice> list = loginChoice.readLoginChoice(filePathLogin);
	
		TeacherJDBC teacherJdbc = new TeacherJDBC();
		for (int j = 0; j < list.size(); j++) {//iterate over no of choice
			if(adminName.equals(list.get(j).getChoice().toLowerCase())) {
			if (adminUserName.equals(list.get(j).getUserName()) && adminPassword.equals(list.get(j).getPassword())) {
				System.out.println("Login Successful" + "\nService:-"+"\nAdd Teacher" + "\nView Teachers"
						+ "\nDelete Teachers" + "\nDelete Specific Teacher");

				List<Teachers> teacher = readTeacher.readExcel(filePathTeacher);

				for (int index = 0; index < teacher.size(); index++) {
					try {
					switch (teacher.get(index).getAction()) {
					case "add": {
						System.out.println("Choice:-Add");
						ReadTeacherExcel read = new ReadTeacherExcel();
						List<Teachers> teacher2 = read.readExcel(filePathTeacher);
						for (Object obj : teacher2) {
							try {
								teacherJdbc.AddTeacher(obj);
							} catch (Exception e) {
								e.getMessage();
							}
						}
						break;					
						}
					case "view": {
						System.out.println("Choice:-View");
						List<Teachers> teachers = teacherJdbc.getTeachers();
						
						for(int i =0 ;i < teachers.size();i++) {
								System.out.println("\n");
								System.out.println("Staff Id  :"+(int)teachers.get(i).getTid());
								System.out.println("Name      :"+teachers.get(i).getName());
								System.out.println("Username  :"+teachers.get(i).getUsername());
								System.out.println("Password  :"+teachers.get(i).getPassword());
							}
						break;
					}
					case "delete all": {
						System.out.println("Choice:-Delete");
						teacherJdbc.deleteTeachers();
						break;
					}
					case "delete": {
						System.out.println("Enter teacher UserName");
						teacherJdbc.deleteSpecificTeacher((int) teacher.get(index).getTid());
						break;
					} // case 4 close
					default:
						System.out.println("Invalid Choice for Admin");
						}// inner switch case close
					}catch(NullPointerException e) {	
					}
				} //for close
			} // if inner
			else { 
				 System.out.println("Invalid Credential..!!!");
				 }
			continue;
			}
		} // for outer
	}
}

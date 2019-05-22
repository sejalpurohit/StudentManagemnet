package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainClass {
	public static String filePath = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {	
			
		/*String filePathStudent = "C:\\Users\\sejal.purohit\\Desktop\\Students.xlsx";
		ReadTeacherExcel read = new ReadTeacherExcel();
		List<Teachers> list =read.readExcel(filePathTeacher);
		for(Object obj : list) {
		System.out.println(obj);}*/
		ReadLoginChoice loginChoice = new ReadLoginChoice();

		List<LoginChoice> list = loginChoice.readLoginChoice(filePath);
			for (int index = 0; index < list.size(); index++) {
				try {
			switch (list.get(index).getChoice().toLowerCase()) {
			case "admin": {
				AdminChoice admin = new AdminChoice();
				admin.choiceForAdmin();
				break;
			} // outer case 1 close
			case "staff": {
				TeacherChoice tChoice = new TeacherChoice();
				tChoice.choiceForTeacher();
				break;
			} // case 2 close
			case "student": {
				StudentChoice sChoice = new StudentChoice();
				sChoice.choiceForStudent();
				break;
			} // case 3 close
			default:
				System.out.println("Invalid Choice..!!");
			}// outer switch case close
				}catch(NullPointerException e) {
					System.out.println("Action cannot be Null");
				}
			System.out.println("================================================================================================================================");
		} // for close
		System.out.println("Session Expired.....!!!!");
	}// main close
}// class close

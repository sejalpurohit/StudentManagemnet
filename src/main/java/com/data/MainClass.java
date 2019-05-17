package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		ReadLoginChoice loginChoice = new ReadLoginChoice();
		String filePath = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";

		List<LoginChoice> list = loginChoice.readLoginChoice(filePath);

		for (int index = 0; index < list.size(); index++) {

			switch (list.get(index).getChoice()) {
			case "Admin": {
				AdminChoice admin = new AdminChoice();
				admin.choiceForAdmin();
				break;
			} // outer case 1 close
			case "Staff": {
				TeacherChoice tChoice = new TeacherChoice();
				tChoice.choiceForTeacher();
				break;
			} // case 2 close
			case "Student": {
				StudentChoice sChoice = new StudentChoice();
				sChoice.choiceForStudent();
				break;
			} // case 3 close
			default:
				System.out.println("Invalid Choice..!!");
			}// outer switch case close

			System.out.println("***********************************************************************************************************");
		} // for close
		System.out.println("session expired..!!");
	}// main close
}// class close

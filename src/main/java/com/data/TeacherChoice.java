package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherChoice {

	public static String filePathStudent = "C:\\Users\\sejal.purohit\\Desktop\\Students.xlsx";
	public void choiceForTeacher() throws IOException, ClassNotFoundException, SQLException {

		ExcelRead sRead = new ExcelRead();
		List<Students> sDetails = sRead.readFromExcel(filePathStudent);

		System.out.println("Welcom to Staff Portal\nVerifying User...");
		ReadLoginChoice loginChoice = new ReadLoginChoice();
		String filePathLogin = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";
		List<LoginChoice> list = loginChoice.readLoginChoice(filePathLogin);

		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getChoice().equalsIgnoreCase("staff")) {
				JDBC jdbc = new JDBC();
				TeacherJDBC t = new TeacherJDBC();

				try {
					int credential = t.verification((String) list.get(j).getUserName(),
							(String) list.get(j).getPassword());
					if (credential == 1) {
						System.out.println("Verification Sucessful.\nService:-Add Student" + "\nDelete Student"
								+ "\nDelete all students");
						for (int index = 0; index < sDetails.size(); index++) {

							switch (sDetails.get(index).getAction().toLowerCase()) {
							case "add": {
								System.out.println("Choice:-Add Student");
								ExcelRead read = new ExcelRead();
								List<Students> details = read.readFromExcel(filePathStudent);
								Calculation calculate = new Calculation();
								for (Object obj : details) {
									calculate.total(obj);
									try {
										jdbc.store(obj);
									} catch (Exception e) {
										e.getMessage();
									}
								}
								break;
							}
							case "delete": {
								System.out.println("Choice:-Delete By Id");
								jdbc.deleteSpecificStudent((int) sDetails.get(index).getId());
								break;
							}
							case "delete all": {
								System.out.println("Choice:-Delete All Student");
								jdbc.deleteAllStudent();
								break;
							}
							default:
								System.out.println("Invalid Choice for Staff");
							}// inner switch case close*/
						} // for close
					} // if close
					else {
						System.out.println("Invalid Staff credentials");
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
			//}//outer if close
			//continue;
		} // for close

	}

}

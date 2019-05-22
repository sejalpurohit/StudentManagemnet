package com.data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentChoice {

	public void choiceForStudent() throws SQLException, IOException {

		String filePathStudent = "C:\\Users\\sejal.purohit\\Desktop\\Students.xlsx";
		ExcelRead sRead = new ExcelRead();
		List<Students> sDetails = sRead.readFromExcel(filePathStudent);
		System.out.println("Welcome to Students Portal\nStudent" + "Service:-" + "\n1)View All"
				+ "\n2)View Student by Id");
		JDBC jdbc = new JDBC();
		for (int index = 0; index < sDetails.size(); index++) {
			try {
			switch (sDetails.get(index).getAction().toLowerCase()) {
			case "view": {
				System.out.println("Choice:- View");
				Students students =jdbc.getSpecificStudent((int) sDetails.get(index).getId());
				System.out.println("Student Id  :"+(int)students.getId());
				System.out.println("Name        :"+students.getName());
				System.out.println("Contact     :"+(long)students.getContact());
				System.out.println("Email       :"+students.getEmail());
				System.out.println("      Marks :-");
				System.out.println("Physics     :"+students.getPhysics());
				System.out.println("Chemistry   :"+students.getChemistry());
				System.out.println("Maths       :"+students.getMaths());
				System.out.println("Biology     :"+students.getBiology());
				System.out.println("Total       :"+students.getTotal());
				System.out.println("Percentage  :"+students.getPercentage());
				System.out.println("Percentage  :"+students.getGrade());
				break;
			}
			case "view all": {
				System.out.println("Choice:-View All");
				List<Students> students = jdbc.getAllStudents();
				for(int i=0 ;i<students.size();i++) {
					System.out.println("\n");
					System.out.println("Student Id  :"+(int)students.get(i).getId());
					System.out.println("Name        :"+students.get(i).getName());
					System.out.println("Contact     :"+(long)students.get(i).getContact());
					System.out.println("Email       :"+students.get(i).getEmail());
					System.out.println("      Marks :-");
					System.out.println("Physics     :"+students.get(i).getPhysics());
					System.out.println("Chemistry   :"+students.get(i).getChemistry());
					System.out.println("Maths       :"+students.get(i).getMaths());
					System.out.println("Biology     :"+students.get(i).getBiology());
					System.out.println("Total       :"+students.get(i).getTotal());
					System.out.println("Percentage  :"+students.get(i).getPercentage());
					System.out.println("Grade  :"+students.get(i).getGrade());
				}//inner for close
				break;
			}
			default:
				System.out.println("invalid Choice for Students");
			}//case close
			}catch(NullPointerException e) {
				System.out.println("Action Cant be Null");
				
			
			
			}//switch case close
		}//for close;
	}//method close
}//class close

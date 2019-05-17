package com.data;

import java.sql.SQLException;

public class Calculation {
	String grade;
	
	JDBC jdbc = new JDBC();
	
	public void total(Students student) throws SQLException {
		double total;
		total = student.getPhysics() + student.getMaths() + student.getChemistry() +student.getBiology() ;
		percentage(total,student);
		student.setTotal(total);
		
		}
	
	public void  percentage(double total,Students student) throws SQLException {
		
		double percentage = (total/400)*100;
		grade((int)percentage, student);
		
		student.setPercentage(percentage);
			
	}
	
	public void grade(int percentage, Students student) throws SQLException {
		
		if (percentage >= 90)
		{
			String grade = "A";
			student.setGrade(grade);
			
		}
		else if (percentage < 90 && percentage >= 75)
		{
			String grade ="B";
			student.setGrade(grade);
		}
		else if (percentage < 75 && percentage >= 60)
		{
			 String grade = "C";
			 student.setGrade(grade);
		}
		else if (percentage < 60 && percentage >= 50)
		{
			String grade = "D";
			student.setGrade(grade);
		}
		else if (percentage < 60 && percentage >= 33)
		{
			String grade = "E";
			student.setGrade(grade);
		}
		else
		{
			String grade = "F";
			student.setGrade(grade);
		}
	
	}
	
	
	
}

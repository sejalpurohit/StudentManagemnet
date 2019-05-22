package com.data;

import java.sql.SQLException;

public class Calculation {
	String grade;
	
	JDBC jdbc = new JDBC();
	
	
	
	
	public void total(Object obj)
	{
		double total;
		total = ((Students) obj).getPhysics() + ((Students) obj).getMaths() + ((Students) obj).getChemistry() +((Students) obj).getBiology() ;
		 {
		System.out.println("Marks cannot be more then 100");}
		percentage(total,obj);
		((Students) obj).setTotal(total);
		
		
	}
	
	public void  percentage(double total,Object obj){
		
		double percentage = (total/400)*100;
		try {
		grade((int)percentage, obj);
		}catch(SQLException e) {
			e.getMessage();
		}
		((Students) obj).setPercentage(percentage);
				}
	public void grade(int percentage, Object obj) throws SQLException {
		
		if (percentage >= 90)
		{
			String grade = "A";
			((Students) obj).setGrade(grade);
			
		}
		else if (percentage < 90 && percentage >= 75)
		{
			String grade ="B";
			((Students) obj).setGrade(grade);
		}
		else if (percentage < 75 && percentage >= 60)
		{
			 String grade = "C";
			 ((Students) obj).setGrade(grade);
		}
		else if (percentage < 60 && percentage >= 50)
		{
			String grade = "D";
			((Students) obj).setGrade(grade);
		}
		else if (percentage < 60 && percentage >= 33)
		{
			String grade = "E";
			((Students) obj).setGrade(grade);
		}
		else
		{
			String grade = "F";
			((Students) obj).setGrade(grade);
		}
	
	}
	
	
	
}

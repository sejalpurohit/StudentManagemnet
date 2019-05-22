package com.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
	Connection connect;

	public JDBC() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void store(Object obj) throws SQLException {
		String sql = "insert into StudentDetails value (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);

		preparedStatement.setInt(1, (int) ((Students) obj).getId());
		preparedStatement.setString(2, ((Students) obj).getName());
		preparedStatement.setInt(3,(int) ((Students) obj).getContact());
		preparedStatement.setString(4,((Students) obj).getEmail());
		preparedStatement.setInt(5, (int) ((Students) obj).getPhysics());
		preparedStatement.setInt(6, (int) ((Students) obj).getChemistry());
		preparedStatement.setInt(7, (int) ((Students) obj).getMaths());
		preparedStatement.setInt(8, (int) ((Students) obj).getBiology());
		preparedStatement.setInt(9, (int) ((Students) obj).getTotal());
		preparedStatement.setInt(10, (int) ((Students) obj).getPercentage());
		preparedStatement.setString(11, ((Students) obj).getGrade());

		preparedStatement.executeUpdate();
		System.out.println("Students data Inserted Successfully");
	}

	public void deleteAllStudent() throws SQLException {
		String sql = "DELETE FROM StudentDetails";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		preparedStatement.executeUpdate(sql);
		System.out.println("Student Table Data Delete...!!!");
	}

	public void deleteSpecificStudent(int id) throws SQLException {
		String sql = "delete from StudentDetails where ID =?";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("Student Id -"+id+" Deleted");
	}
	public Students getSpecificStudent(int id) throws SQLException
	{
		Students student = new Students();
		String sql ="select * from StudentDetails where id = "+id;
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			 if(resultSet.next()) {
				 student.setId(resultSet.getInt(1));
				 student.setName(resultSet.getString(2));
				 student.setContact(resultSet.getInt(3));
				 student.setEmail(resultSet.getString(4));
				 student.setPhysics(resultSet.getInt(5));
				 student.setChemistry(resultSet.getInt(6));
				 student.setMaths(resultSet.getInt(7));
				 student.setBiology(resultSet.getInt(8));
				 student.setTotal(resultSet.getInt(9));
				 student.setPercentage(resultSet.getInt(10));
				 student.setGrade(resultSet.getString(11));
			 }
			 System.out.println("Student Details for id ="+id);
		 	return student;
	 }
	
	public List<Students> getAllStudents() throws SQLException{
		 List<Students> studentList = new ArrayList<>();
		 String sql = "select * from  StudentDetails";
			 Statement statement = connect.createStatement();
			 ResultSet resultSet = statement.executeQuery(sql);
			 while(resultSet.next()) {
				 Students student = new Students();
				 student.setId(resultSet.getInt(1));
				 student.setName(resultSet.getString(2));
				 student.setContact(resultSet.getInt(3));
				 student.setEmail(resultSet.getString(4));
				 student.setPhysics(resultSet.getInt(5));
				 student.setChemistry(resultSet.getInt(6));
				 student.setMaths(resultSet.getInt(7));
				 student.setBiology(resultSet.getInt(8));
				 student.setTotal(resultSet.getInt(9));
				 student.setPercentage(resultSet.getInt(10));
				 student.setGrade(resultSet.getString(11));
				 studentList.add(student);
			 }
			 System.out.println("All Student list :-");
			 	return studentList;
	 }
}

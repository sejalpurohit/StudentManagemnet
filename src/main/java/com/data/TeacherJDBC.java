package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TeacherJDBC {
	Connection connect;
	
	public TeacherJDBC() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "");
	}

	public void AddTeacher(Teachers teacher) throws SQLException {
			String sql = "insert into TeachersLogin value (?,?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, (int)teacher.getTid());
			preparedStatement.setString(2, teacher.getName());
			preparedStatement.setString(3, teacher.getUsername());
			preparedStatement.setString(4, teacher.getPassword());
			preparedStatement.executeUpdate();
			System.out.println("List of Student added to Database from excel sheet");
	}
	public List<Teachers> getTeachers() throws SQLException{
		 List<Teachers> teacherList = new ArrayList<>();
		 String sql = "select * from  TeachersLogin";
			 Statement statement = connect.createStatement();
			 ResultSet resultSet = statement.executeQuery(sql);
			 while(resultSet.next()) {
				 Teachers teacher = new Teachers();
				 teacher.setTid(resultSet.getInt(1));
				 teacher.setName(resultSet.getString(2));
				 teacher.setUsername(resultSet.getString(3)); 
				 teacher.setUsername(resultSet.getString(3));
				 teacherList.add(teacher);
			 }
			 	return teacherList;
	 }
	public void deleteTeachers() throws SQLException {			
		String sql = "DELETE FROM TeachersLogin";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		preparedStatement.executeUpdate(sql);
		System.out.println("Deleted");
	}
	public void deleteSpecificTeacher(int tid) throws SQLException {
		String sql = "delete from  TeachersLogin where TID =?";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		preparedStatement.setInt(1,tid);
			preparedStatement.executeUpdate();
			System.out.println("deleted "+tid);
	}
	public int verification(String userName , String password) throws SQLException
	{
		String sql = "select * from TeachersLogin ";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			if(userName.equals(resultSet.getString(3)) && password.equals(resultSet.getString(4))){
				return 1;
			}			
		}
		return 0;
	}
}

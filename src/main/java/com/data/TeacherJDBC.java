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
	public TeacherJDBC() {
		try {

		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
	}
	public void AddTeacher(Object obj) throws SQLException {
		
			String sql = "insert into TeachersLogin value (?,?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setInt(1, (int) ((Teachers) obj).getTid());
			preparedStatement.setString(2, ((Teachers) obj).getName());
			preparedStatement.setString(3, ((Teachers) obj).getUsername());
			preparedStatement.setString(4, ((Teachers) obj).getPassword());
			preparedStatement.executeUpdate();
			
		
	}
	public List<Teachers> getTeachers() throws SQLException {
		List<Teachers> teacherList = new ArrayList<>();
		String sql = "select * from  TeachersLogin";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Teachers teacher = new Teachers();
			teacher.setTid(resultSet.getInt(1));
			teacher.setName(resultSet.getString(2));
			teacher.setUsername(resultSet.getString(3));
			teacher.setPassword(resultSet.getString(4));
			teacherList.add(teacher);
		}
		return teacherList;
	}
	public void deleteTeachers() {
		String sql = "DELETE FROM TeachersLogin";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			System.out.println("Deleted Staff data");
		} catch (SQLException s) {
			s.getMessage();

		}
	}
	public void deleteSpecificTeacher(int tid) {
		try {
		String sql = "delete from  TeachersLogin where TID =?";
		PreparedStatement preparedStatement = connect.prepareStatement(sql);
		preparedStatement.setInt(1, tid);
		preparedStatement.executeUpdate();
		System.out.println("deleted Staff with id =" + tid);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	public int verification(String userName, String password) throws SQLException {
		String sql = "select * from TeachersLogin ";
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			if (userName.equals(resultSet.getString(3)) && password.equals(resultSet.getString(4))) {
				return 1;
			}
		}
		return 0;
	}
}

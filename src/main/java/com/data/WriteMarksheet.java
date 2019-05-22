package com.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteMarksheet {
	Connection connect;

	public void getMarks() {

		String path = "C:\\Users\\sejal.purohit\\Desktop\\Write.xlsx";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
		}

		try {
			String sql = "select * from studentdetails";
			Statement statement;
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet("Marksheet");
			XSSFRow row = spreadsheet.createRow(0);
			XSSFCell cell;
//generate header
			cell = row.createCell(0);
			cell.setCellValue("Id");
			cell = row.createCell(1);
			cell.setCellValue("Name");
			cell = row.createCell(2);
			cell.setCellValue("Contact");
			cell = row.createCell(3);
			cell.setCellValue("Email");
			cell = row.createCell(4);
			cell.setCellValue("Physics");
			cell = row.createCell(5);
			cell.setCellValue("Chemistry");
			cell = row.createCell(6);
			cell.setCellValue("Maths");
			cell = row.createCell(7);
			cell.setCellValue("Biology");
			cell = row.createCell(8);
			cell.setCellValue("Total");
			cell = row.createCell(9);
			cell.setCellValue("Percentage");
			cell = row.createCell(10);
			cell.setCellValue("Grade");
			
			int i = 1;
			while (resultSet.next()) {
			row = spreadsheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue(resultSet.getInt("ID"));
			cell = row.createCell(1);
			cell.setCellValue(resultSet.getString("NAME"));
			cell = row.createCell(2);
			cell.setCellValue(resultSet.getInt("CONTACT"));
			cell = row.createCell(3);
			cell.setCellValue(resultSet.getString("EMAIL"));
			cell = row.createCell(4);
			cell.setCellValue(resultSet.getInt("PHYSICS"));
			cell = row.createCell(5);
			cell.setCellValue(resultSet.getInt("CHEMISTRY"));
			cell = row.createCell(6);
			cell.setCellValue(resultSet.getInt("MATHS"));
			cell = row.createCell(7);
			cell.setCellValue(resultSet.getInt("BIOLOGY"));
			cell = row.createCell(8);
			cell.setCellValue(resultSet.getInt("TOTAL"));
			cell = row.createCell(9);
			cell.setCellValue(resultSet.getInt("PERCENTAGE"));
			cell = row.createCell(10);
			cell.setCellValue(resultSet.getString("GRADE"));
			cell = row.createCell(11);
			i++;
			}
			

			FileOutputStream output = new FileOutputStream(path);
			workbook.write(output);
			System.out.println("Data Written Successfully");
			workbook.close();
			output.close();

		
		} catch (SQLException |IOException e) {
		System.out.println("Could not write Data");
		}

	}
}

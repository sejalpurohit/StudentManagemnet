package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTeacherExcel {
	

	public List<Teachers> readExcel(String filePath) throws IOException, ClassNotFoundException, SQLException {
		List<Teachers> teachersLogin = new ArrayList<>();
		FileInputStream fileInput = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or
			}
			Iterator<Cell> cellIterator = row.cellIterator();
			Teachers teacher = new Teachers();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int cellCount = cell.getColumnIndex();
				
				switch(cellCount)
				{
				case 0:
					teacher.setTid((double) getCellValue(cell));
					break;
				case 1:
					teacher.setName((String) getCellValue(cell));
					break;
				case 2:
					teacher.setUsername((String) getCellValue(cell));
					break;
				case 3:
					teacher.setPassword((String) getCellValue(cell));
					break;
				case 4:
					teacher.setAction((String) getCellValue(cell));
					break;
				default:
					break;
				}
			}
			teachersLogin.add(teacher);
			//TeacherJDBC teacherJDBC = new TeacherJDBC();
			//teacherJDBC.AddTeacher(teacher);
		}
		fileInput.close();
		workbook.close();
		return teachersLogin;
	}
	private Object getCellValue(Cell cell) {
		switch(cell.getCellType()) {
		case STRING :
			return cell.getStringCellValue();
		
		case NUMERIC:
			return cell.getNumericCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			break;
		}
		return null;
	}
}

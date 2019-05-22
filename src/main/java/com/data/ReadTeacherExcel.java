package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTeacherExcel {
	

	public List<Teachers> readExcel(String filePath) throws IOException {
		List<Teachers> teachersLogin = new ArrayList<>();
		FileInputStream fileInput = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue; //Skip row =0
			}
			Iterator<Cell> cellIterator = row.cellIterator();
			Teachers teacher = new Teachers();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int cellCount = cell.getColumnIndex();
				
				switch(cellCount)
				{
				case 0:
					try {
					teacher.setTid((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Id can be Integer value only");
				}
					break;
				case 1:
					try {
					teacher.setName((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Name can be String value only");
				}
					break;
				case 2:try {
					teacher.setUsername((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Username can be String value only");
				}
					break;
				case 3:try {
					teacher.setPassword((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Password can be String value only");
				}
					break;
				case 4:try {
					teacher.setAction((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Action can be String value only");
				}
					break;
				default:
					break;
				}
			}
			teachersLogin.add(teacher);
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

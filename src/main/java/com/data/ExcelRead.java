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

public class ExcelRead {

	public List<Students> readFromExcel(String filePath) throws IOException, SQLException {
		List<Students> details = new ArrayList<>();

		FileInputStream fileInput = new FileInputStream(new File(filePath));

		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.rowIterator();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			
			if (row.getRowNum() == 0) {
				continue; //Skip row =0
			}
			Students student = new Students();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int column = cell.getColumnIndex();
				switch (column) {
				case 0:
					try {
					student.setId((double) getCellValue(cell));
					}catch(NullPointerException |ClassCastException e) {
						System.out.println("Id can be Integer value only ");
					}
					break;
				case 1:
					try {
					student.setName((String) getCellValue(cell));
					}catch(ClassCastException e) {
						System.out.println("Name can be String Only");
						
					}
					break;
				case 2:
					try {
					student.setContact((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Contact can be Integer value  only");
				}
					break;
				case 3:
					try {
					student.setEmail((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Email can be string value  Only");
				}
					break;
				case 4:
					try {
						
					student.setPhysics((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Physics Marks can be Integer value Only");
				}
					break;
				case 5:
					try {
					student.setChemistry((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Chemistry Marks can be Integer value Only");
				}
					break;
				case 6:
					try {
					student.setMaths((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Maths Marks can be Integer value Only");
				}
					break;
				case 7:
					try {
					student.setBiology((double) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Biology Marks can be Integer value Only");
				}
					break;
				case 8:
					try {
					student.setAction((String) getCellValue(cell));
				}catch(NullPointerException |ClassCastException e) {
					System.out.println("Action can be In String value only");
				}
					break;
				}
			}
			if(student.getPhysics()>100 || student.getChemistry()>100 || student.getMaths()>100 ||student.getBiology()>100)
			{
				System.out.println("Marks can not be greater then 100"
						+ "\n==========================================================================================================");
				
			}
			else 
			{
			details.add(student);
			}
		}
		workbook.close();
		fileInput.close();

		return details;
	}
	public Object getCellValue(Cell cell) {

		switch (cell.getCellType()) {
		case STRING:
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

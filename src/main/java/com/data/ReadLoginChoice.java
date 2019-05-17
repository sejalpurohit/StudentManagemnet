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

public class ReadLoginChoice {
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

	public List<LoginChoice> readLoginChoice(String filePath) throws IOException, SQLException {
		List<LoginChoice> choiceList = new ArrayList<>();

		FileInputStream fileInput = new FileInputStream(new File(filePath));

		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or
			}
			Iterator<Cell> cellIterator = row.cellIterator();
			LoginChoice choice = new LoginChoice();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int column = cell.getColumnIndex();
				switch (column) {
				case 0:
					choice.setChoice((String) getCellValue(cell));
					break;
				case 1:
					choice.setUserName((String) getCellValue(cell));
					break;
				case 2:
					choice.setPassword((String) getCellValue(cell));
					break;
				}
				
			}
			choiceList.add(choice);
		}
		
		//workbook.close();
		fileInput.close();
		return choiceList;
	}



}

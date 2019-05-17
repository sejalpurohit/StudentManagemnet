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

	JDBC jdbc = new JDBC();

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
				continue; // just skip the rows if row number is 0 or
			}
			Students student = new Students();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int column = cell.getColumnIndex();
				switch (column) {
				case 0:
					student.setId((double) getCellValue(cell));
					break;
				case 1:
					student.setName((String) getCellValue(cell));
					break;
				case 2:
					student.setContact((double) getCellValue(cell));
					break;
				case 3:
					student.setEmail((String) getCellValue(cell));
					break;
				case 4:
					student.setPhysics((double) getCellValue(cell));
					break;
				case 5:
					student.setChemistry((double) getCellValue(cell));
					break;
				case 6:
					student.setMaths((double) getCellValue(cell));
					break;
				case 7:
					student.setBiology((double) getCellValue(cell));
					break;
				}
			}
			details.add(student);
			Calculation calculate = new Calculation();
			calculate.total(student);
			jdbc.store(student);
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

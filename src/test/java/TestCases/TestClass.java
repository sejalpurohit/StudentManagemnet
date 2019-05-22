package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.data.AdminChoice;
import com.data.Calculation;
import com.data.MainClass;
import com.data.Students;
import com.data.TeacherChoice;

public class TestClass {

	/*@Test
	public void testPath() {
		String filePath = "C:\\Users\\sejal.purohit\\Desktop\\Teacher.xlsx";
		Assert.assertEquals(AdminChoice.filePathTeacher, filePath);
	}

	@Test
	public void testStudentPath() {
		String filePath = "C:\\Users\\sejal.purohit\\Desktop\\Students.xlsx";
		Assert.assertEquals(TeacherChoice.filePathStudent, filePath);
	}

	@Test
	public void testLoginPath() {
		String path = "C:\\Users\\sejal.purohit\\Desktop\\LoginChoice.xlsx";
		Assert.assertEquals(MainClass.filePath, path);
	}
	
	
	/*@Test
	public void testTotal() {
		Students students = new Students();
		students.setPhysics(99);
		students.setChemistry(88);
		students.setMaths(77);
		students.setBiology(66);
		
		Calculation calculation = new Calculation();
		Assert.assertEquals(calculation.total(students),330);
		Assert.assertEquals(calculation.percentage(calculation.total(students),students), 82);
	}*/
}
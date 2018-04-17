package generics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Lib implements IAutoConstant{
	
	static Workbook wb;
	public static String getCellValue(String sheetName, int rowNum, int columnNum){
		String cellValue="";
		try {
			 wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE));
		cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).toString();
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getRowCount(String sheetName){
		int rowCount=0;
		try {
			 wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE));
		rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}
	
	public static String getPropertyValue(String propertyName){
		String propertyValue="";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FILE));
			propertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {
		}
		return propertyValue;
	}
	
	public static void takeScreenshot(WebDriver driver, String testMethodName){
		try {
			Date d = new Date();
			String currentDate = d.toString().replaceAll(":", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/"+testMethodName+"_"+currentDate+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			
		}
	}
}

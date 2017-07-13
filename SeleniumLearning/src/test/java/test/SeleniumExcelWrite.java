package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.os.WindowsUtils;

public class SeleniumExcelWrite {
public static void main(String[] args) throws Exception {
	try {
		WindowsUtils.killByName("firefox.exe");
		System.out.println("closed successfully");
	} catch (org.openqa.selenium.os.WindowsRegistryException ignored) {
		System.out.println("no browser opened");
	}
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver	bb = new FirefoxDriver(fb,ffp);
	bb.get("https://www.bigbasket.com/choose-city/?next=/");
	/*bb.findElement(By.id("city-select")).sendKeys("Ban");
	Thread.sleep(1000);
	//bb.findElement(By.id("city-select")).click();
	WebElement autoComplete = bb.findElement(By.id("ui-id-2"));
	List<WebElement> selectCity = autoComplete.findElements(By.tagName("li"));
	WebElement city = null;
	for (WebElement temp : selectCity) {
		System.out.println(temp.getText());
		
		 if(temp.getText().equals("Bangalore")){
			 city  = temp;
		 }
	}
	city.click();*/
	
	//bb.quit();
	bb.findElement(By.id("city-select")).click();
	WebElement autoComplete = bb.findElement(By.id("ui-id-2"));
	List<WebElement> selectCity = autoComplete.findElements(By.tagName("li"));
	 int noOfcity = selectCity.size();
	 System.out.println(noOfcity);
	
	File file = new File("D:\\Big.xlsx");
	
	
	
	FileInputStream fis = new FileInputStream(file);

	XSSFWorkbook wb = new XSSFWorkbook(fis);

	XSSFSheet sheet = wb.getSheet("Sheet2");
	for (int i = 0; i < noOfcity; i++) {
		WebElement cityList = selectCity.get(i);
		XSSFRow row = sheet.createRow(i);
		XSSFCell cell = row.createCell(2);
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(cityList.getText());

	}
	
	
fis.close();
bb.close();
FileOutputStream fos=new FileOutputStream(file);
fos.flush();
wb.write(fos);
fos.close();
System.out.println("Excel File Written");
}
}

package dts;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;



public class Approval {
public static void main(String[] args) throws Exception {
	try{
		WindowsUtils.killByName("firefox.exe");
		System.out.println("Browser closed");
	}catch(org.openqa.selenium.os.WindowsRegistryException ignored){
		System.out.println("No browser opened");
	}
	
	WebDriver ap = new FirefoxDriver();
	ap.manage().window().maximize();
	ap.get("http://58.68.10.77/SSO/login?service=http%3A%2F%2F58.68.10.77%2FPTE%2Fjsp%2Fmain.jsp");
	ap.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	File files = new File("E:\\Anandh\\New folder\\SeleniumLearning\\src\\test\\resources\\Employee.xlsx");
	FileInputStream fis = new FileInputStream(files);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Sheet3");
	int lastRowNum = sheet.getLastRowNum();
	for(int i=1;i<=lastRowNum;){
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(0);
		String usr = cell.getStringCellValue();
		XSSFCell pwdCell = row.getCell(1);
		String pwd = pwdCell.getStringCellValue();
	ap.findElement(By.id("username")).sendKeys(usr);
	ap.findElement(By.id("password")).sendKeys(pwd);
	break;
	}
	ap.findElement(By.cssSelector(".imageButton")).click();
	//ap.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(3) > td > div > div.errorMessage > p:nth-child(10) > a")).click();
    ap.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(1)")).click();
   // #leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(3)
    ap.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(3)")).click();
    
}
}

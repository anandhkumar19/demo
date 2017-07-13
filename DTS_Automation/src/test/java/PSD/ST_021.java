package PSD;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ST_021 {
public static void main(String[] args) throws Exception {
	WebDriver psd = new FirefoxDriver();
	psd.get("http://58.68.10.76:8087/PSD/jsp/main.jsp");
	    
	    psd.manage().window().maximize();
	    psd.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
	    File files = new File("E:\\Anandh\\New folder\\DTS\\src\\test\\resources\\PSD.xlsx");
		FileInputStream fis = new FileInputStream(files);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("total rows"+lastRowNum);
		for(int i=0;i<=lastRowNum;){
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell cell = row.getCell(0);
			String usr = cell.getStringCellValue();
			XSSFCell pwdCell = row.getCell(1);
			String pwd = pwdCell.getStringCellValue();
		psd.findElement(By.id("username")).sendKeys(usr);
		psd.findElement(By.id("password")).sendKeys(pwd);
		break;
		}
		psd.findElement(By.cssSelector(".imageButton")).click();
		psd.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).click();
		psd.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1)")).click();
		
		
		
		psd.findElement(By.cssSelector("div.null_even:nth-child(10) > a:nth-child(4) > img:nth-child(1)")).click();
		String FrMonth = "June", ToMonth="June";
		int Fryear = 2017, ToYr=2017;
        int Frday = 11, Today=12;
        psd.findElement(By.name("MonthSelector")).sendKeys(FrMonth);
        psd.findElement(By.name("YearSelector")).sendKeys(Fryear+"");
        psd.findElement(By.id("c"+Frday)).click();
        psd.findElement(By.cssSelector("div.null_odd:nth-child(11) > a:nth-child(4) > img:nth-child(1)")).click();
        psd.findElement(By.name("MonthSelector")).sendKeys(ToMonth);
        psd.findElement(By.name("YearSelector")).sendKeys(ToYr+"");
        psd.findElement(By.id("c"+Today)).click();
        psd.findElement(By.cssSelector(".searchButtonAudit")).click();
      //audits
      		WebElement aduitTable = psd.findElement(By.id("auditTableId"));
      		while (aduitTable.isDisplayed()==false) {
      			System.out.println("Table not displyed");
      		}
      		
		psd.findElement(By.cssSelector(".export")).click();
		Thread.sleep(45000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
}
}

package MCR;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_014 {
public static void main(String[] args) throws Exception {
	WebDriver mcr = new FirefoxDriver();
	mcr.manage().window().maximize();
	mcr.get("http://58.68.10.76:8094/MCR/");
	mcr.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(mcr, 25);
	File files = new File("E:\\Anandh\\New folder\\DTS\\src\\test\\resources\\MCR.xlsx");
	FileInputStream fis = new FileInputStream(files);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("ChargeExp");
	int lastRowNum = sheet.getLastRowNum();
	System.out.println("total rows"+lastRowNum);
	for(int i=1;i<=lastRowNum;){
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(0);
		String usr = cell.getStringCellValue();
		XSSFCell pwdCell = row.getCell(1);
		String pwd = pwdCell.getStringCellValue();
	mcr.findElement(By.id("username")).sendKeys(usr);
	mcr.findElement(By.id("password")).sendKeys(pwd);
	break;
	}
	mcr.findElement(By.cssSelector(".imageButton")).click();
	mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(1)")).click();
	mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(2)")).click();
	for(int i=2;i<=lastRowNum;i++){
		mcr.findElement(By.xpath("//div[@id='spanaccount.id']/span[3]")).click();
		
		XSSFRow accrow =sheet.getRow(i);
		XSSFCell acccell = accrow.getCell(2);
		int accountId = (int) acccell.getNumericCellValue();
		WebElement iframe1 = mcr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
		mcr.switchTo().frame(iframe1);
		mcr.findElement(By.id("search")).sendKeys(accountId+"");
		Thread.sleep(7000);
		mcr.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
		mcr.switchTo().parentFrame();
		mcr.findElement(By.id("submitButton")).click();
		WebElement NoOfRe = mcr.findElement(By.id("pageCount"));
		wait.until(ExpectedConditions.visibilityOf(NoOfRe));
		System.out.println("No of transaction for account_id:"+accountId+"is :"+NoOfRe.getText());
	}
	
}
}

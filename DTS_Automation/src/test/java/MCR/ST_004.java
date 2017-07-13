package MCR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_004 {
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
	//System.out.println("total rows"+lastRowNum);
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
	mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
	mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")).click();
	XSSFSheet sheet2 = wb.getSheet("Ratesheet");
	int lastRowNum2 = sheet2.getLastRowNum();
	for(int i =0;i<=lastRowNum2;i++){
	mcr.findElement(By.id("addNewEntityButton")).click();
	XSSFRow row = sheet2.getRow(i);
	XSSFCell namecell = row.getCell(0);
	String name = namecell.getStringCellValue();
	mcr.findElement(By.id("name")).sendKeys(name);
	XSSFCell chargingMetcell = row.getCell(1);
	String chargingMe = chargingMetcell.getStringCellValue();
	mcr.findElement(By.id("GraduatedTier")).sendKeys(chargingMe);
	XSSFCell desccell = row.getCell(2);
	String description = desccell.getStringCellValue();
	mcr.findElement(By.id("description")).sendKeys(description);
	mcr.findElement(By.id("initialButton")).click();
	mcr.findElement(By.cssSelector("#ers__0 > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > i:nth-child(2)")).click();
	XSSFCell monthccell = row.getCell(3);
	String fromMonth =monthccell.getStringCellValue();
	mcr.findElement(By.name("MonthSelector")).sendKeys(fromMonth);
	XSSFCell fromYeacell = row.getCell(4);
	int fromyr =(int)fromYeacell.getNumericCellValue();
	mcr.findElement(By.name("YearSelector")).sendKeys(fromyr+"");
	XSSFCell fromdccell = row.getCell(5);
	int fromdate =(int)fromdccell.getNumericCellValue();
	mcr.findElement(By.id("c"+fromdate)).click();
	mcr.findElement(By.cssSelector("#ers__0 > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > i:nth-child(2)")).click();
	XSSFCell tomonthccell = row.getCell(6);
	String toMonth =tomonthccell.getStringCellValue();
	mcr.findElement(By.name("MonthSelector")).sendKeys(toMonth);
	XSSFCell toYeacell = row.getCell(7);
	int toyr =(int)toYeacell.getNumericCellValue();
	System.out.println("toyr"+toyr);
	Thread.sleep(3000);
	WebElement ToYear = mcr.findElement(By.name("YearSelector"));
	if(ToYear.isDisplayed()){
		System.out.println("Year is visible");
	}
	else
        System.out.println("Year not vissible");
	Select efyear = new Select(ToYear);
	efyear.selectByValue(toyr+"");
	XSSFCell todccell = row.getCell(8);
	int todate =(int)todccell.getNumericCellValue();
	mcr.findElement(By.id("c"+todate)).click();
	XSSFCell fixedratecell = row.getCell(9);
	int fixedrate =(int)fixedratecell.getNumericCellValue();
	mcr.findElement(By.id("seh__0fixedRate")).sendKeys(fixedrate+"");
	mcr.findElement(By.id("sdu___7ers__0seo__0")).click();
	XSSFCell unitChrcell = row.getCell(10);
	float unitChr =(float)unitChrcell.getNumericCellValue();
	mcr.findElement(By.id("sdu___4")).sendKeys(unitChr+"");
	mcr.findElement(By.id("saveButton")).click();
	}
}


}

package PSD;

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

public class ST_009 {
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
    WebDriverWait wait=new WebDriverWait(psd, 15);
    psd.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
    psd.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")).click();
    for(int i=1;i<=lastRowNum;i++){
    psd.findElement(By.id("addButton")).click();
    WebElement userAccessDialogBox = psd.findElement(By.id("userAccessDialogBox_content"));
    psd.switchTo().frame(userAccessDialogBox);
    psd.findElement(By.xpath("//div[@id='spanemployee.id']/img")).click();
    /*//div[@id='spanrole.id']/img*/
    XSSFRow row = sheet.getRow(i);
	XSSFCell cell = row.getCell(0);
	String empName = cell.getStringCellValue();
	WebElement employeeFrame = psd.findElement(By.id("modelWindowLov_content"));
	psd.switchTo().frame(employeeFrame);
	psd.findElement(By.id("search")).sendKeys(empName);
	psd.findElement(By.id("magnifyImg")).click();
	Thread.sleep(7000);
	psd.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(1) > div:nth-child(1)")).click();
	psd.switchTo().parentFrame();
	XSSFCell usercell = row.getCell(1);
	String user = usercell.getStringCellValue();
	psd.findElement(By.id("userName")).clear();
	psd.findElement(By.id("userName")).sendKeys(user);

	psd.findElement(By.xpath("//div[@id='spanrole.id']/img")).click();
	WebElement roleframe = psd.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	XSSFCell rolecell = row.getCell(2);
	String role = rolecell.getStringCellValue();
	psd.switchTo().frame(roleframe);
	psd.findElement(By.id("search")).sendKeys(role);
	Thread.sleep(9000);
	
	psd.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
	psd.switchTo().parentFrame();
	Thread.sleep(4000);
	psd.findElement(By.cssSelector("#container > img:nth-child(8)")).click();
	
	WebElement successMSG = psd.findElement(By.cssSelector("#container > pre:nth-child(5)"));
	
	System.out.println(successMSG.getText());
	Thread.sleep(6000);
	


WebElement submit = psd.findElement(By.cssSelector("#container > div:nth-child(3) > img:nth-child(7)"));

submit .click();
	psd.switchTo().parentFrame();
Thread.sleep(80000);
    }   
    
    
}
}

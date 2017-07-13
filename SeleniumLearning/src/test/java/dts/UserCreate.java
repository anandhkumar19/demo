package dts;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.interactions.Actions;


public class UserCreate {
public void userCreation(WebDriver usr) throws Exception{
	//public static void main(String[] args) throws Exception {
		
	
	String MDFwndow = usr.getWindowHandle();
	System.out.println("MDF window :"+MDFwndow);
	usr.findElement(By.cssSelector("#psd > span:nth-child(1) > a:nth-child(1)")).click();
	Set<String> newWindow = usr.getWindowHandles();
	for (String string : newWindow) {
		System.out.println("All window key:"+string);
	}//
	String PSDWindow ="";
	for (String temp : newWindow) {
		if(temp.equals(MDFwndow)==false){
			PSDWindow = temp;
			System.out.println("PSD Win"+PSDWindow);
		}
	}
	usr.switchTo().window(PSDWindow);
		/*File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary fb = new FirefoxBinary(pathToBinary);
		FirefoxProfile ffp = new FirefoxProfile();
		WebDriver	usr = new FirefoxDriver(fb,ffp);
		usr.get("http://58.68.10.76:8087/PSD");
		usr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		usr.findElement(By.id("username")).sendKeys("rdas");
		usr.findElement(By.id("password")).sendKeys("Daemon@76");
		usr.findElement(By.cssSelector(".imageButton")).click();*/
		//
	usr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)")).click();
	usr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")).click();
	File files = new File("E:\\Anandh\\New folder\\SeleniumLearning\\src\\test\\resources\\Employee.xlsx");
	FileInputStream fis = new FileInputStream(files);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Sheet4");
	int lastRowNum = sheet.getLastRowNum();
	for(int i=1;i<=lastRowNum;i++){
	usr.findElement(By.id("addButton")).click();
	WebElement userCreFrame = usr.findElement(By.id("userAccessDialogBox_content"));
	usr.switchTo().frame(userCreFrame);
	usr.findElement(By.name("Search")).click();
	WebElement iframe = usr.findElement(By.id("modelWindowLov_content"));
	usr.switchTo().frame(iframe);
	
		XSSFRow row = sheet.getRow(i);
		XSSFCell empNameCell = row.getCell(0);
		String empName = empNameCell.getStringCellValue();
	usr.findElement(By.id("search")).sendKeys(empName);
	Thread.sleep(4000);
	usr.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
	usr.switchTo().parentFrame();
	Thread.sleep(2000);
	XSSFCell usrNameCell = row.getCell(1);
	String usrName = usrNameCell.getStringCellValue();
	usr.findElement(By.id("userName")).clear();
	usr.findElement(By.id("userName")).sendKeys(usrName);
	usr.findElement(By.xpath("//*[@id='spanrole.id']/img")).click();
	Thread.sleep(3000);
	WebElement roleFrame1 = usr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	usr.switchTo().frame(roleFrame1);
	usr.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
	usr.switchTo().parentFrame();
	Thread.sleep(3000);
	usr.findElement(By.cssSelector("#container > img:nth-child(8)")).click();
	
	Thread.sleep(7000);
	
	usr.findElement(By.cssSelector("#container > div:nth-child(3) > img:nth-child(7)")).click();
	usr.switchTo().parentFrame();
	Thread.sleep(3000);
}
//}
}
}

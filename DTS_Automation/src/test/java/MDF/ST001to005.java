package MDF;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.os.WindowsUtils;

public class ST001to005 {
public static void main(String[] args) throws Exception {
	try{
		WindowsUtils.killByName("firefox.exe");
		System.out.println("Done");
		}catch(org.openqa.selenium.os.WindowsRegistryException ignored){
			System.out.println("No browser opened");
		}
	File file = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(file);
	FirefoxProfile fp = new FirefoxProfile();
    WebDriver mdf = new FirefoxDriver(fb,fp);
    mdf.get("http://58.68.10.76:8095/MDF/jsp/main.jsp");
    mdf.manage().window().maximize();
    mdf.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    mdf.findElement(By.id("username")).sendKeys("anandh");
    mdf.findElement(By.id("password")).sendKeys("daemon@76");
    mdf.findElement(By.cssSelector(".imageButton")).click();
    mdf.findElement(By.cssSelector(".menuarrowdown")).click();
    mdf.findElement(By.cssSelector("div.menuRow:nth-child(4)")).click();
    mdf.findElement(By.linkText("Task Group")).click();
    
    File f = new File("E:\\Anandh\\New folder\\DTS\\src\\test\\resources\\MDF.xlsx");
    FileInputStream fis = new  FileInputStream(f);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheet("TaskGroup");
    int lastRowNum = sheet.getLastRowNum();   
    System.out.println("No of rows in taskgroup" +lastRowNum);
    for(int i=1;i<=lastRowNum;i++){
    mdf.findElement(By.id("addNewEntityButton")).click();	
    XSSFRow row =sheet.getRow(i); 
    XSSFCell namecell = row.getCell(0);
    String Name = namecell.getStringCellValue();
    mdf.findElement(By.id("name")).sendKeys(Name);
    XSSFCell descell = row.getCell(1);
    String Desc = descell.getStringCellValue();
    mdf.findElement(By.id("description")).sendKeys(Desc);
    mdf.findElement(By.cssSelector(".fa-search")).click();
    Thread.sleep(3000);
    WebElement Business = mdf.findElement(By.xpath("//iframe[contains(@id,'window')]"));
    System.out.println(Business.getText());
    mdf.switchTo().frame(Business);
   
    mdf.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
    mdf.switchTo().parentFrame();
    mdf.findElement(By.id("submitButton")).click();
    Thread.sleep(3000);
  mdf.findElement(By.id("InfoBoxButton")).click();  
   }
}
}

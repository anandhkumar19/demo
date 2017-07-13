package AUM;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST004 {
public static void main(String[] args) throws Exception {
	
    WebDriver aum = new FirefoxDriver();
    aum.get("http://58.68.10.76:8091/AUM/jsp/main.jsp");
    
    aum.manage().window().maximize();
    aum.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
    File files = new File("E:\\Anandh\\New folder\\DTS\\src\\test\\resources\\AUM.xlsx");
	FileInputStream fis = new FileInputStream(files);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	int lastRowNum = sheet.getLastRowNum();
	System.out.println("total rows"+lastRowNum);
	for(int i=1;i<=lastRowNum;){
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(0);
		String usr = cell.getStringCellValue();
		XSSFCell pwdCell = row.getCell(1);
		String pwd = pwdCell.getStringCellValue();
	aum.findElement(By.id("username")).sendKeys(usr);
	aum.findElement(By.id("password")).sendKeys(pwd);
	break;
	}
    aum.findElement(By.cssSelector(".imageButton")).click();
    WebDriverWait wait=new WebDriverWait(aum, 15);
    
    for(int i=2;i<=lastRowNum;i++){
    	WebElement conne= aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)"));
        conne.click();
        aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3)")).click();
    	XSSFRow row = sheet.getRow(i);
    	XSSFCell cell = row.getCell(2);
    	String NE = cell.getStringCellValue();
    WebElement fileUpIframe = aum.findElement(By.id("iframeFileUpload"));
    wait.until(ExpectedConditions.visibilityOf(fileUpIframe));
    aum.switchTo().frame(fileUpIframe);
    WebElement networkEle = aum.findElement(By.id("networkElements"));
   
    Select networkElementsSel = new Select(networkEle);
    networkElementsSel.selectByValue(NE);
    aum.findElement(By.id("file-1")).click();
    XSSFCell pathcell = row.getCell(3);
	String CDRnaeme = pathcell.getStringCellValue();
  
    StringSelection stringSelection = new StringSelection("D:\\Desktop\\"+CDRnaeme);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    Robot robot = new Robot();
	
    Thread.sleep(1000);
    
    // Press Enter
   robot.keyPress(KeyEvent.VK_ENTER);
   
  // Release Enter
   robot.keyRelease(KeyEvent.VK_ENTER);
   
    // Press CTRL+V
   robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_V);
   
  // Release CTRL+V
   robot.keyRelease(KeyEvent.VK_CONTROL);
   robot.keyRelease(KeyEvent.VK_V);
   Thread.sleep(4000);
          
           //Press Enter 
   robot.keyPress(KeyEvent.VK_ENTER);
   robot.keyRelease(KeyEvent.VK_ENTER);
 
    aum.findElement(By.id("submitButton")).click();
   
    WebElement SucessMessage = aum.findElement(By.id("redirectionMsg"));
    System.out.println(SucessMessage.getText());
    wait.until(ExpectedConditions.visibilityOf(SucessMessage));
    
    aum.switchTo().parentFrame();
    
    WebElement aumainMenu =aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(1) > span:nth-child(2)"));
   
    wait.until(ExpectedConditions.visibilityOf(aumainMenu));
    aumainMenu.click();
    //.blueclass
    
    aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1)")).click();
    aum.findElement(By.id("fileName")).sendKeys(CDRnaeme);
    aum.findElement(By.cssSelector(".searchButtonCustom")).click();
    //aum.navigate().refresh();
    String noOfRecords = aum.findElement(By.cssSelector(".odd > td:nth-child(5)")).getText();
    System.out.println(noOfRecords);
    }
}
}

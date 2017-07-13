package MCR;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_008 {
	public static void main(String[] args) throws Exception {
		/*File file = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary fb = new FirefoxBinary(file);
		FirefoxProfile fp = new FirefoxProfile();*/
	    WebDriver mcr = new FirefoxDriver();
	    mcr.get("http://58.68.10.76:8091/AUM/jsp/main.jsp");
	    //mcr.get("http://125.17.102.150/AUM/jsp/main.jsp");
	    mcr.manage().window().maximize();
	    mcr.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
	    mcr.findElement(By.id("username")).sendKeys("anandh");
	    mcr.findElement(By.id("password")).sendKeys("daemon@76");
	    mcr.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait=new WebDriverWait(mcr, 15);
	    String aumWindow = mcr.getWindowHandle();
	    WebElement conne= mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)"));
	    conne.click();
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3)")).click();
	    WebElement fileUpIframe = mcr.findElement(By.id("iframeFileUpload"));
	    wait.until(ExpectedConditions.visibilityOf(fileUpIframe));
	    mcr.switchTo().frame(fileUpIframe);
	    WebElement networkEle = mcr.findElement(By.id("networkElements"));
	   
	    Select networkElementsSel = new Select(networkEle);
	    networkElementsSel.selectByValue("EFTPOSFILE");
	    mcr.findElement(By.id("file-1")).click();
	    StringSelection stringSelection = new StringSelection("D:\\Desktop\\PTLASCII-0003.txt");
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
	 
	    mcr.findElement(By.id("submitButton")).click();
	   
	    WebElement SucessMessage = mcr.findElement(By.id("redirectionMsg"));
	    System.out.println(SucessMessage.getText());
	    wait.until(ExpectedConditions.visibilityOf(SucessMessage));
	    mcr.switchTo().parentFrame();
	    WebElement mcrainMenu =mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(1) > span:nth-child(2)"));
	   
	    wait.until(ExpectedConditions.visibilityOf(mcrainMenu));
	    mcrainMenu.click();
	    //.blueclass
	    
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1)")).click();
	    mcr.findElement(By.id("fileName")).sendKeys("PTLASCII-3sp.txt");
	    mcr.findElement(By.cssSelector(".searchButtonCustom")).click();
	    //mcr.navigate().refresh();
	    String noOfRecords = mcr.findElement(By.cssSelector(".odd > td:nth-child(5)")).getText();
	    System.out.println(noOfRecords);
	    mcr.findElement(By.cssSelector("#mcr > span:nth-child(1) > a:nth-child(1)")).click();
	    MCR(mcr,aumWindow);
	}

	private static void MCR(WebDriver mcr, String aumWindow) {
	Set<String> mcrWindow = mcr.getWindowHandles();
	String MCRW ="";
	for (String temp : mcrWindow) {
		if(temp.equals(aumWindow)==false){
			MCRW = temp;
		}
	}
		mcr.switchTo().window(MCRW);
		 mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).click();
		    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1)")).click();
		    mcr.findElement(By.id("fileName")).sendKeys("PTLASCII-0003.txt");
		    mcr.findElement(By.cssSelector(".searchButtonCustom")).click();
		     mcr.findElement(By.xpath("//input[contains(@id,'usageType')]")).click();
		     WebElement iframe1 = mcr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
		     mcr.switchTo().frame(iframe1);
		    String receivedFromMediation = mcr.findElement(By.cssSelector("tr.even:nth-child(2) > td:nth-child(2)")).getText();
		    String availableForRating = mcr.findElement(By.cssSelector("#auditTable > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")).getText();
		    if(receivedFromMediation.equals(availableForRating)){
		    	System.out.println("Sucess");
		    }
		    else
		    	System.out.println("Fail");
	}
	
}

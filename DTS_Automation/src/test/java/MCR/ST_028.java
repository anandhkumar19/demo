package MCR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_028 {
public static void main(String[] args) {
	WebDriver mcr = new FirefoxDriver();
	mcr.manage().window().maximize();
	mcr.get("http://125.17.102.150/MCR/");
	 mcr.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	    mcr.findElement(By.id("username")).sendKeys("anandh");
	    mcr.findElement(By.id("password")).sendKeys("daemon@123");
	    mcr.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait = new WebDriverWait(mcr, 10);
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(1)")).click();
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1)")).click();
	    mcr.findElement(By.id("fileName")).sendKeys("ERPASC2-8311.txt");
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

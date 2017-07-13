package BOC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_005 {
public static void main(String[] args) {
	WebDriver boc = new FirefoxDriver();
    boc.get("http://58.68.10.76:8092/BOC/jsp/main.jsp");
    
    boc.manage().window().maximize();
    boc.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(boc, 6000);
    boc.findElement(By.id("username")).sendKeys("anandh");
	boc.findElement(By.id("password")).sendKeys("daemon@76");
	boc.findElement(By.cssSelector(".imageButton")).click();
	boc.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)")).click();
	boc.findElement(By.xpath("//div[contains(text(), 'ErrorCode Action ')]")).click();
	WebElement errorCodeDiv = boc.findElement(By.id("errorCodeDiv"));
	wait.until(ExpectedConditions.visibilityOf(errorCodeDiv));
	boc.findElement(By.cssSelector("#mainDiv > fieldset:nth-child(7) > legend:nth-child(1) > span:nth-child(1)")).click();
	//String errorC1ode = "MCR-0002";
	WebElement errorC1ode = boc.findElement(By.linkText("MCR-0002"));
	
}
}

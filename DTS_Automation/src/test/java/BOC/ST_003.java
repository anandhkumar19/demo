package BOC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ST_003 {
public static void main(String[] args) throws Exception {
	
	WebDriver boc = new FirefoxDriver();
    boc.get("http://58.68.10.76:8092/BOC/jsp/main.jsp");
    
    boc.manage().window().maximize();
    boc.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
    boc.findElement(By.id("username")).sendKeys("anandh");
	boc.findElement(By.id("password")).sendKeys("daemon@76");
	boc.findElement(By.cssSelector(".imageButton")).click();
	boc.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1)")).click();
	boc.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2)")).click();
	Thread.sleep(4000);
	boc.findElement(By.id("logApplication")).sendKeys("MCR");
    boc.findElement(By.cssSelector("#container > input:nth-child(8)")).click();
}
}

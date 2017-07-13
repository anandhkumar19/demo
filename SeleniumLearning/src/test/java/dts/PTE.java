package dts;


//import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;



public class PTE {
public static void main(String[] args) throws Exception {
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver	pte = new FirefoxDriver(fb,ffp);
	pte.get("http://58.68.10.76:8098/PTE/jsp/main.jsp");
	pte.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	pte.findElement(By.id("username")).sendKeys("rdas");
	pte.findElement(By.id("password")).sendKeys("Daemon@76");
	pte.findElement(By.cssSelector(".imageButton")).click();
	pte.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)")).click();
	pte.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")).click();
	pte.findElement(By.cssSelector(".blueclass")).click();
	pte.findElement(By.cssSelector("tr.INPROGRESS:nth-child(1) > td:nth-child(1) > i:nth-child(1)")).click();
	Thread.sleep(4000);
	Actions action = new Actions(pte);
	action.sendKeys(Keys.ESCAPE).build().perform();
}
}

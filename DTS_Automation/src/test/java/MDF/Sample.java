package MDF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample {
	 public static void main(String[] args) throws Exception {
		  WebDriver wd=new FirefoxDriver();
		  wd.get("http://58.68.10.76:8095/MDF/jsp/main.jsp");
		  wd.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		  wd.findElement(By.id("username")).sendKeys("anandh");
		  wd.findElement(By.id("password")).sendKeys("daemon@76");
		  wd.findElement(By.cssSelector(".imageButton")).click();
		  wd.findElement(By.cssSelector(".menuarrowdown")).click();
		  wd.findElement(By.cssSelector("div.menuRow:nth-child(4)")).click();
		  wd.findElement(By.linkText("Employee-Group")).click();
		  Thread.sleep(4000);
		  wd.findElement(By.id("addNewEntityButton")).click();
		  Thread.sleep(3000);
		  wd.findElement(By.id("submitButton")).click();
		  
		  WebElement textgroup = wd.findElement(By.id("txtgroup.id"));
		  Actions builder=new Actions(wd);
		  builder.moveToElement(textgroup).perform();
		  System.out.println(textgroup.getAttribute("title"));
		 }
}

package AUM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ST008 {
public static void main(String[] args) {
	 WebDriver aum = new FirefoxDriver();
	aum.get("http://58.68.10.76:8091/AUM/jsp/main.jsp");
    aum.manage().window().maximize();
    aum.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
    aum.findElement(By.id("username")).sendKeys("anandh");
    aum.findElement(By.id("password")).sendKeys("daemon@76");
    aum.findElement(By.cssSelector(".imageButton")).click();
    aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")).click();
    aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4)")).click();
    aum.findElement(By.id("view7")).click();
    WebElement iframe1 = aum.findElement(By.xpath("//iframe[contains(@id,'window')]"));
    aum.switchTo().frame(iframe1);
    WebElement topView = aum.findElement(By.id("topologyViewCanvas"));
    if(topView.isDisplayed()==true){
    	System.out.println("Pass");
    }
    else
    	System.out.println("Fail");
}
}

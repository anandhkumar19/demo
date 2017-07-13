package AUM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST030 {
public static void main(String[] args) {
	 WebDriver aum = new FirefoxDriver();
	    aum.get("http://58.68.10.76:8091/AUM/jsp/main.jsp");
	    aum.manage().window().maximize();
	    aum.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
	    aum.findElement(By.id("username")).sendKeys("anandh");
	    aum.findElement(By.id("password")).sendKeys("daemon@76");
	    aum.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait=new WebDriverWait(aum, 15);
	    //#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(1)
	    WebElement aumainMenu =aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(1)"));
	    //wait.until(ExpectedConditions.visibilityOf(aumainMenu));
	    aumainMenu.click(); 
	    String NE ="FIASCII";
	    aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1)")).click();
	    WebElement mediationNes = aum.findElement(By.id("mediationNes"));
	    Select mediationNesSelect = new Select(mediationNes);
	    mediationNesSelect.selectByVisibleText(NE);
	  
	    aum.findElement(By.cssSelector(".searchButtonCustom")).click();
	    WebElement NoOfrec = aum.findElement(By.cssSelector(".pagebanner"));
	    wait.until(ExpectedConditions.visibilityOf(NoOfrec));
        String totalRecNE = NoOfrec.getText();
        System.out.println("Total of record in"+NE+"is "+ totalRecNE );
}
}

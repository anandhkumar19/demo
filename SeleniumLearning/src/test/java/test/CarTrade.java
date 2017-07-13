package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class CarTrade {
public static void main(String[] args) {
	/*File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();*/
	WebDriver ct = new FirefoxDriver();
	ct.manage().window().maximize();
	ct.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	ct.get("https://www.cartrade.com/");
	 ct.findElement(By.id("ucity")).click();
	WebElement enterCity = ct.findElement(By.id("ucity"));
	Select dropDown = new Select(enterCity);
	dropDown.selectByValue("bangalore");
}
}

package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WraneBrothres {
public static void main(String[] args) {
	File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	FirefoxProfile firefoxProfile = new FirefoxProfile();
	WebDriver wb = new FirefoxDriver(ffBinary,firefoxProfile);
	wb.manage().window().maximize();
	wb.get("http://www.warnerbros.com/");
	wb.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor)wb;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	wb.findElement(By.cssSelector(".icon-email")).click();
	WebElement mailFrame = wb.findElement(By.cssSelector(".modal-body > iframe:nth-child(1)"));
	wb.switchTo().frame(mailFrame);
	wb.findElement(By.id("edit-submitted-emailaddress")).sendKeys("anandh");
}
}


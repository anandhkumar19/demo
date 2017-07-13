package test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;

public class ThedemoSite {
public static void main(String[] args) throws Exception {
	try {
		WindowsUtils.killByName("firefox.exe");
		System.out.println("closed successfully");
	} catch (org.openqa.selenium.os.WindowsRegistryException ignored) {
		System.out.println("no browser opened");
	}
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver	fc = new FirefoxDriver(fb,ffp);
	fc.get("http://thedemosite.co.uk/");
	fc.findElement(By.linkText("3. Add a User")).click();
    String ParentWindow = fc.getWindowHandle();
	fc.findElement(By.name("FormsButton2")).click();
	//Thread.sleep(4000);
	Alert validationAlert = fc.switchTo().alert();
	validationAlert.accept();
	WebElement Login = fc.findElement(By.linkText("4. Login"));
	Login.click();
	/*Actions ac = new Actions(fc);
	
	ac.contextClick(Login).build().perform();
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(5000);*/
	Set<String> chidWindow = fc.getWindowHandles();
	String loginWindow="";
	for (String temp : chidWindow) {
		if(temp.equals(ParentWindow)==false){
			loginWindow=temp;
		}
	}
	fc.switchTo().window(loginWindow);
	fc.findElement(By.name("username")).sendKeys("Gowri");
	fc.findElement(By.name("password")).sendKeys("1234");
    fc.findElement(By.name("FormsButton2")).click();
    String loginMsg = fc.findElement(By.cssSelector(".auto-style1 > big:nth-child(6) > blockquote:nth-child(1) > blockquote:nth-child(1)")).getText();
	System.out.println(loginMsg);
	
	fc.close();
}
}

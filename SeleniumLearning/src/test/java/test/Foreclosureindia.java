package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.CSS;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;

public class Foreclosureindia {
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
	fc.get("http://activdoctorsonline.in/");
	fc.manage().timeouts().implicitlyWait(2000, TimeUnit.MINUTES);
	/*WebElement cityList = fc.findElement(By.id("city"));
	Select cityDrop = new Select(cityList);
	cityDrop.selectByVisibleText("Bengaluru");
	fc.findElement(By.cssSelector("div.right_box_content:nth-child(4) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(1) > input:nth-child(2)")).click();
	//String i ="4";
	//fc.findElement(By.xpath("//a[contains(text(), ' 3')]")).click();
	for(int i=2;i<4;i++){
	fc.findElement(By.linkText(i+"")).click();
	WebElement Parent = fc.findElement(By.cssSelector(".large-8"));
	List<WebElement> child = Parent.findElements(By.tagName("tr"));
	String fileContent ="";
	for (WebElement tempVar : child) {
		 fileContent =tempVar.getText();
		System.out.println(fileContent);
	}
	}*/
/*	WebElement Login = fc.findElement(By.cssSelector("#topBarbtnS > a:nth-child(1)"));
	Actions actions = new Actions(fc);
	actions.moveToElement(Login).click().build().perform();*/
	
	WebElement Parent = fc.findElement(By.id("topBarbtnS"));
	
	List<WebElement> Child = Parent.findElements(By.tagName("a"));
	
	for (WebElement temp : Child) {
		System.out.println(temp.getText());
	}

}

}

package dts;

import java.io.File;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Pagination {
public static void main(String[] args) throws Exception {
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver	bih = new FirefoxDriver(fb,ffp);
	/*System.setProperty("webdriver.chrome.driver",
			"E:\\Anandh\\chromedriver.exe");
	WebDriver emp = new ChromeDriver();*/
	
	bih.manage().window().maximize();
	bih.get("http://125.17.102.150/BIH");
	bih.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	bih.findElement(By.id("username")).sendKeys("aravindh");
	bih.findElement(By.id("password")).sendKeys("daemon@123");
	bih.findElement(By.cssSelector(".imageButton")).click();
	bih.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(1)")).click();
	bih.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
	bih.findElement(By.cssSelector("tr.even:nth-child(2) > td:nth-child(2) > a:nth-child(1)")).click();
	Thread.sleep(3000);
	bih.findElement(By.id("searchButton")).click();

	
	String noOfrecordsText = bih.findElement(By.xpath("//span[@class='pagebanner']")).getText();
	
	System.out.println(noOfrecordsText);
	String noOfrecordsplit[] =noOfrecordsText.split(" ");
	String noOflogs =noOfrecordsplit[0];
	System.out.println(noOflogs);

	int result = Integer.parseInt(noOflogs.replaceAll(",", ""));
	System.out.println(result);
	int i,j;
	for(i=1;i<result/10;i++){
		
		bih.findElement(By.cssSelector(".pagelinks > a:nth-child(9)")).click();
		Thread.sleep(3000);
		String noOfdyrecordsText = bih.findElement(By.xpath("//span[@class='pagebanner']")).getText();
		String noOfdyrecordsplit[] =noOfdyrecordsText.split(" ");
		String noOfdylogs =noOfdyrecordsplit[0];
		int dyresult = Integer.parseInt(noOfdylogs.replaceAll(",", ""));
		if(dyresult==result){
			continue;
		}
		else{
			for(j=i;j<=dyresult/10;j++){
				bih.findElement(By.cssSelector(".pagelinks > a:nth-child(9)")).click();
				Thread.sleep(3000);
			}
		}
	}
	
}


}

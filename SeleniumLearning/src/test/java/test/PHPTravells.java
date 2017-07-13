package test;

import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class PHPTravells {
public static void main(String[] args) throws Exception {
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver php = new FirefoxDriver(fb,ffp);
	php.manage().window().maximize();
	php.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	php.get("http://phptravels.com/demo/");
	php.findElement(By.cssSelector("div.header-navigation:nth-child(3) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
	/*WebElement Service1 = php.findElement(By.xpath("//*[@id='installation']/div[2]/h3/span"));
	System.out.println(Service1.getText());*/
	WebElement mainFeatureFu = php.findElement(By.cssSelector("div.row:nth-child(3)"));
	List<WebElement> mainFea = mainFeatureFu.findElements(By.tagName("h3"));
	for (WebElement temp : mainFea) {
		//System.out.println(temp.getText());
		String PhpFeature =temp.getText();
		System.out.println("Before "+PhpFeature);
//		byte[] contentInBytes = PhpFeature.getBytes();
//		System.out.println("After"+contentInBytes);
//		File outwr = new File("E:\\Anandh\\PHPTra.txt");
//		FileOutputStream fos = new FileOutputStream(outwr);
//		fos.write(contentInBytes);
//		fos.close();
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("E:\\Anandh\\PHPTra.txt"));
		    writer.write( PhpFeature);

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
	php.quit();
	//System.out.println(php.findElement(By.cssSelector("div.col-xs-12:nth-child(5) > h3:nth-child(1)")).getText());
}
}

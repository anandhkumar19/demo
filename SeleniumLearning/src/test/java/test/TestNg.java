package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class TestNg {
@Test
public void ex1()
{
	File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	FirefoxBinary fb = new FirefoxBinary(pathToBinary);
	FirefoxProfile ffp = new FirefoxProfile();
	WebDriver php = new FirefoxDriver(fb,ffp);
	php.manage().window().maximize();
	php.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	php.get("http://phptravels.com/demo/");
}

}

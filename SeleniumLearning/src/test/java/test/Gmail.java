package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {
public static void main(String[] args) {
	WebDriver gm = new FirefoxDriver();
	gm.manage().window().maximize();
	
	gm.get("https://mail.google.com");
}
}

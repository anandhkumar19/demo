package AUM;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.Properties;  

import org.apache.log4j.Logger;
import org.openqa.selenium.By;  
import org.openqa.selenium.NoSuchElementException;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver; 

public class readdataforpro {
public static void main(String[] args) throws Exception {
	
	 FileInputStream fileInput = new FileInputStream(new File("E:\\Anandh\\New folder\\DTS\\src\\test\\resources\\general.properties")); 
	Properties jdbcProperties = new Properties();
	
	jdbcProperties.load(fileInput);  
	
	 WebDriver driver = new FirefoxDriver(); 
	 driver.manage().window().maximize(); 
	 driver.get(jdbcProperties.getProperty("URL")); 
}  
}

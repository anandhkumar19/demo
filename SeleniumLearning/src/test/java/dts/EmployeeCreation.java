package dts;
import java.io.File;
import java.io.FileInputStream;

import java.util.concurrent.TimeUnit;






import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.os.WindowsUtils;
public class EmployeeCreation {
	public static void main(String[] args) throws Exception {
		try{
		WindowsUtils.killByName("firefox.exe");
		System.out.println("Done");
		}catch(org.openqa.selenium.os.WindowsRegistryException ignored){
			System.out.println("No browser opened");
		}
		//WebDriver emp = new FirefoxDriver();
		File  pathToBinary  = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary fb = new FirefoxBinary(pathToBinary);
		FirefoxProfile ffp = new FirefoxProfile();
		WebDriver	emp = new FirefoxDriver(fb,ffp);
		/*System.setProperty("webdriver.chrome.driver",
				"E:\\Anandh\\chromedriver.exe");
		WebDriver emp = new ChromeDriver();*/
		
		emp.manage().window().maximize();
		emp.get("http://58.68.10.76:8082/SSO/login?service=http%3A%2F%2F58.68.10.76%3A8095%2FMDF%2Fjsp%2Fmain.jsp");
		emp.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		File files = new File("E:\\Anandh\\New folder\\SeleniumLearning\\src\\test\\resources\\Employee.xlsx");
		FileInputStream fis = new FileInputStream(files);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("total rows"+lastRowNum);
		for(int i=1;i<=lastRowNum;){
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			String usr = cell.getStringCellValue();
			XSSFCell pwdCell = row.getCell(1);
			String pwd = pwdCell.getStringCellValue();
		emp.findElement(By.id("username")).sendKeys(usr);
		emp.findElement(By.id("password")).sendKeys(pwd);
		break;
		}
		emp.findElement(By.cssSelector(".imageButton")).click();
		emp.findElement(By.cssSelector(".menuarrowdown")).click();
		emp.findElement(By.cssSelector("div.menuRow:nth-child(4)")).click();
		emp.findElement(By.cssSelector(".entityTable > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > a:nth-child(1)")).click();
		
		
		for(int i=2;i<=lastRowNum;i++){
			Thread.sleep(3000);
			WebElement addNew = emp.findElement(By.id("addNewEntityButton"));
			addNew.click();
			WebElement Names = emp.findElement(By.id("name"));
			WebElement Description = emp.findElement(By.id("description"));
			XSSFRow row = sheet.getRow(i);
			XSSFCell nameCell = row.getCell(2);
			String name = nameCell.getStringCellValue();
			Names.sendKeys(name);
			XSSFCell descCell = row.getCell(3);
			String descr = descCell.getStringCellValue();
			Description.sendKeys(descr);
			XSSFCell conCell= row.getCell(4);
			int contno =(int)conCell.getNumericCellValue();
			emp.findElement(By.id("contactNumber")).sendKeys(contno+"");
			emp.findElement(By.cssSelector(".fa-search")).click();
			Thread.sleep(3000);
			WebElement iframe1 = emp.findElement(By.xpath("//iframe[contains(@id,'window')]"));
			emp.switchTo().frame(iframe1);
			emp.findElement(By.cssSelector(".odd > td:nth-child(2) > div:nth-child(1)")).click();
			emp.switchTo().parentFrame();
			XSSFCell emailCell = row.getCell(5);
			String emailID = emailCell.getStringCellValue();
			emp.findElement(By.id("emailId")).sendKeys(emailID);
			WebElement stname = emp.findElement(By.id("address.streetName"));
			stname.sendKeys(row.getCell(6).getStringCellValue());
			WebElement houno = emp.findElement(By.id("address.houseNumber"));
			houno.sendKeys((int)row.getCell(7).getNumericCellValue()+"");	
			WebElement hounoext = emp.findElement(By.id("address.houseNumberExtension"));
			hounoext.sendKeys(row.getCell(8).getStringCellValue());
		
			WebElement zipcode = emp.findElement(By.id("address.zipCode"));
			zipcode.sendKeys((long)row.getCell(9).getNumericCellValue()+"");
			WebElement cityname = emp.findElement(By.id("address.cityName"));
			cityname.sendKeys(row.getCell(10).getStringCellValue());
			WebElement country = emp.findElement(By.id("address.country"));
			country.sendKeys(row.getCell(11).getStringCellValue());
			emp.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
			emp.findElement(By.cssSelector(".serializeOK")).click();
			
		}
		UserCreate uc = new UserCreate();
		uc.userCreation(emp);
	}
	
	
}

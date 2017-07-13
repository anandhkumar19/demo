package dts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;

public class CreationOFRC {
public static void main(String[] args) throws Exception {
	try{
		WindowsUtils.killByName("firefox.exe");
		System.out.println("Done");
		}catch(org.openqa.selenium.os.WindowsRegistryException ignored){
			System.out.println("No browser opened");
		}
	WebDriver rc = new FirefoxDriver();
	rc.manage().window().maximize();
	rc.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	rc.get("http://58.68.10.77/SSO/login?service=http%3A%2F%2F58.68.10.77%2FDPC%2F");
	//String pwd = pwdCell.getStringCellValue();
	rc.findElement(By.id("username")).sendKeys("aravindh");
	rc.findElement(By.id("password")).sendKeys("Daemon@234");
	rc.findElement(By.cssSelector(".imageButton")).click();
	rc.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
	rc.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();
	rc.findElement(By.id("addNewEntityButton")).click();
	rc.findElement(By.id("name")).sendKeys("RC33");
	rc.findElement(By.id("description")).sendKeys("RC33");
	rc.findElement(By.name("Search")).click();
	WebElement iframe1 = rc.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	rc.switchTo().frame(iframe1);
	rc.findElement(By.cssSelector(".odd > td:nth-child(2) > div:nth-child(1)")).click();
	rc.switchTo().parentFrame();
	Thread.sleep(3000);
	rc.findElement(By.id("startDate")).click();
	rc.findElement(By.id("c20")).click();
	rc.findElement(By.xpath("//*[@id='spangLMapping.id']/span[3]")).click();
	Thread.sleep(3000);
	WebElement iframe2 = rc.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	rc.switchTo().frame(iframe2);
	rc.findElement(By.cssSelector(".odd > td:nth-child(2) > div:nth-child(1)")).click();
	rc.switchTo().parentFrame();
	Thread.sleep(3000);
	rc.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	rc.findElement(By.name("Search")).click();
	Thread.sleep(3000);
	WebElement iframe3 = rc.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	rc.switchTo().frame(iframe3);
	rc.findElement(By.id("search")).sendKeys("RC33");
	rc.findElement(By.cssSelector("#magnifyImg")).click();
	Thread.sleep(2000);
	rc.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
	rc.switchTo().parentFrame();
	rc.findElement(By.cssSelector("#container > center:nth-child(7) > img:nth-child(2)")).click();
	
	Select dropDown = new Select(rc.findElement(By.id("status")));
	System.out.println("First status :"+dropDown.getFirstSelectedOption().getText());
	rc.findElement(By.id("chargeValue")).sendKeys("55");
	rc.findElement(By.cssSelector("#container > center:nth-child(8) > img:nth-child(2)")).click();
	rc.findElement(By.id("SendForApproval")).click();
	WebElement statusInp = rc.findElement(By.id("status"));
	Select dropDown1 = new Select(statusInp);
	System.out.println("First status :"+dropDown1.getFirstSelectedOption().getText());
	String status = dropDown1.getFirstSelectedOption().getText();
	if(status.equals("INPROGRESS")){
		System.out.println("Pass");
	}else
		System.out.println("False");
	String workFlowMSG= rc.findElement(By.id("liElement")).getText();
	System.out.println("Workflow message"+workFlowMSG);
	String split[] = workFlowMSG.split(":");
	String workflowId = split[1];
	System.out.println("workflow instnce id"+workflowId);
	//PteWorkflow pw = new 
	rc.close();
	
}
}

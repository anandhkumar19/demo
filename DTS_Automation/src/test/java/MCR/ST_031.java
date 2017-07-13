package MCR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ST_031 {
public static void main(String[] args) throws Exception {
	WebDriver mcr = new FirefoxDriver();
	mcr.manage().window().maximize();
	mcr.get("http://58.68.10.76:8094/MCR/");
	 mcr.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	    mcr.findElement(By.id("username")).sendKeys("anandh");
	    mcr.findElement(By.id("password")).sendKeys("daemon@76");
	    mcr.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait = new WebDriverWait(mcr, 10);
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(1)")).click();
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(6) > div:nth-child(2)")).click();
	    mcr.findElement(By.xpath("//div[@id='spanaccount.id']/span[3]")).click();
	    Thread.sleep(3000);
		WebElement iframe1 = mcr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
		mcr.switchTo().frame(iframe1);
		mcr.findElement(By.id("search")).sendKeys("129264");
		Thread.sleep(7000);
		mcr.findElement(By.cssSelector(".odd > td:nth-child(1) > div:nth-child(1)")).click();
		mcr.switchTo().parentFrame();
		mcr.findElement(By.id("submitButton")).click();
		WebElement rerateButton = mcr.findElement(By.id("rerate"));
		wait.until(ExpectedConditions.visibilityOf(rerateButton));
		String NoOfCDR = mcr.findElement(By.id("pageCount")).getText();
		String[] totalCoube = NoOfCDR.split(" ");
		String totalCount = totalCoube[3];
		System.out.println("totalCount: "+totalCount);
		rerateButton.click();
		Thread.sleep(3000);
		mcr.findElement(By.cssSelector("button.btn:nth-child(1)")).click();
		WebElement audit = mcr.findElement(By.id("auditTableId"));
		List<WebElement> listOfAllTRs = audit.findElements(By
				.tagName("tr"));
		WebElement lastRowElement = listOfAllTRs
				.get(listOfAllTRs.size() - 1);

		List<WebElement> allCellsOfLastRow = lastRowElement.findElements(By
				.tagName("td"));
		WebElement secondCellOfLastRow = allCellsOfLastRow.get(1);
		System.out.println(secondCellOfLastRow.getText());
		//#auditTableId > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)
		String status = mcr.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(3)")).getText();
		System.out.println(status);
		/*if(status.equals("Completed")==false){
			mcr.findElement(By.cssSelector("#rerateWindow > div:nth-child(4) > img:nth-child(1)")).click();
			
		}*/
}
}

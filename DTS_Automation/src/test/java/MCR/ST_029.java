package MCR;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_029 {
public static void main(String[] args) throws Exception {
	WebDriver mcr = new FirefoxDriver();
	mcr.manage().window().maximize();
	mcr.get("http://58.68.10.76:8094/MCR/");
	mcr.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	 mcr.findElement(By.id("username")).sendKeys("anandh");
	    mcr.findElement(By.id("password")).sendKeys("daemon@76");
	    mcr.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait = new WebDriverWait(mcr, 150);
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(5) > div:nth-child(1)")).click();
	    mcr.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(5) > div:nth-child(2)")).click();
	    mcr.findElement(By.linkText("Manage rejection")).click();
	    WebElement iframe1 = mcr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	    wait.until(ExpectedConditions.visibilityOf(iframe1));
	    mcr.switchTo().frame(iframe1);
	    WebElement mcrRe = mcr.findElement(By.id("mcrRejectionsFrame"));
	    mcr.switchTo().frame(mcrRe);
	    mcr.findElement(By.id("sortedFieldListSelectBox")).sendKeys(" identifier");
	    mcr.findElement(By.id("operator")).sendKeys("Equal to");
	    mcr.findElement(By.id("fieldValue")).sendKeys("1292640O");
	    mcr.findElement(By.id("overlapAddButton")).click();
	    mcr.findElement(By.id("searchButton2")).click();
	    WebElement bathUpdate = mcr.findElement(By.id("myDisplayTableId"));
	    wait.until(ExpectedConditions.visibilityOf(bathUpdate));
	    mcr.findElement(By.id("fieldNameId")).sendKeys("startTime");
	    Thread.sleep(3000);
	    mcr.findElement(By.id("fieldValueInfo")).click();
	    mcr.findElement(By.id("calenderImage")).click();
	    WebElement month = mcr.findElement(By.name("MonthSelector"));
	    if (month.isDisplayed()==true) {
			System.out.println("Month true");
		}
	    else
	    	System.out.println("Month false");
	    month.sendKeys("December");
	    Thread.sleep(3000);
        WebElement year = mcr.findElement(By.name("YearSelector"));
        if (year.isDisplayed()==true) {
			System.out.println("Year true");
		}
	    else
	    	System.out.println("year false");
        Select yea = new Select(year); 
        yea.selectByValue("2016");
        mcr.findElement(By.id("c2")).click();
        mcr.findElement(By.cssSelector("#updateInfo > input:nth-child(1)")).click();
        WebElement commentframe = mcr.findElement(By.xpath("//iframe[contains(@id,'window')]"));
        mcr.switchTo().frame(commentframe);
        WebElement rejComm = mcr.findElement(By.id("comment"));
        wait.until(ExpectedConditions.visibilityOf(rejComm));
        rejComm.sendKeys("Update starttime");
        mcr.findElement(By.id("saveButton")).click();
        mcr.switchTo().parentFrame();
        Thread.sleep(5000);
        mcr.findElement(By.id("InfoBoxButton")).click();
        Thread.sleep(5000);
        WebElement markCDR = mcr.findElement(By.id("tabHeader_5"));
        if(markCDR.isDisplayed()){
        	System.out.println("yes");
        }
        markCDR.click();
        WebElement reproCDR = mcr.findElement(By.id("rejectionUpdateDetails"));
        if (reproCDR.isDisplayed()) {
			mcr.findElement(By.cssSelector("#markReprocess > div:nth-child(2) > input:nth-child(2)")).click();
		}
        mcr.findElement(By.cssSelector(".dialog_buttons > button:nth-child(1)")).click();
        mcr.findElement(By.id("InfoBoxButton")).click();
        Thread.sleep(5000);
        mcr.findElement(By.id("tabHeader_6")).click();
        mcr.findElement(By.cssSelector("#manageReprocess > input:nth-child(2)")).click();
        mcr.findElement(By.id("InfoBoxButton")).click();
        mcr.findElement(By.id("tabHeader_9")).click();
        WebElement audit_id = mcr.findElement(By.id("auditTableId"));
        wait.until(ExpectedConditions.visibilityOf(audit_id));
        WebElement taBody = audit_id.findElement(By.tagName("tbody"));
        //System.out.println(taBody.getSize());
        List<WebElement>alltd = taBody.findElements(By.tagName("tr"));
        
        WebElement latestId = alltd
				.get(alltd.size() - alltd.size());
		List<WebElement> allCellsOfLastRow = latestId.findElements(By
				.tagName("td"));
		WebElement firstCellOfLastRow = allCellsOfLastRow.get(0);
		System.out.println(firstCellOfLastRow.getText());
		 String auditID = firstCellOfLastRow.getText();
		 mcr.findElement(By.linkText(auditID)).click();
        
      
      
        
}


}

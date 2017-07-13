package AUM;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ST025 {
public static void main(String[] args) throws Exception {
	 WebDriver aum = new FirefoxDriver();
	    aum.get("http://58.68.10.76:8091/AUM/jsp/main.jsp");
	    //aum.get("http://125.17.102.150/AUM/jsp/main.jsp");
	    aum.manage().window().maximize();
	    aum.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	    aum.findElement(By.id("username")).sendKeys("anandh");
	    aum.findElement(By.id("password")).sendKeys("daemon@76");
	    aum.findElement(By.cssSelector(".imageButton")).click();
	    WebDriverWait wait=new WebDriverWait(aum, 150);
	    
	     aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(5) > div:nth-child(1)")).click();
	    //wait.until(ExpectedConditions.visibilityOf(ProcessRejMa));
	   
	    aum.findElement(By.cssSelector("#leftMenuContainer > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(5) > div:nth-child(2)")).click();
	    aum.findElement(By.linkText("Manage rejection")).click();
	    WebElement mainRejectionScreen = aum.findElement(By.xpath("//iframe[contains(@id,'window')]"));
	    wait.until(ExpectedConditions.visibilityOf(mainRejectionScreen));
	    aum.switchTo().frame(mainRejectionScreen);
	    //System.out.println("First Frame"+mainRejectionScreen);
	    WebElement aumRejFrame = aum.findElement(By.id("aumRejectionFrame"));
	   
	    aum.switchTo().frame(aumRejFrame);
	    //System.out.println("Second Frame"+aumRejFrame);
	    WebElement Fields = aum.findElement(By.id("sortedFieldListSelectBox"));
	    wait.until(ExpectedConditions.visibilityOf(Fields));
	    Select cdrFileName = new Select(Fields);
	    cdrFileName.selectByValue("cdrFileName");
	    aum.findElement(By.id("operator")).sendKeys("Like");
	    aum.findElement(By.id("fieldValue")).sendKeys("%EPSASCII-RatFix%");
	    aum.findElement(By.id("overlapAddButton")).click();
	    aum.findElement(By.id("searchButton2")).click();
	    WebElement bathUpdate = aum.findElement(By.id("myDisplayTableId"));
	    wait.until(ExpectedConditions.visibilityOf(bathUpdate));
	    
	    aum.findElement(By.id("fieldNameId")).sendKeys("usageType");
	 
	    aum.findElement(By.id("fieldValueInfo")).sendKeys("60010");
	    aum.findElement(By.id("fieldNameId")).sendKeys("originator");
	    Thread.sleep(3000);
	    aum.findElement(By.id("fieldNameId")).sendKeys("usageType");
	 
	    aum.findElement(By.id("fieldValueInfo")).sendKeys("60010");
	    aum.findElement(By.cssSelector("#updateInfo > input:nth-child(1)")).click();
        WebElement commentframe = aum.findElement(By.xpath("//iframe[contains(@id,'window')]"));
        aum.switchTo().frame(commentframe);
        WebElement rejComm = aum.findElement(By.id("comment"));
        wait.until(ExpectedConditions.visibilityOf(rejComm));
        rejComm.sendKeys("Update starttime");
        aum.findElement(By.id("saveButton")).click();
        aum.switchTo().parentFrame();
        Thread.sleep(5000);
        aum.findElement(By.id("InfoBoxButton")).click();
        Thread.sleep(5000);
        WebElement markCDR = aum.findElement(By.id("tabHeader_5"));
        if(markCDR.isDisplayed()){
        	System.out.println("yes");
        }
        markCDR.click();
        WebElement reproCDR = aum.findElement(By.id("rejectionUpdateDetails"));
        if (reproCDR.isDisplayed()) {
			aum.findElement(By.cssSelector("#markReprocess > div:nth-child(2) > input:nth-child(2)")).click();
		}
        aum.findElement(By.cssSelector(".dialog_buttons > button:nth-child(1)")).click();
        aum.findElement(By.id("InfoBoxButton")).click();
        Thread.sleep(5000);
        aum.findElement(By.id("tabHeader_6")).click();
        aum.findElement(By.cssSelector("#manageReprocess > input:nth-child(2)")).click();
        aum.findElement(By.id("InfoBoxButton")).click();
        Thread.sleep(5000);
        WebElement auditTab = aum.findElement(By.id("tabHeader_9"));
        
        auditTab.click();
        WebElement audit_id = aum.findElement(By.id("auditTableId"));
        wait.until(ExpectedConditions.visibilityOf(audit_id));
        WebElement taBody = audit_id.findElement(By.tagName("tbody"));
       
        List<WebElement>alltd = taBody.findElements(By.tagName("tr"));
        WebElement latestId = alltd
				.get((alltd.size() - alltd.size()));
        System.out.println(latestId);
		List<WebElement> allCellsOfLastRow = latestId.findElements(By
				.tagName("td"));
		WebElement status = allCellsOfLastRow.get(2);
		String statusText = status.getText();
		System.out.println("Status text is "+statusText);
	
        
	    while (!statusText.equalsIgnoreCase("Completed")) {
	    	aum.findElement(By.id("reprocessRefresh")).click();
	    	System.out.println(" looping statusText is not equal to completed"+statusText);
	    	 taBody = audit_id.findElement(By.tagName("tbody"));
	    	 alltd = taBody.findElements(By.tagName("tr"));
	    	 latestId = alltd
	 				.get((alltd.size() - alltd.size()));
	    	allCellsOfLastRow=latestId.findElements(By
					.tagName("td"));
			 status = allCellsOfLastRow.get(2);
			 statusText = status.getText();
		}
	    WebElement latestauId = allCellsOfLastRow.get(0);
		System.out.println(latestauId.getText());
		 String auditID = latestauId.getText();
		 aum.findElement(By.linkText(auditID)).click();
}
}

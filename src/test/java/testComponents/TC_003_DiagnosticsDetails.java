package testComponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.DiagnosticsPage;
import testBase.BaseClass;
import utility.ExcelUtilities;

public class TC_003_DiagnosticsDetails extends BaseClass{
	
	@Test(priority = 1)
	public void navigateToDiagnostics() throws InterruptedException, IOException {
			
		DiagnosticsPage diag = new DiagnosticsPage(driver);
		
		diag.getLabTest().click();
		
		System.out.println("\n------------- Top City Details -------------");
		if(diag.isSectionDisplayed()) {
			List<WebElement> topCityNames = diag.getTopCities();
			int cityLen =diag.getTopCities().size();
			
			captureScreenShot("navigateToDiagnostics");
			Thread.sleep(2000);
			
			for(int i=0;i<cityLen; i++) {
				
				System.out.println("City"+(i + 1) +": " + topCityNames.get(i).getText());
				ExcelUtilities.writeExcel("Top Cities", i, 0, topCityNames.get(i).getText());
			}
			
		}else {
			System.out.println("Top City Names are not available");
		}
		
		System.out.println("\n--------------------------");
	}
}

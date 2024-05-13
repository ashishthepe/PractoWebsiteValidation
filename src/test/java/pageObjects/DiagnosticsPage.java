package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiagnosticsPage extends BasePage{

	public DiagnosticsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@class=\"nav-mid\"]/div[4]")
	WebElement labTest;
	
	@FindBy(xpath = "//div[@class=\"ReactModal__Content ReactModal__Content--after-open\"]")
	WebElement diagnosticSection;
	
	@FindBy(xpath = "//div[@class =\"u-margint--standard o-f-color--primary\"]")
	List<WebElement> topCities;
	
	
	By diagnosticSection2 =By.xpath("//div[@class=\"ReactModal__Content ReactModal__Content--after-open\"]");
	
	public WebElement getLabTest() {
		return labTest;
	}
	public WebElement getDiagnosticSection() {
		return diagnosticSection;
	}
	
	public boolean isSectionDisplayed() {
		try {
			waitForElementToAppear(diagnosticSection2);
			if(diagnosticSection.isDisplayed()) {
				return  true;
			}else {
				return false;
			}	
		}catch(Exception e) {
			return false;
		}
				
	}
	
	public List<WebElement> getTopCities() {
		return topCities;
	}
	
	

}

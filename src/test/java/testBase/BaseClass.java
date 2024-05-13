package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static WebDriver driver;
	

	@BeforeClass
	@Parameters({"browser","url"})
	public void setUpBrowser(String br,String appurl) throws IOException, InterruptedException 
	{
			
			if(br.equalsIgnoreCase("Chrome"))
			{
				driver=new ChromeDriver(); 
				System.out.println("Testing in Chrome...........");
				System.out.println("");
			}
			else if(br.equalsIgnoreCase("Edge")) 
			{
				driver=new EdgeDriver();
				System.out.println("Testing in Edge...........");
				System.out.println("");
			}
			
			driver.get(appurl);
//			Thread.sleep(15000);
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 
	}
	
	// Closing Browser function
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		driver = null;
	}
	
	
	
	// Screenshot method
	public void captureScreenShot(String name) throws IOException 
	
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		File targetFile=new File(targetFilePath);
		FileHandler.copy(sourceFile, targetFile);
		
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	} 
	
	
}

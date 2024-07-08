package Common_Utils1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1 
{

	public WebDriver driver;
    public static WebDriver sdriver;
	  File_Utils1 futils = new File_Utils1();
     JavaUtils1 jutils = new JavaUtils1();
	 protected Webdriver_Utils1 wutils = new Webdriver_Utils1();
     ExcelUtils1 eutils = new ExcelUtils1();


		@BeforeSuite
		public void BSconfig() throws IOException
		{
			//dgm
			String BROWSER = futils.getDataFromPropertiesfileDGMPage("Browser");
			
			String URL = futils.getDataFromPropertiesfileDGMPage("Url");
			
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else
			{
				driver = new FirefoxDriver();
			}
			
			driver.get(URL);
			
			wutils.Maximize(driver);
			
			wutils.ImplcitWait(driver);	
			
			//Vendor
//			String BROWSER = futils.getDataFromPropertiesfileVendor("Browser");
//			String URL = futils.getDataFromPropertiesfileVendor("url_Vendor");
//			
//			
//			if(BROWSER.equalsIgnoreCase("chrome"))
//			{
//				driver = new ChromeDriver();
//			}
//			else
//			{
//				driver = new FirefoxDriver();
//			}
//			
//			driver.get(URL);
//			
//			wutils.Maximize(driver);
//			
//			sdriver = driver;
//		}
//			
//			
//		@BeforeClass
//		public void BCconfig() throws IOException
//		{
//			
//			   System.out.println("Launch the browser");
//			   
		      sdriver=driver;

			
		}
		
		
		@BeforeMethod
		public void BMconfig() throws IOException
		{
         
		  System.out.println("Start Test");
			
			
		}
		
		@AfterMethod
		public void AMconfig() throws InterruptedException
		{
			
			
	     	System.out.println("Successfully done Test Scenario");
	   	
	         
		}
		
		@AfterClass
		public void ACconfig() throws IOException
		{
			
			//driver.close();
		
			
		}
		
		
		@AfterSuite
		public void ASconfig()
		{
			System.out.println("DisConnect to data base");
			
			
		}
			
		
		
	}
 
       



        
	   
	   



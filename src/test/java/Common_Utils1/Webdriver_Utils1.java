package Common_Utils1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utils1 
{
	 
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void Minimize(WebDriver driver)
	{
		driver.manage().window().maximize();

	}
	

	    public WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement, int i) 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
	        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
	    }
	
	
	public void ImplcitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//action class1 for mouse hover
	public void Action(WebDriver driver, WebElement webelementname)
	{
		Actions act = new Actions(driver);
		act.moveToElement(webelementname).perform();
	}
	
	public void ActionClick(WebDriver driver, WebElement webelementname)
	{
		Actions act = new Actions(driver);
		act.click(webelementname).perform();
	}
	
	//select class
	
	public void SelectDropdown(WebElement elementname, int index)
	{
		
		Select s1 = new Select(elementname);
		s1.selectByIndex(index);
		
	}
	
	//select class for select by visible text
	
		public void SelectDropdownText(WebElement elementname, String str)
		{
			
			Select s1 = new Select(elementname);
			s1.selectByVisibleText(str);
			
		}
		
		
		//parents to child
		public void SwitchtoMethod(WebDriver driver)
		{
			 
	        Set<String> ids = driver.getWindowHandles();
			
		    for(String ids1 : ids)
		   {
			  String title =  driver.switchTo().window(ids1).getTitle();
			  
		   } 
	 
		}
		
		
		public void ChildtoParentSwitch(WebDriver driver)
		{
			
			 Set<String> ids = driver.getWindowHandles();
		      System.out.println(ids);
		      
			  for(String allid: ids)
		 	     {
		 	        	 String allurl = driver.switchTo().window(allid).getCurrentUrl();
		 	        	 
		 		    	 
	 		    	     String parenturl = driver.getWindowHandle();
		 		        	 	
//		 		    	 if(allurl.contains(parenturl))
//		 		    	 {
//		 	    		// driver.close();
//		 		    		 break;
//		 		    		 
//		 		    	 }
		 		     }
		}
		
		
		//public void robotclass
		public void RobotClass() throws AWTException
		{
			
			Robot rb = new Robot();
			rb.delay(2000);
			
			//perform Control +v action to paste file
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
		}
		
		
		//this is for take a ss of failed testscript 
		public String screenshotwebpage1(WebDriver driver,String Screenshotname) throws IOException
		{
			//-----to take screenshot of webpage screenshot-------->
		       TakesScreenshot ss = (TakesScreenshot)driver;
		       File temp = ss.getScreenshotAs(OutputType.FILE);
		       
		       File Destination = new File("./Screenshots" + Screenshotname+".jpg");
		   	   temp.renameTo(Destination);
		   	   //FileUtils.copyFile(temp, Destination);
		   	   return Destination.getAbsolutePath(); //where ur ss is there to get the location destination
		}
	

		
		//selectforFetchOptionsandClickonElementsof drodown
		
		
		public void handleDropdown(Select dropdown,WebDriver driver) throws InterruptedException 
		{
		    List<WebElement> options = dropdown.getOptions();
		    for (int i = 0; i < options.size(); i++) 
		    {
		        dropdown.selectByIndex(i);
		        Thread.sleep(2000);
		        
		        if(i==1)
		        {
		        	if(i==1)
					{
						System.out.println("Stage 1 Table Data");
						List<WebElement> stage1ElementTable = driver.findElements(By.xpath("//table[@id=\"postList\"]//th"));
						StringBuilder columnNames = new StringBuilder();
				        
					   //here printing a row1 with columns	
						for (WebElement e1 : stage1ElementTable) 
						{
						    columnNames.append(e1.getText()).append(" ");
						}
		                System.out.println(columnNames.toString());
		                
		                
		                //here print all rows and columns   
		                List<WebElement> data = driver.findElements(By.xpath("//table[@id=\"postList\"]//td"));
		                StringBuilder RowNames = new StringBuilder();
		                for(WebElement r : data)
		                {
		                	RowNames.append(r.getText()).append(" ");    
		                }
		                System.out.println(RowNames.toString());
				  	}
					else if(i==2)
					{
						System.out.println("Stage 2 Table Data");
						List<WebElement> stage2ElementTable = driver.findElements(By.xpath("//table[@id=\"postList\"]//th"));	
						StringBuilder columnNames = new StringBuilder();
						for (WebElement e1 : stage2ElementTable) 
						{
							columnNames.append(e1.getText()).append("            ");
						}
					     System.out.println(columnNames.toString());
					    
					     
		                List<WebElement> data1 = driver.findElements(By.tagName("td"));
		                StringBuilder RowNames1 = new StringBuilder();
						for(WebElement r : data1)
						{
							RowNames1.append(r.getText()).append("               ");    
		                    
						}
						 System.out.println( RowNames1.toString());
						 
					}
		        }
		    }
		    Thread.sleep(1000);
		}
		
		
		public void Select_handleDropdown(Select dropdown) throws InterruptedException 
		{
		    List<WebElement> options = dropdown.getOptions();
		    for (int i = 0; i < options.size(); i++) 
		    {
		        dropdown.selectByIndex(i);
		        Thread.sleep(2000);
		    }
	
		    
		}}
		


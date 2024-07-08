package POM_Base_Meda;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Utils1.File_Utils1;
import Common_Utils1.Webdriver_Utils1;
import POM_Meda_Pages.Beneficiary_Dashboard;
import POM_Meda_Pages.Beneficiary_Loginpage;

//@Listeners(Listner_Implimantation.class)
public class Beneficiary_LoginBase   //extends BaseClass1
{
    WebDriver driver; 
	File_Utils1 futils = new File_Utils1();
	Webdriver_Utils1 wutils = new Webdriver_Utils1();
	
	@Test(priority=1)
	public void TestUrl() throws IOException, InterruptedException
	{
		String BROWSER1 = futils.getDataFromPropertiesfileLgnPage("Browser1");
		String URL1 = futils.getDataFromPropertiesfileLgnPage("url1");
		
		if(BROWSER1.equalsIgnoreCase("chrome"))
		   {
			   driver = new ChromeDriver();
		   }
		   else
		   {
			   driver = new EdgeDriver();
		   }
		   
		   driver.get(URL1);
		   
		   wutils.Maximize(driver);
		   
		   wutils.ImplcitWait(driver);
	}
	
	@Test(priority = 2)
	public void TestLoginPage() throws InterruptedException, IOException
	{
		  Beneficiary_Loginpage blp = new Beneficiary_Loginpage();
		  PageFactory.initElements(driver, blp);
		  
		  //username and application number textfield
		  blp.getLgnUsernameTf().sendKeys(futils.getDataFromPropertiesfileLgnPage("Username1"));
		  
		  //password Tf
		  blp.getLgnPasswordTf().sendKeys("8243");
		  Thread.sleep(2000);
		  
		  if(blp.getLgnButton().isDisplayed())
		  {
			  System.out.println("login button is displayed");
		  }
		  else
		  {
			  System.out.println("Login button not displayed");
		  }
		  Thread.sleep(1000);
		  
		   
		   
		   blp.getLgnButton().click();
		   
		   Thread.sleep(3000);
		   
		   String AtualTitle = driver.getTitle();
		   String ExpectedTitle ="Maharashtra Energy Development Agency (MEDA) | Beneficiary";
		   
		   Assert.assertEquals(AtualTitle, ExpectedTitle, "title not matched");
		   
		
	}
		  
	
		        
		  @Test(priority=3) 
		  public void ValidateDashboardFunctionality() throws InterruptedException
		  {
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
		    
		    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table solar_tbl']//tr"));
		    
		    for(WebElement r : rows)
		    {
	            List<WebElement> cells = r.findElements(By.tagName("td"));
	            
	            for (WebElement c : cells) 
	            {
	            	
	                System.out.println(c.getText());
	                
	            }
	            System.out.println();
	        

		    }
		    
		    if(bd.getImgLogofMedaOnDashboard().isDisplayed())
		    {
		    	System.out.println("Logo of Meda displayed on dashboard");
		    }
		    else
		    {
		    	System.out.println("Logo of Meda not displayed on dashboard");

		    }
		    
		    //Maha Krushi Urja Abhiyan -PM Kusum Yojana (KYP0001) image is display or not
		    Assert.assertTrue(bd.getImageOfDashboardTable().isDisplayed());
		    Thread.sleep(2000);
		    
		    //click on complete your form
		    bd.getCompleteURFormbtn().click();  
		    Thread.sleep(2000);
		    
		  }
		  
		  @Test(priority = 4)
		  public void ValidateBeneficiaryisAbletoCompleteBeneficiaryForm() throws InterruptedException, AWTException
		  {
			  //1. Applicant Residential Address
			  
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
			  //house number tf
			  bd.getHouseNumTf().sendKeys("122");
			  
			  bd.StreetLandmarkTf().sendKeys("Near Ram Nagr");
			  Thread.sleep(1000);
			  //Distict Dropdown
			  wutils.SelectDropdownText(bd.getDistrictDropdown(),"Nandurbar");
			  Thread.sleep(2000);

			  //Taluka Dropdown
			  wutils.SelectDropdownText(bd.getTalukaDropdown(),"Nandurbar");
			  Thread.sleep(2000);

			  //Village Dropdown
			  wutils.SelectDropdownText(bd.getVillageDropdown(),"Nandurbar");
			  Thread.sleep(1000);

			  //pin code Tf
			  bd.getPincodeTf().sendKeys("222333");
			  Thread.sleep(2000);

			  //Mobile number Tf
			  if(bd.getMobileTf().isEnabled())
			  {
				  System.out.println("Mobile number textfiled is enable");
			  }
			  else
			  {
				  System.out.println("Mobile number textfiled is disabled");

			  }
			  
			  Thread.sleep(2000);
		  }
		  
		  @Test(priority = 5)
		  public void VerifyIrrigationSourceInformation() throws InterruptedException
		  {
			  //2.Irrigation Source Information
			  
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
			  
			  //Type of irrigation source Dropdown
			  wutils.SelectDropdownText(bd.getIrrigationSourceDrop(),"Bore Well ( बोअरवेल )");
			  Thread.sleep(1000);

			 // Irrigation Source Depth (in Feet) TF
			  bd.getIrrigationSourceDepthTf().clear();
			  Thread.sleep(2000);
			  bd.getIrrigationSourceDepthTf().sendKeys("100");
			  Thread.sleep(1000);

			  bd.getWidthTf().sendKeys("12");
			  
			  //dropdown of irrigation mode
			  wutils.SelectDropdownText(bd.getIrr_modeDropdown(),"Sprinkler ( तुषार सिंचन )");
			  Thread.sleep(2000);
		  }
		  
		  @Test(priority = 6)
		  public void verifyCropsDetails() throws InterruptedException
		  {

			 //3. Crops Details
			  
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
			  
			  //Crop Type: Previous Year dropdown
			  wutils.SelectDropdownText(bd.getCrpTyp_PrioviousYdropdown(),"Kharif ( खरीप )");
			  Thread.sleep(2000);

			  bd.getTot_CropsPrivYearTf().clear();
			  Thread.sleep(2000);
			  
			  bd.getTot_CropsPrivYearTf().sendKeys("1");
			  
			  //Crop Type: Last to Last Year Dropdown
			  wutils.SelectDropdown(bd.getLastYearDropdown(),2);
			  Thread.sleep(3000);
			  
			  //No. of Crops: Last to Last Year *
			  bd.getLastYearCropsTf().clear();
			  Thread.sleep(2000);
			  bd.getLastYearCropsTf().sendKeys("5");
			  
			  //4.Required Pump Details
			  Thread.sleep(2000);
//			  bd.getReqPumpTypTf().clear();
//			  Thread.sleep(2000);
//			  bd.getReqPumpTypTf().sendKeys("DC");
//			  
//			  Thread.sleep(3000);
              
			  //Required Pump Sub Type
			  wutils.SelectDropdown(bd.getPumpSubTypeDropDown(),2);
			  Thread.sleep(2000);
			  //Pump Category dropdown
			  wutils.SelectDropdown(bd.getPump_categoryDropDown(), 0);
			  Thread.sleep(2000);

			  //Pump Capacity dropdown
			  wutils.SelectDropdown(bd.getPump_CapacityDropDown(), 2);
			  Thread.sleep(2000);

			  //Water level/depth of water in Summer Season (In Feet) Tf
			  bd.getSumWaterLevelTf().sendKeys("5");
			  Thread.sleep(1000);

			  //Water level/depth of water in Rainy Season (In Feet) Tf
			  bd.getRainySesonTf().sendKeys("3");
			  Thread.sleep(1000);

			  //Water Throughput Required (Litres/Minute)Tf
			  bd.getWater_ThroughputTf().sendKeys("15");
			  Thread.sleep(2000);

			  //Solar Agricultural Pump Cost (Rs.) Tf
			  boolean Tf = bd.getSolar_Agri_PumpTf().isEnabled();
			  System.out.println("getSolar_Agri_PumpTf is enable" + Tf);
			  
			  //Beneficiary share (Rs.)*
			  boolean BeneficiaryShare = bd.getBenf_shareTf().isEnabled();
			  System.out.println(BeneficiaryShare);
			  
		  }
		  
		  @Test(priority = 7)
		  public void  VerifyBankDetalis() throws AWTException, InterruptedException
		  {
	
			  //5.Bank Details
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
			  
			  //account number tf
			  bd.getAccountNumTf().sendKeys("345652876");
			  
			  //account holder name
			  bd.getAccountHolderNameTf().sendKeys("Shivani pawar");
			  
			  //Account Type Dropdown
			  wutils.SelectDropdown(bd.getAccount_typeDROP(), 1);
			  
			  //IFSC CODE
			  bd.getBank_ifscTf().sendKeys("SBIN0005476");
			  
		  }
		  
		  public void verifyBeneficiaryisAbleToUploadDocs() throws InterruptedException, AWTException
		  {
			  
			  Beneficiary_Dashboard bd = new Beneficiary_Dashboard();
			  PageFactory.initElements(driver, bd);
			  //6.Scan / Upload Documents 
			  
			  Thread.sleep(2000);
			  //get Upload Van Patte Certificate
			  wutils.ActionClick(driver,bd.getUploadVanPatteCetificate());
			  
			    Robot rb = new Robot();
				rb.delay(2000);
				
				//copyfile to clipboard
				StringSelection ss = new StringSelection("C:\\Users\\Innosystech_8_Pc_5\\Downloads\\Image2.jpeg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				
				//perform Control +v action to paste file
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);

				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);
				
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(2000);

				//Upload talathi certificate
				wutils.ActionClick(driver,bd.getUploadtalathi_certificate());
				
				StringSelection ss1 = new StringSelection("Image3.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
				
				wutils.RobotClass();
				
				Thread.sleep(2000);
				
				//upload vanPatte Map
				wutils.ActionClick(driver,bd.getUploadVanPtteMap());
				
				StringSelection ss2 = new StringSelection("Image6.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
				
				wutils.RobotClass();
				
				Thread.sleep(2000);
				
				//upload adhar card
				wutils.ActionClick(driver,bd.getUploadadhar_card());
				
				StringSelection ss3 = new StringSelection("image4.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss3, null);
				
				wutils.RobotClass();
				
				Thread.sleep(4000);
				
				//Cancle check upload bank passbook copy
				wutils.ActionClick(driver,bd.getUploadBankPassCopy());
				
				StringSelection ss4 = new StringSelection("Image8.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss4, null);
				
				wutils.RobotClass();
				
				Thread.sleep(3000);
				
				
				//passport size photo
				wutils.ActionClick(driver,bd.getUploadPassportPhoto());
				
				StringSelection ss5 = new StringSelection("Image7.jpg");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss5, null);
				
				wutils.RobotClass();
				Thread.sleep(2000);
				
				bd.getCheckbox().click();
				
				
				Thread.sleep(3000);
				
				bd.getSubmitButtonOfForm().click();			
				Thread.sleep(10000);
				
		  }
		  
		  
		  
		   
		
		
	}
	
    
	
	
	


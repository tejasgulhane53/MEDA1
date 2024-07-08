package POM_Base_Meda;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Common_Utils1.BaseClass1;
import Common_Utils1.File_Utils1;
import Common_Utils1.Listner_Implimantation;
import Common_Utils1.Webdriver_Utils1;
import POM_Meda_Pages.Beneficiary_Reg_Page;
import POM_Meda_Pages.Pump_DetailsPopupPage;
import POM_Meda_Pages.yourAppPayment_DetailsPage;

//@Listeners(Listner_Implimantation.class)
public class Beneficiary_Reg_Base //extends BaseClass1
{
	
	WebDriver driver;
	 Webdriver_Utils1 wutils = new Webdriver_Utils1();
	  File_Utils1 futils = new File_Utils1();
	
  
   @Test(priority = 1)
	public void TestBeneficiaryRegistrationURL() throws IOException, InterruptedException
	{
	  	   
	   String URL =  futils.getDataFromPropertiesfile("Url");
	   String BROWSER = futils.getDataFromPropertiesfile("Browser");
	   
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   driver = new ChromeDriver();
	   }
	   else
	   {
		   driver = new EdgeDriver();
	   }
	   
	   driver.get(URL);
	   
	   wutils.Maximize(driver);
	   
	   wutils.ImplcitWait(driver);
	  	    
	}
   
   @Test(priority = 2)
   public void TestValidRagistration() throws InterruptedException
   {
	   //select existing pump dropdown
	   POM_Meda_Pages.Beneficiary_Reg_Page brp = new POM_Meda_Pages.Beneficiary_Reg_Page();
	   PageFactory.initElements(driver, brp);
	   wutils.SelectDropdown(brp.getExistingpumpDropdown(), 1);
	   
	   //Source of Power Existing Pump dropdown
	   wutils.SelectDropdown(brp.getSource_powerexistingpumpdrop(), 1);   
	   
	   //Existing Pump Type dropdown
	   wutils.SelectDropdown(brp.getExisting_pumpTypeDrop(), 1);
	   
	   //Existing Pump Sub Type dropdown
	   wutils.SelectDropdown(brp.getExisting_pumpsubTypeDrop(),1);
	   
	   //Existing Pump Capacity in HP dropdown
	   wutils.SelectDropdown(brp.getExisting_pump_Capin_HPDrop(), 1);
	   
	   //Energy Efficient Pump dropdown
	   wutils.SelectDropdown(brp.getEnergy_EficientPumpDrop(), 1);
	   
	   //Annual Diesel textfield
	   brp.getAnnualDesealTextfield().sendKeys("500");   
	   
	   //personal and Land_Details of applicant
	   //enter adhar number
	   brp.getAdharnum().sendKeys("423465595955");
	  
	   
	   //check that state textfield disable or enabled
	  boolean statetextfield = brp.getStateTextfield().isEnabled();//false
	  System.out.println(statetextfield);
	  
	
	  //land district dropdown
	  wutils.SelectDropdownText(brp.getLnddistDropdown(),"Nandurbar (नंदूरबार)");
	  
	  //land taluka dropdown
      wutils.SelectDropdownText(brp.getLndTalukaDropdown(),"Nandurbar (नंदूरबार)");
  
	  //land village dropdown
	  wutils.SelectDropdownText(brp.getLndvillageDropdown(),"Nandurbar (नंदुरबार)");
	  //Thread.sleep(3000);
	  
	 //click on radiobutton 
	  brp.getInfoPopup_radiobtn().click();
	  //click on submit 
	  brp.getPopupsubmitBtn().click();
	  
	  //mobile number textfield
	  brp.getPhnoTextfield().sendKeys("7083006019");
	  
	  //caste catagory dropdown
	  wutils.SelectDropdown(brp.getCastcategoryTextfield(), 2);
	  
	  //email id 
	  brp.getEmailTextfield().sendKeys("tejasgulhane70@gmail.com");
	  
	  //Van_Patte Dropdown
	  wutils.SelectDropdown(brp.getVanPatte_Dropdown(),1);
     Thread.sleep(6000);

	  
	  //popup of Hamipatra information
	  brp.getHamipatraRadiobtn().click();
	  Thread.sleep(1000);
	  brp.getHamipatrasubmitBTN().click();
	  Thread.sleep(2000);
	  	  
	  //Enter beneficiary name 
	  brp.getUserNameTf().sendKeys("Tejas");
	  
	  //Enter beneficiary father name 
	  brp.getFatherNameTf().sendKeys("Sanjay");
	  
	  //Enter beneficiary Surname
	  brp.getSurnameTf().sendKeys("Gulhane");
	 
	  
	   
	  Thread.sleep(2000);
	  //click on application submit button
	  brp.getApplicationSubmitbtn().click();
	  Thread.sleep(4000);
	  
	  if(brp.getYesContinuebtn().isDisplayed())
	  {
		System.out.println("Yes Continue button is present on webpage");  
	  }
	  else
	  {
			System.out.println("Yes Continue button is not present on webpage");  

	  }
	  
	  Thread.sleep(4000);
	  //click on yes continue button
	  brp.getYesContinuebtn().click();
	  Thread.sleep(2000);
	  
	 
//	  String Actualurl = driver.getCurrentUrl();
//	  System.out.println("actuel url :" + Actualurl);
	  
	  Thread.sleep(5000);

	  //handle the popup of (leave site)
	  driver.switchTo().alert().accept();
	  Thread.sleep(20000);
	  
//	  String Expected = driver.getCurrentUrl();
//	  System.out.println("Expected url :" + Expected);
	  
	  //Assert.assertEquals(Actualurl, Expected, "Url are not matching");
	  
	 // brp.getVerifybuttonElement().click();
	  
   }
   
   @Test(priority = 3, enabled = false)
   public void testpumpDetailsPopup()
   {
	  Pump_DetailsPopupPage pdp = new Pump_DetailsPopupPage();
	  PageFactory.initElements(driver, pdp);  
	  
	  
	  WebElement table = pdp.getLanddetails_table1();

      // Get all rows from the table
      List<WebElement> rows = table.findElements(By.tagName("tr"));

      // Iterate over each row and print the text of each cell
      for (WebElement row : rows) 
      {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          for (WebElement cell : cells)
          {
              System.out.print("row " +  cell.getText());
          }
          
          System.out.println();
      }
      
      
	 System.out.println("Available Quota :" + pdp.getAvailableQuata().getText()); 
	  
	//ValidateAvailable Quata is displayed or not
  	boolean availableQuota = pdp.getAvailableQuata().isDisplayed();
  	System.out.println("Available Quota is display : " + availableQuota);
  	
  	
  	boolean Paymentbtn = pdp.getProceedtoPayment().isDisplayed();
  	System.out.println("Proceed to payment is displayed : "+ Paymentbtn);
  	
  	//click on proceed to payment
  	pdp.getProceedtoPayment().click();
  
  	
  	
   }
   
   @Test(priority = 4,enabled = false)
   public void TestYourApplicationPaymentDetails()
   {
	   yourAppPayment_DetailsPage adp = new yourAppPayment_DetailsPage();
	   PageFactory.initElements(driver, adp);
	   
	    String transactionid = adp.getTransactionidField().getText();
	    System.out.println("transaction id :" + transactionid);
	   
	  // test transaction id field
	  if(adp.getTransactionidField().isEnabled())
	  {
		  System.out.println("Transaction id textfield enabled");
	  }
	  else
	  {
		  System.out.println("Transaction id textfield disabled");
	  }
	  
	    String totalamt = adp.getTotalamtTextfield().getText();
	    System.out.println("total amount :" + totalamt);
	    
	   	    
	    boolean btn = adp.getProceedTPaymentbtn().isDisplayed();
	    System.out.println("proceed to pay button is displayed :" + btn);
	    
	    adp.getProceedTPaymentbtn().click();
	      
   }
   	
   @Test(enabled = false)
   public void TestVillageListbtn() throws InterruptedException
   {
	  
		Beneficiary_Reg_Page brp = new Beneficiary_Reg_Page();
		PageFactory.initElements(driver, brp);
		Thread.sleep(2000);
		boolean btn = brp.getVillagelistbtn().isDisplayed();
		System.out.println("Village list button is displayed" + btn);
		Thread.sleep(3000);
		brp.getVillagelistbtn().click();
   }
   
   
   
	   
//	  //select existing pump dropdown
//	   Beneficiary_Reg_Page brp = new Beneficiary_Reg_Page();
//	   PageFactory.initElements(driver, brp);
//	   wutils.SelectDropdown(brp.getExistingpumpDropdown(), 2);
//	   
//	   //enter adhar number
//	   brp.getAdharnum().sendKeys("222222222225");
//	  
//	   
//	   //check that state textfield disable or enabled
//	  boolean statetextfield = brp.getStateTextfield().isEnabled();//false
//	  System.out.println(statetextfield);
//	  
//	
//	  //land district dropdown
//	  wutils.SelectDropdown(brp.getLnddistDropdown(),2);
//	  
////	  //land taluka dropdown
//      wutils.SelectDropdown(brp.getLndTalukaDropdown(), 2);
//      Thread.sleep(1000);
////	  
////	  //land village dropdown
//	  wutils.SelectDropdown(brp.getLndvillageDropdown(), 2);
//	  Thread.sleep(1000);
//	  
//	  //mobile number textfield
//	  brp.getPhnoTextfield().sendKeys("7083006015");
//	  
//	  //caste catagory dropdown
//	  wutils.SelectDropdown(brp.getCastcategoryTextfield(), 2);
//	  
//	  //email id 
//	  brp.getEmailTextfield().sendKeys("rajesh122@gmail.com");   
	   
	}
	
	


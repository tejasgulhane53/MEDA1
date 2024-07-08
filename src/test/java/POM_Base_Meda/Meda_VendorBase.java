package POM_Base_Meda;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Common_Utils1.BaseClass1;
import Common_Utils1.ExcelUtils1;
import Common_Utils1.File_Utils1;
import Common_Utils1.Listner_Implimantation;
import Common_Utils1.Webdriver_Utils1;
import POM_Meda_VendorPage.Equipment_Modi_ReqPage;
import POM_Meda_VendorPage.Grievance_Page;
import POM_Meda_VendorPage.PDI_MOD_Page;
import POM_Meda_VendorPage.Payment_Page;
import POM_Meda_VendorPage.Policy_ManagementPage;
import POM_Meda_VendorPage.SiteEnggModule_Page;
import POM_Meda_VendorPage.Staff_Mod_Page;
import POM_Meda_VendorPage.Vendor_LoginPage;
import POM_Meda_VendorPage.WorkOrder_Page;
import POM_Meda_VendorPage.procurement_ManagmentPage;
import io.reactivex.rxjava3.functions.Action;

@Listeners(Listner_Implimantation.class)
public class Meda_VendorBase extends BaseClass1
{
	//WebDriver driver = null;
	
	Webdriver_Utils1 wutils = new Webdriver_Utils1();
	File_Utils1 futils = new File_Utils1();
	ExcelUtils1 eutils = new ExcelUtils1();
	
	SoftAssert softassert = new SoftAssert();
	ExtentReports extent = new ExtentReports();
	
	
	
	@Test(priority = 1)
	public void VerifyVendorsLoginUrl() throws IOException
	{	
			
		ExtentTest test = extent.createTest("launch url");
		test.pass("APPLICATION start SuccesSfully");
		test.info("Launch Url");
		
		System.out.println("             ");
		
	}
	
	@Test(priority = 2)
	public void VerifyVendorLoginPageWithValidCredential() throws InterruptedException, IOException
	{
		wutils.ImplcitWait(driver);
	

		String  USERNAME = futils.getDataFromPropertiesfileVendor("user_name");
		String PASSWORD = futils.getDataFromPropertiesfileVendor("pass_word");
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		vlp.getEmailTf().sendKeys(USERNAME);
		Thread.sleep(2000);
		vlp.getPassTf().sendKeys(PASSWORD);
		
		vlp.getCaptchaTf().click();
		Thread.sleep(15000);
		
		vlp.getLoginbtn().click();
		
		Thread.sleep(2000);
		
		ExtentTest test = extent.createTest("launch url");

		test.info("Successfully Done Login");
	
	}
	
	
	
//	@Test(dependsOnMethods = "CheckThatAll_ModulesofDashBoard_HeaderPart_AfterLogin")
//	public void VerifyVendorLoginPageWithInvalidCredential() throws InterruptedException, IOException
//	{
//		wutils.ImplcitWait(driver);
//		
//		
//		Vendor_LoginPage vlp = new Vendor_LoginPage();
//		PageFactory.initElements(driver, vlp);
//		
//		vlp.getEmailTf().sendKeys("tejas@12322");
//		Thread.sleep(2000);
//		vlp.getPassTf().sendKeys("77366366");
//		
//		vlp.getCaptchaTf().click();
//		Thread.sleep(15000);
//		
//		vlp.getLoginbtn().click();
//		
//		Thread.sleep(2000);
//		
//		
//	
//	}
//	
	
	@Test(priority = 3)
	public void VerifyFunctionalityofNotificationPopupAfterLogin() throws InterruptedException
	{
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//notifiaction popup
		if(vlp.getNotificatioPopup().isDisplayed())
		{
			System.out.println("Popup notification is displayed after login.");
		}
		else
		{
			System.out.println("Popup notification is not displayed after login.");
		}
		
		Thread.sleep(1000);
		
		if(vlp.getDownloadLink().isDisplayed())
		{
			System.out.println("Download link is Present on Notification Popup");
		}
		else
		{
			System.out.println("Download link is Not Present on Notification Popup");
		}
		
		//close the notification
		vlp.getClosepopupbtn().click();
		Thread.sleep(2000);
		
		ExtentTest test = extent.createTest("launch url");

		test.info("Popup Verification successfully Done after Login");
	
	}
	
	
	
	@Test(priority = 4)
	public void CheckThatAll_ModulesofDashBoard_HeaderPart_AfterLogin() throws InterruptedException, AWTException
	{
		
	Vendor_LoginPage vlp = new Vendor_LoginPage();
	PageFactory.initElements(driver, vlp);
	List<WebElement> Allmodule = vlp.getAllmodulesOfheaderpart();
	
	for(int i =0; i<Allmodule.size(); i++)
	{
		if(i>=2 && i<=8)
		{
			Allmodule.get(i).click();
			Thread.sleep(2000);
		}
		else if(i>=9 && i<=9)
		{
			wutils.Action(driver, Allmodule.get(i));
			Thread.sleep(2000);
			
		}
		else if(i>=10 && i<=10)
		{
			Allmodule.get(i).click();
			
			Thread.sleep(3000);	
		}
		else if(i>=13 && i<=13 )
		{
			Allmodule.get(i).click();
			
		 String Expected = driver.getTitle();
		 String Actual = "innoproduction...!";
		
		 softassert.assertEquals(Expected,Actual);
		 
		 Thread.sleep(4000);
		
		 Thread.sleep(2000);
		 driver.navigate().back();
			
		}
		
		
	}
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//a[@href='https://innoproduction.in/meda/meda_vendor/dashboard'])[1]")).click();
	
	Thread.sleep(2000);
	
	}
		
	
	@Test(priority = 5)
	public void VerifyDashboardFunctionalityOfHomeModule() throws InterruptedException
	{
		
	    Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//verify dashboard page title
//		String Expected = driver.getTitle();
//		String Actual = " Vendor | Maharashtra Energy Development Agency (MEDA) ";
//		
//		Assert.assertEquals(Expected, Actual);
//		
//		Thread.sleep(2000);
		
	    //handle the table of dashboard
		
	    System.out.println("Maha Krushi Urja Abhiyan -PM Kusum Yojana (KYP0001)  Table   :   ");
	    
	    List<WebElement> dashboardTable = vlp.getTableofDashboard1();
		
	    for(int i=0; i<dashboardTable.size();i++)
	    {
	    	
		  String tablekrushi = dashboardTable.get(i).getText();
		  System.out.println(tablekrushi);
		
		  System.out.println("-----------------------------------------------------");
     	}	
	    
	    //check logo is present on dashboard
	    
		if(vlp.getLogoofDashboardVendor().isDisplayed())
		{
			System.out.println("Scheme Logo is Displayed on Dashboard");
		}
		else
		{
			System.out.println("Scheme Logo is not Displayed on Dashboard");
		}
		
		//handle dropdowns Elements options of Dahboard Module
	     WebElement drop = vlp.getDashboardDropdown();
	     
	     Select s1 = new Select(drop);
	     List<WebElement> Droptions = s1.getOptions();
	     
	     for(int i=0; i<Droptions.size();i++)
	     {
	    	s1.selectByIndex(i);
	    	Thread.sleep(5000);
	    	System.out.println(Droptions.get(i).getText());
	     }
	    	
	     System.out.println("---------------------------------------------------------------");
	 }
		
	   
	//----------------------------------------beneficiary Report Module ----------------------
	
	@Test(priority = 6)
	public void VerifyBeneficiaryReportFunctionality() throws InterruptedException, AWTException
	{
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		vlp.getBeneficiaryReport().click();
		
		//fetch the beneficiaryReport column name
		List<WebElement> row1Columns = driver.findElements(By.xpath("//table[@id=\"dist_wise_work_allocated\"]//th"));
		for(int i=0;i<row1Columns.size();i++)
		{
			String text = row1Columns.get(i).getText();
			System.out.println(text);
		//	StringBuilder sb = new StringBuilder(text);
			//sb.append("  ").toString();	
		}
		
	    List<WebElement> rowsColumns = driver.findElements(By.xpath("//table[@id=\"dist_wise_work_allocated\"]//td"));

		for(WebElement e1 : rowsColumns)
		{
			System.out.println(e1.getText());
		}
		
		
		//click all element of dropdown Beneficiary
		WebElement drop = vlp.getBeneficiaryRepoDrop1();
		Select s1 = new Select(drop);
		List<WebElement> listDrop = s1.getOptions();
		
		for(int i=0; i< listDrop.size(); i++)
		{
			//s1.selectByIndex(i);  
		    //Thread.sleep(2000);
			System.out.println(listDrop.get(i).getText());
		}
		
		
	}
	
	@Test (priority = 7)
	public void VerifyThatView_EyeBtn1Functionality() throws InterruptedException
	{
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//Click on Beneficiary Report Eye btn 1
		vlp.getEyebtn1().click();
		
		Thread.sleep(2000);
			
		//total no of pages
//		String text = driver.findElement(By.xpath("//a[text()='280']")).getText();
//		System.out.println("total no of pages" + text);
//		
//		int totalPages = Integer.valueOf(text);
//		System.out.println("total pages  :" + totalPages );
		
		
		//Fetch Data From Table
		
		for(int p=1 ; p< 3; p++)
		{
			
			    WebElement activePage = driver.findElement(By.xpath("//div[@class='footable-pagination-wrapper']//li//a"));
			    System.out.println("Active page: " + activePage.getText());
			    Thread.sleep(1000);

			   //total number of rows 
			    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr"));
			    System.out.println("Number of rows: " + rows.size());

			    for (WebElement row : rows) 
			    {
			        List<WebElement> cells = row.findElements(By.tagName("td"));
			        StringBuilder rowText = new StringBuilder();
			        for (WebElement cell : cells) 
			        {
			            rowText.append(cell.getText()).append("  ");
			        }
			    
			        System.out.println(rowText.toString());
			    }
		  
		  
		    String pagenation = Integer.toString(p+1);
		    driver.findElement(By.xpath("//ul[@class='pagination justify-content-center']//li//a[text()= '" + pagenation + "']")).click();
		    Thread.sleep(2000);
		    
//		    JavascriptExecutor jse = (JavascriptExecutor)driver;
//		    jse.executeScript("Window.scrollBY(0,400)");
		  
		 }
		
	}
	
	@Test(priority = 8)
	public void VerifyDropdownsAfterClickonViewbtn1() throws InterruptedException
	{
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
	   //handle stage dropdown
		
		WebElement stagedrop = vlp.getStageDrop();
		Select s2 = new Select(stagedrop);
		List<WebElement> stagedropdown = s2.getOptions();
	
	
		
		for(int i=0; i<stagedropdown.size();i++)
		{
			s2.selectByIndex(i);
			Thread.sleep(2000);
			
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
		Thread.sleep(1000);
		
		//handle site engg drop
		
		WebElement siteEnggDrop = vlp.getSiteEnggDrop();
		Select s3 = new Select(siteEnggDrop);
		List<WebElement> siteEnggDrop1 = s3.getOptions();
		
		for(int i=0; i<siteEnggDrop1.size();i++)
		{
			s3.selectByIndex(i);
			Thread.sleep(2000);
			
		}
		Thread.sleep(1000);
		
		//handle district
		
		WebElement DistDrop = vlp.getDistDrop();
		Select s4 = new Select(DistDrop);
		List<WebElement> DidtictDrop = s4.getOptions();
		
		for(int i=0; i<DidtictDrop.size();i++)
		{
			s4.selectByIndex(i);
			Thread.sleep(2000);
			
		}
		Thread.sleep(1000);
		
		//handle taluka drop
		WebElement talikadrop = vlp.getTalukaDrop();
		Select s5 = new Select(talikadrop);
		List<WebElement> talukaDrop = s5.getOptions();

		for(int i=0; i<talukaDrop.size();i++)
		{
			s5.selectByIndex(i);
			Thread.sleep(2000);	
		}
		
		Thread.sleep(1000);
		
		//handle status drop
		WebElement statusDrop = vlp.getStatusDrop();
		Select s6 = new Select(statusDrop);
		List<WebElement> StatDrop = s6.getOptions();
		

		for(int i=0; i<StatDrop.size();i++)
		{
			s6.selectByIndex(i);
			Thread.sleep(2000);
			
		}
		
		Thread.sleep(1000);
		
		WebElement paymentdrop = vlp.getPaystatusDrop();
		Select s7 = new Select(paymentdrop);
		List<WebElement> Paymdrop = s7.getOptions();
		
		for(int i=0; i<Paymdrop.size();i++)
		{
			s2.selectByIndex(i);
			Thread.sleep(2000);
			
		}
	   
	 
	}

	
	@SuppressWarnings("unlikely-arg-type")
	@Test(priority = 9)
	public void ValidateAfterSearchBeneficiaryNameAndBeneficiaryId() throws IOException, InterruptedException
	{
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//get Beneficiary name from excel sheet
		ExcelUtils1 eutils = new ExcelUtils1();
		String data = eutils.getDataFromExcelFile("Sheet1",1,1);
		
		System.out.println(data);
		
		//search with name on Tf
		vlp.getSrch_benfTf().sendKeys(data);
		
		//search with ID on Tf
		String data1 = eutils.getDataFromExcelFile("Sheet1",2, 2);
		vlp.getSrch_benf_ID_TF().sendKeys(data1);
		
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		vlp.getSrch_benfTf().sendKeys(data);
		Thread.sleep(3000);	
		
	}
	
	
	@Test(priority= 10)
	public void afterSearchingBeneficiaryIDAndNameCheckJSR_Report() throws InterruptedException
	{
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
			
		vlp.getJsrReport().click();
		
		Thread.sleep(2000);
		
		wutils.SwitchtoMethod(driver);
		
		String expected = driver.getTitle();
		
		String actual = expected;
		
		Assert.assertEquals(expected,actual);
		
		boolean jsrRepoTable = vlp.getJsrReportTable().isDisplayed();
		System.out.println("JSR REPORT TABLE  :"  +  jsrRepoTable );
		
		//site engg sign is displayed or not
		boolean sign = vlp.getSiteEnggSign().isDisplayed();
		System.out.println("Sign is Displayed of site engineer :" + sign);
		
		driver.close();
		
		wutils.ChildtoParentSwitch(driver);
		
		Thread.sleep(3000);
		
	    driver.navigate().back();
	    
	    Thread.sleep(3000);
	    
	    driver.navigate().back();
	    Thread.sleep(3000);
	    
	    driver.navigate().back();
	    Thread.sleep(3000);
	    
	    
		
	}
	
	@Test(priority = 11)
	public void VarifyThatViewbtn2_AfterClickonBeneficiaryReport() throws InterruptedException
	{
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		vlp.getEyebtn2().click();
		
		Thread.sleep(2000);
		
		
	    //Handle all dropdowns
		wutils.handleDropdown(new Select(vlp.getStageDrop()), driver);
		wutils.handleDropdown(new Select(vlp.getSiteEnggDrop()), driver);
		wutils.handleDropdown(new Select(vlp.getDistDrop()), driver);
		wutils.handleDropdown(new Select(vlp.getTalukaDrop()), driver);
		wutils.handleDropdown(new Select(vlp.getStatusDrop()), driver);
		wutils.handleDropdown(new Select(vlp.getPaystatusDrop()), driver);
		
		
	}
	
	@Test(priority = 12)
	public void VerifyAfterSearchingBeneficiaryName() throws IOException, InterruptedException
	{    
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//  vlp.getEyebtn2().click();
		
		
		int totalRows = 5;  //eutils.getTotalRows("Sheet1");

		//hare i test searching all beneficiary name from table and fetch data
		for (int row = 1; row <= totalRows ; row++)
		{                      
		    
		    String beneficiaryName = eutils.getDataFromExcelFileParbhani_Benef("Sheet1", row, 1);
		                                                                                     //1 is a column number
		    System.out.println("Searching for: " + beneficiaryName);
		    
		    Thread.sleep(2000);
		    WebElement searchBname = vlp.getSrch_benfTf();
     		searchBname.sendKeys(beneficiaryName);
		    
		    Thread.sleep(2000);
		    searchBname.clear();
		    Thread.sleep(2000);    
		}	
		
	}	
	
	
	@Test(priority = 13)
	public void VerifyAfterSearchingBeneficiaryIDs() throws IOException, InterruptedException
	{
		//searching a multiple ids
		
		Vendor_LoginPage vlp = new Vendor_LoginPage();
		PageFactory.initElements(driver, vlp);
		
		//vlp.getEyebtn2().click();
		
		
		int totalRows =  5 ;  //eutils.getTotalRows("Sheet1");
		
		//searching Data in Table by using Beneficiary ID
		for(int row = 1 ; row<= totalRows; row++)
		{
			
			String Benfids = eutils.getDataFromExcelFileParbhani_Benef("Sheet1", row, 2);
			
			 System.out.println("Searching for: " + Benfids);
			 
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			 WebElement searchBId =  vlp.getSrch_benf_ID_TF();
			 searchBId.sendKeys(Benfids);
			 Thread.sleep(2000);
			 
			 searchBId.clear();
			 Thread.sleep(2000);
			
		}
	
		driver.navigate().back();
		Thread.sleep(2000);
		
		}
		
	
	//-------------------------------site Engg Module--------------------
	
	@Test(priority = 14)
	public void VerifySiteEnggModuleFunctionality() throws InterruptedException
	{
		
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		//click on site Engg Module
		SEPage.getSiteEnginnerModule().click();
		Thread.sleep(2000);
		
		if(SEPage.getListofSiteEnggTable().isDisplayed())
		{
			System.out.println("After Click on Site Engg LIst is Displayed");
		}
		else
		{
			System.out.println("After Click on Site Engg LIst is not Displayed");
		}
		
		Thread.sleep(2000);
		
	}
	

	@Test(priority = 15)
	public void VerifyVendorisAbletoAllocateWorkToSiteEnginner() throws InterruptedException
	{
		
		SoftAssert softassert = new SoftAssert();
		
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		
		// click on Allocate Work
		SEPage.getAllocateWorkPlusbtnInTable().click();
		
		 WebElement SchemeDrop = SEPage.getSchemeDropdown();
		 
		 Select s1 = new Select(SchemeDrop);
		 s1.selectByIndex(1);
		 
//		 List<WebElement> SchemDropOptions = s1.getOptions();
//		 
//		 for(int i=0; i<SchemDropOptions.size();i++)
//		 {
//			 s1.deselectByIndex(i);
//			 System.out.println(SchemDropOptions.get(i).getText());
//		 }
	
		 
		 //select Type Drop 
		 WebElement typeDrop = SEPage.getTypeDropdown();
		 wutils.SelectDropdown(typeDrop, 1);
				 
		 Thread.sleep(2000);
		 
		 //select District Drop
		 WebElement Distdropdown =  SEPage.getDistrictDropdown();
		 Select S = new Select(Distdropdown);
		 
		  if(S.getOptions().size() > 1)
		  {
	         S.selectByIndex(0);
	      } 
		  else 
		  {
			  softassert.fail("Dropdown " + Distdropdown + " doesn't have any options.");
	      }
		
		  driver.navigate().back();
		  Thread.sleep(4000);
		 
		//select taluka drop
		 WebElement talukadrop = SEPage.getTalukaDropdown();
		 wutils.SelectDropdown(talukadrop, 0);
		
		
		 WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
	     submitButton.click();
	     
	     
	      
	}	 
	
	@Test(priority = 16)
	public void VerifyUserIsAbleToEditSiteEnggDatail_List() throws InterruptedException
	{
		
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		SEPage.getEditBtnSiteEngg().click();
		
		SEPage.getSiteEngNameTf().clear();
		SEPage.getSitEenggAddressTf().clear();
		Thread.sleep(2000);
		SEPage.getContctNoSiteEnggTf().clear();
		SEPage.getEmailtf().clear();
		
		Thread.sleep(2000);
		
		
		SEPage.getSiteEngNameTf().sendKeys("Amit");
		SEPage.getContctNoSiteEnggTf().sendKeys("8775444323");
		Thread.sleep(2000);
		SEPage.getEmailtf().sendKeys("amit@yopmail.com");
		SEPage.getSitEenggAddressTf().sendKeys("kothrud");
		Thread.sleep(2000);
		//click on update
		SEPage.getUpdatebtn().click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 17)
	public void CheckThat_InViewBeneficiary_VendoriSAbleToSubmitStatus() throws InterruptedException
	{
		
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		SEPage.getViewBeneficiary().click();
		
		//handle schemeNamedrop
		WebElement drop = SEPage.getSchemeName();
		wutils.SelectDropdown(drop, 1);
		
//		Select s = new Select(drop);
//		List<WebElement> Schemedropdown = s.getOptions();
//		
//		for(int i=0; i<= Schemedropdown.size();i++)
//		{
//			s.selectByIndex(i);
//			Thread.sleep(1000);
//			System.out.println(Schemedropdown.get(i).getText());
//		}
		
	   // Check if the dropdown has options
	     WebElement Distdropdown1 =  SEPage.getDistViewBeneficiary();
		 Select S = new Select(Distdropdown1);
		
		  if(S.getOptions().size() > 1)
		  {
	         S.selectByIndex(0);
	      } 
		  else 
		  {
			    softassert.fail("Dropdown " + Distdropdown1.getText() + " doesn't have any options.");
		
	      }
		 
		  driver.navigate().back();
		  Thread.sleep(4000);
	    //handle taluka drop
	    wutils.SelectDropdown(SEPage.getTalukaViewBeneficiary(), 0);
	    
	    //village drop
	    wutils.SelectDropdown(SEPage.getVillageViewBeneficiary(), 0);
	    
	    //status drop
	    wutils.SelectDropdown(SEPage.getStatusViewBeneficiary(), 2);
	    
	    //submit btn
	    SEPage.getSubmitbtnofViewBenef().click();
	    
	   
	    Thread.sleep(2000);
		
	}
	
	@Test(priority = 18)
	public void CheckVendorIsAbleToTrackBeneficiary() throws InterruptedException
	{
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		//click on tracking btn 
		SEPage.getViewTracking().click();
		
		//select any one opt
		wutils.SelectDropdown(SEPage.getTrackSchemedrop(), 1);
		Thread.sleep(1000);
		//choose dist drop
		wutils.SelectDropdown(SEPage.getTrackdistrictdrop(), 3);
		Thread.sleep(1000);
		//taluka drop
		wutils.SelectDropdown(SEPage.getTracktaluka(), 2);
		Thread.sleep(1000);
		//village drop
		
		wutils.SelectDropdown(SEPage.getTrackvillagedrop(), 2);
		Thread.sleep(2000);
		//click on search
		
		SEPage.getTrackSearchbtn().click();	
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 19)
	public void VerifyVendorIsAbleToDeleteSiteEnggListorData() throws InterruptedException
	{
		SiteEnggModule_Page SEPage = new SiteEnggModule_Page();
		PageFactory.initElements(driver, SEPage);
		
		if(SEPage.getDeletebtn().isDisplayed())
		{
			System.out.println("Delete Button Is Present on Site Engg Table List");
		}
		else
		{
			System.out.println("Delete Button Is not Present on Site Engg Table List");
		}
		
		
		//click on delete button
		SEPage.getDeletebtn().click();
		Thread.sleep(1000);
		//do not delet
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		
	}
	
	//-------------------------------------------------Staff Module -----------------------------------------
	
	
	@Test(priority = 20)
	public void Verify_StaffModule_Functionality() throws InterruptedException
	{
		
		Staff_Mod_Page smp = new Staff_Mod_Page();
		PageFactory.initElements(driver, smp);
		
	    //click on staff Module
	   smp.getStaffModLink().click();
		
	   Thread.sleep(2000);
	   
	   if(smp.getStaffListinTable().isDisplayed())
	   {
		   System.out.println("After Click on Staff Module Staff List Are Dispayed..!");
	   }
	   else
	   {
		   System.out.println("After Click on Staff Module Staff List Are not Dispayed..!");
	   }
		
		Thread.sleep(2000);
	}
		
		@Test(priority = 21)
		public void CheckThatUserisActiveOrNoT_IN_StaffModule() throws InterruptedException
		{
			
			Staff_Mod_Page smp = new Staff_Mod_Page();
			PageFactory.initElements(driver, smp);
			
			
			List<WebElement> ActiveUser = driver.findElements(By.xpath("//span[text()='Active']"));
			
			List<WebElement> UserName = driver.findElements(By.xpath("//tbody//tr//td[3]"));
			
			for(int i=0 ; i< ActiveUser.size();i++)
			{
			     
				 WebElement ActiveUserElements = ActiveUser.get(i);
				 WebElement UserNameElement = UserName.get(i);
				 
				 
				String username1 = UserNameElement.getText();
				
				if(ActiveUserElements.isDisplayed())
				{
					 System.out.println(username1 + " is active");
				}
				else
				{
					 System.out.println(username1 + " is inactive");
				}	
				
			}
			Thread.sleep(2000);
		}
		
		
		@Test(priority = 22)
		public void VerifyUserIsAbleToAddNewStaff() throws InterruptedException
		{
			
			Staff_Mod_Page smp = new Staff_Mod_Page();
			PageFactory.initElements(driver, smp);
			
			//click on add staff
			smp.getADDStaf().click();
			
			Thread.sleep(1000);
			//dropdown 
			wutils.SelectDropdown(smp.getUserTypeDrop(), 1);
			
			//name 
			smp.getNameTf().sendKeys("Tejas");
			Thread.sleep(1000);
			//contact tf
			smp.getContactTf().sendKeys("7083006015");
			
			//email Tf
			smp.getEmailTf().sendKeys("tejas@123gmail.com");
			Thread.sleep(1000);
			//radio button For user active or not
			WebElement radiobtn = smp.getRadiobtn();
			
			radiobtn.click();
			
			
			Thread.sleep(2000);
			
			if(radiobtn.isSelected())
			{
				System.out.println("Radio Button is Selected");
			}
			else
			{
				System.out.println("Radio Button is not Selected");

			}
			
			Thread.sleep(1000);
			
			smp.getAddressTf().sendKeys("Amravati");
			
			Thread.sleep(2000);
			
			smp.getSubmitbtn().click();
			
			Thread.sleep(3000);
			//conformation Altert
			System.out.println(driver.switchTo().alert().getText());
			
			//handle alert
			
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			
			driver.navigate().back();
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority = 23)
		public void VerifyUserisAbletoEdit_PerticularStaffData() throws InterruptedException
		{
			
			
			Staff_Mod_Page smp = new Staff_Mod_Page();
			PageFactory.initElements(driver, smp);
			
			//click on edit btn
			smp.getEditbtn().click();
			
			smp.getNameTf().clear();
			smp.getEmailTf().clear();
			smp.getAddressTf().clear();
			smp.getContactTf().clear();
			
			
			Thread.sleep(1000);
			//dropdown 
			wutils.SelectDropdown(smp.getUserTypeDrop(), 1);
			
			//name 
			smp.getNameTf().sendKeys("Tejas11");
			Thread.sleep(1000);
			//contact tf
			smp.getContactTf().sendKeys("7083006015");
			
			//email Tf
			smp.getEmailTf().sendKeys("tejas@1gmail.com");
			Thread.sleep(1000);
			//radio button For user active or not
			WebElement radiobtn = smp.getRadiobtn();
			
			radiobtn.click();
			
			
			Thread.sleep(2000);
			
			if(radiobtn.isSelected())
			{
				System.out.println("Radio Button is Selected");
			}
			else
			{
				System.out.println("Radio Button is not Selected");

			}
			
			Thread.sleep(1000);
			
			smp.getAddressTf().sendKeys("Pune");
			
			Thread.sleep(2000);
			
			smp.getUpdatebtn().click();
			
			//conformation Altert
			System.out.println(driver.switchTo().alert().getText());
			
			//handle alert
			
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority = 24)
		public void VerifyUserIsAbleToDelete_PerticularStaffListData() throws InterruptedException
		{
			
			Staff_Mod_Page smp = new Staff_Mod_Page();
			PageFactory.initElements(driver, smp);
			
			if(smp.getDeletebtn().isDisplayed())
			{
				System.out.println("Delete Button Is Present on Staff List Table");
			}
			else
			{
				System.out.println("Delete Button is not present on Staff List Table");
			}
			
			//click on delete
			smp.getDeletebtn().click();
			
			Thread.sleep(2000);
			//handle alert
			driver.switchTo().alert().dismiss();
				
			Thread.sleep(2000);
		}
		
		//------------------------------Work Order -----------------------------------------
		
		@Test(priority = 25)
		public void validate_Functionality_of_WorkOrder_Module() throws InterruptedException
		{
			
			WorkOrder_Page wp = new WorkOrder_Page();
			PageFactory.initElements(driver, wp);
			
			//click on WorkOrder
			wp.getWorkOrder().click();
			
			Thread.sleep(2000);
			
//			String ExpCurrentUrl = driver.getCurrentUrl();
//			String ActualUrl = "https://innoproduction.in/meda/meda_vendor/work_order";
//			
//			Assert.assertEquals(ExpCurrentUrl,ActualUrl);
//			
			if(wp.getSchemeDrop().isDisplayed())
			{
				System.out.println("Scheme dropdown is Present on Current page");
			}
			else
			{
				
			System.out.println("Scheme dropdown is notb Present on Current page");
			
			}
			Thread.sleep(2000);
		}
		
		
		@Test(priority = 26)
		public void ValidateSchemeDropdown_of_WorkOrderModule() throws InterruptedException
		{
			
			WorkOrder_Page wp = new WorkOrder_Page();
			PageFactory.initElements(driver, wp);
			
			WebElement drop = wp.getSchemeDrop();
			Select s1 = new Select(drop);
		    List<WebElement> options = s1.getOptions();
		    Thread.sleep(2000);
		   	
		    	if(options.isEmpty())
		    	{
		    		System.out.println("Option is not Visible in Scheme Dropdown");
		    	}
		    	else
		    	{
		    		System.out.println("Options is Visible in Scheme Dropdown");

		    	}
		    	Thread.sleep(2000);
		  
		}
		
	        @Test(priority = 27)
		    public void ValidateAfterSelectingDropdownOptions() throws InterruptedException
		    {
	        	
	        	WorkOrder_Page wp = new WorkOrder_Page();
				PageFactory.initElements(driver, wp);
				
				WebElement drop = wp.getSchemeDrop();
				Select s1 = new Select(drop);
			    List<WebElement> options = s1.getOptions();
			    
			    for(int i=0; i<options.size();i++)
			    {

			    		s1.selectByIndex(i);
			    		Thread.sleep(2000);
			    		
			    		if(options.size()==i)
			    		{
			    			
			    		 WebElement WorkOrderTable = wp.getWorkordertable();
			    		
			    		 boolean workOrdertable1 = WorkOrderTable.isDisplayed();
			    		
			    		 System.out.println("Work Order Detailed are Displayed   :"  + workOrdertable1 );
			    	
			    		}
			    }	 
		    	
		    }
		  
	        @Test(priority = 28,enabled = false)
	        public void ValidateWorkOrderZipFile()
	        {
	        	WorkOrder_Page wp = new WorkOrder_Page();
				PageFactory.initElements(driver, wp);
				
				if(wp.getWorkOrderZip().isDisplayed())
				{
					System.out.println("Zip File Present in Work order Module");
				}
				else
				{
					System.out.println("Zip File is not Present in Work Order Module");
				}
	        	
	        	
	        }
	        
       //------------------------------------Payment----------------------------------------
		    
		@Test(priority = 29)	
		public void validatePaymentFunctionality() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			//mouse Hover on Paymenet
			wutils.Action(driver,pp.getPayment());
			
			Thread.sleep(2000);
			
			WebElement PaymentProgress = pp.getPaymentProgresslink();
			
			if(PaymentProgress.isDisplayed())
			{
				System.out.println("After Mouse Hover on payment, Payment progress option is displayed");
			}
			else 
			{
				System.out.println("Not Displayed");
			}
			
			
			wutils.Action(driver,pp.getPayment());
			
			Thread.sleep(2000);
			
			if(pp.getPaymentRaised().isDisplayed())
			{
				System.out.println("Testcase Passed");
			}
			else
			{
				System.out.println("Testcase Failed");
			}
			
			Thread.sleep(4000);
		}
			
		@Test(priority = 30)
		public void ValidateAfterClickonPaymentProgress() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			//wutils.Action(driver,pp.getPayment());

			
			//click on ProgressLink
			pp.getPaymentProgresslink().click();
			Thread.sleep(2000);
			
			
			//validate schemdrop
			WebElement schemedrop1 = pp.getSchemeDropdown();
			Select s2 = new Select(schemedrop1);
			List<WebElement> option = s2.getOptions();
			
			for(int i =0; i< option.size(); i++)
			{
				s2.selectByIndex(i);
				Thread.sleep(2000);

			}
			
			Thread.sleep(2000);

			
         driver.navigate().refresh();
         
		}
		
		@Test(priority = 31)
		public void VendorisAbleToSeePaymentProgressReport() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			wutils.SelectDropdown(pp.getPaymentraiseDrop(), 1);
			
			Thread.sleep(2000);
			
			wutils.SelectDropdown(pp.getSchemeDropdown(), 2);
			
			Thread.sleep(2000);
			
			wutils.SelectDropdown(pp.getDistDrop(), 1);	
			
			driver.navigate().refresh();
			
			Thread.sleep(2000);
			
		}
		
		@Test(priority = 32)
		public void VerifyUserIsAble_To_RaiseThePayment() throws InterruptedException
		{
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			//select option 2
			wutils.SelectDropdown(pp.getSchemeDropdown(), 2);
			
			//select at least one beneficiary
			WebElement CheckboxinTable = pp.getBeneficiary();
			CheckboxinTable.click();
			
		    Thread.sleep(2000);
			if(CheckboxinTable.isSelected())
			{
				System.out.println("CheckBox Is Selected");
			}
			else
			{
			    System.out.println("CheckBox Is not selected");
			}

			
			//click on raise payment
			pp.getRaisePaymentbtn().click();
			
			Thread.sleep(2000);
			
			driver.switchTo().alert().dismiss();
			
			Thread.sleep(2000);
			
			driver.navigate().back();
			Thread.sleep(2000);
		  	
		}
		
		@Test(priority = 33)
		public void VerifFunctionalityofPaymentRaised() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			wutils.Action(driver,pp.getPayment());
			
			pp.getPaymentRaised().click();
			Thread.sleep(2000);
			
			 WebElement Drop = pp.getSchemedropInPaymentRaise();
			 Select s1 = new Select(Drop);
			  List<WebElement> opt = s1.getOptions();
			  
			  for(int i=0;i<opt.size();i++)
			  {
				  s1.selectByIndex(i);
				  Thread.sleep(2000);
			  }
			  
			  Thread.sleep(2000);
			  //invoice no tf
			WebElement tf = pp.getInvoioceNoTf();
			boolean tf1 = tf.isDisplayed();
			System.out.println("Innovice tf is displyed  :" +  tf1);
			
			Thread.sleep(2000);
			  //beneficiary id
			WebElement appnoTf= pp.getApplicationNoTf();
			boolean appnoTf1 = appnoTf.isEnabled();
			System.out.println("Application No tf is Enabled :" + appnoTf1);
			
		}
		
		@Test(priority = 34)
		public void CheckThatVendorIsAbleToSubmitRaiseInvoice() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			//select 2nd option
			wutils.SelectDropdown(pp.getSchemedropInPaymentRaise(),1);
			Thread.sleep(2000);
			//invoice nO TF
			
			pp.getInvoioceNoTf().sendKeys("3646");
			
			//application no tf
			
			pp.getApplicationNoTf().sendKeys("Mk98947747");
			Thread.sleep(2000);
			
			//click on submit
			
			pp.getSubmitbtn().click();
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority = 35)
		public void VerifyUserIsAbleToseeBeneficiaryInVoice() throws InterruptedException
		{
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			
            wutils.Action(driver,pp.getPayment());
			
			pp.getPaymentRaised().click();

			Thread.sleep(2000);
			pp.getViewbtn1().click();
			Thread.sleep(2000);
			
			pp.getApplicationNOINview1Tf().click();
			
			Thread.sleep(2000);
			
			if(pp.getInvoicetavleList().isDisplayed())
			{
				System.out.println("After Click on View1 Beneficiary Invoice is  displayed");
				
			}
			else
			{
				System.out.println("After Click on View1 Beneficiary Invoice is not displayed");
				
			}
			
		}
		
		@Test(priority = 36)
		public void VerifyVendorIsABLE_TO_SearchBenefiaryInvoice() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			WebElement ViewSchemeDrop = pp.getSchemedropinView();
			wutils.SelectDropdown(ViewSchemeDrop, 2);
			
			Thread.sleep(2000);
			
			pp.getApplicationNOINview1Tf().sendKeys("MK14043367");
			Thread.sleep(2000);
			
			pp.getSearchbtnView1().click();
			
			driver.navigate().back();
		}
		
		
		@Test(priority = 37)
		public void VerifyVendorIsAbleToTrackTrackBeneficiaryFiles() throws InterruptedException
		{
			
			Payment_Page pp = new Payment_Page();
			PageFactory.initElements(driver, pp);
			
			//click on trackFile 
			pp.getTrackFile().click();
			Thread.sleep(2000);
			
			boolean tracklistTable = pp.getFileTrackList().isDisplayed();
			System.out.println(tracklistTable);
			
		    Thread.sleep(2000);
		    
		    pp.getClosebtn().click();
		    Thread.sleep(2000);
			
		}	
		
		//---------------------------------------Grievance -----------------------------------------
		
		@Test(priority = 38)
		public void ValidateFunctionalityGrievanceModule() throws InterruptedException
		{
			
		  Grievance_Page gp = new Grievance_Page();
		  PageFactory.initElements(driver, gp);
		  
		  //click on Grievance Module
		  gp.getWebelegrievanceModule().click();
		  
		  Thread.sleep(2000);
		  
		  WebElement Schemedropdown = gp.getSchemeDrop();
		  
		  Select s = new Select(Schemedropdown);
		  List<WebElement> opt = s.getOptions();
		  for(int i=0;i< opt.size();i++)
		  {
			  s.selectByIndex(i);
			  Thread.sleep(2000);
		  }
		  
		  Thread.sleep(2000);
		  
		  //click on submit 
		  gp.getSubmitbtn().click();
		  
		  Thread.sleep(2000);
		  
		  gp.getCanclebtn().click();
			
			
		}
		
		@Test(priority = 39)
		public void VerifyVendorIsAbleToSeeGrievances() throws InterruptedException
		{
			  Grievance_Page gp = new Grievance_Page();
			  PageFactory.initElements(driver, gp);
			  
			  //select scheme in drop
			  wutils.SelectDropdown(gp.getSchemeDrop(),1);
			  Thread.sleep(2000);
			  //Click on submit
			  gp.getSubmitbtn().click();
			  
		}
		
		@Test(priority = 40)
		public void CheckThta_Name_Status_AndGrievanceinTable() throws InterruptedException
		{
			
			Grievance_Page gp = new Grievance_Page();
			PageFactory.initElements(driver, gp);

			List<WebElement> grievance = driver.findElements(By.xpath("//tbody//td[9]"));
			List<WebElement> Name = driver.findElements(By.xpath("//tbody//td[2]"));
			List<WebElement> Status = driver.findElements(By.xpath("//tbody//td[7]"));
				
		for(int p= 1 ; p<=2; p++)
		{
			
		    for (int i = 0; i < 10; i++) 
		    {
		    	
		        String name = Name.get(i).getText();
		        String status = Status.get(i).getText();
		        String Grievance = grievance.get(i).getText();

		        System.out.println("Name: " + name + ", Status: " + status + ", Grievance: " + Grievance);  
		        
		    }

		   String pagenation = Integer.toString(p);
		   WebElement page = driver.findElement(By.xpath("//ul[@class='pagination justify-content-center']//li//a[text()= '" + pagenation + "']")); 
		   wutils.ActionClick(driver, page);    
		}
		    
		    Thread.sleep(2000);
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll up the page
	        js.executeScript("window.scrollTo(0, 0)");
	        
	        Thread.sleep(2000);
		    gp.getCanclebtn().click();
		   
			Thread.sleep(2000);
			
		}
		
		@Test(priority = 41)
		public void ValidateAferGettingGrievanceVendorisAbleToAllocateSiteEngg() throws InterruptedException
		{
			 
			Grievance_Page gp = new Grievance_Page();
			 PageFactory.initElements(driver, gp);
			  
			 
			  Thread.sleep(2000);
			  wutils.SelectDropdown(gp.getSchemeDrop(), 1);
			  Thread.sleep(2000);
			  
			  gp.getSubmitbtn().click();
			  
			    Thread.sleep(2000);
			    String pagenation = Integer.toString(2);
			    driver.findElement(By.xpath("//ul[@class='pagination justify-content-center']//li//a[text()= '" + pagenation + "']")).click();  
			  
			    Thread.sleep(2000);
			  	
			    wutils.SelectDropdown(gp.getSiteenggDropinTable(), 3);
			    Thread.sleep(2000);
			    driver.switchTo().alert().accept();
			    
			    Thread.sleep(15000);
		}
		
		//-----------------------------------------procurement Management-------------------------------
		
		@Test(priority = 42)
		public void VerifyAfterMouseHover_on_ProcurementManagement() throws InterruptedException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			//mouse hover on  Procurement management
			wutils.Action(driver,pmp.getProcurement());
			
			Thread.sleep(2000);
			
			List<WebElement> webelement = pmp.getLinks_4();
			for(int i=0 ;i<webelement.size();i++)
			{
				
				if(webelement.get(i).isDisplayed())
				{
					pmp.getLinks_4().get(i).click();
					Thread.sleep(3000);
				}
				else
				{
					System.out.println("Elements Are Not Working/Displayed...Test Failed..!");
				}
			
				
				wutils.Action(driver,pmp.getProcurement());	
				
			}
			
			Thread.sleep(2000);
			
		}
		
		@Test(priority = 43)
		public void ValidateFunctionalityofPumpManagement() throws InterruptedException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			//click on pump management
			pmp.getPumpManagement().click();
			Thread.sleep(2000);
			
			//pump scheme
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_Scheme()));
			
			//pump oem name
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_oem_name()));
			
			//pupmptype
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_pumptype()));
			Thread.sleep(2000);
			//pumpsubtype
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_pumpsubtype()));
			
			//pup capacity
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_pumpcapacity()));

			//pump catageory
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_pumpcatagiry()));

			//pump src
			wutils.Select_handleDropdown(new Select(pmp.getPumpmgmnt_pumpsrc()));
           
			Thread.sleep(2000);
            
			pmp.getPumpmgmnt_quantityTF().sendKeys("1111");
			Thread.sleep(2000);
			
			boolean uploadpopup = pmp.getUploadFilePumpMgmnt().isDisplayed();
			System.out.println("Upload Popup Dispaly :" + "Test Passed.." + uploadpopup );
			
			//click on cancle
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
		
		@Test(priority = 44)
		public void UserIsAbletoSubmitPumpManagementInformation() throws InterruptedException, AWTException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_Scheme(), 1);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_oem_name(), 3);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_pumptype(), 1);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_pumpsubtype(), 1);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_pumpcapacity(), 1);
			
			Thread.sleep(2000);
			pmp.getPumpmgmnt_quantityTF().sendKeys("200");
			
			Thread.sleep(2000);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_pumpcatagiry(), 1);
			
			wutils.SelectDropdown(pmp.getPumpmgmnt_pumpsrc(), 1);
			
			//upload file
			wutils.ActionClick(driver,pmp.getUploadFilePumpMgmnt());
			Thread.sleep(2000);
			
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
			
				pmp.getPumpsubmitbtn().click();
				
				Thread.sleep(2000);
				
				driver.navigate().refresh();
				Thread.sleep(2000);
		}
		
		
		@Test(priority = 45)
		public void ValidateDownloadIDsLinks() throws InterruptedException
		{
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			//click on download Id Pdf
			pmp.getDownloadidslink1().click();
			
			Thread.sleep(3000);
			
			 // Get the current URL after the click action
	        String expected = "HTTP ERROR 500---";
	        String actual = driver.getCurrentUrl();
	        
	        // Use SoftAssert to compare expected and actual URLs
	        softassert.assertEquals(actual, expected, "404 error");
	        
//			 if (expected == Actual) 
//			 {
//		            softassert.fail("404 Error");
//		           
//		     }
//			 else
//			 { 
//		            softassert.fail("404 Error");
//			 }
			 
			 Thread.sleep(4000);    
			 driver.navigate().back();

			Thread.sleep(3000);
			
			pmp.getDownloadidslink2().click();
			
			Thread.sleep(2000);

			String expected1 = driver.getCurrentUrl();
			String actual1 = "HTTP ERROR 500---";

			if (expected1 == actual1) 
			{
			    System.out.println("Test Passed");
			}
			else
			{
			    //softassert.assertFalse(true, "Title mismatch: Expected title - " + actual1 + ", Actual title - " + expected1);
				softassert.fail("404 error");
				
			}
            Thread.sleep(2000);
			softassert.assertFalse(false);
			Thread.sleep(6000);
			driver.navigate().back();

			// Call assertAll at the end of your test method
	        softassert.assertAll();
	        
		}
		
		
		@Test(priority = 46)
		public void validateFunctionalityofControllerManagement() throws InterruptedException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			Thread.sleep(4000);
			wutils.Action(driver,pmp.getProcurement());
			
			pmp.getControllerManagement().click();
			
			Thread.sleep(3000);
			
//			//scheme
//			wutils.Select_handleDropdown(new Select(pmp.getControllermgmnt_Scheme()));
//			
//			Thread.sleep(1000);
//			//oem 
//			wutils.Select_handleDropdown(new Select(pmp.getController_oem_name()));	
//			
//			Thread.sleep(2000);
			
		}
		
		@Test(priority = 47)
		public void VerifyVendorisAbletoSee_ControllerManagementList_WithRaisedStatus() throws InterruptedException
		{
			  
			List<WebElement> RaisedStatus = driver.findElements(By.xpath("//tbody//td[4]"));
			
			List<WebElement> ListoemName = driver.findElements(By.xpath("//tbody//td[2]"));
			
			  for (int i = 0; i < 2; i++) 
			    {
			    	
			        String raisedstatus = RaisedStatus.get(i).getText();
			        String listoemname = ListoemName.get(i).getText();

			        System.out.println("listoemname: " + listoemname + ", raisedstatus: " + raisedstatus );  
			        
			    }
			
			driver.navigate().refresh();
			Thread.sleep(3000);
			
		}
	
		@Test(priority = 48)
		public void VerifyVendorisAbleToSubmitControllerManagement() throws AWTException, InterruptedException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			wutils.SelectDropdown(pmp.getControllermgmnt_Scheme(), 1);
			
			Thread.sleep(2000);
			wutils.SelectDropdown(pmp.getController_oem_name(), 3);
			Thread.sleep(2000);
			
			wutils.ActionClick(driver,pmp.getUploadControlerFile());
			
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

			//click on Submit
			pmp.getControllersubmitbtn().click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			
		}
		
		@Test(priority = 49)
		public void VerifyVendorisabletoGneratePassword() throws AWTException, InterruptedException
		{
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			//click on password genrate link
			pmp.getGenratePassword().click();
			Thread.sleep(2000);
			
            wutils.ActionClick(driver,pmp.getUploadControlerFile());
			

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

			//click on submit
			//pmp.getControllersubmitbtn().click();
			
			pmp.getControl_gen_passcanclebtn().click();
			Thread.sleep(3000);
			
		}
		
		@Test(priority = 50)
		public void TestRMSDATA() throws InterruptedException 
		{
			
		    procurement_ManagmentPage pmp = new procurement_ManagmentPage();
		    PageFactory.initElements(driver, pmp);

		    wutils.Action(driver, pmp.getProcurement());
		    pmp.getControllerManagement().click();

		    pmp.getTestRmsData().click();

		    wutils.SwitchtoMethod(driver);

		    Thread.sleep(3000);

		    boolean rmsDataExists = false; 
		    
		    softassert.fail(rmsDataExists + "500 error");

		    Thread.sleep(4000);
		   

		    driver.close();

		    wutils.ChildtoParentSwitch(driver);
		    
		    softassert.assertAll();
		    
		    Thread.sleep(2000);
		    
		}
		
		@Test(priority = 51)
		public void validateVendorisAbleToSubmitPanelManagementInfo() throws InterruptedException, AWTException
		{
			
			 procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			 PageFactory.initElements(driver, pmp);

			 wutils.Action(driver, pmp.getProcurement());
			 Thread.sleep(2000);
			 pmp.getPanelManagement().click();
			 
			 //scheme drop
			 wutils.SelectDropdown(pmp.getPanelmgmnt_Schemedrop(), 1);
			 
			 //orm drop
			 wutils.SelectDropdown(pmp.getPanel_oem_name(), 1);
			 
			 Thread.sleep(2000);
			 //panel type
			 pmp.getPanel_typeTf().sendKeys("DC");
			 
			 Thread.sleep(2000);
			 //panel capacity
			 pmp.getPanel_capacityTf().sendKeys("335");
			 
			 //size tf
			 pmp.getPanelSizeTf().sendKeys("12");
			 
			 Thread.sleep(3000);
			 
			 //upload iec certi
			wutils.ActionClick(driver,  pmp.getPaneliac_certificateUpload());
			
			Robot rb = new Robot();
			rb.delay(2000);
			
			//copyfile to clipboard
			StringSelection ss = new StringSelection("C:\\Users\\Innosystech_8_Pc_5\\Downloads\\hexagon.pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			wutils.RobotClass();
			 
			Thread.sleep(3000);
			
			//upload ids
			wutils.ActionClick(driver,pmp.getPanel_idertificateupload());
			
			//copyfile to clipboard
			StringSelection ss1 = new StringSelection("C:\\Users\\Innosystech_8_Pc_5\\Downloads\\controller_id_csv_format.csv");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			
			wutils.RobotClass();
			
			Thread.sleep(2000);
			//click on submit
			pmp.getPanelsubmitbtn().click();
			Thread.sleep(2000);
			pmp.getOkpopup().click();
			
			Thread.sleep(4000);
			
		}
		
		@Test(priority = 52)
		public void ClickonPanelManagementandCheckPanelMgmtListAreDisplayedorNot() throws InterruptedException
		{
			
			 procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			 PageFactory.initElements(driver, pmp);
			 
			 wutils.Action(driver, pmp.getProcurement());
			 Thread.sleep(2000);
			 pmp.getPanelManagement().click();
			 Thread.sleep(2000);
			 
			 if(pmp.getPanelmgmtList().isDisplayed())
			 {
				 System.out.println("Panel Management List are Displayed");
			 }
			 else
			 {
				 System.out.println("Panel Management List are not Displayed");

			 }
			 
			 Thread.sleep(4000);
			 
		}
		
		@Test(priority = 53)
		public void ValidatePanelManagementCertificateView() throws InterruptedException
		{
			
			procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			PageFactory.initElements(driver, pmp);
			
			
			pmp.getPanelView1().click();
			
			Thread.sleep(2000);
			wutils.SwitchtoMethod(driver);
			
			Thread.sleep(3000);
			
			softassert.fail("404 Page Found");
			
		    Thread.sleep(4000);
		    
		    driver.close();
		    
		    wutils.ChildtoParentSwitch(driver);
		    
		    softassert.assertAll();
		    
		    Thread.sleep(3000);
			
		}

        @Test(priority = 54)
		public void Validate_VendorisAbleTo_AddStructure() throws InterruptedException
		{
        	 procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			 PageFactory.initElements(driver, pmp);
			 
			 wutils.Action(driver, pmp.getProcurement());
			 Thread.sleep(2000);
			 
			 pmp.getStructureMgmt().click();
			 Thread.sleep(2000);
			 
			 pmp.getSteel_typeTf().sendKeys("10hp");
			 Thread.sleep(2000);
			 
			 wutils.SelectDropdown(pmp.getGalvanizedrop(), 1);
			 Thread.sleep(2000);
			 
			 wutils.SelectDropdown(pmp.getCoaxial_Manual_trackerDrop(), 1);
			 Thread.sleep(2000);
			 
			 //click on submit
			 pmp.getStructmgmtsubmitbtn().click();	 
			 
			 Thread.sleep(1000);
			 pmp.getOkpopup().click();	 
			 Thread.sleep(3000);    	
		}
        
        @Test(priority = 55)
        public void ValidateVendorIsAble_ToRemoveStructure_AfterCreate() throws InterruptedException
        {
        	
        	 procurement_ManagmentPage pmp = new procurement_ManagmentPage();
			 PageFactory.initElements(driver, pmp);
			 
			 pmp.getStructureDeletebtn().click();
			 Thread.sleep(2000);
			 
			 if(pmp.getStructRemovepopup().isDisplayed())
			 {
				 System.out.println("After Click Delete Popup displayed");
				 Thread.sleep(1000);
				 pmp.getCanclebtnpopup().click();
			 }
			 else
			 {
				 
				 System.out.println("After Click Delete Popup not displayed");
				 Thread.sleep(2000);
				 pmp.getYesbtnpopup().click();
			 }
        	
        }
		
	//----------------------------Policy Management -----------------------------------------------------
        
        @Test(priority = 56)
        public void  ValidatePolicyManagementUI() throws InterruptedException
        {
        	
        	Policy_ManagementPage pmp = new Policy_ManagementPage();
        	PageFactory.initElements(driver, pmp);
        	
        	pmp.getPolicymanagement().click();
        	
        	if(pmp.getPolicyDrop().isDisplayed())
        	{
        		wutils.SelectDropdown(pmp.getPolicyDrop(), 1);
        	}
        	else
        	{
        		System.out.println("option not availabe in policy dropdown...");
        	}	
        	
        	Thread.sleep(2000);
        	
        	if(pmp.getSubmitbtn().isDisplayed())
        	{
        		System.out.println("Submit button is present on Policy management page");
        	}
        	else
        	{
        		System.out.println("Submit button is present on Policy management page");
        	}
        	
        	Thread.sleep(2000);
        	String cancle = pmp.getCancelbtn().getText();
        	System.out.println(cancle + "button is present");
        	
        	driver.navigate().refresh();
        	
        }
        
        @Test(priority = 57)
		public void verifyVendorisAbletoSubmitBeneficiaryPolicy() throws InterruptedException, AWTException
		{
        	
        	Policy_ManagementPage pmp = new Policy_ManagementPage();
        	PageFactory.initElements(driver, pmp);
        	
        	if(pmp.getPolicyDrop().isDisplayed())
        	{
        		wutils.SelectDropdown(pmp.getPolicyDrop(), 1);
        	}
        	else
        	{
        		System.out.println("option not availabe in policy dropdown...");
        	}	
        	
        	Thread.sleep(3000);
        	//insurance name 
        	pmp.getInsurance_company_nameTf().sendKeys("Innover systech");
        	
        	Thread.sleep(2000);
        	//policy num
             WebElement policynum1 = pmp.getPoli_num_Tf();
             policynum1.sendKeys("1234"); 
             
             Thread.sleep(2000);
             
           //dropdown
             wutils.SelectDropdown(pmp.getPolicyPeriodDrop(), 1);
             
             pmp.getFromdate_pickerTf().sendKeys("10-12-2022");
             
             Thread.sleep(2000);
             
             pmp.getTodatelast().sendKeys("10-08-2023");
             
             Thread.sleep(2000);
             
             wutils.ActionClick(driver,pmp.getPolicyuploadfile());
             

 		    Robot rb = new Robot();
 			rb.delay(2000);
 			
 			//copyfile to clipboard
 			StringSelection ss = new StringSelection("C:\\Users\\Innosystech_8_Pc_5\\Downloads\\Image2.jpeg");
 			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
 			
 			wutils.RobotClass();
 			
 			//click on select beneficiary
 			//pmp.getSelectbeneficiary().click();
 			
 			Thread.sleep(2000);
 			//click on submit btn
 			pmp.getSubmitbtn().click();
 			
 			wutils.waitForElementToBeClickable(driver,pmp.getOkbtn(),10).click();
 			Thread.sleep(2000);
 			
 			driver.navigate().refresh();
 			
 			Thread.sleep(3000);
 		
		}
        
        
        @Test(priority = 57)
		public void verifyVendorisAbletoSelectBeneficiary() throws InterruptedException, AWTException
		{
        	
        	Policy_ManagementPage pmp = new Policy_ManagementPage();
        	PageFactory.initElements(driver, pmp);
		
        	
        	if(pmp.getPolicyDrop().isDisplayed())
        	{
        		wutils.SelectDropdown(pmp.getPolicyDrop(), 1);
        	}
        	else
        	{
        		System.out.println("option not availabe in policy dropdown...");
        	}	
        	
        	Thread.sleep(2000);
        	
        	//click on select beneficiary
 			pmp.getSelectbeneficiary().click();
 			
 			Thread.sleep(2000);
 			
 			//schem drop after click on select beneficiary
 			wutils.SelectDropdown(pmp.getSchemeBenfdrop(), 2);
 			
 			Thread.sleep(2000);
 			wutils.SelectDropdown(pmp.getDistdrop(), 2);

 			Thread.sleep(2000);
 			
 			wutils.SelectDropdown(pmp.getTalukadrop(), 2);
 			
 			Thread.sleep(2000);
 			
 			wutils.SelectDropdown(pmp.getVillagedrop(), 2);
 			

 			Thread.sleep(2000);
 			//click on submit
 			
 			pmp.getSubmitbtnbenficiary().click();

 			Thread.sleep(2000);
 			
 			pmp.getClosebtn().click();
 			
 			Thread.sleep(2000);
        	
	}
        //------------------------------------------PDI Module-----------------------------
        
        
        @Test(priority = 58)
        public void ValidateAfterClickonController() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	//mouse hover on pdi module
            wutils.Action(driver,pmp.getPDImodule());
            //click on controller
             pmp.getPdi_Controller().click();
            
            Thread.sleep(2000);
            
            //validate table dta after click on controller
            List<WebElement> _1strow = pmp.getController_1stSColumnRow();
            
            List<WebElement> _AllRows = pmp.getController_rows();
            
            StringBuilder rowText = new StringBuilder();

            for(int i = 0; i < _1strow.size(); i++) 
            {
                rowText.append(_1strow.get(i).getText()).append("              ");
            }

            System.out.println(rowText.toString());
            
            Thread.sleep(2000);
            

            StringBuilder allrow = new StringBuilder();

            for(int i = 0; i < _AllRows.size(); i++) 
            {
            	allrow.append(_AllRows.get(i).getText()).append("     ");
            	System.out.println("                                           ");
            }
            
            System.out.println(allrow.toString());   
            
            Thread.sleep(3000);
        	    	
        }
        
        @Test(priority = 59)
        public void VerifyUserisAbletoSee_ControllerDetailsofPDI() throws InterruptedException
        {
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	pmp.getController_details().click();
        	
        	Thread.sleep(3000);
        	
        	WebElement crdp = pmp.getControllerDetailpage();
        	
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	 js.executeScript("arguments[0].scrollTop += 300;", crdp);  
        	
            List<WebElement> ControllerDetails = driver.findElements(By.xpath("//table[@class='table table-hover']//tr"));
            int totalrows = ControllerDetails.size();
            System.out.println(totalrows);
      
        
            for(int i=0; i< ControllerDetails.size();i++)
            {
        		 System.out.println(ControllerDetails.get(i).getText());  
             	System.out.println("                                           ");

            }
          
            Thread.sleep(2000);
         }
        
        @Test(priority = 60) 
        public void VerifyImagesisDisplayedorNotINControllerDetailsPopup() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	
           // WebElement crdp = pmp.getControllerDetailpage();
        	

            List<WebElement> controllerImages = pmp.getControllerDetailImg();
         
            for(int i=0;i<controllerImages.size(); i++)
            {
        	   if(controllerImages.get(i).isDisplayed())
        	   {
        		 System.out.println(controllerImages.get(i).getText() + "Image is Display");
             	System.out.println("                                           ");

        	   }
        	   else
        	   {
        		   
        		 System.out.println("Image is not Display on Controller details page");

        	    }
             }	
            
            Thread.sleep(2000);
            pmp.getClosebtn().click();
            Thread.sleep(2000);
         }
        
        
        @Test(priority = 61)
        public void ValidateAfterClickonSetPump() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	//mouse hover on pdi module
            wutils.Action(driver,pmp.getPDImodule());
            //click on controller
             pmp.getSetPumplink().click();
            
            Thread.sleep(2000);
            
            //validate table after click on Pump Set
            List<WebElement> setpump_1strow = pmp.getSetpump_1stSColumnRow();
            
            List<WebElement> setpump_AllRows = pmp.getSetPump_rows();
            
            StringBuilder SetPumprowText = new StringBuilder();

            for(int i = 0; i < setpump_1strow.size(); i++) 
            {
            	SetPumprowText .append(setpump_1strow.get(i).getText()).append("              ");
            	System.out.println("                                           ");

            }

            System.out.println(SetPumprowText .toString());
            
            
            Thread.sleep(3000);
            

            StringBuilder setPumpallrow = new StringBuilder();

            for(int i = 0; i < setpump_AllRows.size(); i++) 
            {
            	setPumpallrow .append(setpump_AllRows.get(i).getText()).append("     ");
            	System.out.println("                                           ");

            }
            
            System.out.println(setPumpallrow .toString());   
            
            Thread.sleep(3000);
        	    	
        }
        
        @Test(priority = 62)
        public void ValidatePumpSetDetails() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	pmp.getSetpump_details().click();
        	Thread.sleep(2000);
         	
            List<WebElement> setpumpDetail = pmp.getSetPumpDetailsTable();
            int totalrows1 = setpumpDetail.size();
            System.out.println(totalrows1);
      
        
            for(int i=0; i< setpumpDetail.size();i++)
            {
        		 System.out.println(setpumpDetail.get(i).getText());  
             	System.out.println("                                           ");

            }
          
            Thread.sleep(2000);
         }	
        
        
        @Test(priority = 63) 
        public void VerifyImagesisDisplayedorNot_onSetPumpPopup_Page() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
            List<WebElement> setpumpimge  = pmp.getSetPumpImage();
         
            for(int i=0;i<setpumpimge .size(); i++)
            {
        	   if(setpumpimge .get(i).isDisplayed())
        	   {
        		 System.out.println(setpumpimge .get(i).getText() + "Image is Display on set pump details page");
             	System.out.println("                                                      ");

        	   }
        	   else
        	   {
        		   
        		 System.out.println("Image is not Display on set pump details page");

        	    }
             }	
            
            Thread.sleep(2000);
            pmp.getClosebtn().click();
            Thread.sleep(4000);
            
         }
        
        @Test(priority = 64)
        public void ValidateMMSDatails() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	//mouse hover on pdi module
            wutils.Action(driver,pmp.getPDImodule());
            
            Thread.sleep(2000);
            pmp.getMmslink().click();
            
            Thread.sleep(2000);
            
            pmp.getMmsDetails().click();
            
            Thread.sleep(2000);
         	
            List<WebElement> mmsDetail = pmp.getMMSDetailsTables();
            int totalrows2 = mmsDetail .size();
            System.out.println(totalrows2);
      
        
            for(int i=0; i< mmsDetail .size();i++)
            {
        		 System.out.println(mmsDetail .get(i).getText());  
             	System.out.println("                                           ");

            }
          
            Thread.sleep(2000);
         }	
             
        @Test(priority = 65) 
        public void VerifyImagesisDisplayedorNot_onMMSpopUp_Page() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	
            List<WebElement> MMSDetailimge  = pmp.getMmsdetailsImage();
         
            for(int i=0;i<MMSDetailimge .size(); i++)
            {
        	   if(MMSDetailimge.get(i).isDisplayed())
        	   {
        		 System.out.println(MMSDetailimge .get(i).getText() + "Image is Display on MMS details page");
             	System.out.println("                                                      ");

        	   }
        	   else
        	   {
        		   
        		 System.out.println("Image is not Display on MMS details page");

        	    }
             }
            
            Thread.sleep(2000);
            pmp.getClosebtn().click();
            Thread.sleep(2000);   
        }
        
        
        
        @Test(priority = 66)
        public void ValidateModulesatails() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	//mouse hover on pdi module
            wutils.Action(driver,pmp.getPDImodule());
            Thread.sleep(2000);
         	
            
            pmp.getModuleslink().click();
            Thread.sleep(2000);
         	
            pmp.getModulesDetails().click();
            
            List<WebElement> modulesDetail = pmp.getModulesDetailsTables();
            int totalrows2 = modulesDetail.size();
            System.out.println(totalrows2);
      
        
            for(int i=0; i< modulesDetail.size();i++)
            {
        		 System.out.println(modulesDetail.get(i).getText());  
             	System.out.println("                                            ");
  
            }
          
            Thread.sleep(2000);
         }	
             
        @Test(priority = 67) 
        public void VerifyImagesisDisplayedorNot_onModulespopUp_Page() throws InterruptedException
        {
        	
        	PDI_MOD_Page pmp = new PDI_MOD_Page();
        	PageFactory.initElements(driver, pmp);
        	
        	
            List<WebElement> ModuleDetailimge  = pmp.getModulesdetailsImage();
         
            for(int i=0;i<ModuleDetailimge .size(); i++)
            {
        	   if(ModuleDetailimge .get(i).isDisplayed())
        	   {
        		 System.out.println(ModuleDetailimge.get(i).getText() + "Image is Display on MMS details page");
             	System.out.println("                                                      ");

        	   }
        	   else
        	   {
        		   
        		 System.out.println("Image is not Display on MMS details page");

        	    }
             }
            
            Thread.sleep(2000);
            pmp.getClosebtn().click();
            Thread.sleep(2000);   
        }
        
     //-------------------------------equipment modification  request ----------------------------------------
        
       @Test(priority = 68)
       public void VerifyUserisableTosearch_EquipModiRequestListUsingBenfAppNo() throws InterruptedException
       {
    	   
    	   Equipment_Modi_ReqPage emrp = new Equipment_Modi_ReqPage();
    	   PageFactory.initElements(driver, emrp);
    	   
    	   //mouse hover on equpm_modi_req
    	   wutils.Action(driver,emrp.getEqui_mod_req());
    	   
    	   Thread.sleep(2000);
    	   
    	   //click on equip req
    	   emrp.getEqui_ReqLink().click();
    	   
    	   Thread.sleep(2000);
    	   //enter a application no
    	   emrp.getBenfSearchTf().sendKeys("MK1107168087");
    	   
    	   Thread.sleep(2000);
    	   
    	   emrp.getSearchbtn().click();
    	   
    	   Thread.sleep(3000);
    	    
       }
       
       @Test(priority = 69)
       public void VerifyAfterSearchingUserisAbletoClear() throws InterruptedException
       {
    	   
    	   Equipment_Modi_ReqPage emrp = new Equipment_Modi_ReqPage();
    	   PageFactory.initElements(driver, emrp);
    	   
    	   //mouse hover on equpm_modi_req
    	   wutils.Action(driver,emrp.getEqui_mod_req());
    	   
    	   Thread.sleep(2000);
    	   
    	   //click on equip req
    	   emrp.getEqui_ReqLink().click();
    	   
    	   Thread.sleep(2000);
    	   //enter a application no
    	   emrp.getBenfSearchTf().sendKeys("MK1107168087");
    	   
    	   Thread.sleep(2000);
    	   
    	   emrp.getSearchbtn().click();
    	   
    	   Thread.sleep(2000);
    	   
    	    emrp.getClearbtn().click();
    	    
    	    softassert.assertTrue(false);
    	    
     	   // softassert.assertAll();
//    	    
            Thread.sleep(2000);
//    	    
       }
       
       
       @Test(priority = 70)
       public void VerifyUserisableTosearch_EquipModiRequestList_PassingAllBenefDetails() throws InterruptedException
       {
    	   
    	   Equipment_Modi_ReqPage emrp = new Equipment_Modi_ReqPage();
    	   PageFactory.initElements(driver, emrp);
    	   
    	   //mouse hover on equpm_modi_req
    	   wutils.Action(driver,emrp.getEqui_mod_req());
    	   Thread.sleep(2000);
    	   
    	   
    	   emrp.getReq_ListLink().click();
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getSchemedrop(), 2);
    	   Thread.sleep(2000);
    	   wutils.SelectDropdown(emrp.getDistDrop(), 2);

    	   Thread.sleep(2000);
    	   wutils.SelectDropdown(emrp.getTalukaDrop(), 3);
    	   
    	   wutils.SelectDropdown(emrp.getVillageDrop(), 2);
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getRequestStatusDrop(), 1);
    	   
    	   Thread.sleep(2000);
    	 //search app no
    	   
    	   emrp.getSearchbyBenefTf().sendKeys("MK1107168087");
    	   Thread.sleep(2000);
    	   
    	   emrp.getSearchbtn().click();

    	   Thread.sleep(2000);
       
       } 
       
       
       @Test(priority = 71)
       public void VerifyUserisAbleToclearEquipmentListInfo() throws InterruptedException
       {
    	   
    	   Equipment_Modi_ReqPage emrp = new Equipment_Modi_ReqPage();
    	   PageFactory.initElements(driver, emrp);
    	   
    	  
    	   //mouse hover on equpm_modi_req
    	   wutils.Action(driver,emrp.getEqui_mod_req());
    	   Thread.sleep(2000);
    	   emrp.getReq_ListLink().click();
    	   
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getSchemedrop(), 2);
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getDistDrop(), 2);

    	   Thread.sleep(2000);
    	   wutils.SelectDropdown(emrp.getTalukaDrop(), 3);
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getVillageDrop(), 2);
    	   Thread.sleep(2000);
    	   
    	   wutils.SelectDropdown(emrp.getRequestStatusDrop(), 1);
    	   
    	   Thread.sleep(2000);
    	 //search app no
    	   
    	   emrp.getSearchbyBenefTf().sendKeys("MK1107168087");
    	   Thread.sleep(2000);
    	   
    	   emrp.getClearbtn().click();

    	   Thread.sleep(2000);   
       } 
        
        
        
        
        
}    
        
        
	
		
		
	
	


	
	
   



		
	
	

	
		
	 
	   
		
	
	
	
	
	
	
	



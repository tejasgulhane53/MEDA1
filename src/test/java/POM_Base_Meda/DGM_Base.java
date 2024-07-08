package POM_Base_Meda;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common_Utils1.BaseClass1;
import Common_Utils1.ExcelUtils1;
import Common_Utils1.File_Utils1;
import Common_Utils1.Webdriver_Utils1;
import POM_DGM_Pages.DGM_DashboardPanelPage;
import POM_DGM_Pages.DGM_LoginPage;
import POM_DGM_Pages.DGM_StateCentralBeneficiaryPage;

//@Listeners(Listner_Implimantation.class)
public class DGM_Base  extends BaseClass1
{
	
	File_Utils1 futils = new File_Utils1();
	Webdriver_Utils1 wutils = new Webdriver_Utils1();
	ExcelUtils1 Eutils = new ExcelUtils1();
	SoftAssert s_assert = new SoftAssert();
	
  
	@Test(priority = 1)
	public void VerifyDGMLoginPage_WithValidCredential() throws InterruptedException, IOException
	{
		
        String USERNAME = futils.getDataFromPropertiesfileDGMPage("username");
		String PASSWORD = futils.getDataFromPropertiesfileDGMPage("password");
		
		wutils.ImplcitWait(driver);
		
		DGM_LoginPage  dlp = new DGM_LoginPage();
		PageFactory.initElements(driver, dlp);
		
		//Heading of DGM LOGIN
		WebElement DgmLoginHeadingTitle = dlp.getDGMOfficeHeadingTitle();
		if(DgmLoginHeadingTitle.isDisplayed())
		{
			System.out.println("Heading is Displayed"+ DgmLoginHeadingTitle.getText() );
		}
		else
		{
			System.out.println("Heading is not Displayed");
		}
		
		Thread.sleep(1000);
		
		//image of officeField
		boolean OfficefieldImg = dlp.getImgOfficeField().isDisplayed();
		System.out.println("Image is Display on Login Page" + OfficefieldImg);
        Thread.sleep(1000);
        
        // links of dgm login page
        List<WebElement> LoginPageLinks = driver.findElements(By.tagName("//a"));
        
        for(WebElement links : LoginPageLinks)
        {
        	System.out.println("All the Links of Login Page :" + links.getText());	
        }
        
        Thread.sleep(1000);
		
		dlp.getUseremailTf().sendKeys(USERNAME);
		//Thread.sleep(1000);
		dlp.getPasswordTf().sendKeys(PASSWORD);
		//Thread.sleep(3000);
		
		//click on login button
		dlp.getLoginbtn().click();
		
	   // Thread.sleep(1000);
			
	}
	
	
	@Test(priority = 2)
	public void TestDGMDashboard() throws InterruptedException, AWTException
	{
	    //Check that login page and Dashboard Url are same or diff
		wutils.ImplcitWait(driver);
		String LoginUrl = "https://innoproduction.in/meda/uat/office/dgm/";
	    String dashboardurl = driver.getCurrentUrl();
	    
	    if(dashboardurl == LoginUrl)
	    {
	    	System.out.println("url match");
	    }
	    else
	    {
	    	System.out.println("url not matching"); 
	    	
	    }
	    
	    Thread.sleep(1000);
	}
	
	
	    @Test(priority = 3)
	    public void VerifyMahakrushiDropdownofDashboard() 
	    {
	    	
	    DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	    PageFactory.initElements(driver, ddpl);
	    
	   //Mahakrushi Urja Dropdown
	    
	   boolean drop1 = ddpl.getMahakrushiUrjaDropdown().isDisplayed();
	   System.out.println("mahakrushi dropdown is displayed" + drop1);
	   
	   int size = ddpl.getMahakrushiDropdowMultiple().size();
	   System.out.println(size);
	   
	   //Fetch that Option that option
	   
	   for(WebElement opt : ddpl.getMahakrushiDropdowMultiple())
	   {
		   System.out.println("Options displyed of mahakrishi dropdown of dashboard " + opt.getText());
	   }
	   
	   System.out.println("----------------------------------------------------------------------------------");
	   
    }
	
	    @Test(priority = 4)
	    public void ValidateMedaLogoOfDashboard() throws InterruptedException
	    {
	    	DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	 	    PageFactory.initElements(driver, ddpl);
	 	    
	       //logo of meda
	      Rectangle medalogo = ddpl.getDGMLogoImge().getRect();
	      System.out.println(medalogo.getX());
	      System.out.println(medalogo.getY());
	      System.out.println("Height of logo " +medalogo.getHeight());
	      System.out.println("width of logo "+medalogo.getWidth());
	  
	      Thread.sleep(2000);
	  
	    }
	  
	    @Test(priority = 5)
	    public void CheckFullScreenbtnofDashboard() throws InterruptedException, AWTException
	   {
	    	
	    	DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	 	    PageFactory.initElements(driver, ddpl);
	    	
	       //test fullscreen btn working or not
	       wutils.ActionClick(driver,ddpl.getFullscreenbtn());
	       Thread.sleep(2000);
	  
	       Robot rb = new Robot();
	       rb.delay(500);
	       rb.keyPress(KeyEvent.VK_ESCAPE);
	       rb.keyRelease(KeyEvent.VK_ESCAPE);
	       Thread.sleep(2000);
	  
	       //profile logo of Dashboard
	       boolean profileLogo = ddpl.getUserDropdownProfLogo().isDisplayed();
	       System.out.println(" profile logo is displayed  :" + profileLogo  );
	 
	    }
	
	    @Test(priority = 6)
	    public void ValidateImageofsolarpumpofDashboard() throws InterruptedException
	    {
	    	
	    	 DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	 	     PageFactory.initElements(driver, ddpl);
	    	
	         //pumpimage of dashboard
	          boolean imagepump = ddpl.getImgePump().isDisplayed();
	          System.out.println("pump image is displayed  " + imagepump );
	
	          Thread.sleep(1000);
	     }
	    
	    
	    @Test(priority = 7)
	    public void CheckNotificationbtnOfDashboard()
	    {
	    	
	    	 DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	 	     PageFactory.initElements(driver, ddpl);
	
	         //Notification Bar of Dashboard
	 	    
	         if(ddpl.getNotificatiobtn().isDisplayed())
	         {
	        	 
		         System.out.println("Notification Button Is Displayed :   Test Passed ");
		         
	         }
	         else
	         {
	        	 
	         	 System.out.println("Notification Button Is not Displayed :   Test Fail ");

	         }
	      
        }
	
	    
	    
	    
	    
	    
	    @Test(priority = 8)
	    public void VerifyBeneficiaryReportofDashboard() throws InterruptedException
	    {
		
	      	wutils.ImplcitWait(driver);
	        DGM_DashboardPanelPage ddpl  = new DGM_DashboardPanelPage();
	        PageFactory.initElements(driver, ddpl);
	      
	        boolean Beneficiaryreport = ddpl.getBeneficiaryReport().isDisplayed();
	        System.out.println("Beneficiary Report are Displayed :" +  Beneficiaryreport);
	    
	        Thread.sleep(1000);
	   
	    }
	    
	    @Test(priority = 9)
	    public void VerifyBeneficiaryReportValueswithColoumnName() throws InterruptedException 
	   {
		
	       //Fetch that Beneficiary Values
	       List<WebElement> beneficiaryvalues = driver.findElements(By.xpath("//*[local-name()='g' and contains(@class, 'highcharts-data-labels')]//*[name()='tspan']"));
	       System.out.println("Total Beneficiary Values : " + beneficiaryvalues.size());
	  
	       Thread.sleep(3000);
	  
	       String BenefValue = new String();
	       int count = 0;
	  
	       for (WebElement BV : beneficiaryvalues) 
	       {
	           BenefValue = BV.getText();
	          //System.out.println(BenefValue);
	          count++;
	          if (count >= 23) 
	          {
	        	  
	             break; 
	             
	          }
	       }
	      
	        Thread.sleep(2000);

	        // fetch all Columns nemes of beneficiaries
	        List<WebElement> BenefColumnName = driver.findElements(By.xpath("//*[local-name()='g' and contains(@class, 'highcharts-axis-labels highcharts-xaxis-labels')]//*[name()='text']"));
	         
     	     for (int i=0; i< BenefColumnName.size();i++) 
     	     {
     		  
	            WebElement BenifColm = BenefColumnName.get(i);
	      
	            String BenefColumn = BenifColm.getText();
	      
	            System.out.println(BenefColumn + "   : " + beneficiaryvalues.get(i).getText());
	      
	            System.out.println("-------------------------------------------------------------------------------");
	      
	          }
     	     
     	      Thread.sleep(1000);
     	 
	      }
     	   
     	
     	  @Test(priority = 10)
     	  public void VerifyToggleMenuOfBeneficiaryReport() throws InterruptedException
     	  {
     	  
     		DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
     	    PageFactory.initElements(driver, ddpl);
     	    
     	    //Beneficiary Toggle
     	     boolean benfTogMenu = ddpl.getBenfReportToggle().isDisplayed();
     	     System.out.println("Beneficiary Toggle menu is displayed " + benfTogMenu);
     	 
     	     ddpl.getBenfReportToggle().click();
     	  
             Thread.sleep(2000);
          
             List<WebElement> BenfiRepToglSubmdule = driver.findElements(By.xpath("//li[@class='highcharts-menu-item'  and contains(@tabindex,'-1')]"));
          
             for(WebElement BRMenubarsubmdl : BenfiRepToglSubmdule)
             {
            	 
        	   if(BRMenubarsubmdl.isDisplayed())
               {
        		 System.out.println(BRMenubarsubmdl.getText() + " Element is Displyed...Test Paased");
        	   }
        	   else
        	   {
        		 System.out.println("Element are not displayed");
        	   }
        	   
            }
          
     	      	  
	}
    
	@Test(priority = 11)
	public void Test_CastWiseProfile_PieChatOfDashboard() throws InterruptedException
	{
		
		wutils.ImplcitWait(driver);

		DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
		PageFactory.initElements(driver, ddpl);
		
		if(ddpl.getCasteWisePiechartReport().isDisplayed())
		{
			System.out.println("Caste Wise Complited Ragistration Report is Displayed  :" + "Test Passed !");
		}
		else
		{
			System.out.println("Caste Wise Complited Ragistration Report is not Displayed  :" + "Test Failed !");

		}
		
		System.out.println("                                                            ");
		
		Thread.sleep(2000);
		
	}
	
	  @Test(priority = 12)
	    public void TestCastwiseValueWithCasteName()
	   {
		
		List<WebElement> CastWiseReport = driver.findElements(By.xpath("//*[local-name()='g' and contains(@filter,\"none\")]//*[name()='tspan']"));
		
		System.out.println("                                                             ");
		
		System.out.println("All Caste Wise Complited profile :------>");
		
		
		for (int i = 23; i < CastWiseReport.size(); i++) 
		   {
			
		    WebElement Cstrport = CastWiseReport.get(i);
		    
		    String report1 = Cstrport.getText();
		   
		    System.out.println(report1);
		    
			System.out.println("------------------------------------------------------------");
			
			}
		
	    }
	  
		@Test(priority = 13)
		public void VerifyToggleMenuBarOf_PieChart() throws InterruptedException
		{
			
		DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
	    PageFactory.initElements(driver, ddpl);
		
		//Pie chart menu bar
		boolean menubrPieChart = ddpl.getMenubarTogglePieChart().isDisplayed();
		System.out.println("Menu Bar Displayed   :" + menubrPieChart);
		Thread.sleep(1000);
		
		//open toggle of piechart menubar
		ddpl.getMenubarTogglePieChart().click();
		Thread.sleep(2000);
		
		}
		  
		
		@Test(priority = 14)
		public void VerifyAfterClickonPieChartToggleMenu()
		{
			
		
	    //after click on piechart menu bar test all the web elements its displayed all element or not
		//and fetch all web elements
		List<WebElement>  PieChartMenuBarsSubModule = driver.findElements(By.xpath("(//*[local-name()='ul'])[13]//li"));
		
		System.out.println("how meny submodules are displayed : " + PieChartMenuBarsSubModule.size());
		
		    for(WebElement Piechrtsubmodule : PieChartMenuBarsSubModule )
		    {
		    	
		    if(Piechrtsubmodule.isDisplayed()) 
		    {
		        
		        
		        System.out.println(Piechrtsubmodule.getText() + " is Displayed  ---> Test Passed ");
		    } 
		    
		    else
		    {
		        System.out.println(" Menu item not displayed ----> Test Failed ");
		 
		    }
		    
		  }
		    
		    System.out.println("                                                                    ");
		}		    
		    
		    @Test(priority = 15)
		    public void VerifyStateSchemeSubmoduleOfDashboard() throws InterruptedException
		    {
		    	
		    	DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
				PageFactory.initElements(driver, ddpl);
				
				 
				 
				//mouse hover on statescheme module 
				wutils.Action(driver, ddpl.getStateSchememodule());
				
				//click on scheme
				ddpl.getSchemebtn().click();
				
				Thread.sleep(2000);
				
				String Expected = driver.getTitle();
				
				String Actual = "MEDA | DGM Office";
				
				Assert.assertEquals(Expected, Actual, "Title not matched ");	
		    	
				System.out.println("                                                             ");
				
				Thread.sleep(1000);
				
		    }
		    
		    
		    @Test(priority = 16)
		    public void VerifyCentralScheme_ofDashboardFunctionality() throws InterruptedException
		    {
		    	
		    	DGM_DashboardPanelPage ddpl = new DGM_DashboardPanelPage();
				PageFactory.initElements(driver, ddpl);
				
				//mouse hover on central scheme module
				wutils.Action(driver, ddpl.getCentralSchememodule());
				Thread.sleep(1000);
				//central scheme of button
		     	ddpl.getCentralSchemebtn().click();
		     	
		     	Thread.sleep(2000);
		     	
		     	//check img is display on central scheme or not 
		     	
		     	if(ddpl.getImgCentralScheme().isDisplayed())
		     	{
		     		System.out.println("Image is present or Displayed on central scheme page .....Test Passed");
		     	}
		     	else
		     	{
		     		
		     		System.out.println("Image is not present or Displayed on central scheme page .....Test Failed");	
		     	}
		     	
		     	
		     	//View Logs Button 
		     	boolean viewlogsbtn = ddpl.getViewLogbtn().isDisplayed();
		     	System.out.println(viewlogsbtn  +  "Button is present on central scheme page");
		     	
		     	Thread.sleep(1000);
		     	
		     	//verify title 
		     	String Expected = driver.getTitle();
		     	
		     	String Actual = "MEDA | DGM Office";
		     	
		     	if(Expected.equalsIgnoreCase(Actual))
		     	{
		     		System.out.println("Beneficiary Central Page Title Matched");
		     	}
		     	else
		     	{
		     		System.out.println("Beneficiary Central Page Title is not Matched");
		     	}
		     	
		     	System.out.println("                                                              ");
		     	
		     	Thread.sleep(2000);
		    }
		    
		    @Test(priority = 17)
		    public void VerifyStateCentralBeneficiaryFunctionality() throws InterruptedException
		    {
		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
				
				//mouse hover on central beneficiary module
			    wutils.Action(driver, DSCBP.getCentralBeneficiaryModule());
			    
			  //Fetch all the submodule of Central beneficiary Scheme
			  System.out.println("All the submodules of central beneficiary scheme");
			    
			  List<WebElement> centbenfschemesubmod = DSCBP.getAllsubmodulesOfCentralBenfScheme();
			  
			  for(WebElement CBSsubmod : centbenfschemesubmod )
			  {
				  System.out.println(CBSsubmod.getText());
			  }
			    
				
			  //click on scheme
			  DSCBP.getCentralBenefSchemeLink().click();
			  
			  
			  List<WebElement> Coloumnname = driver.findElements(By.xpath("//table[@id='zero_configuration_table_info']//th"));
			  
			  List<WebElement> TableRows = driver.findElements(By.xpath("//table[@id='zero_configuration_table_info']//td"));

			System.out.println("------------------Scheme Table Data Coloums-----------------------------"); 
			for(WebElement Cname: Coloumnname)
			{
				System.out.println(Cname.getText());
			}
			
			System.out.println("--------------Rows-------------------------------");
			
			Thread.sleep(1000);
			
		    for(WebElement Trows : TableRows)	
		    {
		    	System.out.println(Trows.getText()  );
		    }
		    	
		    Thread.sleep(2000);
		    
		    //click on view1 /eyebtn1 
		    
		    DSCBP.getEyebtn1().click();
		    Thread.sleep(2000);
		   
		}
		    
		    @Test(priority = 18)
		    public void verifyBasicInformationAfterClickonEyeorViewbtn() throws InterruptedException
		    {
		   
		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
				
				
				   //fetch the all besic info after click on eye btn1
			    
				   List<WebElement> allbasicinfo = DSCBP.getAllBasicInfo();
				   
				   for(int i=0; i<allbasicinfo.size();i++)
				   {
					   System.out.println(allbasicinfo.get(i).getText());
					   System.out.println("------------------------------------------------");
				   }
				
		       //IMGE OF Basic Info
		       boolean imgBasicInfo = DSCBP.getImageBasicInfo().isDisplayed();
		       System.out.println("Image is displayed on basic info  " +  imgBasicInfo);
		   
		       //click on SchemeDocument
		       DSCBP.getSchemedocument().click();
		       Thread.sleep(2000);
		       
		       System.out.println("                                                      ");
		       
		     }    
		 
		    @Test(priority = 19)
		    public void ValidateSchemeDocumnets() throws InterruptedException, IOException
		    {
		    	
		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
				
		        //pdf links of scheme documents 
		        WebElement pdflink1 = DSCBP.getPdflinksofSchemedocs1();
		               
		        pdflink1.click();
		        
		        //parents to child swithc
		       wutils.SwitchtoMethod(driver);
		 
			    
			    Thread.sleep(2000);
			    
			    s_assert.assertTrue(false);
			    
			    if (driver.getPageSource().contains("404")) 
	            {
	                System.out.println("404 Error Found for PDF: " + pdflink1);
	            } 
			    else 
	            {
	                System.out.println("PDF is accessible: " + pdflink1);
	            }
			    
			   Thread.sleep(2000);
			   
			   driver.close();
			   
			   Thread.sleep(1000);
			   
			   //child to parents
			    wutils.ChildtoParentSwitch(driver);
			      
			    
		    }
			  
		    @Test(priority = 20)
		    public void verifyFinancialDetails() throws InterruptedException
		    {
		    	

		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
				
				//clcik on financial details
				DSCBP.getFinancialDetails().click();
				
				//fetching all the table data 
				
				List<WebElement> FinancialdetailsCname = DSCBP.getFinanDetailsTableCname();
				
				List<WebElement> FinancialDetailTableRows = DSCBP.getFinanDetailsTableRows();
				
				
				System.out.println("---------------Table Data-------------");
				
				for(int i=0; i< FinancialdetailsCname.size(); i++)
				{
					
					String CNAME = FinancialdetailsCname.get(i).getText();
					System.out.println(CNAME);
					
					Thread.sleep(1000);
					
					String TableRows = FinancialDetailTableRows.get(i).getText();
					System.out.println(TableRows);
					
				}
		    }
				
		    @Test(priority = 21)
				public void VerifyLocationDetails() throws InterruptedException, IOException
				{
					//fetch all the table job location info in excl sheet
					
		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
				
				DSCBP.getLocationDetails().click();
				Thread.sleep(1000);
				
				Eutils.WriteDataFromTableinExcel(driver);
		    	
		    	
				}
		    
		    @Test(priority = 22,enabled = false)
		    public void verifyBeneficiaryRegister_SurveyParameterFunctionality() throws InterruptedException
		    {
		    	DGM_StateCentralBeneficiaryPage DSCBP = new DGM_StateCentralBeneficiaryPage();
				PageFactory.initElements(driver, DSCBP);
		
				//click on 
				DSCBP.getBeneficiaryRegister_SurveyParameter().click();
				Thread.sleep(2000);
				
             List<WebElement> Allwebelements = DSCBP.getAllSubmodulesBeneficiaryRegister_SurveyParameter();
			  
			  for(WebElement  elements : Allwebelements)
			  {
				   elements.click();
				   
				   Thread.sleep(2000);
				   
				   switch (elements.getText()) 
				   {
				   
				  case "Personal & Land Details of Applicant":
				  {
				     
					  List<WebElement> e1 = DSCBP.getBeneficiaryRegister_SurveyParameterElements();
					
					  if (e1.size() >= 1 && e1.size() <= 17) 
					  {
					      for (WebElement element : e1) 
					      {
					          
					          if (element.isEnabled())
					          {
					              System.out.println("true");
					          } 
					          else 
					          {
					              System.out.println("false");
					          }
					      }
					  } 
					  
					  else 
					  {
					      System.out.println("The size of e1 is not within the range of 1 to 17");
					  }
				  }
				  break;
				  }
				   
				   }
			 
			  }
		    }

					 
//				  case "Bank Details":
//				  {
//				     
//					  List<WebElement> e2 = DSCBP.getBankDetailsAllTfElements();
//					
//					  for(WebElement element2 : e2)
//					  {
//								
//					    if(e2.size() >=17 && e2.size() <=25)
//						{
//							if(element2.isEnabled())
//							{
//					         System.out.println(element2.getText()+ "Bank Details All Tf are Enabled");
//					       
//					        }
//					         else
//					        {
//						    System.out.println(element2.getText() + "Bank Details All Tf  are desabled");
//
//						    }
//						 }
//					   
//					  }
//					 // System.out.println("------------------------------------------------------------");
//					  break;
//				  }
//					
//				  case "Required Pump Details":
//				  {
//				     
//					   List<WebElement> E3 = DSCBP.getRequiredPumpDetailsAllTfElements();
//					
//					  for(WebElement element3 : E3  )
//					  {
//								
//					    if(E3.size() >=26 && E3 <=35)
//						{
//							if(element3.isEnabled())
//							{
//					       System.out.println(element3.getText() + "Required Pump Details All Tf are Enabled");
//					       
//					        }
//					         else
//					        {
//						    System.out.println(element3.getText() + "Required Pump Details All Tf are desabled");
//
//						    }
//						 }
//					  //  System.out.println("------------------------------------------------------------");
//					    
//					  } 
//					  break; 
//					  
//					  
//					  
//					  
//					  }
				  
					  	
				   
					    
					   
					    
					    		 
				    
				 
					
				
				 
			  
			  
			  
		    
		    


				
		    	
		    	    
			    
	        
	  
		 
		    
		  
		        
		  
		  
		 
		    
		    
		    
		    

		
		
		
		
		
		
	
	
	
	
	
	
	


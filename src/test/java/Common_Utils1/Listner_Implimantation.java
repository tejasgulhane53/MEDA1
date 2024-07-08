package Common_Utils1;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listner_Implimantation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		
		String methodneme = result.getMethod().getMethodName();
     	//Reporter.log(methodneme+"Testcript execution Started",true);  //this is for html report
		//instesd of write their method we write methode name
		
		test = report.createTest(methodneme);// to add the logs your extent report 
		
		
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodneme = result.getMethod().getMethodName();

		//Reporter.log(methodneme+"Testcript Is Pass",true);
		
		test.log(Status.PASS, methodneme + "TestScript is pass"); //becoz its pass method so we use pass

	}

	public void onTestFailure(ITestResult result) 
	
	{
		
		JavaUtils1 jutils = new JavaUtils1();
	   Webdriver_Utils1 wutils = new Webdriver_Utils1();
	   
		String methodname = result.getMethod().getMethodName(); //just to get the method name which method failed the testscript if you have a 100 method how we can analize which method is fails so tahts why we use this methods
		Throwable message = result.getThrowable(); // if the testcript is faild so we throgh the exception cosole also ntml rep[ort also
		Reporter.log(methodname + "Testcript Is Fail" + message, true);
		
		
		test.log(Status.FAIL, methodname + "TestScript is Fail");
		
		try {
            // Your test logic
        } catch (Exception e) {
            // Log exception in Extent report
            test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
        }
		
		String Screenshotname = methodname + jutils.getRandomNumber();
		
		try
		{
			String path = wutils.screenshotwebpage1(BaseClass1.sdriver, methodname); //changes for to get the ss in extent report
			
			 //to add ss to my extent reports 
			 test.addScreenCaptureFromPath(path);
			
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) 
	{

		String methodname = result.getMethod().getMethodName();

		//Reporter.log(methodneme+"Testcript Is Skipped",true);
		test.log(Status.SKIP,methodname+ "TestScript is Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		
		       JavaUtils1 jutils = new JavaUtils1();
		
				ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\Vendors Module"+jutils.getRandomNumber()+".html");  //to configure your extent report  set title to your webpage  that type of configure
				htmlreport.config().setDocumentTitle("MEDA Testcase") ;   //to set the title use method setdocument title
			    
				
				//assign the name your report set report name
				htmlreport.config().setReportName("Vendor Module Of Meda TC");
				
				//SET THE TheMe
				htmlreport.config().setTheme(Theme.STANDARD);
				
				
			    report = new ExtentReports();  
				
				//to attached all the data to the reports we use this method
				report.attachReporter(htmlreport);
				
				report.setSystemInfo("OS", "Windows");
				report.setSystemInfo("Browser", "Chrome");
				report.setSystemInfo("URL", "https://innoproduction.in/meda/meda_vendor/");
				report.setSystemInfo("Module Name", " Vendor ");
				report.setSystemInfo("Author", "Tejas Gulhane");
				

				
		
		
	}

	public void onFinish(ITestContext context)
	{
		
		//it will be adding all the information to our report whatever we write in on start method the data will add
		report.flush(); 
	}

}

package POM_DGM_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DGM_LoginPage 
{
	//username TF 
     @FindBy(id="useremail")
     private WebElement useremailTf;
     
     
   //Password TF 
     @FindBy(id="password")
     private WebElement passwordTf;
     
     //login btn
     @FindBy(id="login")
     private WebElement loginbtn;
     
     //forgot password link 
     @FindBy(xpath="//a[text()='Password?']")
     private  WebElement forgotPasswordLink;
     
     //img of field offices on login page 
     @FindBy(xpath="(//img[@title=\"MEDA Offices\"])[2]")
     private WebElement ImgOfficeField;
     
     //regional ofice links
    @FindBy(xpath="//a[@title='Regional office']")
     private WebElement RegionalOfficeLinks;
    
    //district office links
    @FindBy(id="district")
    private WebElement DistrictOfficeLink;
    
    //dgm office link
    @FindBy(id="dgm")
    private WebElement dgmofficeLink;
     
    //DGM LOGIN Heading TITLE VERIFY
    @FindBy(xpath="//h1[text()='DGM Login']")
    private WebElement DGMOfficeHeadingTitle;
    

	public WebElement getUseremailTf() 
	{
		return useremailTf;
	}

	public WebElement getPasswordTf() 
	{
		return passwordTf;
	}

	public WebElement getLoginbtn() 
	{
		return loginbtn;
	}

	public WebElement getForgotPasswordLink()
	{
		return forgotPasswordLink;
	}

	public WebElement getImgOfficeField()
	{
		return ImgOfficeField;
	}

	public WebElement getRegionalOfficeLinks() 
	{
		return RegionalOfficeLinks;
	}

	public WebElement getDistrictOfficeLink() 
	{
		return DistrictOfficeLink;
	}

	public WebElement getDgmofficeLink() 
	{
		return dgmofficeLink;
	}

	public WebElement getDGMOfficeHeadingTitle() 
	{
		return DGMOfficeHeadingTitle;
	}
	
	
    
    
    
    
     
     
	
	
}

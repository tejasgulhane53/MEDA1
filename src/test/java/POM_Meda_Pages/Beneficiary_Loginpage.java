package POM_Meda_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Beneficiary_Loginpage 
{
	
	//username or application number textfield
	@FindBy(id="useremail")
	private WebElement lgnUsernameTf;
	
	//Password tf
	@FindBy(id="password")
	private WebElement lgnPasswordTf;
	
	//login button
	@FindBy(xpath="//button[text()='Login']")
	private WebElement lgnButton;
	
	//Forgot password link
    @FindBy(linkText="Password?")
    private WebElement ForgotPassLink;
    
  //Resend username and password 
    @FindBy(xpath="//a[text()='Username & Password?']")
    private WebElement ResnedUNandPass;

	public WebElement getLgnUsernameTf() {
		return lgnUsernameTf;
	}

	public WebElement getLgnPasswordTf() {
		return lgnPasswordTf;
	}

	public WebElement getLgnButton() {
		return lgnButton;
	}

	public WebElement getForgotPassLink() {
		return ForgotPassLink;
	}

	public WebElement getResnedUNandPass() {
		return ResnedUNandPass;
	}
		
	
	
	

}

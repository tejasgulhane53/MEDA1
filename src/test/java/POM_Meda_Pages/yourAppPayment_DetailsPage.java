package POM_Meda_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class yourAppPayment_DetailsPage 
{
   @FindBy(xpath="(//input[@class=\"form-control\"])[1]")
   private WebElement TransactionidField;
   
   @FindBy(xpath ="(//input[@class=\"form-control\"])[2]")
   private WebElement TotalamtTextfield;
   
   @FindBy(xpath = "(//input[@type='submit'])[2]")
   private WebElement proceedTPaymentbtn;

public WebElement getTransactionidField() 
{
	return TransactionidField;
}

public WebElement getTotalamtTextfield() 
{
	return TotalamtTextfield;
}

public WebElement getProceedTPaymentbtn() 
{
	return proceedTPaymentbtn;
}
   
   
   
   
}

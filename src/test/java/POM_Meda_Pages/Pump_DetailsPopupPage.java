package POM_Meda_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pump_DetailsPopupPage 
{
	
	@FindBy(xpath="(//table[@class='table table-striped'])[1]")
	private WebElement landdetails_table1;

	public WebElement getLanddetails_table1() 
	{
		return landdetails_table1;
	}
	
	
	@FindBy(xpath="(//table[@class='table table-striped'])[1]")
	private WebElement availableQuata;
	
	@FindBy(id="is_payment_no")
	private WebElement proceedtoPayment;

	public WebElement getProceedtoPayment() 
	{
		return proceedtoPayment;
	}


	public WebElement getAvailableQuata() {
		return availableQuata;
	}

	
}

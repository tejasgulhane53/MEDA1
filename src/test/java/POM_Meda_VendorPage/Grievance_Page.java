package POM_Meda_VendorPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Grievance_Page 
{
	
	@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/grievance']")
	private WebElement webelegrievanceModule; 
	
	@FindBy(id="project_id")
	private WebElement SchemeDrop;
	
	@FindBy(xpath ="//button[text()='Submit']")
	private WebElement Submitbtn;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement Canclebtn;
	
	@FindBy(xpath="(//select[@name='se_data'])[2]")
	private WebElement siteenggDropinTable;
	
	

	public WebElement getSiteenggDropinTable() {
		return siteenggDropinTable;
	}

	public WebElement getWebelegrievanceModule() 
	{
		return webelegrievanceModule;
	}

	public WebElement getSchemeDrop()
	{
		return SchemeDrop;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	public WebElement getCanclebtn() {
		return Canclebtn;
	}
	
	
	
	

}

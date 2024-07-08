package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Staff_Mod_Page 
{
	
	@FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/staff']")
	private WebElement StaffModLink;
	
	@FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/staff/add']")
	private WebElement ADDStaf;
	
	//user type drop 
	@FindBy(id = "user_type")
	private WebElement UserTypeDrop;
	
	//name Tf
	@FindBy(id = "name")
	private WebElement NameTf;
	
	@FindBy(id = "contact")
	private WebElement contactTf;
	
	@FindBy(id = "email")
	private WebElement emailTf;
	
	@FindBy(xpath = "//input[@name='is_active']")
	private WebElement Radiobtn;
	
	@FindBy(id = "address")
	private WebElement addressTf;
	
	@FindBy(xpath = "//button[text()='Submit  ']")
	private WebElement Submitbtn;
	
	
	
	//staff list in table
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']")
	private WebElement StaffListinTable;


    //edit btn 
	@FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/staff/add/152']")
	private WebElement Editbtn;
	
	
	@FindBy(xpath ="//button[@class='btn btn-success btn-rounded']")
	private WebElement Updatebtn;
	
	
	//delete
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	private WebElement deletebtn;
	
	
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}



	public WebElement getUpdatebtn() 
	{
		return Updatebtn;
	}



	public WebElement getEditbtn() {
		return Editbtn;
	}



	public WebElement getStaffModLink() {
		return StaffModLink;
	}



	public WebElement getADDStaf() {
		return ADDStaf;
	}



	public WebElement getUserTypeDrop() {
		return UserTypeDrop;
	}



	public WebElement getNameTf() {
		return NameTf;
	}



	public WebElement getContactTf() {
		return contactTf;
	}



	public WebElement getEmailTf() {
		return emailTf;
	}



	public WebElement getRadiobtn() {
		return Radiobtn;
	}



	public WebElement getAddressTf() {
		return addressTf;
	}



	public WebElement getSubmitbtn() {
		return Submitbtn;
	}



	public WebElement getStaffListinTable() {
		return StaffListinTable;
	}
	
	
	
	
	
	
	

}

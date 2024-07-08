package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Policy_ManagementPage 
{
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/policy_management']")
	private WebElement Policymanagement;
	
	@FindBy(id ="policychange")
    private WebElement PolicyDrop;
	
	
	@FindBy(id ="comp_name")
    private WebElement Insurance_company_nameTf;
	
	
	@FindBy(id ="poli_num")
    private WebElement poli_num_Tf;
	
	
	
	
	@FindBy(id ="poli_period")
    private WebElement PolicyPeriodDrop;
	
	
	@FindBy(id ="form_date")
    private WebElement Fromdate_pickerTf;
	
	
	@FindBy(id ="to_date")
    private WebElement todatelast;
	
	
	@FindBy(id ="poli_file")
    private WebElement policyuploadfile;
	
	
	@FindBy(xpath = "//button[text()='Select Beneficiary']")
    private WebElement selectbeneficiary;
	
	@FindBy(xpath ="//div[@class='sa-confirm-button-container']")
	private WebElement okbtn;
	
	
	@FindBy(id ="scheme")
	private WebElement schemeBenfdrop;
	
	@FindBy(id ="dist")
	private WebElement distdrop;
	
	
	@FindBy(id ="taluka")
	private WebElement talukadrop;
	
	@FindBy(id ="village")
	private WebElement villagedrop;
	
	@FindBy(xpath ="(//button[@type='Submit'])[2]")
	private WebElement submitbtnbenficiary;
	
	@FindBy(xpath ="(//span[@aria-hidden='true'])[2]")
	private WebElement closebtn;
	
	
	
	
	
	public WebElement getSchemeBenfdrop() {
		return schemeBenfdrop;
	}

	public WebElement getTalukadrop() {
		return talukadrop;
	}
	
	

	public WebElement getDistdrop() {
		return distdrop;
	}

	public WebElement getVillagedrop() {
		return villagedrop;
	}

	public WebElement getSubmitbtnbenficiary() {
		return submitbtnbenficiary;
	}

	public WebElement getClosebtn() {
		return closebtn;
	}

	public WebElement getOkbtn() {
		return okbtn;
	}

	public WebElement getPoli_num_Tf() {
		return poli_num_Tf;
	}

	public WebElement getInsurance_company_nameTf() {
		return Insurance_company_nameTf;
	}

	public WebElement getPolicyPeriodDrop() {
		return PolicyPeriodDrop;
	}

	public WebElement getFromdate_pickerTf() {
		return Fromdate_pickerTf;
	}

	public WebElement getTodatelast() {
		return todatelast;
	}

	public WebElement getPolicyuploadfile() {
		return policyuploadfile;
	}

	public WebElement getSelectbeneficiary() {
		return selectbeneficiary;
	}

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement Cancelbtn;

	public WebElement getPolicymanagement() {
		return Policymanagement;
	}

	public WebElement getPolicyDrop() {
		return PolicyDrop;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getCancelbtn() {
		return Cancelbtn;
	}
	
	
	
	
}

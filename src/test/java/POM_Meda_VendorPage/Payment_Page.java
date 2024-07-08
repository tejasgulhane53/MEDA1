package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment_Page 
{
	
	@FindBy(xpath = "(//a[@class='waves-effect waves-dark'])[1]")
	private WebElement Payment;
	
	@FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/payment_progress']")
	private WebElement PaymentProgresslink;
	
	@FindBy(id ="raise_percent")
	private WebElement PaymentraiseDrop;
	
	@FindBy(id ="project_id")
	private WebElement schemeDropdown;
	
	@FindBy(id ="dist_id")
	private WebElement distDrop;
	
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/raised_invoice/invoice_list']")
	private WebElement PaymentRaised;
	
	
	@FindBy(id="chkBeneficiaryName")
	private WebElement Beneficiary;
	
	@FindBy(xpath="//button[text()='Raise Payment']")
	private WebElement RaisePaymentbtn;
	
	//2 payment raised
	
	@FindBy(id ="scheme_id")
	private WebElement schemedropInPaymentRaise;
	
	@FindBy(id="invoice_no")
	private WebElement InvoioceNoTf;
	
	@FindBy(id="application_no")
	private WebElement ApplicationNoTf;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Submitbtn;
	
	@FindBy(xpath="//i[@class='fa fa-eye']")
	private WebElement Viewbtn1;
	
	@FindBy(xpath="//button[text()='Track file']")
	private WebElement TrackFile;
	
	//after click on view btn
	@FindBy(id="project_id")
	private WebElement SchemedropinView;
	
	
	@FindBy(id="application_no")
	private WebElement applicationNOINview1Tf;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchbtnView1;
	
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped']")
	private WebElement InvoicetavleList;
	
	
	@FindBy(id="postList")
	private WebElement FileTrackList;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement Closebtn;
	
	
	

	public WebElement getFileTrackList() {
		return FileTrackList;
	}

	public WebElement getClosebtn() {
		return Closebtn;
	}

	public WebElement getInvoicetavleList() {
		return InvoicetavleList;
	}

	public WebElement getSchemedropInPaymentRaise() {
		return schemedropInPaymentRaise;
	}

	public WebElement getInvoioceNoTf() {
		return InvoioceNoTf;
	}

	public WebElement getApplicationNoTf() {
		return ApplicationNoTf;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	public WebElement getViewbtn1() {
		return Viewbtn1;
	}

	public WebElement getTrackFile() {
		return TrackFile;
	}

	public WebElement getSchemedropinView() {
		return SchemedropinView;
	}

	public WebElement getApplicationNOINview1Tf() {
		return applicationNOINview1Tf;
	}

	public WebElement getSearchbtnView1() {
		return searchbtnView1;
	}

	public WebElement getBeneficiary() {
		return Beneficiary;
	}

	public WebElement getRaisePaymentbtn() {
		return RaisePaymentbtn;
	}

	public WebElement getPaymentRaised() {
		return PaymentRaised;
	}

	public WebElement getPayment() {
		return Payment;
	}

	public WebElement getPaymentProgresslink() {
		return PaymentProgresslink;
	}

	public WebElement getPaymentraiseDrop() {
		return PaymentraiseDrop;
	}

	public WebElement getSchemeDropdown() {
		return schemeDropdown;
	}

	public WebElement getDistDrop() {
		return distDrop;
	}
	
	

}

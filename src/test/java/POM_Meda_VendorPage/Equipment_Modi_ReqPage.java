package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Equipment_Modi_ReqPage 
{
	
	@FindBy(xpath ="//span[text()='Equipement Modification Request']")
	private WebElement equi_mod_req;
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/maintenance']")
	private WebElement Equi_ReqLink;
	
	@FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/maintenance/request_list']")
	private WebElement Req_ListLink;
	
	
	@FindBy(id ="srch_benf")
	private WebElement BenfSearchTf;
	
	@FindBy(xpath ="//button[text()='Search']")
	private WebElement searchbtn;
	
	@FindBy(xpath ="//button[text()='Clear']")
	private WebElement Clearbtn;

	public WebElement getEqui_mod_req() {
		return equi_mod_req;
	}

	public WebElement getEqui_ReqLink() {
		return Equi_ReqLink;
	}

	public WebElement getReq_ListLink() {
		return Req_ListLink;
	}

	public WebElement getBenfSearchTf() {
		return BenfSearchTf;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getClearbtn() {
		return Clearbtn;
	}
	
	
	//req list
	
	@FindBy(id ="scheme")
	private WebElement Schemedrop;
	
	@FindBy(id ="district")
	private WebElement distDrop;
	
	@FindBy(id ="taluka")
	private WebElement TalukaDrop;
	
	@FindBy(id ="village")
	private WebElement VillageDrop;
	
	@FindBy(id ="request_status")
	private WebElement RequestStatusDrop;
	
	@FindBy(id ="srch_benf")
	private WebElement searchbyBenefTf;

	public WebElement getSchemedrop() {
		return Schemedrop;
	}

	public WebElement getDistDrop() {
		return distDrop;
	}

	public WebElement getTalukaDrop() {
		return TalukaDrop;
	}

	public WebElement getVillageDrop() {
		return VillageDrop;
	}

	public WebElement getRequestStatusDrop() {
		return RequestStatusDrop;
	}

	public WebElement getSearchbyBenefTf() {
		return searchbyBenefTf;
	}
	
	

}
//MK1107168087
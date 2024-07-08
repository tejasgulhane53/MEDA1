package POM_Meda_VendorPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Vendor_LoginPage 
{
    
	@FindBy(id="useremail")
	private WebElement EmailTf;
	
	@FindBy(id="password")
	private WebElement PassTf;
	
	@FindBy(id="captcha")
	private WebElement CaptchaTf;
	
	
	@FindBy(xpath="(//div[@class='form-group'])[4]//img")
	private WebElement Captchacode;
	
	@FindBy(xpath ="//button[text()='Log In']")
	private WebElement loginbtn;

	
	
	@FindBy(xpath ="//span[@class='hide-menu']")
	private List <WebElement> AllmodulesOfheaderpart;
	//NotificationPopup
	
	
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement NotificatioPopup;
	
	public List<WebElement> getAllmodulesOfheaderpart() {
		return AllmodulesOfheaderpart;
	}






	//Download link present in notification popup
	@FindBy(xpath = "//a[text()='Download Here']")
	private WebElement DownloadLink;
	
	//close popuu btn
	@FindBy(xpath="//button[@type='button']")
	private WebElement Closepopupbtn;

	//table dashboard
	@FindBy(xpath="//table[@class='table']//tr")
	private List<WebElement> tableofDashboard1;
	
	//logo dashboard
	@FindBy(xpath="//img[@class='avatar-md rounded mr-3']")
	private WebElement LogoofDashboardVendor;
	
	//dropdown of dashboard
	@FindBy(id="master_scheme")
	private WebElement DashboardDropdown;
	
	

	
	
	
	
	public WebElement getEmailTf() {
		return EmailTf;
	}


	public WebElement getPassTf() {
		return PassTf;
	}


	public WebElement getCaptchaTf() {
		return CaptchaTf;
	}


	public WebElement getCaptchacode() {
		return Captchacode;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public WebElement getNotificatioPopup() {
		return NotificatioPopup;
	}


	public WebElement getDownloadLink() {
		return DownloadLink;
	}


	public WebElement getClosepopupbtn() {
		return Closepopupbtn;
	}


	public List<WebElement> getTableofDashboard1() {
		return tableofDashboard1;
	}


	public WebElement getLogoofDashboardVendor() {
		return LogoofDashboardVendor;
	}


	public WebElement getDashboardDropdown() {
		return DashboardDropdown;
	}


	
	
	
	
//-------------------------------------Beneficiary Report--------------------------------------------
	
	
	@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/dashboard/mis_report']")
	private WebElement BeneficiaryReport;
	
	
	//dropdown beneficiary report
	@FindBy(id="master_scheme")
	private List<WebElement> BeneficiaryRepoDrop;
	
	//dropdown beneficiary report
		@FindBy(id="master_scheme")
		private WebElement BeneficiaryRepoDrop1;


		//click on eye btn
		@FindBy(xpath="(//i[@class='fa fa-eye'])[1]")
		private WebElement Eyebtn1;
		
		//all dropdowns
		@FindBy(xpath="(//div[@class=\"card\"])[1]//select")
		private List<WebElement> Alldropdowns;
		
		//stage dropdown
		@FindBy(id="stage")
		private WebElement StageDrop;
		
		//site engg dropdown
		@FindBy(id="se_eng")
		private WebElement SiteEnggDrop;

		//district dropdown
		@FindBy(id="district")
		private WebElement DistDrop;
		
		//Taluka dropdown
				@FindBy(id="taluka")
				private WebElement talukaDrop;
				
				//Village dropdown
				@FindBy(id="village")
				private WebElement villageDrop;
				
				
				//Status dropdown
				@FindBy(id="status")
				private WebElement statusDrop;
				
				
				//dropdown paymentstatus
				@FindBy(id="paystatus")
				private WebElement paystatusDrop;
				
				//Serchby beneficiary tf
				
				@FindBy(id="srch_benf")
				private WebElement srch_benfTf;
				
				//Search By Beneficiary ID tf
				@FindBy(id="srch_benf_appl")
				private WebElement srch_benf_ID_TF;
				
				//table user name
				@FindBy(xpath="(//td)[3]")
				private WebElement BeneficiarynameinTable;
		
		
               //click on jsr
				@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/jsr_pdf/tapshil_pdf/168087/9']")
				private WebElement jsrReport;

				
				//jsr page report in table
				@FindBy(xpath="(//table[@cellpadding=\"0\"])[1]")
				private WebElement jsrReportTable;
				
				//jsr site Engg sign
				@FindBy(xpath="//img[@src='https://innoproduction.in/meda/meda_vendor/assets/images/no_thumb.png']")
				private WebElement SiteEnggSign;
				
				
				//click on eye btn
				@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/work/tender_wise_beneficiary/30/9']")
				private WebElement Eyebtn2;
				
				//beneficiaryname tf
				@FindBy(xpath="//input[@id='srch_benf']")
				private WebElement BanfeciaryName2Tf;
				
				

	public WebElement getBanfeciaryName2Tf() {
					return BanfeciaryName2Tf;
				}


	public WebElement getBeneficiaryReport() {
		return BeneficiaryReport;
	}


	public List<WebElement> getBeneficiaryRepoDrop() {
		return BeneficiaryRepoDrop;
	}


	public WebElement getBeneficiaryRepoDrop1() {
		return BeneficiaryRepoDrop1;
	}


	public WebElement getEyebtn1() {
		return Eyebtn1;
	}


	public List<WebElement> getAlldropdowns() {
		return Alldropdowns;
	}


	public WebElement getStageDrop() {
		return StageDrop;
	}


	public WebElement getSiteEnggDrop() {
		return SiteEnggDrop;
	}


	public WebElement getDistDrop() {
		return DistDrop;
	}


	public WebElement getTalukaDrop() {
		return talukaDrop;
	}


	public WebElement getVillageDrop() {
		return villageDrop;
	}


	public WebElement getStatusDrop() {
		return statusDrop;
	}


	public WebElement getPaystatusDrop() {
		return paystatusDrop;
	}


	public WebElement getSrch_benfTf() {
		return srch_benfTf;
	}


	public WebElement getSrch_benf_ID_TF() {
		return srch_benf_ID_TF;
	}


	public WebElement getBeneficiarynameinTable() {
		return BeneficiarynameinTable;
	}


	public WebElement getJsrReport() {
		return jsrReport;
	}


	public WebElement getJsrReportTable() {
		return jsrReportTable;
	}


	public WebElement getSiteEnggSign() {
		return SiteEnggSign;
	}


	public WebElement getEyebtn2() {
		return Eyebtn2;
	}
	
	
	
	
	
}

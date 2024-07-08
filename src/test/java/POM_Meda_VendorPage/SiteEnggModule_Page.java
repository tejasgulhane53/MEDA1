package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteEnggModule_Page 
{
	@FindBy(xpath = "(//a[@href=\"https://innoproduction.in/meda/meda_vendor/site_engineer\"])[1]")
	private WebElement SiteEnginnerModule;

	@FindBy(xpath="//table[@class='table table-bordered table-striped']")
	private WebElement ListofSiteEnggTable;
	
	@FindBy(xpath ="//a[@class='btn btn-info']")
	private WebElement AllocateWorkPlusbtnInTable;
	
	//after click on plus btn allocate work
	
	@FindBy(id="project_id")
	private WebElement SchemeDropdown;
	
	@FindBy(id="type")
	private WebElement typeDropdown;
	
	@FindBy(id="district")
	private WebElement districtDropdown;
	
	@FindBy(id="taluka")
	private WebElement talukaDropdown;
	
	//edit btn
	
	@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/site_engineer/add/87']")
	private WebElement EditBtnSiteEngg;
	
	@FindBy(id ="engineer_name")
	private WebElement SiteEngNameTf;
	
	@FindBy(id="contact")
	private WebElement ContctNoSiteEnggTf;
	
	@FindBy(id="email")
	private WebElement Emailtf;
	
	
	@FindBy(id="address")
	private WebElement SitEenggAddressTf;
	
	@FindBy(xpath="//button[@class='btn btn-success btn-rounded']")
	private WebElement updatebtn;
	
	
	
	//view Beneficiary
	@FindBy(xpath="//a[@href='https://innoproduction.in/meda/meda_vendor/site_engineer/view_beneficiary/87']")
	private WebElement ViewBeneficiary;
	
	//scheme name dropdown
	@FindBy(id="scheme_id")
	private WebElement  SchemeName;
	
	@FindBy(id="district")
	private WebElement DistViewBeneficiary;
	
	@FindBy(id="taluka")
	private WebElement TalukaViewBeneficiary;
	
	
	@FindBy(id="village")
	private WebElement villageViewBeneficiary;
	
	@FindBy(id="status")
	private WebElement StatusViewBeneficiary;
	
	@FindBy(id="beneficiary")
	private WebElement beneficiarySearch;
	
	
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement  submitbtnofViewBenef;
	
	
	//tracking 
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/site_engineer/view_tracking/87']")
	private WebElement ViewTracking;
	
	//select Schemedrop
	@FindBy(id="scheme_id")
	private WebElement TrackSchemedrop;
	
	
	//dist drop
	@FindBy(id="district")
	private WebElement Trackdistrictdrop;
	
	@FindBy(id="taluka")
	private WebElement Tracktaluka;
	
	@FindBy(id="village")
	private WebElement Trackvillagedrop;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement TrackSearchbtn;
	
	
	//delete btn
	
	@FindBy(xpath="(//a[@data-original-title='Delete'])[1]")
	private WebElement Deletebtn;
	
	
	
	public WebElement getSiteEnginnerModule() 
	{
		return SiteEnginnerModule;
	}

	public WebElement getListofSiteEnggTable() 
	{
		return ListofSiteEnggTable;
	}

	public WebElement getAllocateWorkPlusbtnInTable() {
		return AllocateWorkPlusbtnInTable;
	}

	public WebElement getSchemeDropdown() {
		return SchemeDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getDistrictDropdown() {
		return districtDropdown;
	}

	public WebElement getTalukaDropdown() {
		return talukaDropdown;
	}

	public WebElement getEditBtnSiteEngg() {
		return EditBtnSiteEngg;
	}

	public WebElement getSiteEngNameTf() {
		return SiteEngNameTf;
	}

	public WebElement getContctNoSiteEnggTf() {
		return ContctNoSiteEnggTf;
	}

	public WebElement getEmailtf() {
		return Emailtf;
	}

	public WebElement getSitEenggAddressTf() {
		return SitEenggAddressTf;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	public WebElement getViewBeneficiary() {
		return ViewBeneficiary;
	}

	public WebElement getSchemeName() {
		return SchemeName;
	}

	public WebElement getDistViewBeneficiary() {
		return DistViewBeneficiary;
	}

	public WebElement getTalukaViewBeneficiary() {
		return TalukaViewBeneficiary;
	}

	public WebElement getVillageViewBeneficiary() {
		return villageViewBeneficiary;
	}

	public WebElement getStatusViewBeneficiary() {
		return StatusViewBeneficiary;
	}

	public WebElement getBeneficiarySearch() {
		return beneficiarySearch;
	}

	public WebElement getSubmitbtnofViewBenef() {
		return submitbtnofViewBenef;
	}

	public WebElement getViewTracking() {
		return ViewTracking;
	}

	public WebElement getTrackSchemedrop() {
		return TrackSchemedrop;
	}

	public WebElement getTrackdistrictdrop() {
		return Trackdistrictdrop;
	}

	public WebElement getTracktaluka() {
		return Tracktaluka;
	}

	public WebElement getTrackvillagedrop() {
		return Trackvillagedrop;
	}

	public WebElement getTrackSearchbtn() {
		return TrackSearchbtn;
	}

	public WebElement getDeletebtn() {
		return Deletebtn;
	}

	
	
	
	
	
	
    
}

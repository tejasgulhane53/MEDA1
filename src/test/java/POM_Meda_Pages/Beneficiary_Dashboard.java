package POM_Meda_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Beneficiary_Dashboard 
{
	//logo of Dashboard
	@FindBy(xpath="//img[@src=\"https://innoproduction.in/meda/uat/assets/images/logo.png\"]")
	private WebElement ImgLogofMedaOnDashboard;
	
	//complete ur form btn
	@FindBy(xpath="//a[@class='btn btn-warning btn-rounded']")
	private WebElement CompleteURFormbtn;

	//reupload doc button
	@FindBy(xpath="//a[@class='btn btn-sm btn-success']")
	private WebElement ReuploadDocLink;

    //select langauge dropdown 	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle bor_radi24']")
	private WebElement SelectLangDropdown;

	//Validate photo of dashboard
	@FindBy(xpath="//img[@src='https://innoproduction.in/meda/uat/uploads/solar/logo/9/7fdc1a630c238af0815181f9faa190f5']")
	private WebElement ImageOfDashboardTable;
	

	
	public WebElement getImgLogofMedaOnDashboard() {
		return ImgLogofMedaOnDashboard;
	}

	public WebElement getCompleteURFormbtn() {
		return CompleteURFormbtn;
	}

	public WebElement getReuploadDocLink() {
		return ReuploadDocLink;
	}

	public WebElement getSelectLangDropdown() {
		return SelectLangDropdown;
	}

	public WebElement getImageOfDashboardTable() {
		return ImageOfDashboardTable;
	}
	
	//---------------------------------------------------------------------
	//3.Applicant Residential Address
	@FindBy(id="house_no")
	private WebElement HouseNumTf;
	
	@FindBy(id="address")
	private WebElement StreetLandmarkTf;
	
	@FindBy(id="district_id_1")
	private WebElement DistrictDropdown;
	
	@FindBy(id="taluka_1")
	private WebElement TalukaDropdown;
	
	@FindBy(id="village_1")
	private WebElement villageDropdown ;
	
	@FindBy(id="pin_code")
	private WebElement  pincodeTf ;
	
	@FindBy(id="mobile")
	private WebElement  mobileTf ;
	
	
	
	public WebElement getStreetLandmarkTf() {
		return StreetLandmarkTf;
	}

	public WebElement getMobileTf() {
		return mobileTf;
	}

	public WebElement getHouseNumTf() {
		return HouseNumTf;
	}

	public WebElement StreetLandmarkTf() {
		return StreetLandmarkTf ;
	}

	public WebElement getDistrictDropdown() {
		return DistrictDropdown;
	}

	public WebElement getTalukaDropdown() {
		return TalukaDropdown;
	}

	public WebElement getVillageDropdown() {
		return villageDropdown;
	}

	public WebElement getPincodeTf() {
		return pincodeTf;
	}

	
//------------------------------------------------------------------
	//Irrigation Source Information
	
	//Type of Irrigation Source* dropdown
	@FindBy(id="irr_source")
	private WebElement IrrigationSourceDrop;
	
	@FindBy(id="irr_src_depth")
	private WebElement IrrigationSourceDepthTf;
	
	@FindBy(id="irr_borewell")
	private WebElement WidthTf;
	
	@FindBy(id="irr_mode")
	private WebElement irr_modeDropdown;
	
	



	public WebElement getWidthTf() {
		return WidthTf;
	}

	public WebElement getIrrigationSourceDrop() {
		return IrrigationSourceDrop;
	}

	public WebElement getIrrigationSourceDepthTf() {
		return IrrigationSourceDepthTf;
	}

	public WebElement getIrr_modeDropdown() {
		return irr_modeDropdown;
	}
	
	//-------------------------------------------------------------------
	//crops details
	
	//Crop Type: Previous Year*
	@FindBy(id ="ct_py")
	private WebElement CrpTyp_PrioviousYdropdown;
	
	@FindBy(id ="tot_crops")
	private WebElement tot_CropsPrivYearTf;
	
	//lastYearDrop
	@FindBy(id="ct_ly_py")
	private WebElement LastYearDropdown;
	
	//no. of Crops: Last to Last Year
	@FindBy(id="tot_crops_ly")
	private WebElement LastYearCropsTf;



	public WebElement getCrpTyp_PrioviousYdropdown() {
		return CrpTyp_PrioviousYdropdown;
	}

	public WebElement getTot_CropsPrivYearTf() {
		return tot_CropsPrivYearTf;
	}

	public WebElement getLastYearDropdown() {
		return LastYearDropdown;
	}

	public WebElement getLastYearCropsTf() {
		return LastYearCropsTf;
	}


//---------------------------------------------------------------------
	//Required Pump Details Field
	
	@FindBy(id="pump_type")
	private WebElement ReqPumpTypTf;
	
	@FindBy(id="pump_sub_type")
	private WebElement PumpSubTypeDropDown;
	
	@FindBy(id="pump_category")
	private WebElement pump_categoryDropDown;
	
	@FindBy(id="pump_required")
	private WebElement pump_CapacityDropDown;
	
	@FindBy(id="summer_season")
	private WebElement SumWaterLevelTf;
	
	@FindBy(id="rainy_season")
	private WebElement RainySesonTf;
	
	@FindBy(id="water_thruput")
	private WebElement Water_ThroughputTf;
	
	@FindBy(id="agricultural_pumpcost")
	private WebElement Solar_Agri_PumpTf;
	
	@FindBy(id="benf_share")
	private WebElement benf_shareTf;



	public WebElement getReqPumpTypTf() {
		return ReqPumpTypTf;
	}

	public WebElement getPumpSubTypeDropDown() {
		return PumpSubTypeDropDown;
	}

	public WebElement getPump_categoryDropDown() {
		return pump_categoryDropDown;
	}

	public WebElement getPump_CapacityDropDown() {
		return pump_CapacityDropDown;
	}

	public WebElement getSumWaterLevelTf() {
		return SumWaterLevelTf;
	}

	public WebElement getRainySesonTf() {
		return RainySesonTf;
	}

	public WebElement getWater_ThroughputTf() {
		return Water_ThroughputTf;
	}

	public WebElement getSolar_Agri_PumpTf() {
		return Solar_Agri_PumpTf;
	}

	public WebElement getBenf_shareTf() {
		return benf_shareTf;
	}
	
//---------------------------------------------------------------------------------------------------------------	
	//Bank Details
	
	@FindBy(id="bank_account")
	private WebElement AccountNumTf;
	
	@FindBy(id="bank_acc_hold")
	private WebElement AccountHolderNameTf;
	
	@FindBy(id="account_type")
	private WebElement account_typeDROP;
	
	@FindBy(id="bank_ifsc")
	private WebElement bank_ifscTf;
	
	@FindBy(id="bank_name")
	private WebElement bank_nameTf;
	
	@FindBy(id="bank_micr")
	private WebElement  bank_micrCodeTf;
	
	@FindBy(id="bank_branch")
	private WebElement bank_branchTf;
	
	@FindBy(id="bank_loc")
	private WebElement bankCityVillageTf;



	public WebElement getAccountNumTf() {
		return AccountNumTf;
	}

	public WebElement getAccountHolderNameTf() {
		return AccountHolderNameTf;
	}

	public WebElement getAccount_typeDROP() {
		return account_typeDROP;
	}

	public WebElement getBank_ifscTf() {
		return bank_ifscTf;
	}

	public WebElement getBank_nameTf() {
		return bank_nameTf;
	}

	public WebElement getBank_micrCodeTf() {
		return bank_micrCodeTf;
	}

	public WebElement getBank_branchTf() {
		return bank_branchTf;
	}

	public WebElement getBankCityVillageTf() {
		return bankCityVillageTf;
	}
	
//----------------------------------------------------------------------------------	
	//Scan / Upload Documents 
	
	//जिल्हास्तरीय वनहक्क समितीने दिलेले वनपट्टे प्रमाणपत्र 
	@FindBy(id="van_patte_certificate")
	private WebElement UploadVanPatteCetificate;
	
	//प्रमाणपत्रामध्ये नमूदं क्षेत्रामध्ये जलस्रोत उपलब्ध असल्याबाबत तलाठी कार्यालयाचा दाखला
	@FindBy(id="talathi_certificate")
	private WebElement Uploadtalathi_certificate;
	
	@FindBy(id="van_patte_map")
	private WebElement UploadVanPtteMap;
	
	@FindBy(id="adhar_card")
	private WebElement Uploadadhar_card;
	
	@FindBy(id="chq_bnk_pass")
	private WebElement UploadBankPassCopy;
	
	@FindBy(id="photo_benf")
	private WebElement UploadPassportPhoto;



	public WebElement getUploadVanPatteCetificate() {
		return UploadVanPatteCetificate;
	}

	public WebElement getUploadtalathi_certificate() {
		return Uploadtalathi_certificate;
	}

	public WebElement getUploadVanPtteMap() {
		return UploadVanPtteMap;
	}

	public WebElement getUploadadhar_card() {
		return Uploadadhar_card;
	}

	public WebElement getUploadBankPassCopy() {
		return UploadBankPassCopy;
	}

	public WebElement getUploadPassportPhoto() 
	{
		return UploadPassportPhoto;
	}
	
	
	//click on checkbox
	
	@FindBy(id="checkTerms")
	private WebElement Checkbox;
	
	//click on submit button
	@FindBy(id="main_submit_btn")
	private WebElement SubmitButtonOfForm;



	public WebElement getCheckbox() 
	{
		return Checkbox;
	}

	public WebElement getSubmitButtonOfForm() 
	{
		return SubmitButtonOfForm;
	}

	
	
	

	
	

	
	
	
	
	
	


	
	
	
	
}

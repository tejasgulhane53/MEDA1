package POM_DGM_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DGM_StateCentralBeneficiaryPage 
{
	
	//-----------------------------Central Beneficiary Scheme ------------------------------------------------
	
		@FindBy(xpath="//span[text()='State Central Benf.']")
		private WebElement CentralBeneficiaryModule;
		
		//all the submodules of central beneficiary scheme   
		@FindBy(xpath="(//*[local-name()='ul'])[4]//span")
		private List<WebElement> AllsubmodulesOfCentralBenfScheme;
		
		
		
		
		//-------------  submodule scheme1----------------
		@FindBy(xpath="(//span[text()='Scheme'])[3]")
		private WebElement CentralBenefSchemeLink;
		
		//dropdown of scheme link page
		@FindBy(xpath="//select[@name='zero_configuration_table_info_length']")
		private WebElement ShowEntriesSchemepageDropdown;
		
		//search tf of scheme page
		@FindBy(xpath="//input[@type='search']")
		private WebElement SchemesearchTF;
		
		
		
		//----------table view eyebtn1-----------------------------------------
		@FindBy(xpath="(//span[@data-original-title='View'])[1]")
		private WebElement eyebtn1;
		
	     //after click on eye1 btn 
		//fetch all info of Basic info
		@FindBy(xpath="//div[@id=\"basic_info\"]//div")
		private List<WebElement> allBasicInfo;
		
		//Maha Krushi Urja Abhiyan img 
		@FindBy(xpath="//img[@src=\"https://innoproduction.in/meda/uat/uploads/solar/logo/9/7fdc1a630c238af0815181f9faa190f5\"]")
		private WebElement ImageBasicInfo;
		
		//--------------------lick Scheme Document after click on eye1btn---------------------------------
		@FindBy(xpath="(//a[@data-toggle=\"collapse\"])[2]")
		private WebElement Schemedocument;
		
		//pdf1 in scheme document
		@FindBy(xpath="(//a[@href=\"https://innoproduction.in/meda/uat/uploads/solar/document/9/4eff25cd4eda074167288e624ad37dc0\"])[1]")
		private WebElement PdflinksofSchemedocs1;
		
		//pdf2 in scheme document
		@FindBy(xpath="(//a[@href=\"https://innoproduction.in/meda/uat/uploads/solar/document/9/4eff25cd4eda074167288e624ad37dc0\"])[1]")
		private WebElement PdflinksofSchemedocs2;
		
		
		
		//-------click on Financial Details------------------------------
	
		@FindBy(xpath="(//a[@data-toggle=\"collapse\"])[3]")
		private WebElement FinancialDetails; 
		
		//xpath for coloum name of financial details
		@FindBy(xpath = "//table[@class='table table-bordered table-striped']//th ")
		private List<WebElement>  finanDetailsTableCname;
		
		//xpath for rows of financial details multiple single element 
		@FindBy(xpath = "//table[@class='table table-bordered table-striped']//td ")
		private List<WebElement>  finanDetailsTableRows;
		
		
		
		//--------------Location Deatails --------------------
		
		
		@FindBy(xpath="(//a[@data-toggle=\"collapse\"])[4]")
		private WebElement LocationDetails; 
		
		@FindBy(xpath="(//a[text()='Next'])[2]")
		private WebElement NextbtnLinkOftable;
		
		
		//--------------------Beneficiary Register/Survey Parameter :----------------------------
		
		
		@FindBy(xpath="(//a[@data-toggle=\"collapse\"])[5]")
		private WebElement BeneficiaryRegister_SurveyParameter  ;
		
		@FindBy(xpath = "//div[@id=\"nav-tab\"]//a")
		private List<WebElement> allSubmodulesBeneficiaryRegister_SurveyParameter;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> BeneficiaryRegister_SurveyParameterElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> BankDetailsAllTfElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> RequiredPumpDetailsAllTfElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> Scan_UploadDocumentsAllTfElements;
;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> Applicant_ResidentialAddressLocationAllTfElementsAllTfElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> IrrigationSourceInformationAllTfElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement> CropsDetailsAllTfElements;
		
		@FindBy(xpath ="(//div[@id='nav-tabContent'])[1]//input")
		private List<WebElement>ApplicatiofornewoffgridAllTfElements ;
		
		
		
		
			
		//table view eyebtn2
		@FindBy(xpath="(//span[@data-original-title='View'])[2]")
		private WebElement eyebtn2;

		public WebElement getCentralBeneficiaryModule() {
			return CentralBeneficiaryModule;
		}

		public List<WebElement> getAllsubmodulesOfCentralBenfScheme() {
			return AllsubmodulesOfCentralBenfScheme;
		}

		public WebElement getCentralBenefSchemeLink() {
			return CentralBenefSchemeLink;
		}

		public WebElement getShowEntriesSchemepageDropdown() 
		{
			return ShowEntriesSchemepageDropdown;
		}

		public WebElement getSchemesearchTF() 
		{
			return SchemesearchTF;
		}

		public WebElement getEyebtn1() {
			return eyebtn1;
		}

		public List<WebElement> getAllBasicInfo() {
			return allBasicInfo;
		}
		
		
		

		
		
		public WebElement getImageBasicInfo() {
			return ImageBasicInfo;
		}

		public WebElement getSchemedocument() {
			return Schemedocument;
		}

		
		
	
		public WebElement getPdflinksofSchemedocs1() {
			return PdflinksofSchemedocs1;
		}

		public WebElement getPdflinksofSchemedocs2() {
			return PdflinksofSchemedocs2;
		}

		
		public WebElement getFinancialDetails() {
			return FinancialDetails;
		}
		

		public List<WebElement> getFinanDetailsTableCname() {
			return finanDetailsTableCname;
		}

		public List<WebElement> getFinanDetailsTableRows() {
			return finanDetailsTableRows;
		}
		
		
	

		public WebElement getLocationDetails() {
			return LocationDetails;
		}

		
		public WebElement getNextbtnLinkOftable() {
			return NextbtnLinkOftable;
		}

		
		public WebElement getBeneficiaryRegister_SurveyParameter() {
			return BeneficiaryRegister_SurveyParameter;
		}

		public List<WebElement> getAllSubmodulesBeneficiaryRegister_SurveyParameter() {
			return allSubmodulesBeneficiaryRegister_SurveyParameter;
		}
		
		
		public List<WebElement> getBeneficiaryRegister_SurveyParameterElements() {
			return BeneficiaryRegister_SurveyParameterElements;
		}
		
		
		
		

		public List<WebElement> getBankDetailsAllTfElements() {
			return BankDetailsAllTfElements;
		}

		public List<WebElement> getRequiredPumpDetailsAllTfElements() {
			return RequiredPumpDetailsAllTfElements;
		}

		public List<WebElement> getScan_UploadDocumentsAllTfElements() {
			return Scan_UploadDocumentsAllTfElements;
		}

		public List<WebElement> getApplicant_ResidentialAddressLocationAllTfElementsAllTfElements() {
			return Applicant_ResidentialAddressLocationAllTfElementsAllTfElements;
		}

		public List<WebElement> getIrrigationSourceInformationAllTfElements() {
			return IrrigationSourceInformationAllTfElements;
		}

		public List<WebElement> getCropsDetailsAllTfElements() {
			return CropsDetailsAllTfElements;
		}

		public List<WebElement> getApplicatiofornewoffgridAllTfElements() {
			return ApplicatiofornewoffgridAllTfElements;
		}

		public WebElement getEyebtn2() {
			return eyebtn2;
		}
		
	

		


		
		
		

}

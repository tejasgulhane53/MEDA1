package POM_Meda_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Beneficiary_Reg_Page 
{
    //existing diesel pump dropdown 
    @FindBy(id ="is_ext_user")
    private  WebElement ExistingpumpDropdown;

    //adhar number textfield
    @FindBy(id="aadhar_no")
    private WebElement Adharnum;
    
    //state disabled textfield
    @FindBy(id="state")
    private WebElement stateTextfield;
    
    //Land district dropdown
    @FindBy(id="district_id_2")
    private WebElement LnddistDropdown;
    
  //Land taluka dropdown
    @FindBy(id="taluka_2")
    private WebElement LndTalukaDropdown;
    
  //Land Village dropdown
    @FindBy(id="village_2")
    private WebElement LndvillageDropdown;
    
    //mobile number textfield
    @FindBy(id="mobile_2")
    private WebElement phnoTextfield;
    
 
   
	//Caste Catogery dropdown
    @FindBy(id="cast_category")
    private WebElement CastcategoryTextfield;
    
    //email id textfield
    @FindBy(id="email")
    private WebElement emailTextfield;
    
  //van patte dropdown
    @FindBy(id="van_patte_holder")
    private WebElement VanPatte_Dropdown;
    
    //Hamipatra popup handle help of radio button and submit button
    @FindBy(id="van_patte_accept")
    private WebElement HamipatraRadiobtn;
    
    //hamipatra submit button
    @FindBy(id ="und_submit")
    private WebElement hamipatrasubmitBTN;
    
    
    public WebElement getHamipatraRadiobtn() {
		return HamipatraRadiobtn;
	}

	public WebElement getHamipatrasubmitBTN() {
		return hamipatrasubmitBTN;
	}

	//Name Textfield
    @FindBy(id="name")
    private WebElement userNameTf;
    
    @FindBy(id="father_husband")
    private WebElement FatherNameTf;
    
    @FindBy(id="surname")
    private WebElement SurnameTf;
    
    //button of submit application
    @FindBy(id ="btn_van_patte_holder")
    private WebElement applicationSubmitbtn;
    
    //after submit the application getting msg "are you sure to continue btn"
    @FindBy(xpath="//button[text()='Yes, continue!']")
    private WebElement yesContinuebtn;
    
    //after recieving the otp we have to verify
    @FindBy(xpath="//button[text()='Verify OTP']")
    private WebElement verifybuttonElement;
    
    
    @FindBy(id="is_verify_cast")
    private  WebElement PayForOnlineAppBtn;
    
    
    
    public WebElement getPayForOnlineAppBtn()
    {
		return PayForOnlineAppBtn;
	}
    
    public WebElement getVanPatte_Dropdown() {
		return VanPatte_Dropdown;
	}

	public WebElement getUserNameTf() {
		return userNameTf;
	}

	public WebElement getFatherNameTf() {
		return FatherNameTf;
	}

	public WebElement getSurnameTf() {
		return SurnameTf;
	}

	public WebElement getSubmitbtn() {
		return applicationSubmitbtn;
	}

	
    
   
   
  public WebElement getVerifybuttonElement() {
		return verifybuttonElement;
	}

public WebElement getApplicationSubmitbtn() {
		return applicationSubmitbtn;
	}

	public WebElement getYesContinuebtn() {
		return yesContinuebtn;
	}

	//------------->  
    //after click on some drop are visible
    @FindBy(id="ext_src_pow")
    private WebElement source_powerexistingpumpdrop;
    
    //radio button
    @FindBy(id="undertaking_accpet")
    private WebElement infoPopup_radiobtn;
    
    @FindBy(xpath="(//button[text()='Submit'])[2]")
    private WebElement popupsubmitBtn;
    
	

	public WebElement getPopupsubmitBtn() {
		return popupsubmitBtn;
	}

	@FindBy(id ="ext_pmp_typ")
    private WebElement existing_pumpTypeDrop;
    
    @FindBy(id ="ext_pmp_sbtyp")
    private WebElement existing_pumpsubTypeDrop;
    
    @FindBy(id ="ext_pmp_cp")
    private WebElement existing_pump_Capin_HPDrop;
    
    @FindBy(id="ext_eff_pmp")
    private WebElement Energy_EficientPumpDrop;
    
    @FindBy(id="ext_anu_dsl")
    private WebElement annualDesealTextfield;

  // --------------->  
    
    public WebElement getAnnualDesealTextfield() 
    {
		return annualDesealTextfield;
	}
    
    public WebElement getInfoPopup_radiobtn() 
    {
		return infoPopup_radiobtn;
	}

	//Village List Button
    @FindBy(xpath="//a[text()='Safe Villages List']")
    private WebElement Villagelistbtn;

	public WebElement getSource_powerexistingpumpdrop() {
		return source_powerexistingpumpdrop;
	}

	public WebElement getExisting_pumpTypeDrop() {
		return existing_pumpTypeDrop;
	}

	public WebElement getExisting_pumpsubTypeDrop() {
		return existing_pumpsubTypeDrop;
	}

	public WebElement getExisting_pump_Capin_HPDrop() {
		return existing_pump_Capin_HPDrop;
	}

	public WebElement getEnergy_EficientPumpDrop() {
		return Energy_EficientPumpDrop;
	}

	public WebElement getVillagelistbtn() {
		return Villagelistbtn;
	}

	public WebElement getExistingpumpDropdown() {
		return ExistingpumpDropdown;
	}

	public WebElement getAdharnum() {
		return Adharnum;
	}

	public WebElement getStateTextfield() {
		return stateTextfield;
	}

	public WebElement getLnddistDropdown() {
		return LnddistDropdown;
	}

	public WebElement getLndTalukaDropdown() {
		return LndTalukaDropdown;
	}

	public WebElement getLndvillageDropdown() {
		return LndvillageDropdown;
	}

	public WebElement getPhnoTextfield() {
		return phnoTextfield;
	}

	public WebElement getCastcategoryTextfield() {
		return CastcategoryTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}
    
    
	
    
    
}

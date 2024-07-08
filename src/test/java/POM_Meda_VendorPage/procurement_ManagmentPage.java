package POM_Meda_VendorPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class procurement_ManagmentPage
{
	
  @FindBy(xpath ="(//a[@class='waves-effect waves-dark'])[2]")
  private WebElement procurement;
  
  @FindBy(xpath ="(//ul[@class='active'])[2]//li")
  private List<WebElement> Links_4;
  
  @FindBy(xpath="//li[text()='Pump Management']")
  private WebElement PumpManagement;
  
  //elements of pump mgment
  @FindBy(id="scheme")
  private  WebElement Pumpmgmnt_Scheme;
  
  @FindBy(id="oem_name")
  private  WebElement Pumpmgmnt_oem_name;
  
  @FindBy(id="pumptype")
  private  WebElement Pumpmgmnt_pumptype;
  
  
  @FindBy(id="pumpsubtype")
  private  WebElement Pumpmgmnt_pumpsubtype;
  
  @FindBy(id="pumpcapacity")
  private  WebElement Pumpmgmnt_pumpcapacity;
  
  @FindBy(id="quantity")
  private  WebElement Pumpmgmnt_quantityTF;
  
  @FindBy(id="pumpcat")
  private  WebElement Pumpmgmnt_pumpcatagiry;
  
  @FindBy(id="pumpsrc")
  private  WebElement Pumpmgmnt_pumpsrc;
  
  @FindBy(id="addids")
  private WebElement uploadFilePumpMgmnt;
  
  @FindBy(xpath="//button[text()='Submit']")
  private WebElement pumpsubmitbtn;
  
  @FindBy(xpath="//button[text()='Cancel']")
  private WebElement pumpCanclebtn;
  
  
  @FindBy(xpath="(//a[@class='view_certificate btn btn-info'])[1]")
  private WebElement Downloadidslink1;
  
  @FindBy(xpath="(//a[@class='view_certificate btn btn-info'])[2]")
  private WebElement Downloadidslink2;
  
  
  
  
  public WebElement getDownloadidslink1() {
	return Downloadidslink1;
}

public WebElement getDownloadidslink2() {
	return Downloadidslink2;
}

public WebElement getPumpmgmnt_Scheme() {
	return Pumpmgmnt_Scheme;
}

public WebElement getPumpmgmnt_oem_name() {
	return Pumpmgmnt_oem_name;
}

public WebElement getPumpmgmnt_pumptype() {
	return Pumpmgmnt_pumptype;
}

public WebElement getPumpmgmnt_pumpsubtype() {
	return Pumpmgmnt_pumpsubtype;
}

public WebElement getPumpmgmnt_pumpcapacity() {
	return Pumpmgmnt_pumpcapacity;
}

public WebElement getPumpmgmnt_quantityTF() {
	return Pumpmgmnt_quantityTF;
}

public WebElement getPumpmgmnt_pumpcatagiry() {
	return Pumpmgmnt_pumpcatagiry;
}

public WebElement getPumpmgmnt_pumpsrc() {
	return Pumpmgmnt_pumpsrc;
}

public WebElement getUploadFilePumpMgmnt() {
	return uploadFilePumpMgmnt;
}

public WebElement getPumpsubmitbtn() {
	return pumpsubmitbtn;
}

public WebElement getPumpCanclebtn() {
	return pumpCanclebtn;
}


//controller management---------------
@FindBy(xpath="//li[text()='Controller Management']")
  private WebElement ControllerManagement;

//elements of pump mgment
@FindBy(id="scheme")
private  WebElement Controllermgmnt_Scheme;

@FindBy(id="oem_name")
private  WebElement Controller_oem_name;

@FindBy(id="addControllers")
private WebElement UploadControlerFile;

  
  @FindBy(xpath="//li[text()='Structure Management']")
  private WebElement StructureManagement;
  
  @FindBy(xpath="//button[text()='Submit']")
  private WebElement Controllersubmitbtn;
  

   @FindBy(xpath = "//a[@href='https://innoproduction.in/meda/meda_vendor/manage/generate_password']")
   private WebElement GenratePassword;
   
   @FindBy(xpath="//a[text()='Test RMS Data']")
   private WebElement TestRmsData;
   
   @FindBy(xpath ="//button[text()='Ok']")
   private WebElement okpopup;
   
   @FindBy(xpath ="//a[text()='Cancel ']")
   private WebElement control_gen_passcanclebtn;
   
   
     
   
public WebElement getControl_gen_passcanclebtn() {
	return control_gen_passcanclebtn;
}

public WebElement getOkpopup() {
	return okpopup;
}

public WebElement getTestRmsData() {
	return TestRmsData;
}

public WebElement getGenratePassword() {
	return GenratePassword;
}

public WebElement getControllermgmnt_Scheme() {
	return Controllermgmnt_Scheme;
}

public WebElement getController_oem_name() {
	return Controller_oem_name;
}

public WebElement getUploadControlerFile() {
	return UploadControlerFile;
}

public WebElement getControllersubmitbtn() {
	return Controllersubmitbtn;
}

public WebElement getProcurement() {
	return procurement;
}

public List<WebElement> getLinks_4() {
	return Links_4;
}

public WebElement getPumpManagement() {
	return PumpManagement;
}

public WebElement getControllerManagement() {
	return ControllerManagement;
}

public WebElement getPanelManagement() {
	return panelManagement;
}

public WebElement getStructureManagement() {
	return StructureManagement;
}
	
 //panel management

@FindBy(xpath="//li[text()='Panel Management']")
private WebElement panelManagement ;

  
//elements of pump mgment
@FindBy(id="scheme")
private  WebElement Panelmgmnt_Schemedrop;

@FindBy(id="oem_name")
private  WebElement Panel_oem_name;

@FindBy(id="panel_type")
private WebElement panel_typeTf;

@FindBy(id="panel_capacity")
private WebElement panel_capacityTf;

	
@FindBy(id="size")
private WebElement panelSizeTf;

@FindBy(id="iac_certificate")
private WebElement Paneliac_certificateUpload;

@FindBy(id="addids")
private WebElement panel_idertificateupload; 

@FindBy(xpath ="//button[text()='Submit']")
private WebElement  panelsubmitbtn;


@FindBy(xpath="//table[@class='table table-bordered table-striped']")
private WebElement panelmgmtList;

@FindBy(xpath ="(//a[@class='view_certificate btn btn-warning'])[1]")
private WebElement panelView1;

@FindBy(xpath ="(//a[@class='view_certificate btn btn-warning'])[2]")
private WebElement panelView2;

@FindBy(xpath="(//a[@class='remove_pump_type btn btn-danger'])[1]")
private WebElement RemovePanel1;




public WebElement getPanelmgmtList() {
	return panelmgmtList;
}

public WebElement getPanelView1() {
	return panelView1;
}

public WebElement getPanelView2() {
	return panelView2;
}

public WebElement getRemovePanel1() {
	return RemovePanel1;
}

public WebElement getPanelmgmnt_Schemedrop() {
	return Panelmgmnt_Schemedrop;
}

public WebElement getPanel_oem_name() {
	return Panel_oem_name;
}

public WebElement getPanel_typeTf() {
	return panel_typeTf;
}

public WebElement getPanel_capacityTf() {
	return panel_capacityTf;
}

public WebElement getPanelSizeTf() {
	return panelSizeTf;
}

public WebElement getPaneliac_certificateUpload() {
	return Paneliac_certificateUpload;
}

public WebElement getPanel_idertificateupload() {
	return panel_idertificateupload;
}

public WebElement getPanelsubmitbtn() {
	return panelsubmitbtn;
}


//sturctureManagement

@FindBy(xpath ="//li[text()='Structure Management']")
private WebElement StructureMgmt;

@FindBy(id="steel_type")
private WebElement steel_typeTf;

@FindBy(id="galvanize")
private WebElement galvanizedrop;

@FindBy(id="co_man_tra")
private WebElement Coaxial_Manual_trackerDrop;

@FindBy(xpath ="//button[text()='Submit']")
private WebElement  Structmgmtsubmitbtn;

@FindBy(xpath ="//a[@class='remove_pump_type btn btn-danger']")
private WebElement StructureDeletebtn;


@FindBy(xpath ="//button[text()='Cancel']")
private WebElement canclebtnpopup;

@FindBy(xpath ="//button[text()='Yes!']")
private WebElement Yesbtnpopup;

@FindBy(xpath="//div[@class='sweet-alert  showSweetAlert visible']")
private WebElement StructRemovepopup;




public WebElement getStructRemovepopup() {
	return StructRemovepopup;
}

public WebElement getCanclebtnpopup() {
	return canclebtnpopup;
}

public WebElement getYesbtnpopup() {
	return Yesbtnpopup;
}

public WebElement getStructureMgmt() {
	return StructureMgmt;
}

public WebElement getSteel_typeTf() {
	return steel_typeTf;
}

public WebElement getGalvanizedrop() {
	return galvanizedrop;
}

public WebElement getCoaxial_Manual_trackerDrop() {
	return Coaxial_Manual_trackerDrop;
}

public WebElement getStructmgmtsubmitbtn() {
	return Structmgmtsubmitbtn;
}

public WebElement getStructureDeletebtn() {
	return StructureDeletebtn;
}




}

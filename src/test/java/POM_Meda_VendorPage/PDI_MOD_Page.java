package POM_Meda_VendorPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PDI_MOD_Page 
{
	
	@FindBy(xpath ="(//a[@class='waves-effect waves-dark'])[5]")
	private WebElement PDImodule;
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/work/pdi_data/1']")
	private WebElement pdi_Controller;
	
	@FindBy(xpath ="(//button[@class='btn btn-submit'])[1]")
	private WebElement Controller_details;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']//td")
	private List <WebElement> Controller_rows;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']//th")
	private List <WebElement> Controller_1stSColumnRow;

	@FindBy(xpath ="//img[@class='card-img-top']")
	private List<WebElement>  ControllerDetailImg;
	
	
	@FindBy(xpath ="(//div[@class=\"modal-content\"])[3]")
	private WebElement ControllerDetailpage;
	
	
	@FindBy(xpath="//button[text()='×']")
	private WebElement closebtn;
	
	
	
	
	public WebElement getClosebtn() {
		return closebtn;
	}

	public WebElement getControllerDetailpage() {
		return ControllerDetailpage;
	}

	public List<WebElement> getControllerDetailImg() {
		return ControllerDetailImg;
	}

	public WebElement getPDImodule() {
		return PDImodule;
	}

	public WebElement getPdi_Controller() {
		return pdi_Controller;
	}

	public WebElement getController_details() {
		return Controller_details;
	}

	public List<WebElement> getController_rows() {
		return Controller_rows;
	}

	public List<WebElement> getController_1stSColumnRow() {
		return Controller_1stSColumnRow;
	}
	
	
	
	//pump set
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/work/pdi_data/2']")
	private WebElement setPumplink;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']//td")
	private List <WebElement> setPump_rows;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']//th")
	private List <WebElement> Setpump_1stSColumnRow;
	
	@FindBy(xpath ="(//button[@class='btn btn-submit'])[1]")
	private WebElement Setpump_details;


	
	@FindBy(xpath ="//table[@class='table table-hover']//tr")
	private List <WebElement> setPumpDetailsTable;
	
	
	@FindBy(xpath ="//img[@class='card-img-top']")
	private List <WebElement> setPumpImage;
	
	


	public List<WebElement> getSetPumpImage() {
		return setPumpImage;
	}

	public WebElement getSetpump_details() {
		return Setpump_details;
	}

	public List<WebElement> getSetPumpDetailsTable() {
		return setPumpDetailsTable;
	}

	public WebElement getSetPumplink() {
		return setPumplink;
	}

	public List<WebElement> getSetPump_rows() {
		return setPump_rows;
	}

	public List<WebElement> getSetpump_1stSColumnRow() {
		return Setpump_1stSColumnRow;
	}

	

	//mms
	
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/work/pdi_data/3']")
	private WebElement Mmslink;
	
	@FindBy(xpath ="(//button[@class='btn btn-submit'])[1]")
	private WebElement mmsDetails;
	
	
	@FindBy(xpath ="//table[@class='table table-hover']//tr")
	private List <WebElement> MMSDetailsTables;
	
	
	@FindBy(xpath ="//img[@class='card-img-top']")
	private List <WebElement> mmsdetailsImage;




	public WebElement getMmslink() {
		return Mmslink;
	}

	public WebElement getMmsDetails() {
		return mmsDetails;
	}

	public List<WebElement> getMMSDetailsTables() {
		return MMSDetailsTables;
	}

	public List<WebElement> getMmsdetailsImage() {
		return mmsdetailsImage;
	}
	
	
	
	//modules
	@FindBy(xpath ="//a[@href='https://innoproduction.in/meda/meda_vendor/work/pdi_data/4']")
	private WebElement Moduleslink;
	
	@FindBy(xpath ="(//button[@class='btn btn-submit'])[1]")
	private WebElement ModulesDetails;
	
	
	@FindBy(xpath ="//table[@class='table table-hover']//tr")
	private List <WebElement> ModulesDetailsTables;
	
	
	@FindBy(xpath ="//img[@class='card-img-top']")
	private List <WebElement> ModulesdetailsImage;




	public WebElement getModuleslink() {
		return Moduleslink;
	}

	public WebElement getModulesDetails() {
		return ModulesDetails;
	}

	public List<WebElement> getModulesDetailsTables() {
		return ModulesDetailsTables;
	}

	public List<WebElement> getModulesdetailsImage() {
		return ModulesdetailsImage;
	}
	
	
	
	
}

package POM_DGM_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DGM_DashboardPanelPage 
{
	
	//menu toggle
	@FindBy(xpath="//div[@class='menu-toggle']")
	private WebElement MenuToggleHeader;
	
    //Meda logo on dgm panel
	@FindBy(xpath="//img[@src='https://innoproduction.in/meda/uat/assets/images/logo.png']")
	private WebElement DGMLogoImge;
	
	//beside title img of pump 
	@FindBy(xpath="//img[@src='https://innoproduction.in/meda/uat/assets/images/logo.png']")
	private WebElement ImgePump;
	
	//maha krushi urja abhiyan dropdown single select purpose
	@FindBy(id="master_scheme")
	private WebElement MahakrushiUrjaDropdown;
	
	@FindBy(id="master_scheme")
	private List<WebElement> MahakrushiDropdowMultiple;
	
	//Beneficiary Statistic Report
	@FindBy(xpath="(//*[local-name()='svg'])[1]")
	private WebElement BeneficiaryReport;
	
	//user dropdown profile logo
	@FindBy(id="userDropdown")
	private WebElement userDropdownProfLogo;
	
	//minimiz and fullscreen button
	@FindBy(xpath="//i[@class='i-Full-Screen header-icon d-none d-sm-inline-block']")
	private WebElement fullscreenbtn;
	
	 //Notification bar btn
	 @FindBy(xpath="//i[@class='i-Bell text-muted header-icon']")
	 private WebElement Notificatiobtn;

	 //menu bar toggle  of Beneficiary statististic report
	 @FindBy(xpath="(//button[@title='Chart context menu'])[1]")
	 private WebElement benfReportToggle;
	 
	 
	 //Castewise Pie chart displayed or not 
	 @FindBy(xpath="(//*[local-name()='svg'])[2]")
	 private WebElement CasteWisePiechartReport;
	 
	 //castwise pieChart ToggleMenubar
	 @FindBy(xpath="(//button[@title='Chart context menu'])[2]")
	 private WebElement MenubarTogglePieChart;
	 
	 //fullscreen btn headerpart
	 @FindBy(xpath="//li[text()='View in full screen']")
	 private WebElement PieChartFullScreenBtn;
		
		
	public WebElement getMenuToggleHeader() 
	{
		return MenuToggleHeader;
	}

	public WebElement getDGMLogoImge()
	{
		return DGMLogoImge;
	}

	public WebElement getImgePump() 
	{
		return ImgePump;
	}

	public WebElement getMahakrushiUrjaDropdown()
	{
		return MahakrushiUrjaDropdown;
	}

	public WebElement getBeneficiaryReport() 
	{
		return BeneficiaryReport;
	}

	public List<WebElement> getMahakrushiDropdowMultiple() 
	{
		return MahakrushiDropdowMultiple;
	}

	public WebElement getUserDropdownProfLogo() 
	{
		return userDropdownProfLogo;
	}

	public WebElement getFullscreenbtn()
	{
		return fullscreenbtn;
	}

	public WebElement getNotificatiobtn() 
	{
		return Notificatiobtn;
	}

	public WebElement getBenfReportToggle() 
	{
		return benfReportToggle;
	}

	public WebElement getCasteWisePiechartReport()
	{
		return CasteWisePiechartReport;
	}

	public WebElement getMenubarTogglePieChart() 
	{
		return MenubarTogglePieChart;
	}

	public WebElement getPieChartFullScreenBtn() 
	{
		return PieChartFullScreenBtn;
	}

	
	//------------------------State Scheme sub module of dashboard----------------------------
	
	@FindBy(xpath="//span[text()='State Scheme']")
	private WebElement StateSchememodule;
	
	
	@FindBy(xpath="//span[text()='Scheme']")
	private WebElement Schemebtn;


	public WebElement getStateSchememodule()
	{
		return StateSchememodule;
	}

	public WebElement getSchemebtn() 
	{
		return Schemebtn;
	}
	
	
	//---------------------------central scheme --------------------------------
	
	@FindBy(xpath="//span[text()='Central Scheme']")
	private WebElement CentralSchememodule;
	
	//scheme btn
	@FindBy(xpath="(//span[text()='Scheme'])[2]")
	private WebElement centralSchemebtn;
	
	//central scheme img
	@FindBy(xpath="//img[@src=\"https://innoproduction.in/meda/uat/uploads/solar/logo/10/538dcf9d8b98ac9a193a01f25d975ad2\"]")
	private WebElement ImgCentralScheme;
	
	//view logs
	@FindBy(xpath="//a[@data-toggle='tooltip']")
	private WebElement ViewLogbtn;


	public WebElement getCentralSchememodule()
	{
		return CentralSchememodule;
	}

	public WebElement getCentralSchemebtn() 
	{
		return centralSchemebtn;
	}

	public WebElement getImgCentralScheme()
	{
		return ImgCentralScheme;
	}

	public WebElement getViewLogbtn()
	{
		return ViewLogbtn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

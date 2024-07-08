package POM_Meda_VendorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkOrder_Page 
{
	
	@FindBy(xpath="(//a[@class=' waves-effect waves-dark'])[4]")
	private WebElement WorkOrder;
	
	
	
	@FindBy(id ="project_id")
	private WebElement SchemeDrop;


	//table after selecting drop 
	@FindBy(xpath ="//table[@class='table table-bordered table-striped']")
	private WebElement workordertable;
	
	
	@FindBy(xpath="//button[@data-toggle='tooltip']")
    private WebElement WorkOrderZip;
	
	
	
	
	public WebElement getWorkOrderZip() {
		return WorkOrderZip;
	}


	public WebElement getWorkordertable() {
		return workordertable;
	}


	public WebElement getWorkOrder() {
		return WorkOrder;
	}



	public WebElement getSchemeDrop() {
		return SchemeDrop;
	}
	
	

}

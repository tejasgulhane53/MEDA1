package Common_Utils1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utils1 
{
	//beneficiary reg
	public String getDataFromPropertiesfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Beneficiary_reg and loginfiles\\Benifeciary_reg_url.properties.txt");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String value = p.getProperty(key);
		
		return value;
			
	}
	
	//beneficiary login
	public String getDataFromPropertiesfileLgnPage(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Beneficiary_reg and loginfiles\\Beneficiary_LoginCredential.properties.txt");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String value = p.getProperty(key);
		
		return value;	
		
	}
	
	//DGM LOGIN
	public String getDataFromPropertiesfileDGMPage(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Beneficiary_reg and loginfiles\\DGM_Login.properties.txt");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String value = p.getProperty(key);
		
		return value;
		
	}
	
	//Vendor login
	
	public String getDataFromPropertiesfileVendor(String key) throws IOException
	{
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Beneficiary_reg and loginfiles\\VendorData.properties.txt");
		
		Properties p  = new Properties();
		
		p.load(fis);
		
	   String value =	p.getProperty(key);
	   
	   return value;
		
		
		
		
	}


}

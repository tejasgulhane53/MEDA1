package Common_Utils1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import POM_DGM_Pages.DGM_StateCentralBeneficiaryPage;


public class ExcelUtils1 
{
	WebDriver driver ;
	//write the data in excel sheet from table
	
	public void WriteDataFromTableinExcel(WebDriver driver) throws IOException, InterruptedException
	{
		
	   List<WebElement> Cname = driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]//th"));
	   
	   List<WebElement> Tablerows = driver.findElements(By.xpath("//table[@id=\"DataTables_Table_0\"]//td"));
	   
	   
	
      
       Workbook wb = new XSSFWorkbook();
       Sheet sheet = wb.createSheet("Sheet1");

       // Write Column to the first row
       
       Row row1 = sheet.createRow(0);
       for (int i = 0; i < Cname.size(); i++) 
       {
           row1.createCell(i).setCellValue(Cname.get(i).getText());
       }

     
       int rowNum =1;
       for (WebElement row : Tablerows)
       {
           Row excelRow = sheet.createRow(rowNum++);
          
           excelRow.createCell(rowNum).setCellValue(row.getText());
           
       }
       
       
         // Thread.sleep(4000);
          
          //driver.findElement(By.xpath("(//a[text()='Next'])[2]")).click();
	
   
      
       
	   FileOutputStream fis = new FileOutputStream("src\\test\\resources\\WriteExcelData\\LocationDetailsFetch.xlsx");

       wb.write(fis);
      
	} 
	   
	   
	
	
	
	//getDataFromPropertyFile
	public String getDataFromExcelFile(String sheet, int rownum, int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\ReadExcel\\Nanded_Beneficiary.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet(sheet);
		
		Row rw = sh.getRow(rownum);
		
		Cell c1 = rw.getCell(cellnum);
		
	   String value = c1.getStringCellValue();
		
	   return value;
		
	}
	
	
	//getDataFromExcel file
	public String getDataFromExcelFileParbhani_Benef(String sheet, int rownum, int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream("src\\test\\resources\\ReadExcel\\Parbhani_Beneficiary.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet(sheet);
		
		Row rw = sh.getRow(rownum);
		
		Cell c1 = rw.getCell(cellnum);
		
	    String value = c1.getStringCellValue();
		
	    return value;
		
	}
	
	
	     //this method to get the all rows in excel sheet
      public int getTotalRows(String sheetName) throws IOException 
	 {
    	  
    	  FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\ReadExcel\\Parbhani_Beneficiary.xlsx");
	       
	        Workbook workbook = WorkbookFactory.create(fileInputStream);
	        
	        Sheet sheet = workbook.getSheet(sheetName);
	        
	        int lastRowNum = sheet.getLastRowNum();
	       
	        workbook.close();
	       
	        fileInputStream.close();
	        
	        return lastRowNum + 1;   	
		       
		        
	  }
		
	
		
	
	
	
	
	
	
	
	
	
	}
	
	
	   
	   
	   
	    
	    
		
	



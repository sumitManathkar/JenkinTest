package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;

public class Util {
	//Workbook workbook=null;
	public static WebDriver OpenBrowser(String bName, String URL){
		WebDriver driver=null;
		if(bName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			driver.get(URL);
		}
		return driver;
	}
	
	public static Object[][] ReadExcelData(String fName) throws Exception{
		FileInputStream fileInputStream= new FileInputStream(fName); //Excel sheet file location get mentioned here
		Workbook workbook = Workbook.getWorkbook(fileInputStream);; //get my workbook 
        Sheet worksheet=workbook.getSheet(0);// get my sheet from workbook
        Cell[] Row=worksheet.getRow(0);//getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getRows();//getPhysicalNumberOfRows();// count my number of Rows
        System.out.println(RowNum);
        int ColNum= Row.length;//Row.getLastCellNum(); // get last ColNum 
         
        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
               // HSSFRow row= worksheet.getRow(i+1);
                Cell[] row=worksheet.getRow(i+1); 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                       // HSSFCell cell= row.getCell(j);
                        Cell cell=worksheet.getCell(j, i);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            //String value=formatter.formatCellValue(cell);
                        	//CellFormat f=cell.getCellFormat();
                            String value=cell.getContents();
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
		

            }
            return Data;
		}
}

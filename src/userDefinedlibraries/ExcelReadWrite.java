package userDefinedlibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWrite {
	public static File src;
	public static String exfilepath = "C:\\Users\\user\\eclipse-workspace\\AlertHandling\\src\\Datatable\\alert_handling_details.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook; 
	public static XSSFSheet sheet;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String category1;
    public static String category2;
    
	
    //TO READ DATA FROM EXCEL SHEET
	public static int readexcel() throws IOException {
		try
	    {
			src=new File(exfilepath);
			fileip = new FileInputStream(src);
		    workbook = new XSSFWorkbook(fileip); 
		    sheet = workbook.getSheetAt(0);
		    
	    	for(int i=1; i<=sheet.getLastRowNum(); i++)
	        {
	            if(i==1)
	            {
	                 category1 = (sheet.getRow(i).getCell(0)).getStringCellValue();
	                 category2 = (sheet.getRow(i).getCell(1)).getStringCellValue();
	                
	                 row=i;	                 
	                 break;
	            }
	        }	    	
	    }
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
        }
		catch (IOException e)
		{
        	e.printStackTrace();
		}
		return row;
	}
	
	//TO WRITE DATA FROM EXCEL SHEET
	public static boolean writeExcel(String sheetName, int colNumber, int rowNum, String value)
    {
        try
        {
            sheet = workbook.getSheet(sheetName);
            Row = sheet.getRow(rowNum);
            if(Row==null)
                Row = sheet.createRow(rowNum);
 
            cell = Row.getCell(colNumber);
            if(cell == null)
                cell = Row.createCell(colNumber);
 
            cell.setCellValue(value);
 
            fileop = new FileOutputStream(exfilepath);
            workbook.write(fileop);
            fileop.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
	}
	






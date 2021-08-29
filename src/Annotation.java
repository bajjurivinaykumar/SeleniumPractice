import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Annotation{
	
    public static final String currentDir = System.getProperty("user.dir");
 
    public static String testDataExcelPath = currentDir + "\\src\\resources\\testdata.xlsx";
 
    private static XSSFWorkbook excelWBook;
  
    private static XSSFSheet excelWSheet;
    
    private static XSSFCell cell;
 
    private static XSSFRow row;
  
    public static int rowNumber;
   
    public static int columnNumber;
	
@DataProvider(name="getTestData")
public Object[][] getData()
{	
	try {
		 FileInputStream ExcelFile = new FileInputStream(testDataExcelPath );
		 System.out.println(testDataExcelPath);
		excelWBook = new XSSFWorkbook(ExcelFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 System.out.println(testDataExcelPath);

    excelWSheet = excelWBook.getSheet("Revision");
    int rowCount = excelWSheet.getPhysicalNumberOfRows();
    int columnCount = excelWSheet.getRow(0).getPhysicalNumberOfCells();
    //Row header = excelWSheet.getRow(0);
    System.out.println("Excel rows: "+ rowCount + " " +columnCount);
    Object[][] obj  = new Object[rowCount-1][columnCount];
    
    for(int i = 1; i < rowCount; i++)
    {            	
       	for (int j =0; j<columnCount; j++)
      	{
       	 System.out.println("I: "+ i + "J: " +j + "Data: " +excelWSheet.getRow(i).getCell(j).toString() );
       		   obj[i-1][j] = excelWSheet.getRow(i).getCell(j).toString();   	
      	}
    	
    }
 	return obj;
}

@Test(dataProvider = "getTestData")
public void testMethod(String p1, String p2, String p3, String p4, String p5)
{
	System.out.println(p1 +"    "+p2+"   "+p3+"   "+p4+"   "+p5);
	
}

}

//extent Reports
package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.annotations.DataProvider;


public class DataProviders {
	
	@DataProvider(name="Data")
	public static String[][] getAllData() throws IOException
	{
		String userDir = System.getProperty("user.dir");
        String path = userDir + "/testData/User.xlsx";
		
		XLUtility xl=new XLUtility(path);
		
		
		int rownum=xl.getRowCount("UserData");
		int colcount=xl.getCellCount("UserData", 1);
		
		
		String apidata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("UserData", i, j);
			}
		}
		return apidata;
		
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String userDir = System.getProperty("user.dir");
        String path = userDir + "/testData/User.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("UserData");
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("UserData", i, 1);
		}

		return apidata;

	}
	

}

package utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	
	// Data provider
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		
		// . in file path represent current project location
		String path = ".\\testdata\\Opencart_LoginData.xlsx"; // take excel file path which is present in test data folder.
		ExcelUtility xlutil = new ExcelUtility(path); // create the object of excel utility.
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		System.out.println(totalrows);
		System.out.println(totalcols);
		String logindata[][]= new String[totalrows][totalcols];
		
		for(int i =1;i<=totalrows;i++) {
			
			for(int j =0;j<totalcols;j++) {
				
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
				System.out.println(i + "+++++++++++++++++");
				System.out.println(j + " ////////////////");
				
				System.out.println(Arrays.deepToString(logindata));
			}
				
		}
		return logindata;
		
	}
	
	//DataProvider 2..
//	...
//	...
//	..

}
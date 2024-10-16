package com.saag.Base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClsTestData 
{
	public static Object[][] getExcelData(String fPath) throws Exception
	{
		Object[][] myData=null;
		XSSFWorkbook wb=new XSSFWorkbook(fPath);
		XSSFSheet ws= wb.getSheet("Sheet1");
		int rows=ws.getPhysicalNumberOfRows();
		myData=new Object[rows-1][2];

		for(int i=1;i<rows;i++)
		{
			myData[i-1][0]=ws.getRow(i).getCell(0).getStringCellValue();
			myData[i-1][1]=ws.getRow(i).getCell(1).getStringCellValue();
		}

		return myData;
	}
}






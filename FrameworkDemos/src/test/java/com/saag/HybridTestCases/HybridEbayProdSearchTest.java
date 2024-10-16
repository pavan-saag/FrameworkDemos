package com.saag.HybridTestCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saag.Base.ClsEbay;
import com.saag.Base.ClsTestData;
import com.saag.Base.TestBase;

public class HybridEbayProdSearchTest extends TestBase
{
	@Test(dataProvider = "ebayData")
	public void prodSearch(String cat,String prod) 
	{
		ClsEbay obj=new ClsEbay(driver);
		obj.fnProdSearch(prod);

		Reporter.log("'" + prod + "' Product Search Test is Successful...",true);
	}

	@DataProvider
	public Object[][] ebayData() throws Exception
	{
		Object[][] myData=ClsTestData.getExcelData(".\\src\\test\\resources\\Excel\\DDFEbayTestData.xlsx");

		return myData;
	}
}
















package com.saag.DDFTestCases;

import org.testng.annotations.Test;

import com.saag.Base.TestBase;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DDFEbayProdCatSearchTest extends TestBase
{
	@Test(dataProvider = "ebayData")
	public void catSearch(String cat,String prod) 
	{
		WebElement dd=driver.findElement(By.id("gh-cat"));
		Select s=new Select(dd);
		s.selectByVisibleText(cat);

		WebElement txt=driver.findElement(By.id("gh-ac"));
		txt.clear();
		txt.sendKeys(prod);
		driver.findElement(By.id("gh-btn")).click();

		Reporter.log("'" + prod + "' Product Search in '" + cat + "' Category Test is Successful...",true);
	}

	@DataProvider
	public Object[][] ebayData() throws Exception
	{
		Object[][] myData=null;
		XSSFWorkbook wb=new XSSFWorkbook(".\\src\\test\\resources\\Excel\\DDFEbayTestData.xlsx");
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

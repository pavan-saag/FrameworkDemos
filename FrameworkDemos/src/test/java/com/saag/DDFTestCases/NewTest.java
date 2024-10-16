package com.saag.DDFTestCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.*;

import com.saag.Base.TestBase;

public class NewTest extends TestBase {
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
		Object[][] myData=new Object[2][2];
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=testDB;integratedsecurity=true");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from ebayinput");
		
		int i=0;
		while(rs.next())
		{
			myData[i][0]=rs.getString(1);
			myData[i][1]=rs.getString(2);
			i=i+1;
		}
		
		return myData;
	}
}

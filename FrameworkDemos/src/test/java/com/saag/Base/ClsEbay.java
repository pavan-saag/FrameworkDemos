package com.saag.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClsEbay extends TestBase
{
	public WebDriver wd;
	
	public ClsEbay(WebDriver d)
	{
		wd=d;
	}
	
	public void fnProdSearch(String prodName)
	{
		WebElement txt=wd.findElement(By.id(pOR.getProperty("txtSearch")));
		txt.clear();
		txt.sendKeys(prodName);
		wd.findElement(By.id(pOR.getProperty("btnSearch"))).click();
	}
	
	public void fnProdCatSearch(String cat,String pName)
	{
		WebElement dd=wd.findElement(By.id(pOR.getProperty("ddCat")));
		Select s=new Select(dd);
		s.selectByVisibleText(cat);
		
		fnProdSearch(pName);
	}
}










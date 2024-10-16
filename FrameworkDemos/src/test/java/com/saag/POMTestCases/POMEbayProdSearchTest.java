package com.saag.POMTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saag.Base.ClsEbay;
import com.saag.Base.TestBase;

public class POMEbayProdSearchTest extends TestBase
{
  @Test
  public void prodSearch() 
  {
	  ClsEbay obj=new ClsEbay(driver);
	  obj.fnProdSearch("Sony");
	  
	  Reporter.log("Ebay Product Search Test is Successful..",true);
  }
}













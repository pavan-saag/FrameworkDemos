package com.saag.POMTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saag.Base.ClsEbay;
import com.saag.Base.TestBase;

public class POMEbayProdCatSearchTest extends TestBase
{
  @Test
  public void catSearch()
  {
	 ClsEbay obj=new ClsEbay(driver);
	 obj.fnProdCatSearch("Cameras & Photo", "Sony");
	 
	 Reporter.log("Ebay Product search in a category test is successful...",true);
  }
}

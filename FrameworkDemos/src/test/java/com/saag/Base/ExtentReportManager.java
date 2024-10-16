package com.saag.Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkRep;
	public ExtentReports erp;
	public ExtentTest test;
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test=erp.createTest(result.getName());
		test.log(Status.PASS, "TestCase Passed is : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=erp.createTest(result.getName());
		test.log(Status.FAIL, "TestCase Failed is : " + result.getName());
		test.log(Status.FAIL, "TestCase Failed Because : " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=erp.createTest(result.getName());
		test.log(Status.SKIP, "TestCase Skipped is : " + result.getName());
	}

	@Override
	public void onStart(ITestContext context)
	{
		sparkRep=new ExtentSparkReporter(System.getProperty("user.dir") + "/srs/test/resources/Reports/myReport.html");
		sparkRep.config().setDocumentTitle("Selenium Automation Report");
		sparkRep.config().setReportName("Functionality Test");
		sparkRep.config().setTheme(Theme.DARK);
		
		erp=new ExtentReports();
		erp.attachReporter(sparkRep);
		
		erp.setSystemInfo("Computer Name", "localhost");
		erp.setSystemInfo("Environment", "QA");
		erp.setSystemInfo("Tester Name", "Pavan");
		erp.setSystemInfo("OS","Windows10");
		erp.setSystemInfo("BrowserName", "Chrome");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		erp.flush();
	}

}

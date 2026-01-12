package DesginFramework.TestComponent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DesignFramework.resources.TestReport;

public class Listners extends Baseclass implements ITestListener {
	ExtentTest test;
	ExtentReports report = TestReport.reportForTestCases();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.pass("passed Test cases");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// screenshot
		
		test.fail(result.getThrowable());
		
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String filePath = null;
		try {
			 filePath =captureScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		test.addScreenCaptureFromPath(filePath ,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		report.flush();
	}

}

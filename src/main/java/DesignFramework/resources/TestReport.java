package DesignFramework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReport {
	
	
	
	public static ExtentReports reportForTestCases() {
		
		String path = System.getProperty("user.dir") +"//Report//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		
		report.setSystemInfo("Tester", "Sumit Charpe");
		
		return report;
		
	}

}

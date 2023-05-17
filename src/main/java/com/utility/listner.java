package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listner extends Base_Utility implements ITestListener {
	
	ExtentReports extent= getreports();
	ThreadLocal<ExtentTest> extent_test=new ThreadLocal<ExtentTest>();

		public void onTestStart(ITestResult result) {
			test=extent.createTest(result.getTestClass().getName()+ " == " +result.getMethod().getMethodName());
	//		library.test.addScreenCaptureFromBase64String(getscreenshot());
			extent_test.set(test);
		}
	
		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS, "Test Case Pass" );
			test.addScreenCaptureFromBase64String(result.getName());
			
		}
	
		public void onTestFailure(ITestResult result) {
			test.log(Status.FAIL, "Test Case Fail");
			test.addScreenCaptureFromBase64String(result.getName());
//			library.test.addScreenCaptureFromBase64String(getscreenshot1());
			
		}
	
		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, "Test Case Skip");
		}
	
	
		public void onFinish(ITestContext context) {
			extent.flush();
		}
		
		
		public String getcapcture(String screenshot_name) {
			String destination = System.getProperty("user.dir")+ "/failed_Tests_ScreenShots/" + 
					screenshot_name +".png";
			try {
				
				TakesScreenshot ts=(TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File finaldestination = new File(destination);
				FileUtils.copyFile(source, finaldestination);
			

			} catch (Exception e) {
				System.out.println(e);
			}			
			return destination;
		}
		

		
	

}

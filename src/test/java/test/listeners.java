package test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.screenshot;

public class listeners extends BaseTest implements ITestListener{
	
   public void onStart(ITestContext result) {
	  reports=Reports.confiReports(); 
   }
   public void onTestStart(ITestResult result) {
	System.out.println("Test Start" + result.getName()); 
 }
    public void onTestSuccess(ITestResult result) {
	System.out.println("Test Success" + result.getName());
    	test.log(Status.PASS,result.getName());
  }
    public void onTestFailure(ITestResult result) {
	System.out.println("Test fail" + result.getName());
	test.log(Status.FAIL,result.getName());

	  try {
	      screenshot.takeScreenshot(driver, result.getName());
	}
	 catch(IOException e) {
	    e.printStackTrace();
	}
  }
     public void onTestSkipped(ITestResult result) {
	 System.out.println("Test Skipped" + result.getName());
     test.log(Status.SKIP,result.getName());

     }
	 
	public void onFinish(ITestContext result) {
		reports.flush();
	}
	
}
	
	
	
	
	
	



	

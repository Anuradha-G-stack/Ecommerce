package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest  {
	public static WebDriver driver;
	 Select select;
      public static ExtentReports reports;
      public static ExtentTest test;
      
	  public void switchToChildBrowser() {
	  Set<String> handles =driver.getWindowHandles();
	  Iterator<String> i=handles.iterator();
		while(i.hasNext())
		 {
		    driver.switchTo().window(i.next());
	
     	}
		
	}
	
	
}

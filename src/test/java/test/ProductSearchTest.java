package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.NaaptalHomePage;

@Listeners (test.listeners.class)
 public class ProductSearchTest extends BaseTest {
	@BeforeMethod
    public void openApplication(){
	driver= Browser.launchApplication();
  }
   @Test
    public void VerifyIfUserisAbletoClickOnlogin(){
     test=reports.createTest("VerifyIfUserisAbletoClickOnlogin");
     NaaptalHomePage naaptalhomepage=new NaaptalHomePage (driver);
     naaptalhomepage.clickonloginOrRegister();
  }
 
   @Test
   public void VerifyIfUserisAbletoSearchProduct(){
	 test=reports.createTest("VerifyIfUserisAbletoSearchProduct");
	NaaptalHomePage naaptalhomepage=new NaaptalHomePage (driver);
	naaptalhomepage.enterProductTosearch("coocker");
	naaptalhomepage.ClickOnsearch();
	Assert.assertTrue(driver.getTitle().contains("coocker"));
	Assert.assertTrue(naaptalhomepage.getNumberOfProductDisplayed()>0);

 }
 @Test
  public void VerifyIfUserisAbletoDisplayShoppingcatagories(){
	test=reports.createTest("VerifyIfUserisAbletoDisplayShoppingcatagories");
	NaaptalHomePage naaptalhomepage=new NaaptalHomePage (driver);
	naaptalhomepage.ViewShoppingCategories(driver);
	Assert.assertTrue(naaptalhomepage.islistproductdisplyed());
 }
	
  @Test
  public void VerifyIfUserisClickOnAddCart(){
	test=reports.createTest("VerifyIfUserisClickOnAddCart");
	NaaptalHomePage naaptalhomepage=new NaaptalHomePage (driver);
    naaptalhomepage.cart();
	Assert.assertTrue(naaptalhomepage.ClickOnAddToCartPage());
 }
 @Test
 public void VerifyIfUserisClickOnTrackOrder(){
	test=reports.createTest("VerifyIfUserisClickOnTrackOrder");
	NaaptalHomePage naaptalhomepage=new NaaptalHomePage (driver);
    naaptalhomepage.clickontrackOrder();
    String name=naaptalhomepage.clickonTrackOrderandcheck();
    Assert.assertEquals(naaptalhomepage.clickonTrackOrderandcheck(),name);
    	  
   }
	 
}
	
	


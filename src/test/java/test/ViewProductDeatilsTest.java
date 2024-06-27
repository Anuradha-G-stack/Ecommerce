package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptalHomePage;
import pom.ProductResultPage;
import pom.ProductdetailsPage;
@Listeners (test.listeners.class)
public class ViewProductDeatilsTest extends BaseTest {

	
	@BeforeMethod
	 public void openApplication()
	 {
		driver= Browser.launchApplication();
   }
	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView(){
	test=reports.createTest("verifyIfUserIsViewProductDetailsFromQuickView");
	NaaptalHomePage naaptalhomepage=new NaaptalHomePage(driver);
	naaptalhomepage.enterProductTosearch("shoes");
	naaptalhomepage.ClickOnsearch();
	ProductResultPage productResultPage = new ProductResultPage(driver);
	String productName = productResultPage.getProductTitle(1);
	Double productPrice = productResultPage.getProductPriceOnQuickView();
	productResultPage.moveToDesiredProduct(driver, 1);
	productResultPage.clickOnQuickView(1);
	Assert.assertTrue(driver.getTitle().contains("shoes"));
	 Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);
		
		}
	@Test
	public void addproducttocart(){
		test=reports.createTest("addproducttocart");
		NaaptalHomePage naaptalhomepage=new NaaptalHomePage(driver);
		naaptalhomepage.enterProductTosearch("Mixer");
		naaptalhomepage.ClickOnsearch();
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		
		switchToChildBrowser();
        ProductdetailsPage productdetails = new ProductdetailsPage(driver);
		productdetails.clickToClickhereToBuyProduct();
	 }
	
	
}

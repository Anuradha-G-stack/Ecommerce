package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CartPage;
import pom.NaaptalHomePage;
import pom.PaymentPage;
import pom.ProductResultPage;
import pom.ProductdetailsPage;
import pom.loginPage;
import utility.Reports;

@Listeners(test.listeners.class)
public class CartTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver = Browser.launchApplication();
	}

	@Test
	public void VerifyAddProductFromOrderDetails() throws InterruptedException {
		test = reports.createTest("VerifyAddProductFromOrderDetails");
		NaaptalHomePage naaptalhomepage = new NaaptalHomePage(driver);
		naaptalhomepage.enterProductTosearch("cooker");
		naaptalhomepage.ClickOnsearch();
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);

		switchToChildBrowser();
		ProductdetailsPage productdetailspage = new ProductdetailsPage(driver);
		String Expectedname = productResultPage.getProductNameOnQuickView();
		Double ExpectedPrice = productResultPage.getProductPriceOnQuickView();
		Double ExpectedShipping = productdetailspage.getShippingPrice();
		productdetailspage.clickToClickhereToBuyProduct();
		productResultPage.verifyUserIsAbleToClickOnContinueShopping();
		naaptalhomepage.enterProductTosearch("toys");
		naaptalhomepage.ClickOnsearch();
		productResultPage.selectDesiredProduct(0);

		switchToChildBrowser();
		productdetailspage.clickToClickhereToBuyProduct();
		CartPage cartPage = new CartPage(driver);

		Assert.assertNotEquals(productResultPage.NoOfProductInCart(), 0);
		String Expectedname1 = productResultPage.getProductNameOnQuickView();
		Double ExpectedPrice1 = productResultPage.getProductPriceOnQuickView();
		Double ExpectedShipping1 = productdetailspage.getShippingPrice();

		Assert.assertEquals(cartPage.getNumberOfProductinCart(), 2);
		Assert.assertEquals(cartPage.getNameOfproductInCart(1), Expectedname);
		Assert.assertEquals(cartPage.getNameOfproductInCart(0), Expectedname1);
		Assert.assertEquals(cartPage.getProductPrice(2), ExpectedPrice);
		Assert.assertEquals(cartPage.getProductPrice(1), ExpectedPrice1);
		Assert.assertEquals(cartPage.getShippingPrice(2), ExpectedShipping);
		Assert.assertEquals(cartPage.getShippingPrice(1), ExpectedShipping1);

		cartPage.VerifyUserIsAbleToRemoveProduct(1);
		Thread.sleep(1000);
		cartPage.VerifyUserIsAbleToRemoveProduct(0);
		// cartPage.VerifyUserIsAbleTocloseTheAddToCartPage();

	}

	@Test
	public void VerifyIfUserIsAbleToProceedCheckout()
			throws InterruptedException, EncryptedDocumentException, IOException {
		test = reports.createTest("VerifyIfUserIsAbleToProceedCheckout");

		NaaptalHomePage naaptalhomepage = new NaaptalHomePage(driver);

		naaptalhomepage.enterProductTosearch("toys");
		naaptalhomepage.ClickOnsearch();
		ProductResultPage productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);

		switchToChildBrowser();
		ProductdetailsPage productdetails = new ProductdetailsPage(driver);
		productdetails.clickToClickhereToBuyProduct();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnProceedToCheck();
		loginPage loginpage = new loginPage(driver);
		Thread.sleep(3000);
		loginpage.checkUserIsAbleToEnterTheMoblieNo("9511253656");
		loginpage.clickOnContinue();
		Thread.sleep(20000);
		loginpage.verifyIfUserIsClickOnSumbittButtonAfterEntreTheOtp();
		loginpage.selectTitleWhileenteringTheAddress(2);
		loginpage.verifyUserIsableToEnterFirstnameInFirstnameField();
		loginpage.verifyUserIsableToEnterLastnameInLastnameField();
		loginpage.verifyUserIsableToEnterAddresInAddresField();
		loginpage.verifyUserIsableToEnterLandMarkInLandMarkField();
		loginpage.verifyUserIsableToEnterPinCoadeInPinCodeField();
		loginpage.verifyUserIsableToEnterMobileNumberInMobileNumberField();
		loginpage.verifyUserIsableToEnterMobilelandlineNumberInlandlineNumberField();
		loginpage.clickOnAddNewAddress();
		loginpage.verfyIfUserIsAbleToSelectShippingAdd();
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.verifyToCheckUserIsAbleToSelectPaymentMode(0);
		// paymentPage.clickOnPlaceOrder();

	}
}

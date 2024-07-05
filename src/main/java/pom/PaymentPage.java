package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
	@FindBy(xpath = "(//label[@class='paymentModeGroup_label'])")
	private List<WebElement> paymentMode;
	@FindBy(xpath = "//a[@class='red_button_normal']")
	private WebElement placeOrder;

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyToCheckUserIsAbleToSelectPaymentMode(int index) {
		paymentMode.get(index).click();
	}

	public void clickOnPlaceOrder() {
		placeOrder.click();
	}
}

package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductdetailsPage extends BasePage {

	@FindBy(xpath = "//div[@id='square_Details']//h1")
	private WebElement productNameOnQuickView;
	@FindBy(xpath = "//div[@id='square_Details']//span[@class='offer-price']")
	private WebElement productPriceOnQuickView;

	@FindBy(xpath = "//a[@class='red_button icon chat']")
	private WebElement ClickHereToBuyProduct;

	@FindBy(xpath="//div[@class='boxSelection']//li")private List<WebElement> size;
	
	public ProductdetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productNameOnQuickView.getText();
	}

	public double getProductPrice() {
		String[] p = productPriceOnQuickView.getText().split(" ");
		return Double.parseDouble(removeCommaFromString(p[0]));
	}

	public double getShippingPrice() {
		String[] p = productPriceOnQuickView.getText().split(" ");
		return Double.parseDouble(removeCommaFromString(p[2]));
	}

	public void clickToClickhereToBuyProduct() {
		ClickHereToBuyProduct.click();
	}
	public void selectSize(int index) {
		size.get(index).click();
	}
}
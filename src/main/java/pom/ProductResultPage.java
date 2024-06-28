package pom;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductResultPage extends BasePage {
	

	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath = "//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	@FindBy (xpath = "//div[@class='item_title']//a")private List<WebElement> productTitle;
	@FindBy (xpath = "//span[@class='offer-price']")private List<WebElement> offerPrice;
	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productNameOnQuickView;
	@FindBy (xpath = "//div[@id='square_Details']//span[@class='offer-price']")private WebElement productPriceOnQuickView;
	@FindBy(xpath="(//span[@class='ship-price'])[1]")private List<WebElement> shippingPrice;
    @FindBy (xpath="(//span[@class='font-bold'])[4]")private WebElement TotalNoOfProduct;
    @FindBy (xpath="(//a[@class='link_Continue'])[2]")private WebElement continueShopping;
	public ProductResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	
	public void selectDesiredProduct(int index) {
		products.get(index).click();
	}
	
	public void clickOnQuickView(int index) {
		quickView.get(index).click();
	}
	
	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}
	
	public Double getshippingPrice(int index){
		String [] s= shippingPrice.get(index).getText().split(" ");
		return Double.parseDouble(removeCommaFromString(s[0]));
	}
	public String getProductNameOnQuickView() {
		return productNameOnQuickView.getText();
	}
	
	public Double getProductPriceOnQuickView() {
	   String [] p =	productPriceOnQuickView.getText().split(" ");
	   return Double.parseDouble(removeCommaFromString (p[0]));

    }
    public String NoOfProductInCart() {
	  return TotalNoOfProduct.getText();
		
	}
    public void verifyUserIsAbleToClickOnContinueShopping() {
    	continueShopping.click();
    }
}
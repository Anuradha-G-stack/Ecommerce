 package pom;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage  extends BasePage{
	
	@FindBy (xpath="//ul[@id='cartData']")private List<WebElement> products;
    @FindBy (xpath="//ul[@class='clearfix']//h2")private List<WebElement>productName;
    @FindBy (xpath="//li[@class='head_UPrice']")private List<WebElement>productPrice;
    @FindBy (xpath="//li[@class='head_ship']")private List<WebElement>shippingPrice;
    @FindBy (xpath="//a[@title='Close']")private WebElement closeOnCart;
    @FindBy (xpath="//p[@class='chintu']//a")private List<WebElement> remove;
    @FindBy (xpath="(//a[@class='red_button2'])[2]")private WebElement proceedToCheck;
    
    public CartPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public int getNumberOfProductinCart() {
    	 return products.size();
    }
    
    public String getNameOfproductInCart(int index){
    	 return productName.get(index).getText();
    }
    
    public Double getProductPrice(int index) {
    	//index start from 1 as 0 is table heading
    	 return Double.parseDouble(removeCommaFromString(productPrice.get(index).getText().substring(3)));
      }
    public Double getShippingPrice(int index) {
    	//index start from 1 as 0 is table heading
         return Double.parseDouble(removeCommaFromString(shippingPrice.get(index).getText().substring(3)));
    }
    public void VerifyUserIsAbleTocloseTheAddToCartPage(){
    	closeOnCart.click();
    }
    public void VerifyUserIsAbleToRemoveProduct(int index) {
    	remove.get(index).click();
    }
    public void clickOnProceedToCheck() {
    	proceedToCheck.click();
    }
    }



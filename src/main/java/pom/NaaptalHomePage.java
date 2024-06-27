
package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptalHomePage extends BasePage {
  @FindBy (xpath="//a[@id='login-panel-link']")private WebElement loginOrRegister;
  @FindBy(xpath="//a[text()='Track Order']")private WebElement trackOrder;
  @FindBy(xpath="//div[@class='cate_head']")private WebElement ShoppingCategories;
  @FindBy(xpath="//input[@id='header_search_text']")private WebElement searchfield;
  @FindBy(xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]")private WebElement search;
  @FindBy(xpath="(//a[@id='cart-panel-link'])[2]")private WebElement cart;
  @FindBy(xpath="//div[@id='mainMenuContent']//li")private WebElement listProduct;
  @FindBy(xpath="//div[@class='grid_Square ']")private List<WebElement> productList;
  @FindBy(xpath="//a[@class='link_Continue']")private WebElement AddToCartpage;
  @FindBy(xpath="//article[@id='staticContent']//section//h2")private WebElement trackOrderPage;
  
  public NaaptalHomePage(WebDriver driver){
	  PageFactory.initElements(driver, this);
  }
  public void clickonloginOrRegister(){
	  loginOrRegister.click();
  }
  public void clickontrackOrder(){
	   trackOrder.click();
  }
  public void ViewShoppingCategories(WebDriver driver){
	  Actions act=new Actions(driver);
	  act.moveToElement(ShoppingCategories);
      act.perform();
  }
  public boolean islistproductdisplyed(){
	 return listProduct.isDisplayed();
  }
  public  void enterProductTosearch(String product){
	  searchfield.sendKeys(product);
  }
  public void ClickOnsearch(){
	  search.click();
  }
  public void cart(){
	  cart.click();
  }
  public int getNumberOfProductDisplayed(){
	return productList.size();	 
  }
  
  public boolean ClickOnAddToCartPage(){
	  return AddToCartpage.isDisplayed();
  }
  public String clickonTrackOrderandcheck(){
	return trackOrderPage.getTagName();
  }
}

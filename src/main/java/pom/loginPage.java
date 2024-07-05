package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.parametrization;

public class loginPage extends BasePage {
	@FindBy(xpath = "//input[@id='gc-registration-basic-panel-mobile']")
	private WebElement mobileNumber;
	@FindBy(xpath = "(//input[@type='button'])[3]")
	private WebElement clickOnContinue;
	@FindBy(xpath = "//input[@id='gc-registration-otp-panel-submit']")
	private WebElement clickOnSubmitt;
	@FindBy(xpath = "//select[@name='fktitle_id']")
	private WebElement Title;
	@FindBy(xpath = "(//input[@class='input_Special'])[1]")
	private WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement address;
	@FindBy(xpath = "//input[@name='landmark']")
	private WebElement landMark;
	@FindBy(xpath = "//input[@name='pincode']")
	private WebElement pinCode;
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobileNo;
	@FindBy(xpath = "//input[@name='landline']")
	private WebElement landLineNo;
	@FindBy(xpath = "//a[@class='red_button_normal']")
	private WebElement clickOnAdd;
	@FindBy(xpath = "(//span[text()=' Ship to This Address '])[2]")
	private WebElement shipOnThisAddress;

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void checkUserIsAbleToEnterTheMoblieNo(CharSequence mobilenumber) {
		mobileNumber.sendKeys(mobilenumber);
	}

	public void clickOnContinue() {
		clickOnContinue.click();
	}

	public void verifyIfUserIsClickOnSumbittButtonAfterEntreTheOtp() {
		clickOnSubmitt.click();
	}

	public void selectTitleWhileenteringTheAddress(int index) {
		Select select = new Select(Title);
		select.selectByIndex(index);
	}

	public void verifyUserIsableToEnterFirstnameInFirstnameField() throws EncryptedDocumentException, IOException {
		String name = parametrization.getdata(0, 0, "sheet1");
		firstname.sendKeys(name);
	}

	public void verifyUserIsableToEnterLastnameInLastnameField() throws EncryptedDocumentException, IOException {
		String Lastname = parametrization.getdata(1, 0, "sheet1");
		lastName.sendKeys(Lastname);
	}

	public void verifyUserIsableToEnterAddresInAddresField() throws EncryptedDocumentException, IOException {
		String Address = parametrization.getdata(2, 0, "sheet1");
		address.sendKeys(Address);
	}

	public void verifyUserIsableToEnterLandMarkInLandMarkField() throws EncryptedDocumentException, IOException {
		String Landmark = parametrization.getdata(3, 0, "sheet1");
		landMark.sendKeys(Landmark);
	}

	public void verifyUserIsableToEnterPinCoadeInPinCodeField() throws EncryptedDocumentException, IOException {
		String pincode = parametrization.getdata(4, 0, "sheet1");
		pinCode.sendKeys(pincode);
	}

	public void verifyUserIsableToEnterMobileNumberInMobileNumberField()
			throws EncryptedDocumentException, IOException {
		String mobilenumber = parametrization.getdata(5, 0, "sheet1");
		mobileNo.sendKeys(mobilenumber);
	}

	public void verifyUserIsableToEnterMobilelandlineNumberInlandlineNumberField()
			throws EncryptedDocumentException, IOException {
		String landlinenumber = parametrization.getdata(6, 0, "sheet1");
		mobileNo.sendKeys(landlinenumber);
	}

	public void clickOnAddNewAddress() {
		clickOnAdd.click();
	}

	public void verfyIfUserIsAbleToSelectShippingAdd() {
		shipOnThisAddress.click();
	}
}

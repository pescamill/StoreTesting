package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[data-target='#orderModal']")
	public WebElement placeOrderBtn;
	
	@FindBy(id = "name")
	public WebElement nameInput;
	
	@FindBy(id = "card")
	public WebElement creditCardInput;
	
	@FindBy(css = "button[onclick='purchaseOrder()']")
	public WebElement purchaseBtn;
	
	@FindBy(xpath = "/html/body/div[10]/h2")
	public WebElement alertSuccess;
	
	// Click on Place Order
	public void placeOrderClick() {
		wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
		placeOrderBtn.click();
	}

	// Input a name in the order
	public void setName(String name) {
		wait.until(ExpectedConditions.visibilityOf(nameInput));
		nameInput.sendKeys(name);
	}

	// Input a credit card in the order
	public void setCreditCard(String creditCard) {
		wait.until(ExpectedConditions.visibilityOf(creditCardInput));
		creditCardInput.sendKeys(creditCard);
	}

	// Click on Purchase Button
	public void clickPurchaseBtn() {
		wait.until(ExpectedConditions.visibilityOf(purchaseBtn));
		purchaseBtn.click();
	}
	
	//Assert buy successful
	public void assertSuccess() {
		wait.until(ExpectedConditions.visibilityOf(alertSuccess));
		assert(alertSuccess.isDisplayed());
	}
	
}

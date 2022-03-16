package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamsungGalaxyS6Page {
	WebDriver driver;
	WebDriverWait wait;
	
	public SamsungGalaxyS6Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[class='btn btn-success btn-lg']")
	public WebElement addToCartSamsung;
	
	@FindBy(xpath = "//a[@id='cartur']")
	public WebElement goToCart;
	
	// Add Samsung Galaxy S6 To Cart
	public void addToCartSamsung() {
		wait.until(ExpectedConditions.visibilityOf(addToCartSamsung));
		addToCartSamsung.click();
	}

	// Go to Cart Page
	public void goToCart() {
		wait.until(ExpectedConditions.visibilityOf(goToCart));
		goToCart.click();
	}
}

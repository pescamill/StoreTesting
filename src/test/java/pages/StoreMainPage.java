package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreMainPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public StoreMainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(linkText = "Samsung galaxy s6")
	public WebElement samsungGalaxyLink;
	
	@FindBy(xpath = "//*[@onclick=\"byCat('notebook')\"]")
	public WebElement notebookSectionBtn;
	
	@FindBy(linkText = "Sony vaio i5")
	public WebElement sonyVaioLink;
	
	//Click Samsung Galaxy S6 Link
	public void clickSamsungLink() {
		wait.until(ExpectedConditions.visibilityOf(samsungGalaxyLink));
		samsungGalaxyLink.click();
	}
	
	public void clickNotebookSection() {
		wait.until(ExpectedConditions.visibilityOf(notebookSectionBtn));
		notebookSectionBtn.click();
	}
	
	public void checkIfSonyVaioi5() {
		wait.until(ExpectedConditions.visibilityOf(sonyVaioLink));
		assert(sonyVaioLink.isDisplayed());
	}
	
}

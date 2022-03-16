package steps;

import org.openqa.selenium.WebDriver;

import pages.PlaceOrderPage;
import pages.SamsungGalaxyS6Page;
import pages.StoreMainPage;

public class StoreSteps {
	
	WebDriver driver;
	StoreMainPage mainPage;
	SamsungGalaxyS6Page samsungPage;
	PlaceOrderPage placeOrder;
	
	public StoreSteps(WebDriver driver){
		this.driver = driver;
		this.mainPage = new StoreMainPage(driver);
		this.samsungPage = new SamsungGalaxyS6Page(driver);
		this.placeOrder = new PlaceOrderPage(driver);
	}
	
	public void buySamsungGalaxyS6(String name, String creditCard) {
		mainPage.clickSamsungLink();
		samsungPage.addToCartSamsung();
		samsungPage.goToCart();
		placeOrder.placeOrderClick();
		placeOrder.setName(name);
		placeOrder.setCreditCard(creditCard);
		placeOrder.clickPurchaseBtn();
		placeOrder.assertSuccess();
	}
	
	public void checkNotebooks() {
		mainPage.clickNotebookSection();
		mainPage.checkIfSonyVaioi5();
	}
}

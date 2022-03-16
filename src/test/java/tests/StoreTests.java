package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.StoreMainPage;
import steps.StoreSteps;

public class StoreTests {
	
	public WebDriver driver;
	public StoreMainPage mainPage;
	public StoreSteps storeSteps;
	public ExtentReports report;
	public ExtentTest test;
	
	public final String baseUrl = "https://www.demoblaze.com/index.html";
	public final String driverPath = "src/main/resources/chromedriver";
	
	@BeforeMethod
	private void startDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		storeSteps = new StoreSteps(driver);
		report = new ExtentReports("/Users/pabloescamilla/Desktop/samsungtest.html");
		test = report.startTest("Store test");
	}
	
	@DataProvider(name = "inputs")
	public Object[][] getData(){
		return new Object[][] {
			{"Pablo Escamilla Anguiano", "0000 1111 2222 3333"},
			{"Juan Escamilla Anguiano", "4444 5555 6666 7777"},
			{"Diego Escamilla Anguiano", "8888 9999 4444 0000"}
		};
	}
	
	@Test(dataProvider = "inputs")
	private void buySamsungGalaxyS6Test(String input1, String input2) {
		storeSteps.buySamsungGalaxyS6(input1, input2);
		test.log(LogStatus.PASS, "Buy Samsung Galaxy S6 Success!");
	}
	
	@Test
	private void checkIfNotebooks() {		
		storeSteps.checkNotebooks();
		test.log(LogStatus.PASS, "Notebooks are available!");
	}
	
	@AfterMethod
	private void endEach() {
		driver.close();
	}
	
	@AfterTest
	private void endTest() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
}

package com.askomdch.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.askdomch.pageclasses.CartPage;
import com.askdomch.pageclasses.CheckoutConfirmationPage;
import com.askdomch.pageclasses.CheckoutPage;
import com.askdomch.pageclasses.HomePage;
import com.askdomch.pageclasses.SearchResultsPage;
import com.askdomch.pageclasses.StorePage;
import com.askdomch.pageclasses.TopNavigationMenu;
import com.askomdch.utilities.BrowserDriverManager;
import com.askomdch.utilities.Constants;

public class BaseTest {

	//protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseURL;
	protected TopNavigationMenu top;
	protected StorePage store;
	protected SearchResultsPage searchResults;
	protected HomePage home;
	protected CartPage cart;
	protected CheckoutPage checkout;
	protected CheckoutConfirmationPage checkoutConfirmation;
	private static Logger log = LogManager.getLogger(BaseTest.class);
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	@Parameters({ "browser" })
	public void browserDriverSetUp(String browser) {
		log.info("****** Before Method ******");
		setDriver(BrowserDriverManager.browserDriverSetup(browser));
		log.info("CURRENT THREAD: " + Thread.currentThread().getId()+ ","+" DRIVER: "+getDriver());
		getDriver().get(Constants.BASE_URL);
	}
	
    protected WebDriver getDriver(){
        return this.driver.get();
    }
    
    private void setDriver(WebDriver driver) {
    	this.driver.set(driver);
    }
    
	@AfterMethod
	public void commonTearDown() throws Exception {
		log.info("****** After Method ******");
		log.info("CURRENT THREAD: " + Thread.currentThread().getId()+ ","+" DRIVER: "+getDriver());
		getDriver().quit();
	}
}

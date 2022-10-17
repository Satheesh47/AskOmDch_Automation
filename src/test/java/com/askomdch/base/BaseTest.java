package com.askomdch.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.askdomch.pageclasses.CartPage;
import com.askdomch.pageclasses.CheckoutConfirmationPage;
import com.askdomch.pageclasses.CheckoutPage;
import com.askdomch.pageclasses.HomePage;
import com.askdomch.pageclasses.SearchResultsPage;
import com.askdomch.pageclasses.StorePage;
import com.askdomch.pageclasses.TopNavigationMenu;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.ExcelUtility;
import com.askomdch.utilities.WebDriverFactory;

public class BaseTest {
	
	protected WebDriver driver;
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
	
	@BeforeClass
	@Parameters({"browser"})
	public void browserSetUp(String browser) {
		log.info("****** Before Class ******");
		driver = WebDriverFactory.getInstance().getDriver(browser);
		driver.get(Constants.BASE_URL);
		top = new TopNavigationMenu(driver);
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "MyFirstTestCase");
	}
	
	
	@AfterClass
	public void commonTearDown() throws Exception {
		log.info("****** After Class ******");
		WebDriverFactory.getInstance().quitDriver();
	}

}

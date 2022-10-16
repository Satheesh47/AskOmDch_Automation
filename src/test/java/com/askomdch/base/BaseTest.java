package com.askomdch.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.askdomch.pageclasses.CartPage;
import com.askdomch.pageclasses.CheckoutConfirmationPage;
import com.askdomch.pageclasses.CheckoutPage;
import com.askdomch.pageclasses.HomePage;
import com.askdomch.pageclasses.SearchResultsPage;
import com.askdomch.pageclasses.StorePage;
import com.askdomch.pageclasses.TopNavigationMenu;
import com.askomdch.utilities.Constants;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	protected String baseURL;
	protected TopNavigationMenu top;
	protected StorePage store;
	protected SearchResultsPage searchResults;
	protected HomePage home;
	protected CartPage cart;
	protected CheckoutPage checkout;
	protected CheckoutConfirmationPage checkoutConfirmation;
	
	@BeforeClass
	@Parameters({"browser"})
	public void browserSetUp(String browser) {
		System.out.println("****** Before Class ******");
		driver = WebDriverFactory.getInstance().getDriver(browser);
		driver.get(Constants.BASE_URL);
		top = new TopNavigationMenu(driver);
		
	}
	
	@BeforeMethod
	public void methodSetUp() {
		//log.info("****** Before Method ******");
		System.out.println("****** Before Method ******");
		//CheckPoint.clearHasMap();
	}
	
	@AfterClass
	public void commonTearDown() throws Exception {
		System.out.println("****** After Class ******");
		WebDriverFactory.getInstance().quitDriver();
		
	}

}

package com.askomdch.testclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.askomdch.base.BaseTest;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.ExcelUtility;

public class MyFirstTestCase extends BaseTest {

	private static Logger log = LogManager.getLogger(MyFirstTestCase.class);

	@BeforeMethod
	public void methodSetUp() {
		log.info("****** Before Method ******");

		// CheckPoint.clearHasMap();
	}

	@Test(dataProvider = "guestCheckoutUsingDirectBankTransfer")
	public void guestCheckoutUsing_DirectBankTransfer(String productName, String firstName, String lastName, String streetAddress, String city, String zipCode, String mail) {
		store = top.storeClick();
		searchResults = store.searchProduct(productName.split(" ")[0]);

		Assert.assertTrue(searchResults.verifySearchResultTitle(productName.split(" ")[0]));
		cart = searchResults.clickAddToCartButton(productName).clickViewCart();
		Assert.assertTrue(cart.verifyProductName(productName));
		checkout = cart.clickProceedToCheckout();
		// Filling checkout form
		checkout.fillFirstNameField(firstName).fillLastNameField(lastName).fillStreetAddressField(streetAddress);
		checkout.fillCityField(city).fillZipCodeField(zipCode).fillEmailField(mail);
		// Order confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage(Constants.ORDER_CONFIRMATION_MESSAGE));

	}

	@Test
	public void loginAndCheckoutUsing_DirectBankTransfer() {

		store = top.storeClick();
		searchResults = store.searchProduct("Blue");
		Assert.assertTrue(searchResults.verifySearchResultTitle("Blue"));
		cart = searchResults.clickAddToCartButton("Blue Shoes").clickViewCart();
		Assert.assertTrue(cart.verifyProductName("Blue Shoes"));
		checkout = cart.clickProceedToCheckout();
		// User Login
		checkout.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		// Filling checkout form
		checkout.fillFirstNameField("Tester").fillLastNameField("Tester").fillStreetAddressField("123 Test Street");
		checkout.fillCityField("Chennai").fillZipCodeField("28951").fillEmailField("test@email.com");
		// Order Confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage(Constants.ORDER_CONFIRMATION_MESSAGE));
	}

	@AfterMethod
	public void closeBrowser() {
		log.info("****** After Method ******");
		driver.get(Constants.BASE_URL);
	}

	@DataProvider(name = "guestCheckoutUsingDirectBankTransfer")
	public Object[][] getGuestCheckoutUsingDirectBankTransfer() {
		Object[][] testData = ExcelUtility.getTestData("guestCheckoutUsing_DirectBankTransfer");
		return (testData);
	}

}

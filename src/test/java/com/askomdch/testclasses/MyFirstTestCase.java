package com.askomdch.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.askomdch.base.BaseTest;
import com.askomdch.utilities.Constants;

public class MyFirstTestCase extends BaseTest {
	
	@Test
	public void guestCheckoutUsing_DirectBankTransfer() {
		store = top.storeClick();
		searchResults = store.searchProduct("Blue");
		Assert.assertTrue(searchResults.verifySearchResultTitle("Blue"));
		cart = searchResults.addBlueShoeToCart();
		Assert.assertTrue(cart.verifyProductName("Blue Shoes"));
		checkout = cart.clickProceedToCheckout();
		// Filling checkout form
		checkout.fillFirstNameField("Tester");
		checkout.fillLastNameField("Tester");
		checkout.fillStreetAddressField("123 Test Street");
		checkout.fillCityField("Chennai");
		checkout.fillZipCodeField("28951");
		checkout.fillEmailField("test@email.com");
		// Order confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage("Thank you. Your order has been received."));
	}
	
	@Test
	public void loginAndCheckoutUsing_DirectBankTransfer() {
		store = top.storeClick();
		searchResults = store.searchProduct("Blue");
		Assert.assertTrue(searchResults.verifySearchResultTitle("Blue"));
		cart = searchResults.addBlueShoeToCart();
		Assert.assertTrue(cart.verifyProductName("Blue Shoes"));
		checkout = cart.clickProceedToCheckout();
		// User Login
		checkout.userLogin(Constants.USER_NAME, Constants.USER_PASSWORD);
		// Filling checkout form
		checkout.fillFirstNameField("Tester");
		checkout.fillLastNameField("Tester");
		checkout.fillStreetAddressField("123 Test Street");
		checkout.fillCityField("Chennai");
		checkout.fillZipCodeField("28951");
		checkout.fillEmailField("test@email.com");
		// Order Confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage("Thank you. Your order has been received."));
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("****** After Method ******");
		driver.get(Constants.BASE_URL);
	}

}

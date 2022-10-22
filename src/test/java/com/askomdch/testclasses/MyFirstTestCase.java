package com.askomdch.testclasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.askdomch.pageclasses.TopNavigationMenu;
import com.askomdch.base.BaseTest;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.ExcelUtility;

public class MyFirstTestCase extends BaseTest {

	@Test(dataProvider = "guestCheckoutUsingDirectBankTransfer")
	public void guestCheckoutUsing_DirectBankTransfer(String productName, String firstName, String lastName,
			String streetAddress, String city, String zipCode, String mail) {
		
		top = new TopNavigationMenu(getDriver());
		store = top.storeClick();
		Assert.assertTrue(store.verifyStoreURL());

		searchResults = store.searchProduct(productName.split(" ")[0]);

		Assert.assertTrue(searchResults.verifySearchResultTitle(productName.split(" ")[0]));
		cart = searchResults.clickAddToCartButton(productName).clickViewCart();
		Assert.assertTrue(cart.verifyCartURL());
		Assert.assertTrue(cart.verifyProductName(productName));
		checkout = cart.clickProceedToCheckout();
		// Filling checkout form
		Assert.assertTrue(checkout.verifyCheckoutURL());
		checkout.fillFirstNameField(firstName).fillLastNameField(lastName);

		checkout.fillStreetAddressField(streetAddress).fillCityField(city).fillZipCodeField(zipCode)
				.fillEmailField(mail);
		// Order confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyCheckoutConfURL());
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage(Constants.ORDER_CONFIRMATION_MESSAGE));

	}

	@Test(dataProvider = "loginAndCheckoutUsingDirectBankTransfer")
	public void loginAndCheckoutUsing_DirectBankTransfer(String productName, String userName, String password,
			String firstName, String lastName, String country, String streetAddress, String city, String state,
			String zipCode, String mail) {
		top = new TopNavigationMenu(getDriver());
		store = top.storeClick();
		Assert.assertTrue(store.verifyStoreURL());

		searchResults = store.searchProduct(productName.split(" ")[0]);
		Assert.assertTrue(searchResults.verifySearchResultTitle(productName.split(" ")[0]));
		cart = searchResults.clickAddToCartButton(productName).clickViewCart();
		Assert.assertTrue(cart.verifyCartURL());
		Assert.assertTrue(cart.verifyProductName(productName));
		checkout = cart.clickProceedToCheckout();

		Assert.assertTrue(checkout.verifyCheckoutURL());
		// User Login
		checkout.userLogin(userName, password);
		// Filling checkout form
		checkout.fillFirstNameField(firstName).fillLastNameField(lastName).selectCountry(country)
				.fillStreetAddressField(streetAddress);
		checkout.fillCityField(city).selectState(state).fillZipCodeField(zipCode).fillEmailField(mail);
		// Order Confirmation
		checkoutConfirmation = checkout.clickPlaceOrder();
		Assert.assertTrue(checkoutConfirmation.verifyCheckoutConfURL());
		Assert.assertTrue(checkoutConfirmation.verifyOrderConfirmationMessage(Constants.ORDER_CONFIRMATION_MESSAGE));
	}

	@DataProvider(name = "guestCheckoutUsingDirectBankTransfer")
	public Object[][] getGuestCheckoutUsingDirectBankTransfer() {
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "MyFirstTestCase");
		Object[][] testData = ExcelUtility.getTestData("guestCheckoutUsing_DirectBankTransfer");
		return (testData);
	}

	@DataProvider(name = "loginAndCheckoutUsingDirectBankTransfer")
	public Object[][] getLoginAndCheckoutUsingDirectBankTransfer() {
		ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "MyFirstTestCase");
		Object[][] testData = ExcelUtility.getTestData("loginAndCheckoutUsing_DirectBankTransfer");
		return (testData);
	}

}

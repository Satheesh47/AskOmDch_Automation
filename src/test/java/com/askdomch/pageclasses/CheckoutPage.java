package com.askdomch.pageclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.Util;

public class CheckoutPage extends CustomDriver {
	
	private String CHECKOUT_TITLE_FIELD = "xpath=>//h1[normalize-space()='Checkout']";
	private String FIRST_NAME_FIELD = "xpath=>//input[@name='billing_first_name']";
	private String LAST_NAME_FIELD = "xpath=>//input[@name='billing_last_name']";
	private String STREET_ADDRESS_FIELD = "xpath=>//input[@name='billing_address_1']";
	private String CITY_FIELD = "xpath=>//input[@name='billing_city']";
	private String ZIPCODE_FIELD = "xpath=>//input[@name='billing_postcode']";
	private String EMAIL_FIELD = "xpath=>//input[@name='billing_email']";
	private String PLACE_ORDER_BUTTON = "id=>place_order";
	private String LOGIN_LINK = "xpath=>//a[normalize-space()='Click here to login']";
	private String USERNAME_FIELD = "xpath=>//input[@name='username']";
	private String PASSWORD_FIELD = "xpath=>//input[@name='password']";
	private String LOGIN_BUTTON = "css=>button[value='Login']";
	private String COUNTRY_DROPDOWN = "id=>billing_country";
	private String STATE_DROPDOWN = "id=>billing_state";
	private String TITLE = "css=>.has-text-align-center";
	private static Logger log = LogManager.getLogger(CheckoutPage.class.getName());
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage fillFirstNameField(String data) {
		waitForElementVisible(CHECKOUT_TITLE_FIELD, 5,"\"Checkout Page title\"");
		waitForElementVisible(FIRST_NAME_FIELD, 5, "\"First Name field\"");
		sendData(FIRST_NAME_FIELD, data, "First Name field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillLastNameField(String data) {
		waitForElementVisible(LAST_NAME_FIELD, 5, "\"Last Name field\"");
		sendData(LAST_NAME_FIELD, data, "Last Name field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillStreetAddressField(String data) {
		waitForElementVisible(STREET_ADDRESS_FIELD, 5, "\"Street Address field\"");
		sendData(STREET_ADDRESS_FIELD, data, "Street Address field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillCityField(String data) {
		waitForElementVisible(CITY_FIELD, 5, "\"City field\"");
		sendData(CITY_FIELD, data, "City field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillZipCodeField(String data) {
		waitForElementVisible(ZIPCODE_FIELD, 5, "\"Zip Code field\"");
		sendData(ZIPCODE_FIELD, data, "Zip Code field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillEmailField(String data) {
		waitForElementVisible(EMAIL_FIELD, 5, "\"Email field\"");
		sendData(EMAIL_FIELD, data, "Email field in the Checkout page");
		return this;
	}
	
	public CheckoutConfirmationPage clickPlaceOrder() {
		waitForElementToBeClickable(PLACE_ORDER_BUTTON, 5);
		javascriptClick(PLACE_ORDER_BUTTON, "Place Order button");
		return new CheckoutConfirmationPage(driver);
	}
	
	public CheckoutPage selectCountry(String countryName) {
		waitForElementVisible(COUNTRY_DROPDOWN, 5, "\"Country dropdown\"");
		selectOption(COUNTRY_DROPDOWN, countryName, "Country dropdown");
		return this;
	}
	
	public CheckoutPage selectState(String stateName) {
		waitForElementVisible(STATE_DROPDOWN, 5, "\"State dropdown\"");
		selectOption(STATE_DROPDOWN, stateName, "State dropdown");
		return this;
	}
	
	public void userLogin(String userName, String password) {
		waitForElementVisible(CHECKOUT_TITLE_FIELD, 5,"\"Checkout Page title\"");
		elementClick(LOGIN_LINK, "Login link");
		waitForElementVisible(USERNAME_FIELD, 5,"\"Username field\"");
		sendData(USERNAME_FIELD, userName, "User name");
		sendData(PASSWORD_FIELD, password, "Password");
		elementClick(LOGIN_BUTTON, "Login button");
		log.info("Login: Username & Password entered");
		waitForElementInVisible(LOGIN_LINK, 5,"\"Login link\"");
	}
	
	public boolean verifyCheckoutURL() {
		waitForElementVisible(TITLE, 5,"\"Checkout Page title\"");
		return Util.verifyTextMatch(getURL(), Constants.CHECKOUT_URL);
	}
}

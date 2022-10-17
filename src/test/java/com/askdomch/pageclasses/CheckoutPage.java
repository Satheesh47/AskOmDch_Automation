package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;

public class CheckoutPage extends CustomDriver {
	
	//public WebDriver driver;
	private String CHECKOUT_TITLE_FIELD = "xpath=>//h1[normalize-space()='Checkout']";
	private String FIRST_NAME_FIELD = "xpath=>//input[@name='billing_first_name']";
	private String LAST_NAME_FIELD = "xpath=>//input[@name='billing_last_name']";
	private String STREET_ADDRESS_FIELD = "xpath=>//input[@name='billing_address_1']";
	private String CITY_FIELD = "xpath=>//input[@name='billing_city']";
	private String ZIPCODE_FIELD = "xpath=>//input[@name='billing_postcode']";
	private String EMAIL_FIELD = "xpath=>//input[@name='billing_email']";
	private String PLACE_ORDER_BUTTON = "css=>button[value='Place order']";
	private String LOGIN_LINK = "xpath=>//a[normalize-space()='Click here to login']";
	private String USERNAME_FIELD = "xpath=>//input[@name='username']";
	private String PASSWORD_FIELD = "xpath=>//input[@name='password']";
	private String LOGIN_BUTTON = "css=>button[value='Login']";
	private String COUNTRY_DROPDOWN = "id=>billing_country";
	private String STATE_DROPDOWN = "id=>billing_state";
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		//this.driver= driver;
	}
	
	public CheckoutPage fillFirstNameField(String data) {
		waitForElementVisible(CHECKOUT_TITLE_FIELD, 5);
		sendData(FIRST_NAME_FIELD, data, "First Name field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillLastNameField(String data) {
		sendData(LAST_NAME_FIELD, data, "Last Name field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillStreetAddressField(String data) {
		sendData(STREET_ADDRESS_FIELD, data, "Street Address field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillCityField(String data) {
		sendData(CITY_FIELD, data, "City field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillZipCodeField(String data) {
		sendData(ZIPCODE_FIELD, data, "Zip Code field in the Checkout page");
		return this;
	}
	
	public CheckoutPage fillEmailField(String data) {
		sendData(EMAIL_FIELD, data, "Email field in the Checkout page");
		return this;
	}
	
	public CheckoutConfirmationPage clickPlaceOrder() {
		elementClick(PLACE_ORDER_BUTTON, "Place Order button");
		return new CheckoutConfirmationPage(driver);
	}
	
	public CheckoutPage selectCountry(String countryName) {
		selectOption(COUNTRY_DROPDOWN, countryName, "Country dropdown");
		return this;
	}
	
	public CheckoutPage selectState(String stateName) {
		selectOption(STATE_DROPDOWN, stateName, "State dropdown");
		return this;
	}
	
	public void userLogin(String userName, String password) {
		waitForElementVisible(CHECKOUT_TITLE_FIELD, 5);
		elementClick(LOGIN_LINK, "Login link");
		waitForElementVisible(USERNAME_FIELD, 5);
		sendData(USERNAME_FIELD, userName, "User name");
		sendData(PASSWORD_FIELD, password, "Password");
		elementClick(LOGIN_BUTTON, "Login button");
		waitForElementInVisible(LOGIN_LINK, 5);
	}
}

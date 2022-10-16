package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;

public class CheckoutPage extends CustomDriver {
	
	public WebDriver driver;
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
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}
	
	public void fillFirstNameField(String data) {
		sendData(FIRST_NAME_FIELD, data, "First Name field in the Checkout page");
	}
	
	public void fillLastNameField(String data) {
		sendData(LAST_NAME_FIELD, data, "Last Name field in the Checkout page");
	}
	
	public void fillStreetAddressField(String data) {
		sendData(STREET_ADDRESS_FIELD, data, "Street Address field in the Checkout page");
	}
	
	public void fillCityField(String data) {
		sendData(CITY_FIELD, data, "City field in the Checkout page");
	}
	
	public void fillZipCodeField(String data) {
		sendData(ZIPCODE_FIELD, data, "Zip Code field in the Checkout page");
	}
	
	public void fillEmailField(String data) {
		sendData(EMAIL_FIELD, data, "Email field in the Checkout page");
	}
	
	public CheckoutConfirmationPage clickPlaceOrder() {
		elementClick(PLACE_ORDER_BUTTON, "Place Order button");
		return new CheckoutConfirmationPage(driver);
	}
	
	public void userLogin(String userName, String password) {
		elementClick(LOGIN_LINK, "Login link");
		waitForElementVisible(USERNAME_FIELD, 5);
		sendData(USERNAME_FIELD, userName, "User name");
		sendData(PASSWORD_FIELD, password, "Password");
		elementClick(LOGIN_BUTTON, "Login button");
		waitForElementInVisible(LOGIN_LINK, 5);
	}
	
	
	
	
	
	

}
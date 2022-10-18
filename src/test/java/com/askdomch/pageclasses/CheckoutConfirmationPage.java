package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.Util;

public class CheckoutConfirmationPage extends CustomDriver {
	
	//public WebDriver driver;
	private String ORDER_CONFIRMATION_FIELD = "css=>.woocommerce-notice";
	//private String TITLE = "css=>.has-text-align-center";
	
	public CheckoutConfirmationPage(WebDriver driver) {
		super(driver);
		//this.driver= driver;
	}
	
	public boolean verifyOrderConfirmationMessage(String expectedMessage) {
		return Util.verifyTextContains(getText(ORDER_CONFIRMATION_FIELD, "Order Confirmation field"), expectedMessage);
	}
	
	public boolean verifyCheckoutConfURL() {
		waitForElementVisible(ORDER_CONFIRMATION_FIELD, 5);
		return Util.verifyTextContains(getURL(), Constants.CHECKOUT_CONFIRMATION_URL);
	}

}

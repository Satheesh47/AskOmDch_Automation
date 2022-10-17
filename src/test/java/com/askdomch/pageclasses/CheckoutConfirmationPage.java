package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Util;

public class CheckoutConfirmationPage extends CustomDriver {
	
	//public WebDriver driver;
	private String ORDER_CONFIRMATION_FIELD = "css=>.woocommerce-notice";
	
	public CheckoutConfirmationPage(WebDriver driver) {
		super(driver);
		//this.driver= driver;
	}
	
	public boolean verifyOrderConfirmationMessage(String expectedMessage) {
		return Util.verifyTextContains(getText(ORDER_CONFIRMATION_FIELD, "Order Confirmation field"), expectedMessage);
	}

}

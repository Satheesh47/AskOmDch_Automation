package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Util;

public class CartPage extends CustomDriver {
	
	public WebDriver driver;
	private String PRODUCT_NAME = "css=>td[class='product-name'] a";
	private String CHECKOUT_BUTTON = "xpath=>//a[normalize-space()='Proceed to checkout']";
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}
	
	public boolean verifyProductName(String productName) {
		return Util.verifyTextContains(getText(PRODUCT_NAME, "Product Name in Cart"), productName);
	}
	
	public CheckoutPage clickProceedToCheckout() {
		elementClick(CHECKOUT_BUTTON, "Clicking on Proceed to Checkout button ..");
		return new CheckoutPage(driver);
	}
	
	

}

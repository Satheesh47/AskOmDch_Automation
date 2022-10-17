package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;

import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Util;

public class SearchResultsPage extends CustomDriver {
	
	//public WebDriver driver;
	private String SEARCH_RESULT_TITLE_FIELD = "css=>.woocommerce-products-header__title.page-title";
	private String VIEW_CART_LINK = "xpath=>//a[@title='View cart']";
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}
	
	public boolean verifySearchResultTitle(String productName) {
		waitForElementVisible(SEARCH_RESULT_TITLE_FIELD, 15);
		return Util.verifyTextContains(getText(SEARCH_RESULT_TITLE_FIELD, "Search Result title"), "Search results: �"+productName+"�");
	}
	
	public SearchResultsPage clickAddToCartButton(String productName) {
		String ADD_TO_CART_BUTTON = "xpath=>//a[@aria-label='Add �"+ productName +"� to your cart']";
		elementClick(ADD_TO_CART_BUTTON, "Add to Cart button");
		return this;
	}
	
	public CartPage clickViewCart() {
		waitForElementVisible(VIEW_CART_LINK,5);
		elementClick(VIEW_CART_LINK, "View Cart link");
		return new CartPage(driver);
	}

}
package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;

import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Util;

public class SearchResultsPage extends CustomDriver {
	
	private String SEARCH_RESULT_TITLE_FIELD = "css=>.woocommerce-products-header__title.page-title";
	private String VIEW_CART_LINK = "xpath=>//a[@title='View cart']";
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifySearchResultTitle(String productName) {
		String SEARCH_RESULT_TITLE_WITH_TEXT = "xpath=>//h1[contains(text(),'Search results: “"+ productName +"”')]";
		waitForElementVisible(SEARCH_RESULT_TITLE_WITH_TEXT, 15,"\"Search Results Page title\"");
		return Util.verifyTextContains(getText(SEARCH_RESULT_TITLE_FIELD, "Search Result title"), "Search results: “"+productName+"”");
	}
	
	public SearchResultsPage clickAddToCartButton(String productName) {
		String ADD_TO_CART_BUTTON = "xpath=>//a[@aria-label='Add “"+ productName +"” to your cart']";
		elementClick(ADD_TO_CART_BUTTON, "Add to Cart button");
		return this;
	}
	
	public CartPage clickViewCart() {
		waitForElementVisible(VIEW_CART_LINK,5,"\"View Cart link\"");
		elementClick(VIEW_CART_LINK, "View Cart link");
		return new CartPage(driver);
	}

}

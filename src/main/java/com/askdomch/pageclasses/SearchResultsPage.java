package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;

import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Util;

public class SearchResultsPage extends CustomDriver {
	
	public WebDriver driver;
	private String SEARCH_RESULT_TITLE_FIELD = "css=>.woocommerce-products-header__title.page-title";
	private String BLUE_SHOE_CART_BUTTON = "xpath=>//a[@aria-label='Add “Blue Shoes” to your cart']";
	private String VIEW_CART_LINK = "xpath=>//a[@title='View cart']";
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean verifySearchResultTitle(String productName) {
		waitForElementVisible(SEARCH_RESULT_TITLE_FIELD, 10);
		return Util.verifyTextContains(getText(SEARCH_RESULT_TITLE_FIELD, "Search Result Title"), "Search results: “"+productName+"”");
	}
	
	public CartPage addBlueShoeToCart() {
		elementClick(BLUE_SHOE_CART_BUTTON, "Add to Cart button");
		waitForElementVisible(VIEW_CART_LINK,5);
		elementClick(VIEW_CART_LINK, "View Cart link");
		return new CartPage(driver);
	}

}

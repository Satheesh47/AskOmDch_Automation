package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;
import com.askomdch.utilities.Constants;
import com.askomdch.utilities.Util;

public class StorePage extends CustomDriver {
	
	private String SEARCH_PRODUCT_FIELD = "xpath=>//input[@class='search-field']";
	private String SEARCH_BUTTON = "xpath=>//button[@type='submit' and @value='Search']";
	private String STORE_PAGE_TITLE = "css=>.woocommerce-products-header__title.page-title";
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public SearchResultsPage searchProduct(String productName) {
		sendData(SEARCH_PRODUCT_FIELD, productName, "Search field");
		elementClick(SEARCH_BUTTON, "Search Button");
		return new SearchResultsPage(driver);
	}
	
	public boolean verifyStoreURL() {
		waitForElementVisible(STORE_PAGE_TITLE, 5,"\"Store Page title\"");
		return Util.verifyTextMatch(getURL(), Constants.STORE_URL);
	}

}

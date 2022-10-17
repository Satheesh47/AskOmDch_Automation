package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;

public class StorePage extends CustomDriver {
	
	//public WebDriver driver;
	private String SEARCH_PRODUCT_FIELD = "xpath=>//input[@class='search-field']";
	private String SEARCH_BUTTON = "xpath=>//button[@type='submit' and @value='Search']"; 
	
	public StorePage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
	}
	
	public SearchResultsPage searchProduct(String productName) {
		sendData(SEARCH_PRODUCT_FIELD, productName, "Search field");
		elementClick(SEARCH_BUTTON, "Search Button");
		return new SearchResultsPage(driver);
	}

}

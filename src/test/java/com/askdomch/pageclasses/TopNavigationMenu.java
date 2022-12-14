package com.askdomch.pageclasses;

import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;

public class TopNavigationMenu extends CustomDriver {
	
	private String STORE_LINK = "css=>li[id='menu-item-1227'] a[class='menu-link']";
	
	public TopNavigationMenu(WebDriver driver) {
		super(driver);
	}
	
	public StorePage storeClick() {
		elementClick(STORE_LINK,"Store Link");
		return new StorePage(driver);
	}
}

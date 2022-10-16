package com.askdomch.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.askomdch.base.CustomDriver;

public class TopNavigationMenu extends CustomDriver {
	
	public WebDriver driver;
	private String STORE_LINK = "css=>li[id='menu-item-1227'] a[class='menu-link']";
	
	public TopNavigationMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public StorePage storeClick() {
		elementClick(STORE_LINK,"Store Link");
		//driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
		return new StorePage(driver);
	}
	
	
	

}

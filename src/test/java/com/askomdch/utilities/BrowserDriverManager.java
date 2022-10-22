package com.askomdch.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverManager {
	
	private static Logger log = LogManager.getLogger(BrowserDriverManager.class.getName());

	public static WebDriver browserDriverSetup(String browser) {
		WebDriver driver = null;
		
		try {
			if (browser.equalsIgnoreCase(Constants.FIREFOX)) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = setFirefoxOptions();
				driver = new FirefoxDriver(firefoxOptions);
				log.info("Firefox browser initiated");
			}
			if (browser.equalsIgnoreCase(Constants.CHROME)) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = setChromeOptions();
				driver = new ChromeDriver(chromeOptions);
				log.info("Chrome browser initiated");
			}
			if (browser.equalsIgnoreCase(Constants.EDGE)) {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();				
				log.info("Edge browser initiated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
    private static ChromeOptions setChromeOptions() {
    	ChromeOptions options = new ChromeOptions();
		/*
		 * options.setExperimentalOption("excludeSwitches",
		 * Collections.singletonList("enable-automation"));
		 * options.setExperimentalOption("useAutomationExtension", false);
		 * options.addArguments("--disable-web-security");
		 * options.addArguments("--no-proxy-server"); Map<String, Object> prefs = new
		 * HashMap<String, Object>(); prefs.put("credentials_enable_service", false);
		 * prefs.put("profile.password_manager_enabled", false);
		 * options.setExperimentalOption("prefs", prefs);
		 */
    	return options;		
    }
    
    private static FirefoxOptions setFirefoxOptions() {
    	FirefoxOptions options = new FirefoxOptions();
    	options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
    	return options;
    }
}

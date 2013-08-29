package com.bestbuy.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bestbuy.seleniumScreens.constants.Constants;

/**
 * This class with initialize the browser session as specified FunctionTest.xml
 */
public class LaunchApplication {

	public WebDriver driver;
	DesiredCapabilities capabilities;

	static Logger log = Logger.getLogger("LaunchApplication");

	/**
	 * This will return the driver of the initialized browser
	 * 
	 * @param selectedBrowser
	 *            This will get browser value from suite
	 * 
	 * @param selectedPlatform
	 *            This will get platform value from suite
	 * 
	 * @throws Exception
	 * 
	 * @throws MalformedURLException
	 */

	public WebDriver launchBrowser(String selectedBrowser,
			String selectedPlatform) throws Exception, MalformedURLException {

		URL server = new URL("http://localhost:4444/wd/hub/");

		if (selectedBrowser.toUpperCase().equals(Constants.FIREFOX)) {

			log.info(" LAUNCHING FIREFOX ");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("firefox");

		} else if (selectedBrowser.toUpperCase().equals(Constants.CHROME)) {

			log.info(" LAUNCHING GOOGLECHROME ");
			try {
				capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("chrome");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (selectedBrowser.toUpperCase().equals(Constants.SAFARI)) {

			log.info(" LAUNCHING SAFARI ");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("safari");
			capabilities.setCapability("safari.autostart ", true);

		} else if (selectedBrowser.toUpperCase().equals(Constants.IPHONE)) {
			try {
				log.info(" LAUNCHING IPHONE DRIVER");
				capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("iPhone");
				capabilities.setJavascriptEnabled(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (selectedBrowser.equalsIgnoreCase(Constants.OPERA)) {
			log.info(" LAUNCHING OPERA ");
			capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("opera");
			capabilities.setCapability("opera.autostart ", true);

		} else {
			throw new Exception(
					"ONLY FIREFOX,CHROME ,SAFARI AND IPHONEDRIVER WORKS");
		}

		if (selectedPlatform.equalsIgnoreCase("WINDOWS")) {
			capabilities.setCapability(CapabilityType.PLATFORM,
					Platform.WINDOWS);
		} else if (selectedPlatform.equalsIgnoreCase("LINUX")) {
			capabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		} else if (selectedPlatform.equalsIgnoreCase("MAC")) {
			capabilities.setCapability(CapabilityType.PLATFORM, Platform.MAC);
		}
		return driver = new RemoteWebDriver(server, capabilities);

	}
}

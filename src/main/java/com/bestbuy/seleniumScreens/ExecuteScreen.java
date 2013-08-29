package com.bestbuy.seleniumScreens;

import java.util.logging.Logger;

import com.bestbuy.properties.PropertyValues;

/**
 * This will execute the script based on action
 */

public class ExecuteScreen extends SeleniumScreen {

	static Logger log = Logger.getLogger("ExecuteScreen");
	private int timeoutInSeconds = 30;

	public ExecuteScreen(String browserName, String platform, String url,
			String resolution) {
		super(browserName, platform, url, resolution);
	}

	/**
	 * This method will execute the script based on action
	 * 
	 * @param actions
	 *            Get the actions specified in the testcases
	 * 
	 * @param elementLocation
	 *            Get the elementLocation specified in the testcases
	 * 
	 * @param inputData
	 *            Get the inputData specified in the testcases
	 * 
	 * @param expectedResult
	 *            Get the expectedResult specified in the testcases
	 * 
	 * @param waitingTime
	 *            Get the waitingTime specified in the testcases
	 * 
	 * @param methodName
	 *            Get the methodName specified in the testcases
	 */
	public void excecutingScript(String actions, String elementLocation,
			String inputData, String expectedResult, long waitingTime,
			String uiIdentifiers, String methodName) {

		PropertyValues propertyValues = new PropertyValues(uiIdentifiers);
		String elementlocation = propertyValues.getPropValue(elementLocation);
		try {
			if (actions.equals("click")) {
				waitForAjax(driver, timeoutInSeconds);
				waitForElementPresent(elementlocation, methodName, waitingTime);
				getXpathWebElement(elementlocation);
				click();

			} else if (actions.equals("visibletext")) {
				waitForAjax(driver, timeoutInSeconds);
				isTextPresent(expectedResult, methodName);

			} else if (actions.equals("textfield")) {
				waitForAjax(driver, timeoutInSeconds);
				waitForElementPresent(elementlocation, methodName, waitingTime);
				getXpathWebElement(elementlocation);
				sendKeys(inputData);

			} else if (actions.equals("submit")) {
				waitForAjax(driver, timeoutInSeconds);
				waitForElementPresent(elementlocation, methodName, waitingTime);
				getXpathWebElement(elementlocation);
				submit();

			} else if (actions.equals("select")) {
				waitForAjax(driver, timeoutInSeconds);
				waitForElementPresent(elementlocation, methodName, waitingTime);
				getXpathWebElement(elementlocation);
				selectText(element, inputData);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is to close the browser
	 */
	public void closeBrowser() {
		log.info("ENTERING CLOSEBROWSER ");
		driver.quit();
	}

}

package com.bestbuy.xmlReader;

import java.util.logging.Logger;

import com.bestbuy.seleniumScreens.ExecuteScreen;
import com.bestbuy.seleniumScreens.constants.Constants;

import org.apache.commons.lang.StringUtils;
import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

/**
 * 
 * This class will parse the testcases xml file
 * 
 */
public class TestcasesXmlParser extends ExecuteScreen {

	static Logger log = Logger.getLogger("TestcasesXmlParser");
	public String actions = "";

	public String elementLocation = "";
	public String inputData = "";
	public String expectedResult = "";
	public long waitingTime;

	private VTDNav vn;

	public TestcasesXmlParser(String browserName, String platform, String url,
			String resolution) {
		super(browserName, platform, url, resolution);

	}

	/**
	 * This method will parse the testcases xml file and get action and its
	 * values in specified order
	 * 
	 * @param xmllocation
	 *            location of the xml file
	 * 
	 * @param xpath
	 *            xpath to parse the xml file
	 * 
	 * @param methodName
	 *            Method Name from which the call is triggered
	 * 
	 * @throws Exception
	 */
	public void executeSelectedTestcases(String xmllocation, String xpath,String uiIdentifiers,
			String methodName) throws Exception {
		VTDGen vg = new VTDGen();
		int i;
		if (vg.parseFile(xmllocation, true)) {
			try {
				vn = vg.getNav();
				AutoPilot ap = new AutoPilot(vn);
				ap.selectXPath(xpath);
				while ((i = ap.evalXPath()) != -1) {
					int attrcount = vn.getAttrCount() * 2;
					for (int j = 1; j <= attrcount; j++) {
						setAttributeValue(i, j);
					}
					excecutingScript(getActions(), getElementLocation(),
							getInputData(), getExpectedResult(),
							getWaitingTime(),uiIdentifiers, methodName);
				}
			} catch (Exception e) {
				log.info("Exception in getSelectedTestcases " + e.getMessage());
			}
		}
	}

	/**
	 * This method will set the appropriate value to it's variable
	 */
	public void setAttributeValue(int i, int j) {
		try {
			if (vn.toString(i + j).equals("action")) {
				int attr = j + 1;
				actions = vn.toString(i + attr);
				setActions(actions);
			}
			if (vn.toString(i + j).equals("element_location")) {
				int attr = j + 1;
				elementLocation = vn.toString(i + attr);
				setElementLocation(elementLocation);
			}
			if (vn.toString(i + j).equals("data_input")) {
				int attr = j + 1;
				inputData = vn.toString(i + attr);
				setInputData(inputData);

			}
			if (vn.toString(i + j).equals("expected_result")) {
				int attr = j + 1;
				expectedResult = vn.toString(i + attr);
				setExpectedResult(expectedResult);
			}
			if (vn.toString(i + j).equals("waittime_ms")) {
				int attr = j + 1;
				if (StringUtils.isNotEmpty(vn.toString(i + attr))) {
					waitingTime = Long.parseLong(vn.toString(i + attr));
				} else {
					waitingTime = Constants.FOURTY_SECONDS;
					setWaitingTime(waitingTime);
				}
			}
		} catch (NavException e) {
			log.info("NavException in setAttributeValue " + e.getMessage());
		}

	}

	/**
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}

	/**
	 * @param actions
	 *            the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

	/**
	 * @return the elementLocation
	 */
	public String getElementLocation() {
		return elementLocation;
	}

	/**
	 * @param elementLocation
	 *            the elementLocation to set
	 */
	public void setElementLocation(String elementLocation) {
		this.elementLocation = elementLocation;
	}

	/**
	 * @return the inputData
	 */
	public String getInputData() {
		return inputData;
	}

	/**
	 * @param inputData
	 *            the inputData to set
	 */
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	/**
	 * @return the expectedResult
	 */
	public String getExpectedResult() {
		return expectedResult;
	}

	/**
	 * @param expectedResult
	 *            the expectedResult to set
	 */
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	/**
	 * @return the waitingTime
	 */
	public long getWaitingTime() {
		return waitingTime;
	}

	/**
	 * @param waitingTime
	 *            the waitingTime to set
	 */
	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	/**
	 * This method is to close  the browser
	 */
	public void closeBrowser() {
		super.closeBrowser();
	}

}

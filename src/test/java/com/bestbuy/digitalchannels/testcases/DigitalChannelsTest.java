package com.bestbuy.digitalchannels.testcases;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bestbuy.browser.BrowserConfiguration;
import com.bestbuy.properties.PropertyValues;
import com.bestbuy.xmlReader.TestcasesXmlParser;

public class DigitalChannelsTest {
	private BrowserConfiguration browserConfig;
	private TestcasesXmlParser testreader;
	private PropertyValues propertyValues;
	private String propsFile;
	private String selectTestStepsToRun;
	private String testcasesLocation;
	private String envConfig;
	private String methodName;
	private String uiIdentifierLocation;

	static Logger log = Logger.getLogger("DigitalChannelsTest");

	/**
	 * @param browser
	 *            get the browser name from suite
	 * 
	 * @param platform
	 *            get the platform name from suite
	 * 
	 * @BeforeTest:The annotated method will be run before any test method
	 *                 belonging to the classes inside the <test> tag is run
	 *                 This method is to instantiate the browser session
	 */
	@Parameters(value = { "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser, String platform) throws Exception {
		try {

			loadProperties();
			browserConfig = new BrowserConfiguration(envConfig);
			String Appurl = browserConfig.getServerData().get("appurl");
			String browserresolution = browserConfig.getServerData().get(
					"browserresolution");
			testreader = new TestcasesXmlParser(browser, platform, Appurl,
					browserresolution);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	public void loadProperties() {
		try {
			propsFile = "./src/main/resources/properties/properties.xml";
			propertyValues = new PropertyValues(propsFile);
			String selectTestcasesToRun = propertyValues
					.getPropValue("SelectTestcasesToRun");
			selectTestStepsToRun = propertyValues
					.getPropValue("SelectTestStepsToRun");
			testcasesLocation = propertyValues
					.getPropValue("TestcasesLocation");
			envConfig = propertyValues.getPropValue("EnvironmentConfig");

			uiIdentifierLocation = propertyValues.getPropValue("UIIdentifiers");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        create the account in the application
	 */

	@Test
	public void testCreateAccount() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING CREATE ACCOUNT TESTCASES");
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String CreateAccount = propertyValues.getPropValue("CreateAccount");
			String testcases = testcasesLocation + "/" + CreateAccount;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        create the signin in the application
	 */
	@Test
	public void testSignin() throws InterruptedException, IOException,
			Exception {
		try {
			log.info("RUNNING SIGNIN TESTCASES");
			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String Signin = propertyValues.getPropValue("Signin");
			String testcases = "./" + testcasesLocation + "/" + Signin;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        Search the particular product in the application
	 */
	@Test
	public void testSearch() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING SEARCH TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String search = propertyValues.getPropValue("Search");
			String testcases = "./" + testcasesLocation + "/" + search;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        search the weekly deals in the application
	 */
	@Test
	public void testWeeklyDeals() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING WEEKELY DEALS TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String weeklyDeals = propertyValues.getPropValue("WeeklyDeals");
			String testcases = "./" + testcasesLocation + "/" + weeklyDeals;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        search the feature offers in the application
	 */
	@Test
	public void testFeatureOffers() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING FEATURE OFFERS TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String featureOffers = propertyValues.getPropValue("FeatureOffers");
			String testcases = "./" + testcasesLocation + "/" + featureOffers;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        create the wish list in the application in all the account holders
	 */
	@Test(dependsOnMethods = "testSignin")
	public void testCreateWishList() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING CREATE WISHLIST TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String createWishList = propertyValues
					.getPropValue("CreateWishList");
			String testcases = "./" + testcasesLocation + "/" + createWishList;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        search the recently viewed products in the application
	 */
	@Test
	public void testRecentlyViewedProducts() throws InterruptedException,
			IOException, Exception {
		log.info("RUNNING RECENTLY VIEWED PRODUCTS TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String recentlyViewedProducts = propertyValues
					.getPropValue("RecentlyViewedProducts");
			String testcases = "./" + testcasesLocation + "/"
					+ recentlyViewedProducts;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        search the recommended products in the application
	 */
	@Test
	public void testRecommendedProduct() throws InterruptedException,
			IOException, Exception {
		log.info("RUNNING RECOMMENDED PRODUCTS TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String recommendedProduct = propertyValues
					.getPropValue("RecommendedProduct");
			String testcases = "./" + testcasesLocation + "/"
					+ recommendedProduct;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        remove the selected product from cart in the application
	 */
	@Test
	public void testRemoveProduct() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING REMOVE PRODUCTS TESTCASES");
		try {
			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String removeProduct = propertyValues.getPropValue("RemoveProduct");
			String testcases = "./" + testcasesLocation + "/" + removeProduct;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        search the deal of day in the application
	 */
	@Test
	public void testDealOfDay() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING DEAL OF DAY TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String dealOfDay = propertyValues.getPropValue("DealOfDay");
			String testcases = "./" + testcasesLocation + "/" + dealOfDay;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        write the review commands about the product
	 */
	@Test(dependsOnMethods = "testSignin")
	public void testWriteReviews() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING WRITE REVIEWS TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String writeReviews = propertyValues.getPropValue("WriteReviews");
			String testcases = "./" + testcasesLocation + "/" + writeReviews;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);
		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * @Test: Makes a class or a method as part of the test This method is to
	 *        find the created wish list
	 */
	@Test(dependsOnMethods = "testSignin")
	public void testFindWishList() throws InterruptedException, IOException,
			Exception {
		log.info("RUNNING FIND WISH LIST TESTCASES");
		try {

			methodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			String findWishList = propertyValues.getPropValue("FindWishList");
			String testcases = "./" + testcasesLocation + "/" + findWishList;
			testreader.executeSelectedTestcases(testcases,
					selectTestStepsToRun, uiIdentifierLocation, methodName);

		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	/**
	 * This method will execute at last and it will close the browser
	 */
	@AfterClass
	public void tearDown() {
		testreader.closeBrowser();

	}

}

package com.my_qa_guide.TestNg_First_Test.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstAnnotationsTest {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(FirstAnnotationsTest.class);
	/**
	 * Constants
	 */

	public static final String JQUERY_INDEX_URL = "https://jqueryui.com/";

	WebDriver driver;

	/**
	 * Initialize the environment of every test
	 */
	@BeforeMethod
	public void initialize() {

		log.info("@BeforeMethod Started");

		// Configure the System Property of the driver using the chromedriver file.
		// IMPORTANT: In my cas i had to grant driver's permission to execute (chmod
		// 777)
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		// Instance the driver so we can start use it
		driver = new ChromeDriver();

		// Tells the driver go to the www.google.com page
		driver.get("http://www.google.com");

		// Maximize window
		driver.manage().window().maximize();

		log.info("@Beforemethod End");
	}

	/**
	 * Clean the navigator and close the driver of every test
	 */
	@AfterMethod()
	public void cleanNavigatorAndCloseDriver() {

		log.info("@Aftermethod Started");

		// Delete all the cookies
		driver.manage().deleteAllCookies();

		// Quit the navigator
		driver.quit();

		log.info("@Aftermethod End");
	}

	// ******************************************************************* //
	// ***************************** TEST ******************************** //
	// ******************************************************************* //
	// ----------- US00000 - TestNG Annotations Flow --------------------- //
	// ------------------------------------------------------------------- //
	/**
	 * Description: Navigate to a website and wait 3 seconds.
	 * 
	 * Pre steps: - Open the browser - Navigate to Google - Maximize
	 * 
	 * Steps: - Navigate to JQUERY_INDEX_URL using the 'get' method - Wait 3000
	 * miliseconds
	 * 
	 * Post steps: - Delete cookies - Close the browser.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testNgAnnotationsFlow() throws InterruptedException {

		log.info("@Test Started");

		// Navigate to "JQUERY_INDEX_URL
		driver.get(JQUERY_INDEX_URL);

		// Freeze the test for 3000 miliseconds
		Thread.sleep(3000);

		log.info("@Test end");
	}
}

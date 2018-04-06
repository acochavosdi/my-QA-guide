package com.my_qa_guide.Driver_Basics.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverBasicsTest {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(DriverBasicsTest.class);

	public static final String JQUERY_INDEX_URL = "https://jqueryui.com/";
	public static final String JQUERY_RESIZABLE_URL = "https://jqueryui.com/resizable/";
	WebDriver driver;

	/**
	 * Initialize the environment of every test
	 */
	@BeforeMethod
	public void initialize() {

		log.info("@BeforeMethod Start");

		// Configure the System Property of the driver using the chromedriver file.
		// IMPORTANT: I had to grant driver's permission to execute.
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

		log.info("@Aftermethod Start");

		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// Quit the navigator
		driver.quit();

		log.info("@Aftermethod End");
	}

	// ******************************************************************* //
	// ***************************** TEST ******************************** //
	// ******************************************************************* //
	// ----------- US00001 - Driver Basics ------------------------------- //
	// ------------------------------------------------------------------- //
	/**
	 * 
	 * Description: Basic navigation operations on driver + some get information
	 * about the current page methods
	 * 
	 * Pre steps: - Open the browser - Navigate to Google - Maximize
	 * 
	 * Steps: - Navigate to JQUERY_INDEX_URL using the 'get' method - Store Current
	 * Title and Url String Vars - Print Title and Url - Navigate to
	 * JQUERY_RESIZABLE_URL using navigate() method - Store and print again the
	 * current Url and title - Order the driver to go back to the last page - Order
	 * the driver to go forward - Refresh the page - Get the current Page Source and
	 * store in a file located on src/main/files
	 * 
	 * Post steps: - Delete cookies - Close the browser.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void driverBasics() throws InterruptedException {

		log.info("@Test Started");

		String currentTitle;
		String currentUrl;

		// Go to the Page with Get Method
		driver.navigate().to(JQUERY_INDEX_URL);

		// Store Current Title, Url and PageSource on String Vars
		// Print Current Url and Title
		// Wait 1500 miliseconds
		currentTitle = driver.getTitle();
		currentUrl = driver.getCurrentUrl();
		log.info("*** CURRENT TITLE: \t\t" + currentTitle + "\t\t\t\t***");
		log.info("*** CURRENT URL: \t\t" + currentUrl + "\t\t\t***");
		Thread.sleep(1500);

		// Go to a Page with navigate().to()
		// Print again current Title and Url
		driver.navigate().to(JQUERY_RESIZABLE_URL);
		currentTitle = driver.getTitle();
		currentUrl = driver.getCurrentUrl();
		log.info("*** CURRENT TITLE: \t\t" + currentTitle + "\t\t\t***");
		log.info("*** CURRENT URL: \t\t" + currentUrl + "\t\t***");
		Thread.sleep(1500);

		// Go back on the browser
		driver.navigate().back();
		Thread.sleep(1500);

		// Go forward on the browser
		driver.navigate().forward();
		Thread.sleep(1500);

		// Refresh the page
		driver.navigate().refresh();
		Thread.sleep(1500);

		// Store the pagesource on a file
		String currentPageSource = driver.getPageSource();

		try {
			File file = new File("src/main/files/pagesource.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(currentPageSource);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			log.error(e);
		}

		log.info("@Test end");
	}
}

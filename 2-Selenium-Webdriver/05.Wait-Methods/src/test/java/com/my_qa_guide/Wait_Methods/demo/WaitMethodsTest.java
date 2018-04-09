package com.my_qa_guide.Wait_Methods.demo;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitMethodsTest {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(WaitMethodsTest.class);

	public static final String JQUERY_INDEX_URL = "https://jqueryui.com/";

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
	// ----------- US00004 - waitMethods --------------------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * Description: Using Wait methods
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Define a valid selector and an invalid one for the tests - Set up
	 * the implicit wait of the current driver to 10 seconds - Try to find the
	 * element with the invalid selector and check the implicit wait is working -
	 * Try and check a Thread sleep - Do a explicit wait with certain conditions
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(description = "waitMethods")
	public void waitMethods(Method method) throws InterruptedException {
		log.info(
				"[log-TestSet] " + this.getClass().getName() + " - Start test waitMethods method: " + method.getName());

		driver.get(JQUERY_INDEX_URL);

		String validNameSelector = "s";
		String invalidNameSelector = "aawfawfaw";

		// Implicit Wait
		log.info("Example implicit wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (driver.findElements(By.name(invalidNameSelector)).size() != 0)
			log.info("Invalid Selector has worked!!! strange thing mr coder...");
		else {
			log.warn("As expected, invalidNameSelector didn't worked");
		}

		if (driver.findElements(By.name(validNameSelector)).size() != 0) {
			WebElement myDynamicElement2 = driver.findElement(By.name(validNameSelector));
			log.info("Element pointed by validNameSelector taken");
		} else {
			log.warn("Element not found");
		}

		// Thread(sleep)
		log.info("Starting Thread wait for 5 seconds");
		Thread.sleep(5000);
		log.info("Ended Thread wait for 5 seconds");

		// Explicit Wait
		log.info("Example explicit wait");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		log.info("Trying to Find with the valid selector, Explicit Wait until conditions or 20 seconds passed");
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(validNameSelector)));
		log.info("FOUND!!");

		log.info("Trying to Find with the invalid selector, Explicit Wait until conditions or 20 seconds passed");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(invalidNameSelector)));
		log.info("FOUND!!");

		// TODO Fluent Wait
		// Esto es casi brujeria

	}
}

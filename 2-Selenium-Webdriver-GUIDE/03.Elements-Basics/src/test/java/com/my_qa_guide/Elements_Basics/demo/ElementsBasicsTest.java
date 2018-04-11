package com.my_qa_guide.Elements_Basics.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsBasicsTest {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(ElementsBasicsTest.class);

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
	// ----------- US00002 - Elements Basics ----------------------------- //
	// ------------------------------------------------------------------- //
	/**
	 * 
	 * Description: Get a single element and print some info about him, then do the
	 * same with a list of elements
	 * 
	 * Pre steps: - Open the browser - Navigate to Google - Maximize
	 * 
	 * Steps: - Got to the page with Get Method - Store a selector found in the web
	 * app by chrome inspector on a String - Check the element is displayed - Store
	 * the element on a WebElement instance - Print the size and tag of the element
	 * by log.info - Locate some elements using a selector - Store them on a list -
	 * Use a for loop to print the text of every element by log.info
	 * 
	 * Post steps: - Delete cookies - Close the browser.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void elementsBasics() throws InterruptedException {

		log.info("@Test Started");

		// Go to the Page with Get Method
		driver.navigate().to(JQUERY_INDEX_URL);

		/**** WORKING WITH SINGLE ELEMENT ****/

		// Step 1 - Locate the element on the Web App by inspector and store the
		// selector on a string;
		String idSelectorForTheNavItem = "main";

		// Step2 - Check the element is displayed
		if (driver.findElements(By.id(idSelectorForTheNavItem)).size() != 0) {

			// Step3 - Store the element on a WebElement instance.
			WebElement element = driver.findElement(By.id(idSelectorForTheNavItem));

			// Step4 - Manipulate the element as u want
			log.info("Size of the element is : " + element.getSize());
			log.info("Tag of the element is : " + element.getTagName());
		} else {
			log.error("Element with id: " + idSelectorForTheNavItem + " not found");
		}

		/**** WORKING WITH SEVERAL ELEMENTS ****/

		// Step1 - Locate elements with a selector
		// IMPORTANT: You will probably dont understand this selector, but it doesnt
		// matter, just accept it works and you will understand better on the next
		// section of the tutorial.

		String xpathSelectorToGettingAList = "//ul[@id='menu-top']/li/a";

		// Store the elements on a list
		List<WebElement> elementsList = driver.findElements(By.xpath(xpathSelectorToGettingAList));

		for (WebElement we : elementsList) {
			log.info("Text of the element: " + we.getText());
		}
		log.info("@Test end");
	}
}

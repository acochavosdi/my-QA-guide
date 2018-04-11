package com.my_qa_guide.Using_Selectors.demo;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsingSelectorsTest {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(UsingSelectorsTest.class);

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
	// ----------- US00003 - Selectors Basics ---------------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * 
	 * Description:In this test we will work with a few different Selectors
	 * 
	 * Pre steps: Open the browser
	 * 
	 * Steps: - Print tagname of 2 elements using id selector - Print tagname of
	 * element using name selector - Print tagname of the same element using 2
	 * different nameClass selector - Print tagname of 4 items whose are chained on
	 * the DOM using CSS Selectors - Get 1 item by 4 different XPATH selectors and
	 * check they are the same element - Get 1 item by 3 different XPATH selectors
	 * and check they are the same element - Click on a link selecting it by
	 * linkText selector - Click on the same link using a partialLinkText Selector -
	 * Print the tagname of an element found by tagName Selector
	 * 
	 * 
	 * Post steps: Close the browser
	 * 
	 * 
	 */

	@Test(description = "selectorsBasic")
	public void selectorsBasic(Method method) throws InterruptedException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test selectorsBasic method: "
				+ method.getName());

		// Go to the page
		driver.get(JQUERY_INDEX_URL);

		/**********************************************************************/
		/*************************** ID SELECTORS *****************************/
		/**********************************************************************/

		// Selectors
		String idSelector1 = "main";
		String idSelector2 = "content-wrapper";

		// Code
		log.info(" ");
		log.info("------------- ID SELECTORS!");
		if (driver.findElements(By.id(idSelector1)).size() != 0)
			log.info("Tag del elemento1 obtenido por id es: " + driver.findElement(By.id(idSelector1)).getTagName());

		if (driver.findElements(By.id(idSelector2)).size() != 0)
			log.info("Tag del elemento2 obtenido por id es: " + driver.findElement(By.id(idSelector2)).getTagName());

		/**********************************************************************/
		/************************** NAME SELECTORS ****************************/
		/**********************************************************************/

		// Selectors
		String nameSelector1 = "s";

		// Code
		log.info(" ");
		log.info("-------------NAME SELECTORS!");

		if (driver.findElements(By.name(nameSelector1)).size() != 0)
			log.info("Tag del elemento obtenido por name es: "
					+ driver.findElement(By.name(nameSelector1)).getTagName());

		/**********************************************************************/
		/*********************** CLASSNAME SELECTORS **************************/
		/**********************************************************************/

		// Selectors
		String classNameSelector1 = "twelve";
		String classNameSelector2 = "content-right";

		// Code
		log.info(" ");
		log.info("-------------NAMECLASS SELECTORS!");
		if (driver.findElements(By.className(classNameSelector1)).size() != 0)
			log.info("Tag del elemento1 obtenido por nameClass es: "
					+ driver.findElement(By.className(classNameSelector1)).getTagName());

		if (driver.findElements(By.className(classNameSelector2)).size() != 0)
			log.info("Tag del elemento2 obtenido por nameClass es: "
					+ driver.findElement(By.className(classNameSelector2)).getTagName());

		/**********************************************************************/
		/************************** CSS SELECTORS *****************************/
		/**********************************************************************/

		// Selectors
		String cssSelector1 = "#content";
		String cssSelector2 = "#content > div.dev-links";
		String cssSelector3 = "#content > div.dev-links > ul";
		String cssSelector4 = "#content > div.dev-links > ul > li:nth-child(3) > a";

		// Code
		log.info(" ");
		log.info("-------------CSS SELECTORS!");

		if (driver.findElements(By.cssSelector(cssSelector1)).size() != 0)
			log.info("Tag del elemento1 obtenido por CSS es: "
					+ driver.findElement(By.cssSelector(cssSelector1)).getTagName());

		if (driver.findElements(By.cssSelector(cssSelector2)).size() != 0)
			log.info("Tag del elemento2 obtenido por CSS es: "
					+ driver.findElement(By.cssSelector(cssSelector2)).getTagName());

		if (driver.findElements(By.cssSelector(cssSelector3)).size() != 0)
			log.info("Tag del elemento3 obtenido por CSS es: "
					+ driver.findElement(By.cssSelector(cssSelector3)).getTagName());

		if (driver.findElements(By.cssSelector(cssSelector4)).size() != 0)
			log.info("Tag del elemento4 obtenido por CSS es: "
					+ driver.findElement(By.cssSelector(cssSelector4)).getTagName());

		/**********************************************************************/
		/************************** XPATH SELECTORS ***************************/
		/**********************************************************************/

		log.info(" ");
		log.info("-------------XPATH SELECTORS!");

		// Selectors
		// 5 ways to select the item1
		String xpathSelector1toItem1 = "//*[@id='content']";
		String xpathSelector2toItem1 = "//div[@id='content']";
		String xpathSelector3toItem1 = "//div[@class='dev-links']/parent::*";
		String xpathSelector4toItem1 = "//div[contains(@class,'v-lin')]/parent::*";
		String xpathSelector5toItem1 = "//aside[@class='widget']/parent::div/preceding-sibling::*";

		// Code
		WebElement tempItem1bySelector1 = driver.findElement(By.xpath(xpathSelector1toItem1));
		WebElement tempItem1bySelector2 = driver.findElement(By.xpath(xpathSelector2toItem1));
		WebElement tempItem1bySelector3 = driver.findElement(By.xpath(xpathSelector3toItem1));
		WebElement tempItem1bySelector4 = driver.findElement(By.xpath(xpathSelector4toItem1));
		WebElement tempItem1bySelector5 = driver.findElement(By.xpath(xpathSelector5toItem1));

		if (tempItem1bySelector1.equals(tempItem1bySelector2) && tempItem1bySelector2.equals(tempItem1bySelector3)
				&& tempItem1bySelector3.equals(tempItem1bySelector4)
				&& tempItem1bySelector4.equals(tempItem1bySelector5))
			log.info("The xpaths pointing to the same element!! It's the same Element!!");

		// Selectors
		// 3 ways to select the item2
		String xpathSelector1toItem2 = "//div/div[@class='dev-links']";
		String xpathSelector2toItem2 = "//div/*[contains(@class,'ev-lin')]";
		String xpathSelector3toItem2 = "//*[contains(@class,'ght twe')]/div[@id='content']/div[@id='banner-secondary' and @class='clearfix']/following-sibling::div";

		// Code
		WebElement tempItem2bySelector1 = driver.findElement(By.xpath(xpathSelector1toItem2));
		WebElement tempItem2bySelector2 = driver.findElement(By.xpath(xpathSelector2toItem2));
		WebElement tempItem2bySelector3 = driver.findElement(By.xpath(xpathSelector3toItem2));

		if (tempItem2bySelector1.equals(tempItem2bySelector2) && tempItem2bySelector2.equals(tempItem2bySelector3))
			log.info("The xpaths pointing to the same element!! It's the same Element!!");

		/**********************************************************************/
		/***************** LINKTEXT & PARTIALLINKTEXT SELECTORS ***************/
		/**********************************************************************/

		log.info(" ");
		log.info("-------------LINK & PARTIAL LINK SELECTORS!");

		// Selectors
		String linkText1 = "Stable";
		String partialLinkText1 = "Stab";

		// Code
		if (driver.findElements(By.linkText(linkText1)).size() != 0) {
			driver.findElement(By.linkText(linkText1)).click();
			log.info("clicked on the link");
		}
		Thread.sleep(3000);

		if (driver.findElements(By.partialLinkText(partialLinkText1)).size() != 0) {
			driver.findElement(By.partialLinkText(partialLinkText1)).click();
			log.info("clicked on the link");
		}
		Thread.sleep(3000);

		/**********************************************************************/
		/************************ TAGNAME SELECTORS ***************************/
		/**********************************************************************/

		log.info(" ");
		log.info("-------------TAG SELECTORS!");

		// Selectors
		String tagName1 = "body";

		// Code
		if (driver.findElements(By.tagName(tagName1)).size() != 0)
			log.info("Tag of the element selected by tagname is: "
					+ driver.findElement(By.tagName(tagName1)).getTagName());
		Thread.sleep(3000);
		log.info("[log-TestSet] " + this.getClass().getName() + " - End test selectorsBasic method: "
				+ method.getName());

	}
}

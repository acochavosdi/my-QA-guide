package com.emergya.pageObjects;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ToolsQAWindowsPage extends BasePageObject {

	/*
	 * Logger
	 */
	private static Logger log = Logger.getLogger(ToolsQAWindowsPage.class);

	/*
	 * String Keys selectors
	 */

	private static final String UNIQUE_ELEMENT_OF_THIS_PAGE = "uniqueElement";
	private static final String BUTTON_NEW_MESSAGE_WINDOWS = "buttonMessageWindows";
	private static final String BUTTON_NEW_TAB = "buttonNewTab";

	public ToolsQAWindowsPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = false;

		if (this.isElementVisibleByXPath(UNIQUE_ELEMENT_OF_THIS_PAGE)) {
			status = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public void openThePopUpAndCloseIt() throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start openThePopUpAndCloseIt method");

		// Store the main window
		String mainWindow = driver.getWindowHandle();
		log.info("THE FIRST WINDOW IS: " + mainWindow);

		// Open the Pop UP
		if (this.isElementVisibleByXPath(BUTTON_NEW_MESSAGE_WINDOWS)) {
			this.getElementByXPath(BUTTON_NEW_MESSAGE_WINDOWS).click();

			// Store And print All windows open
			Set handles = driver.getWindowHandles();
			log.info("THE SET OF WINDOWS IS: " + handles);

			// Enter popup window and close it

			for (String handle1 : driver.getWindowHandles()) {

				log.info("THE CURRENT WINDOWS IS: " + handle1);

				Thread.sleep(2500);
				driver.switchTo().window(handle1);

				if (!handle1.equals(mainWindow)) {
					// Print the body of the window
					WebElement popUp = driver.findElement(By.tagName("body"));
					if (popUp != null) {
						log.warn(popUp.getText());
					}
					driver.close();
				}

			}

			driver.switchTo().window(mainWindow);
		} else {
			log.error("Button not found");
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End openThePopUpAndCloseIt method");
	}

	public void workWithANewTab() throws InterruptedException {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start workWithANewTab method");

		// Store the main window
		String mainWindow = driver.getWindowHandle();
		log.info("THE FIRST WINDOW IS: " + mainWindow);

		// Open the new tab
		if (this.isElementVisibleByXPath(BUTTON_NEW_TAB)) {
			this.getElementByXPath(BUTTON_NEW_TAB).click();

			// Store And print All windows open
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			log.info("THE SET OF WINDOWS IS: " + windows);

			// Enter new tab window and close it after 5 seconds
			driver.switchTo().window(windows.get(1));
			Thread.sleep(5000);
			driver.close();

			// Switch to Main Window so Aftermethod can work fine
			driver.switchToMainwindow();
			Thread.sleep(2000);

		} else {
			log.error("Button not found");
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End workWithANewTab method");

	}

}

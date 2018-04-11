package com.emergya.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class DemoAutomationTestingRegisterPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(DemoAutomationTestingRegisterPage.class);

	/**
	 * Items keys selectors.
	 */

	private static final String REGISTER_FORM_XPATH = "registerFormXPATH";
	private static final String UPLOAD_IMAGE_ID = "uploadImageID";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DemoAutomationTestingRegisterPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(REGISTER_FORM_XPATH);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean uploadImage(String imageFile) throws AWTException {
		boolean status = false;
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start uploadImage method");

		// Click On Upload Button
		if (this.isElementVisibleById(UPLOAD_IMAGE_ID)) {
			this.getElementById(UPLOAD_IMAGE_ID).click();

			// Prepare file
			File auxfile = new File("src/main/resources/files/" + imageFile);
			String fileName = auxfile.getAbsolutePath();

			// Use the robot to perform the steps
			try {
				// Setting clipboard with file location
				setClipboardData(fileName);
				// native key strokes for CTRL, V and ENTER keys
				// Some sleep time to detect the window popup
				Thread.sleep(500);

				Robot robot = new Robot();

				// Delete the default string
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_END);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_END);
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);

				// Copy the path to the window popup
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);

				// Press enter to execute a file search
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(500);

				Thread.sleep(1000);

				status = true;
			} catch (Exception e) {
				log.error("Exception when using robot on uploadTheFileByRobot method");
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End uploadImage method");
		return status;
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {

		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}
}

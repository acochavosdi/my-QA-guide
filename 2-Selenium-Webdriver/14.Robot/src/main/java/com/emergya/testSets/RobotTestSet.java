package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.DemoAutomationTestingRegisterPage;
import com.emergya.utils.BasicTestSet;

public class RobotTestSet extends BasicTestSet {
	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(RobotTestSet.class);

	/*
	 * Constants
	 */

	private static final String URL_REGISTER = "http://demo.automationtesting.in/Register.html";

	private static final String IMAGE_TO_UPLOAD = "imageTest.png";

	public RobotTestSet() {
		super();
	}

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// *********************** TEST ************************** //
	// -------------------- mYQA Gymkana --------------------- //
	// ---------- US00013 - Robot -> Upload an image --------- //
	// ******************************************************* //
	/**
	 * Description: Using Basics of Robot Class
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to the page - Check if the page is ready - Upload a image using
	 * the robot
	 * 
	 * Post steps: - Close the browser
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 *
	 */
	@Test(description = "uploadImageWithRobot")
	public void uploadImageWithRobot(Method method) throws InterruptedException, AWTException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test uploadImageWithRobot method: "
				+ method.getName());

		// Go to the page
		driver.navigate().to(URL_REGISTER);

		// Check if the page is ready
		isReady(demoAutomationTestingRegisterPage = new DemoAutomationTestingRegisterPage(driver));

		// Testing Upload Image
		assertTrue(demoAutomationTestingRegisterPage.uploadImage(IMAGE_TO_UPLOAD), "Error uploading the image");

		Thread.sleep(3000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test uploadImageWithRobot method: "
				+ method.getName());
	}
}

package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.ToolsQAWindowsPage;
import com.emergya.utils.BasicTestSet;

public class WindowsTestSet extends BasicTestSet {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(WindowsTestSet.class);

	/*
	 * Constants
	 */

	private static final String TOOLS_WINDOWS_URL = "http://toolsqa.com/automation-practice-switch-windows/";

	public WindowsTestSet() {
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
	// ---------- US00014 - Windows - Pop Ups and Tabs ------- //
	// ******************************************************* //
	/**
	 * Description: Working with "Message windows" and "New Browser Windows"
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Launch new Browser - Open the URL TOOLS_WINDOWS_URL - Get Main
	 * Window name and store it - Click on Button “New Message Window”, it will open
	 * a Pop Up Window - Get all the Windows name - Print on log.warn the body
	 * content of the pop-up - Close the Pop Up Window - Get Main Window name and
	 * store it - Click on Button “New Browser Tab”, it will open a Pop Up Window -
	 * Get all the Windows name - Enter to the new window and close it after 5
	 * seconds
	 * 
	 * Post steps: - Close the browser
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 *
	 */
	@Test(description = "handlingWindows")
	public void handlingWindows(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test handlingWindows method: "
				+ method.getName());

		driver.get(TOOLS_WINDOWS_URL);

		toolsQAWindowsPage = new ToolsQAWindowsPage(driver);
		assertTrue(toolsQAWindowsPage.isReady());

		log.info("WORKING WITH A TEXT POPUP");
		toolsQAWindowsPage.openThePopUpAndCloseIt();

		driver.sleep(2);

		log.info("WORKING WITH A NEW TAB");
		toolsQAWindowsPage.workWithANewTab();

		Thread.sleep(3000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test handlingWindows method: "
				+ method.getName());
	}
}

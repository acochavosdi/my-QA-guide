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
	// ---------- US00014 - Windows -------------------------- //
	// ******************************************************* //
	/**
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - TODO
	 * 
	 * Post steps: - Close the browser
	 * 
	 * Conclusion: TODO
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

		/*
		 * 1) Launch new Browser
		 * 
		 * 2) Open URL “http://toolsqa.wpengine.com/automation-practice-switch-windows/”
		 * 
		 * 3) Get Main Window name and store it
		 * 
		 * 4) Click on Button “New Message Window”, it will open a Pop Up Window
		 * 
		 * 5) Get all the Windows name
		 * 
		 * 6) Print on log.warn the body content of the pop-up
		 * 
		 * 7) Close the Pop Up Window
		 * 
		 */
		driver.get(TOOLS_WINDOWS_URL);

		toolsQAWindowsPage = new ToolsQAWindowsPage(driver);
		assertTrue(toolsQAWindowsPage.isReady());

		log.info("WORKING WITH A TEXT POPUP");
		toolsQAWindowsPage.openThePopUpAndCloseIt();

		driver.sleep(2);

		/*
		 * 
		 * 1) Get Main Window name and store it
		 * 
		 * 2) Click on Button “New Browser Tab”, it will open a Pop Up Window
		 * 
		 * 3) Get all the Windows name
		 * 
		 * 4) Enter to the new window and close it after 5 seconds
		 *
		 */

		log.info("WORKING WITH A NEW TAB");
		toolsQAWindowsPage.workWithANewTab();

		Thread.sleep(3000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test handlingWindows method: "
				+ method.getName());
	}
}

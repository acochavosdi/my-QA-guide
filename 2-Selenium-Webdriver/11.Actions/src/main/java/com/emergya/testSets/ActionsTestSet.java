package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryDraggablePage;
import com.emergya.pageObjects.JqueryDroppablePage;
import com.emergya.pageObjects.JqueryResizablePage;
import com.emergya.pageObjects.JquerySelectablePage;
import com.emergya.utils.BasicTestSet;

public class ActionsTestSet extends BasicTestSet {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(ActionsTestSet.class);

	/**
	 * Constants
	 */

	private static final String DRAGGABLE_URL = "https://jqueryui.com/draggable/";
	private static final String DROPPABLE_URL = "https://jqueryui.com/droppable/";
	private static final String RESIZABLE_URL = "https://jqueryui.com/resizable/";
	private static final String SELECTABLE_URL = "https://jqueryui.com/selectable/";

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// ******************************************************************* //
	// ***************************** TEST ******************************** //
	// ******************************************************************* //
	// ----------- US00010 - Learning Actions ---------------------------- //
	// ------------------------------------------------------------------- //
	// ----------- Drag & Drop & Resizable & Selectable & Frames --------- //
	// ------------------------------------------------------------------- //
	/**
	 * 
	 * Description: TODO
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - TODO
	 * 
	 * Post steps: - Close the browser
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 * 
	 */
	@Test(description = "testingActions")
	public void testingActions(Method method) throws InterruptedException {

		log.info(
				"[log-TestSet] " + this.getClass().getName() + " - Start dragAndDrop test method: " + method.getName());

		jqueryDraggablePage = new JqueryDraggablePage(driver);
		jqueryDroppablePage = new JqueryDroppablePage(driver);
		jqueryResizablePage = new JqueryResizablePage(driver);
		jquerySelectablePage = new JquerySelectablePage(driver);

		// Draggable Section
		driver.get(DRAGGABLE_URL);
		driver.sleep(1);
		assertTrue(jqueryDraggablePage.isReady(), "Page not ready");
		driver.sleep(2);
		jqueryDraggablePage.dragTheItemByActions();

		// Droppable Section
		driver.get(DROPPABLE_URL);
		driver.sleep(1);
		assertTrue(jqueryDroppablePage.isReady(), "Page not ready");
		driver.sleep(2);
		jqueryDroppablePage.dragAndDropTheItemByActions();

		// Resizable Section
		driver.get(RESIZABLE_URL);
		driver.sleep(1);
		assertTrue(jqueryResizablePage.isReady(), "Page not ready");
		driver.sleep(2);
		jqueryResizablePage.resizeTheItemByActions();

		// Selectable Section
		driver.get(SELECTABLE_URL);
		driver.sleep(1);
		assertTrue(jquerySelectablePage.isReady(), "Page not ready");
		driver.sleep(2);

		jquerySelectablePage.enterTheFrame();

		for (int i = 0; i < 10; i++) {
			jquerySelectablePage.clickOnItem(jquerySelectablePage.selectRandomItem());
			Thread.sleep(200);
		}

		driver.sleep(3);
		log.info("[log-TestSet] " + this.getClass().getName() + " - End dragAndDrop test method: " + method.getName());

	}

}

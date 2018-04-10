package com.emergya.testSets;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.DemoAutomationTestingAlertsPage;
import com.emergya.utils.BasicTestSet;

public class AlertsTestSet extends BasicTestSet {
	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(AlertsTestSet.class);

	/**
	 * Constants
	 */

	private static final String URL_ALERTS = "http://demo.automationtesting.in/Alerts.html";
	private static final String MESSAGE_TO_ALERT_WITH_TEXT_BOX = "Hi Mr.Alert TxtBox";

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
	// ----------- US00011 - Learning Alerts ----------------------------- //
	// ------------------------------------------------------------------- //

	/**
	 * 
	 * Description: Working With Alerts
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Test an alert with text - Test an alert with OK - Test an alert with
	 * OK and CANCEL
	 * 
	 * Post steps: - Close the browser
	 * 
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 * 
	 * 
	 */
	@Test(description = "playingWithAlerts")
	public void playingWithAlerts(Method method) throws InterruptedException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start playingWithAlerts test method: "
				+ method.getName());

		// Go to the page with alerts
		driver.navigate().to(URL_ALERTS);
		isReady(demoAutomationTestingAlertsPage = new DemoAutomationTestingAlertsPage(driver));

		// Test alert with text
		demoAutomationTestingAlertsPage.clickOnAlertWithTextBox();
		demoAutomationTestingAlertsPage.clickOnAlertWithTextBoxButtonToDisplay(MESSAGE_TO_ALERT_WITH_TEXT_BOX);

		// Test an alert with OK
		demoAutomationTestingAlertsPage.clickOnAlertWithOk();
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay();

		// Test an alert with CANCEL and OK
		demoAutomationTestingAlertsPage.clickOnAlertWithOkAndCancel();
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay("cancel");
		Thread.sleep(3000);
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay("ok");
		Thread.sleep(3000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End playingWithAlerts test method: "
				+ method.getName());

	}
}

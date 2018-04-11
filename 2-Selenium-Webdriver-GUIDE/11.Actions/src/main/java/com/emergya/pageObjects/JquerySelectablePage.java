package com.emergya.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JquerySelectablePage extends BasePageObject {

	/*
	 * Logger
	 */

	static Logger log = Logger.getLogger(JquerySelectablePage.class);

	/*
	 * Key Selectors
	 */

	private static final String IFRAME_XPATH = "iframeResizableXPATH";
	private static final String ITEM_LIST_XPATH = "itemListXPATH";

	public JquerySelectablePage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");
		boolean status = this.isElementVisibleByXPath(IFRAME_XPATH);
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");
		return status;
	}

	public void enterTheFrame() {
		WebElement frame = this.getElementByXPath(IFRAME_XPATH);
		driver.switchTo().frame(frame);
	}

	public WebElement selectRandomItem() {

		List<WebElement> elementList;

		Random r = new Random();
		int Low = 1;
		int High = 7;
		int Result = r.nextInt(High - Low) + Low;

		elementList = this.getElementsByXPath(ITEM_LIST_XPATH, 10);

		return elementList.get(Result - 1);
	}

	public void clickOnItem(WebElement elementToClick) {

		if (this.isVisible(elementToClick)) {
			elementToClick.click();
		}
	}
}

package com.emergya.utils;

import com.emergya.pageObjects.SeleniumIsEasyCheckBoxPage;
import com.emergya.pageObjects.SeleniumIsEasyDropDownPage;
import com.emergya.pageObjects.SeleniumIsEasyJavascriptAlertsPage;
import com.emergya.pageObjects.SeleniumIsEasyRadioButtonsPage;
import com.emergya.pageObjects.SeleniumIsEasySimpleFormPage;
import com.emergya.pageObjects.SeleniumIsEasyTestPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 *
 */
public abstract class BasicTestSet extends DefaultTestSet {

	protected SeleniumIsEasyTestPage seleniumIsEasyTestPage;
	protected SeleniumIsEasySimpleFormPage seleniumIsEasySimpleFormPage;
	protected SeleniumIsEasyCheckBoxPage seleniumIsEasyCheckBoxPage;
	protected SeleniumIsEasyRadioButtonsPage seleniumIsEasyRadioButtonsPage;
	protected SeleniumIsEasyDropDownPage seleniumIsEasyDropDownPage;
	protected SeleniumIsEasyJavascriptAlertsPage seleniumIsEasyJavascriptAlertsPage;
}

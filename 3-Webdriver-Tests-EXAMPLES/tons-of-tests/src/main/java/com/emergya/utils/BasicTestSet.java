package com.emergya.utils;

import com.emergya.pageObjects.SeleniumIsEasyCheckBoxPage;
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
}

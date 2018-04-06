package com.emergya.utils;

import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.JqueryDraggablePage;
import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {
	protected GoogleMainPage googleMainPage;
	protected EmergyaMainPage emergyaMainPage;
	protected JqueryMainPage jqueryMainPage;
	protected JqueryDraggablePage jqueryDraggablePage;
}

package com.emergya.utils;

import com.emergya.pageObjects.JqueryDraggablePage;
import com.emergya.pageObjects.JqueryDroppablePage;
import com.emergya.pageObjects.JqueryResizablePage;
import com.emergya.pageObjects.JquerySelectablePage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {
	protected JqueryDraggablePage jqueryDraggablePage;
	protected JqueryDroppablePage jqueryDroppablePage;
	protected JqueryResizablePage jqueryResizablePage;
	protected JquerySelectablePage jquerySelectablePage;
}

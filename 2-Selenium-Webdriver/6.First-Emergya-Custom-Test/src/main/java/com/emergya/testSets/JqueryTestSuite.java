package com.emergya.testSets;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.JqueryMainPage;
import com.emergya.utils.BasicTestSet;

public class JqueryTestSuite extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(JqueryTestSuite.class);

	/**
	 * Constants
	 */

	private static final String JQUERY_INDEX_URL = "https://jqueryui.com/";

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	@Test(description = "firstTestWithEmergyaQA")
	public void firstTestWithEmergyaQA(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test firstTestWithEmergyaQA method: "
				+ method.getName());

		// Abrimos el endpoint con el driver
		driver.get(JQUERY_INDEX_URL);
		Thread.sleep(3000);

		// Instanciamos el objeto de ese endpoint para poder trabajar con el
		jqueryMainPage = new JqueryMainPage(driver);

		// Lanzamos el método isReady() para comprobar si la página esta lista
		if (jqueryMainPage.isReady())
			log.info("Página Cargada y lista");
		else {
			log.error("La web no ha podido cargarse");
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test firstTestWithEmergyaQA method: "
				+ method.getName());

	}
}

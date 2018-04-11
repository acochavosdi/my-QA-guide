package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * Page Object
 * 
 * @author acosanchez
 *
 */
public class JqueryMainPage extends BasePageObject {

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(JqueryMainPage.class);

	/**
	 * Item keys selector
	 */

	private static final String INTRO_PARAGRAPH_XPATH = "introSelectorXpath";
	private static final String LINK_TO_DRAGGABLE_PAGE_XPATH = "linkToDraggablePageXpath";
	private static final String BOOKS_SPAN_XPATH = "spanBooksXPATH";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public JqueryMainPage(EmergyaWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Check if the page is Ready
	 */
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Check if the element with the selector stored in "String intro_xpath", wich
	 * is defined in the own method is displayed;
	 * 
	 * @return true if displayed
	 */
	public boolean isReadyWithSeleniumDefault() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReadyWithSeleniumDefault method");

		String intro_xpath = "//p[@class='intro']";
		boolean status = driver.isElementDisplayed(By.xpath(intro_xpath));

		if (status) {
			log.info("The page with URL: " + driver.getCurrentUrl()
					+ " is ready, checked using Selenium native methods");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReadyWithSeleniumDefault method");

		return status;
	}

	/**
	 * Check if the element with the selector stored in the "properties" file is
	 * displayed, the real selector is taken through the constant key defined at the
	 * top of this class.
	 * 
	 * @return true if displayed
	 */
	public boolean isReadyWithEmergyaHandler() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReadyWithEmergyaHandler method");

		boolean status = this.isElementVisibleByXPath(INTRO_PARAGRAPH_XPATH);
		if (status) {
			log.info("The page with URL: " + driver.getCurrentUrl()
					+ " is ready, checked using Emergya Handler methods");
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReadyWithEmergyaHandler method");

		return status;
	}

	public String getClassOfTheParagraphIntro() {

		if (this.isElementVisibleByXPath(INTRO_PARAGRAPH_XPATH)) {
			WebElement introParagraph = this.getElementByXPath(INTRO_PARAGRAPH_XPATH);
			return introParagraph.getAttribute("class");
		}

		return "bad request";
	}

	/**
	 * Go to the Draggable Page.Include Steps:
	 * 
	 * - Esperar hasta que algo sea visible, máximo 10s
	 * 
	 * - Comprobar que ya es visible.
	 * 
	 * - Almacenar el elemento en un WebElement
	 * 
	 * - Imprimir por log.info() el valor del atributo 'href' del link
	 * 
	 * - Esperar hasta que sea clickable, máximo 10s
	 * 
	 * - Comprobar que ya es clickable.
	 * 
	 * - Clickar en el link.
	 * 
	 * - Comprobar que la página Draggable esta ready.
	 */
	public JqueryDraggablePage goToDraggablePage() {

		WebElement element;
		String hrefAttributeOfTheElement;

		/*
		 * CUANDO NO USAMOS METODOS DEL HANDLER (this.$loquesea), NOS VEMOS OBLIGADOS A
		 * USAR LA FUNCION getXPath PARA EL SELECTOR, YA QUE AUNQUE NO USEMOS EL
		 * HANDLER, EL VERDADERO SELECTOR ESTÁ EN EL FICHERO PROPERTIES, AL QUE SOLO
		 * ACCEDEN LOS METODOS DEL HANDLER, SI NO USARAMOS ESTE METODO, EN VEZ DE
		 * ENVIARLE A LOS METODOS EL SELECTOR, LE ENVIARIAMOS EL VALOR DE LA CONSTANTE
		 * DEFINIDA AL PRINCIPIO DE LA CLASE
		 * 
		 * 
		 * LAS LINEAS COMENTADAS SON EQUIVALENTES A SU SIGUIENTE LINEA,PERO USANDO EL
		 * HANDLER U OTRO MÉTODO VÁLIDO
		 */

		// this.waitForByXPath(LINK_TO_DRAGGABLE_PAGE_XPATH, 10);
		driver.waitUntilVisible(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)), 10);

		// if(this.isElementVisibleByXPath(LINK_TO_DRAGGABLE_PAGE_XPATH))
		if (driver.isElementDisplayed(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)))) {

			// element = this.getElementByXPath(LINK_TO_DRAGGABLE_PAGE_XPATH);
			element = driver.findElement(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)));
			hrefAttributeOfTheElement = element.getAttribute("href");
			log.info("Href attribute of the element is : " + hrefAttributeOfTheElement);

			if (driver.waitUntilElementClickable(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)), 10)) {

				element.click();

				// driver.clickIfExists(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)));

				// driver.clickOnWithMouse(By.xpath(getXPath(LINK_TO_DRAGGABLE_PAGE_XPATH)));

				return new JqueryDraggablePage(driver);

			}
		}

		return null;
	}

	public void usingScrolling() throws InterruptedException {

		



		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		// Scroll to Top
		this.scrollTop();
		Thread.sleep(1500);

		// Scroll to a WebElement
		this.scrollTo(this.getElementByXPath(BOOKS_SPAN_XPATH));
		Thread.sleep(1500);

		// Scroll with Javascript
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1500);

		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1500);

		this.scrollTop();
		Thread.sleep(1500);
	}

}

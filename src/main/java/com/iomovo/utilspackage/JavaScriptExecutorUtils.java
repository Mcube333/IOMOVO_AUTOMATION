package com.iomovo.utilspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * JavaScriptExecutorUtils:
 * - Provides JavaScript-based utility functions for interacting with web pages.
 * - Uses Selenium's JavascriptExecutor for scrolling, clicking, setting values, alerts, etc.
 */
public class JavaScriptExecutorUtils {

//	private WebDriver driver; // Instance of WebDriver
	private static JavascriptExecutor js; // Instance of JavascriptExecutor

	/**
	 * Constructor:
	 * - Initializes the WebDriver and JavascriptExecutor.
	 *
	 * @param driver The WebDriver instance.
	 */
	public JavaScriptExecutorUtils(WebDriver driver) {
//		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// ==========================
	// Page Utility Methods
	// ==========================

	/**
	 * Launches the specified URL in the browser.
	 *
	 * @param url The URL to navigate to.
	 */
	public static void launchURL(String url) {
		js.executeScript("window.location = '" + url + "'");
	}

	/**
	 * Retrieves the title of the current page.
	 *
	 * @return The page title.
	 */
	public String getPageTitle() {
		return js.executeScript("return document.title;").toString();
	}

	/**
	 * Retrieves the current page URL.
	 *
	 * @return The URL of the current page.
	 */
	public String getCurrentPageURL() {
		return js.executeScript("return window.location.href;").toString();
	}

	/** Maximizes the browser window using JavaScript. */
	public static void maximizeWindow() {
		js.executeScript("window.moveTo(0,0); window.resizeTo(screen.width,screen.height);");
	}

	/** Minimizes the browser window using JavaScript. */
	public static void minimizeWindow() {
		js.executeScript("window.outerWidth = window.innerWidth / 2; window.outerHeight = window.innerHeight / 2;");
	}

	/**
	 * Scrolls to a specific element by its ID.
	 *
	 * @param elementId ID of the element to scroll to
	 */
	public static void scrollToElementById(String elementId) {
		js.executeScript("document.getElementById('" + elementId + "').scrollIntoView();");
	}

	/**
	 * Scrolls inside a specific div or container.
	 *
	 * @param element The WebElement representing the container
	 * @param x Horizontal scroll amount
	 * @param y Vertical scroll amount
	 */
	public static void scrollInsideDiv(WebElement element, int x, int y) {
		js.executeScript("arguments[0].scrollBy(arguments[1], arguments[2]);", element, x, y);
	}

	/**
	 * Gets the total number of elements matching a CSS selector.
	 *
	 * @param selector CSS selector
	 * @return Number of matching elements
	 */
	public static long getElementCount(String selector) {
		return (Long) js.executeScript("return document.querySelectorAll('" + selector + "').length;");
	}

	/**
	 * Waits for an element to be visible.
	 *
	 * @param element The WebElement to wait for
	 * @return True if element is visible, false otherwise
	 */
	public static boolean waitForElementToBeVisible(WebElement element) {
		return (Boolean) js.executeScript(
				"var elem = arguments[0]; return (elem.offsetWidth > 0 && elem.offsetHeight > 0);", element);
	}

	// ==========================
	// Scrolling Methods
	// ==========================

	/**
	 * Scrolls to the bottom of the page.
	 */
	public static void scrollPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Scrolls to the top of the page.
	 */
	public static void scrollPageUp() {
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	/**
	 * Scrolls vertically by a specified amount.
	 *
	 * @param deltaY The number of pixels to scroll.
	 */
	public static void scrollPageVerticalByAmount(int deltaY) {
		js.executeScript("window.scrollBy(0, " + deltaY + ");");
	}

	/**
	 * Scrolls horizontally to the right.
	 */
	public static void scrollPageRight() {
		js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
	}

	/**
	 * Scrolls horizontally to the left.
	 */
	public static void scrollPageLeft() {
		js.executeScript("window.scrollTo(-document.body.scrollWidth, 0);");
	}

	/**
	 * Scrolls horizontally by a specified amount.
	 *
	 * @param deltaX The number of pixels to scroll.
	 */
	public static void scrollPageHorizontalByAmount(int deltaX) {
		js.executeScript("window.scrollBy(" + deltaX + ", 0);");
	}

	/**
	 * Scrolls the page to bring the specified element into view.
	 *
	 * @param element The WebElement to bring into view.
	 */
	public static void scrollPageToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Zooms the page to a specified level.
	 *
	 * @param value The zoom level (e.g., "0.5" for 50%, "1.5" for 150%).
	 */
	public static void zoomPage(String value) {
		js.executeScript("document.body.style.zoom='" + value + "';");
	}

	// ==========================
	// Element Interaction Methods
	// ==========================

	/**
	 * Clicks on the specified element using JavaScript.
	 *
	 * @param element The WebElement to click.
	 */
	public static void clickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Sets a value for the specified input element.
	 *
	 * @param element The WebElement where the value will be set.
	 * @param text    The value to set.
	 */
	public static void setValue(WebElement element, String text) {
		js.executeScript("arguments[0].setAttribute('value', arguments[1]);", element, text);
	}

	/**
	 * Retrieves the inner text of the specified element.
	 *
	 * @param element The WebElement to extract text from.
	 * @return The inner text of the element.
	 */
	public String getInnerText(WebElement element) {
		return js.executeScript("return arguments[0].innerText;", element).toString();
	}

	/**
	 * Makes a hidden element visible.
	 *
	 * @param element The WebElement to make visible.
	 */
	public static void makeHiddenElementVisible(WebElement element) {
		js.executeScript("arguments[0].style.display = 'block';", element);
	}

	/**
	 * Clicks on a hidden element after making it visible.
	 *
	 * @param element The WebElement to click.
	 */
	public static void clickHiddenElement(WebElement element) {
		js.executeScript("arguments[0].style.display = 'block';", element);
		element.click(); // Now it's visible, so we can click it
	}

	/**
	 * Highlights the specified element by changing its border style.
	 *
	 * @param element The WebElement to highlight.
	 */
	public static void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red';", element);
	}

	/**
	 * Flashes an element by alternating its background color.
	 *
	 * @param element The WebElement to flash.
	 */
	public static void flash(WebElement element) {
		String originalColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 3; i++) {
			changeColor("#ff0000", element); // Change to red
			changeColor(originalColor, element); // Change back to original color
		}
	}

	/**
	 * Changes the background color of a specified element.
	 *
	 * @param color   The color to apply.
	 * @param element The WebElement to modify.
	 */
	public static void changeColor(String color, WebElement element) {
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "';", element);
		try {
			Thread.sleep(500); // Brief pause for visual effect
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Double-clicks an element using JavaScript. */
	public static void doubleClick(WebElement element) {
		js.executeScript("var event = new MouseEvent('dblclick', {bubbles: true, cancelable: true}); arguments[0].dispatchEvent(event);", element);
	}

	/** Right-clicks an element using JavaScript. */
	public static void rightClick(WebElement element) {
		js.executeScript("var event = new MouseEvent('contextmenu', {bubbles: true, cancelable: true}); arguments[0].dispatchEvent(event);", element);
	}

	/** Drags an element from one position to another using JavaScript. */
	public static void dragAndDrop(WebElement source, WebElement target) {
		js.executeScript(
				"var event = new DragEvent('dragstart', {bubbles: true}); arguments[0].dispatchEvent(event);" +
						"event = new DragEvent('drop', {bubbles: true}); arguments[1].dispatchEvent(event);",
						source, target);
	}

	/**
	 * Changes an element's text.
	 *
	 * @param element The WebElement
	 * @param newText New text content
	 */
	public static void changeElementText(WebElement element, String newText) {
		js.executeScript("arguments[0].textContent = arguments[1];", element, newText);
	}

	/** Simulates pressing a button. */
	public static void pressButton(WebElement button) {
		js.executeScript("arguments[0].click();", button);
	}

	/** Disables right-click functionality on the page. */
	public static void disableRightClick() {
		js.executeScript("document.addEventListener('contextmenu', event => event.preventDefault());");
	}

	/** Makes an input field read-only. */
	public static void makeElementReadOnly(WebElement element) {
		js.executeScript("arguments[0].setAttribute('readonly', 'true');", element);
	}

	/** Makes an input field editable. */
	public static void makeElementEditable(WebElement element) {
		js.executeScript("arguments[0].removeAttribute('readonly');", element);
	}

	/**
	 * Removes an attribute from an element.
	 *
	 * @param element The WebElement
	 * @param attribute The attribute to remove
	 */
	public static void removeAttribute(WebElement element, String attribute) {
		js.executeScript("arguments[0].removeAttribute(arguments[1]);", element, attribute);
	}

	// ==========================
	// Alert Methods
	// ==========================

	/**
	 * Generates an alert with a specified message.
	 *
	 * @param message The alert message.
	 */
	public static void generateAlert(String message) {
		js.executeScript("alert('" + message + "');");
	}

	/**
	 * Closes the alert dialog by overriding the default alert function.
	 */
	public static void closeAlert() {
		try {
			js.executeScript("window.alert=function(){};");
		} catch (Exception ignored) {
			// Exception ignored to prevent crashes if alert override fails
		}
	}

	/** Checks if an alert is present. */
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Accepts an alert popup. */
	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/** Dismisses an alert popup. */
	public static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Enters text into a JavaScript prompt alert.
	 *
	 * @param driver WebDriver instance
	 * @param text Text to enter into the prompt
	 */
	public static void enterTextInPrompt(WebDriver driver, String text) {
		js.executeScript("window.prompt = function() { return '" + text + "'; };");
	}

	/**
	 * Displays a JavaScript confirm dialog.
	 *
	 * @param message The message to display
	 */
	public static void showConfirmDialog(String message) {
		js.executeScript("confirm('" + message + "');");
	}

	/**
	 * Scrolls to a specific position on the page.
	 *
	 * @param x The horizontal coordinate.
	 * @param y The vertical coordinate.
	 */
	public static void scrollToPosition(int x, int y) {
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
	}

	/**
	 * Retrieves the value from an input field.
	 *
	 * @param element The input WebElement.
	 * @return The value of the input field.
	 */
	public static String getInputFieldValue(WebElement element) {
		return js.executeScript("return arguments[0].value;", element).toString();
	}

	/**
	 * Disables an element on the webpage.
	 *
	 * @param element The WebElement to disable.
	 */
	public static void disableElement(WebElement element) {
		js.executeScript("arguments[0].setAttribute('disabled', 'true');", element);
	}

	/**
	 * Enables a previously disabled element.
	 *
	 * @param element The WebElement to enable.
	 */
	public static void enableElement(WebElement element) {
		js.executeScript("arguments[0].removeAttribute('disabled');", element);
	}

	/**
	 * Removes an element from the DOM.
	 *
	 * @param element The WebElement to remove.
	 */
	public static void removeElement(WebElement element) {
		js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", element);
	}

	/**
	 * Simulates a mouse hover action over an element.
	 *
	 * @param element The WebElement to hover over.
	 */
	public static void hoverOverElement(WebElement element) {
		js.executeScript("var event = new MouseEvent('mouseover', { bubbles: true, cancelable: true });"
				+ " arguments[0].dispatchEvent(event);", element);
	}

	/**
	 * Simulates a key press event on a webpage.
	 *
	 * @param key The key to press (e.g., "Enter", "Escape", "ArrowDown").
	 */
	public static void simulateKeyPress(String key) {
		js.executeScript("var event = new KeyboardEvent('keydown', { key: arguments[0] });"
				+ " document.dispatchEvent(event);", key);
	}

	/**
	 * Injects a custom JavaScript function into the page.
	 *
	 * @param script JavaScript function as a string.
	 */
	public static void injectJavaScript(String script) {
		js.executeScript(script);
	}

	/**
	 * Checks if an element is in the viewport.
	 *
	 * @param element The WebElement to check.
	 * @return True if the element is in the viewport, otherwise false.
	 */
	public static boolean isElementInView(WebElement element) {
		return (Boolean) js.executeScript(
				"var rect = arguments[0].getBoundingClientRect();"
						+ " return (rect.top >= 0 && rect.left >= 0 && rect.bottom <= window.innerHeight && rect.right <= window.innerWidth);",
						element);
	}

	/**
	 * Refreshes the webpage using JavaScript.
	 */
	public static void refreshPage() {
		js.executeScript("location.reload();");
	}

	/**
	 * Opens a new browser tab.
	 */
	public static void openNewTab() {
		js.executeScript("window.open();");
	}

	/**
	 * Closes the current browser tab.
	 */
	public static void closeCurrentTab() {
		js.executeScript("window.close();");
	}

	/**
	 * Switches to a new tab based on index.
	 *
	 * @param driver The WebDriver instance.
	 * @param tabIndex The index of the tab to switch to.
	 */
	public static void switchToTab(WebDriver driver, int tabIndex) {
		try {
			driver.switchTo().window(driver.getWindowHandles().toArray()[tabIndex].toString());
		} catch (Exception e) {
			System.err.println("❌ Error switching to tab index: " + tabIndex);
		}
	}

	/**
	 * Retrieves all cookies from the current session using JavaScript.
	 *
	 * @return All cookies in a string format.
	 */
	public static String getAllCookies() {
		return js.executeScript("return document.cookie;").toString();
	}

	/**
	 * Deletes all cookies using JavaScript.
	 */
	public static void deleteAllCookies() {
		js.executeScript("document.cookie.split(';').forEach(function(c) { "
				+ "document.cookie = c.replace(/^ +/, '').replace(/=.*/, '=;expires=' + new Date().toUTCString() + ';path=/'); });");
	}
}


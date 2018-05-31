package com.blulesurge.surgecloud.framework.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;



public class BasePage {
	protected WebDriver driver = null; 
	private String textToWait;
	
	public BasePage (WebDriver driver){
		this.driver = driver; 
	}
	
	
	public WebElement waitForElement(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return foo;
	}
	
	public WebElement waitForElementDisplayed(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	
	public WebElement waitForElementDisplayed(final By locator,int timeToWaitInSec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	
	public WebElement waitForElementText(final By locator,String text) {
		textToWait = text;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.getText().contentEquals(textToWait)) {
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	
	public WebElement waitForElementNotDisplayed(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				if (element.isDisplayed()) {
					return null;
				}
				return element;
			}
		});
		return foo;
	}
	
	public void jsClick(WebElement string){
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",  string);
	}

	
	
	public void hoverItem(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public void hoverItem(By by){
		 WebElement element = driver.findElement(by);
		 hoverItem(element) ;	 
	}
	  
	public void hoverItemEx(WebElement element){
		 Locatable hoverItem = (Locatable) element;
		 Mouse mouse = ((HasInputDevices) driver).getMouse();
		 mouse.mouseMove(hoverItem.getCoordinates()); 
	}
	public void hoverItemEx(By by){
		  WebElement element = driver.findElement(by);
		  hoverItemEx(element);
	 }
	
	
	
}

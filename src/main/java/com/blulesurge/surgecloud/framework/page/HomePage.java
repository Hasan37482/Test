package com.blulesurge.surgecloud.framework.page;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// *************************Model Variable**************************//

	private WebElement title= null;
	private WebElement signIn = null;

	// ***************Model Methods*************************//

	protected WebElement title(){
		title = waitForElementDisplayed(By.cssSelector(""), 500);
		return title;
	}

	protected WebElement signIn(){
		signIn = waitForElementDisplayed(By.xpath("//*[@id='flexslider']/ul/li/div[1]/a"));
		return signIn;
	}
	

	// *************************Controller Methods********************************//

	public HomePage verfyTitle(String expected){
		String actual = title().getText();
		assertThat(actual, equalToIgnoringCase(expected));
		return this;
	}
	
	public SignInPage clickSignInLink(){
		signIn().click();
		return new SignInPage(driver);
	}

	public HomePage and() {
		return null;
	}

	public HomePage then() {
		
		return null;
	}

}
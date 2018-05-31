package com.blulesurge.surgecloud.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





import static org.junit.Assert.*;

public class SignInPage extends Page {

	private WebElement email;
	private WebElement password;
	private WebElement next;
	private WebElement signIn;
	private WebElement signInsuccess;
	private WebElement signedInNOBtn;
	private WebElement logout;

	
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	// *************************Model Methods************************************

	public WebElement email() {
		email = driver.findElement(By.xpath("//*[@id='i0116']"));
		return email;
	}

	public WebElement password() {
		password = driver.findElement(By.xpath("//*[@id='i0118']"));
		return password;
	}

	public WebElement next() {
		next = driver
				.findElement(By
						.xpath("//*[@id='idSIButton9']"));
		return next;
	}
	
	public WebElement signIn() {
		signIn = driver
				.findElement(By
						.xpath(".//*[@id='idSIButton9'][@value='Sign in']"));
		return signIn;
	}
	
	public WebElement logout() {
		logout = driver
				.findElement(By
						.xpath(".//*[@id='app-header-drop-down-menu']/li[6]/a"));
		return logout;
	}
	public WebElement signedInNoBtn() {
		signedInNOBtn = driver
				.findElement(By
						.xpath("//*[@id='idBtn_Back']"));
		return signedInNOBtn;
	}
	public WebElement signInsuccess() {
		signInsuccess = waitForElementDisplayed(By
				.xpath("//*[@id='bs-example-navbar-collapse-1']/div/div/div/div[1]/span"));
		return signInsuccess;

	}

	// *************************Controller Methods************************************

	public SignInPage clickSignIn(String email, String password) {
		email().sendKeys(email);
		next().click();
		password().sendKeys(password);
		signIn().click();
		signedInNoBtn().click();
		return this;
	}

	public SignInPage verifySigninSuccess(String userName) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = signInsuccess().getText();

		assertEquals(userName.toUpperCase(), text.toUpperCase());

		return this;
	}

	public SignInPage clickLogOut(){
		signInsuccess().click();
		logout().click();
		return this;
		
	}
	
	public SignInPage and() {
		
		return null;
	}

	public SignInPage then() {
		
		return null;
	}
}

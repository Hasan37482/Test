package com.blulesurge.surgecloud.framework.controller;

import org.openqa.selenium.WebDriver;


import com.blulesurge.surgecloud.framework.page.HomePage;
import com.blulesurge.surgecloud.framework.page.Page;
import com.blulesurge.surgecloud.framework.page.SignInPage;

public class SurgeCloudApplicationController extends Page{
	public SurgeCloudApplicationController(WebDriver driver){
		super(driver);
	}
	
	
	private HomePage homePage = null;

	private SignInPage signinPage = null; 
	
	
	public SignInPage signinPage(){
		if(signinPage == null){
			signinPage = new SignInPage(driver);
		}
		return signinPage;
	}
	
	public HomePage homePage(){
		
		if(homePage == null){
			homePage = new HomePage(driver);
		}
		return homePage;
		
	}
	


	
	
}
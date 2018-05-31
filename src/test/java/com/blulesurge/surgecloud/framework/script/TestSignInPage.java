package com.blulesurge.surgecloud.framework.script;

import org.testng.annotations.Test;

import com.blulesurge.surgecloud.framework.AppConstant;
import com.blulesurge.surgecloud.framework.ScriptBase;

public class TestSignInPage extends ScriptBase {
	
	
	
	@Test()
	public void test(){
		 surgecloud().homePage()
		.clickSignInLink()
		.clickSignIn(AppConstant.DEFAULT_USER, AppConstant.DEFAULT_PASSWORD)
		.verifySigninSuccess(AppConstant.DEFAULT_USER_NAME)
		.clickLogOut()
		;
	}

	
}

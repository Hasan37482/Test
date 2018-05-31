package com.blulesurge.surgecloud.framework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.blulesurge.surgecloud.framework.controller.SurgeCloudApplicationController;




public class ScriptBase {
	
	protected WebDriver driver = null;
	protected SurgeCloudApplicationController surgecloud =null; 

		
		@Parameters({"Browser"})
		@BeforeMethod
		public void beforeMethod (@Optional("ch")String browser) throws Exception {
			if(browser.contentEquals("ff")){	
				System.setProperty("webdriver.gecko.driver","C:\\Users\\student\\Downloads\\geckodriver-v0.9.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.contentEquals("ch")) {
				File chromeDriverFile = new File(System.getProperty("user.dir") +  "/driver/32/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
				driver = new ChromeDriver();
			}
			
			else if(browser.contentEquals("ie")){
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setJavascriptEnabled(true);
				capabilities.setBrowserName("internet explorer");
				capabilities.setCapability("requireWindowFocus",true);
				//capabilities.setCapability("platform", "WIN8.0");
				//capabilities.setCapability("version", "10");

				//File driverFile = new File("C:/MyDevelopments/EclipseRepository/SeleniumWebDriver05/drivers/IEDriverServer.exe");
				File driverFile = new File(System.getProperty("user.dir") +  "/driver/32/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().to(AppConstant.App_URL);
			driver.manage().window().maximize();
			System.out.println("B class");
			
		}
	

		@AfterMethod(alwaysRun = true)
		public void tearDown() throws Exception{
			//driver.quit();
			surgecloud = null; 
		}
	
	public SurgeCloudApplicationController surgecloud(){
		if(surgecloud == null){
			surgecloud = new SurgeCloudApplicationController(driver);
		}
		return surgecloud;
	}

}

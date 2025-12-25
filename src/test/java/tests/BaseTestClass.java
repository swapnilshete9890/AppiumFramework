package tests;

import java.net.URI;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ExtentManager;

public class BaseTestClass 
{
	protected AndroidDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	public AndroidDriver getDriver() 
	{
	    return driver;
	}

	@BeforeTest
	public void setup()
	{
		extent = ExtentManager.getExtentReport(); 
		
		//capabilities code
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("ZD22284PKR");
		options.setPlatformName("Android");
		options.setPlatformVersion("13");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.bak.mnr.calculatrice");
		options.setAppActivity("com.bak.mnr.calculatrice.MainActivity");
		
		options.setCapability("appium:newCommandTimeout", 60);//newCommandTimeout defines how long Appium should wait for the next command before ending the session.
		
		//use when app need to ne install
		//options.setApp("application apk path stored apk in project");
		
		//use when browser automation is used
		
		//options.withBrowserName("Chrome");
		//options.setChromedriverExecutable(System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		URL url;
		try {
		    url = URI.create("http://127.0.0.1:4723/").toURL();
		} catch (Exception e) {
		    throw new RuntimeException("Invalid Appium server URL", e);
		}

		driver = new AndroidDriver(url, options);

		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
		}
		
		/*If driver creation fails for any reason:
			driver = null
			driver.quit() → NullPointerException */
		
		 extent.flush();  // CLOSE report
	}
	

}

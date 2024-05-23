package todo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void LaunchApp() throws MalformedURLException
	{
		
		DesiredCapabilities caps = new DesiredCapabilities ();
	    
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability("platformName", "android");
		caps.setCapability("deviceName", " Pixel_3_XL_API_34 [emulator-5554]");
		caps.setCapability("automationName", "UiAutomator2");
		File f = new File("any-do-5-18-0-2.apk");
		String path = f.getAbsolutePath();
		caps.setCapability("file", path);
		caps.setCapability("appPackage","com.anydo");
		caps.setCapability("appActivity","com.anydo.activity.SplashActivity");
		 driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/"), caps);
	}

	@AfterClass
	public void QuitApp()
	{
		
		driver.quit();
	}
	
}


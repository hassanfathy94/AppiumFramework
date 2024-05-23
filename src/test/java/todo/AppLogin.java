package todo;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppLogin extends BaseTest {

	
	@SuppressWarnings("deprecation")
	@Test (priority = 2)
	
	public void LoginWithRegisterdMailAndValidPassword() throws MalformedURLException, InterruptedException 
	{
	
    	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/login_main_mail_btn\")")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.anydo:id/user_email\"]")).sendKeys("hassanbashank@gmail.com");
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/verify_email_btn\")")).click();
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/user_password\")")).sendKeys("12345678");
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/sign_in_button\")")).click();
	    String Title = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.anydo:id/txtTopBarTitle\"]")).getText();
	    System.out.println("Top Bar Title : " + Title);
	    org.testng.Assert.assertEquals(Title, "MY DAY");
	    
		
		

		
	}
	
@SuppressWarnings("deprecation")
@Test (priority = 1)
	
	public void LoginWithRegisterdMailAndNotValidPassword() throws MalformedURLException, InterruptedException 
	{
	
    	
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/login_main_mail_btn\")")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.anydo:id/user_email\"]")).sendKeys("hassanbashank@gmail.com");
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/verify_email_btn\")")).click();
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/user_password\")")).sendKeys("1234567");
	    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/sign_in_button\")")).click();
	    String ErrorMessage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/textinput_error\")")).getText();
	    System.out.println("Error Message : " + ErrorMessage);
	    org.testng.Assert.assertEquals(ErrorMessage, "Invalid email/password");
	    
	}


@SuppressWarnings("deprecation")
@Test (priority = 0)

public void LoginWithRegisterdMailAndBlankPassword() throws MalformedURLException, InterruptedException 
{

	
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/login_main_mail_btn\")")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.anydo:id/user_email\"]")).sendKeys("hassanbashank@gmail.com");
    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/verify_email_btn\")")).click();
    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/user_password\")")).sendKeys("");
    String SignInState =driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/sign_in_button\")")).getAttribute("enabled");
    org.testng.Assert.assertEquals(SignInState, "false");
    
}

	
	@SuppressWarnings("deprecation")
	@Test (priority = 0)

	public void LoginWithoutEnteringMail() throws MalformedURLException, InterruptedException 
	{

		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/login_main_mail_btn\")")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.anydo:id/user_email\"]")).sendKeys("");
		String SignInState =  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.anydo:id/verify_email_btn\")")).getAttribute("enabled");
	    org.testng.Assert.assertEquals(SignInState, "false");
	    
	}
	
}

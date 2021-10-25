package Appiumserver_001;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;


public class Installing_apkfiles_001 {
	@Test
public void setup()throws InterruptedException, MalformedURLException{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator" );
	    dc.setCapability(MobileCapabilityType.APP, "C:\\Apkfiles\\Guru99App.apk");
       URL url	=new URL("http://127.0.0.1:4723/wd/hub");
       AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
       
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
  
     
      if(  driver.getPageSource().contains("Text Show here")) {
    	  System.out.println("At home page");
    	   WebElement text=driver.findElement(By.id("com.guru99app:id/txtView"));
           System.out.println(text.getText());
      }
      else {
    	  System.out.println("Error");
      }
      WebDriverWait wait  =new WebDriverWait(driver,20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"_highlighter-box_619e8 _inspected\")]")));
        WebElement header=driver.findElement(By.xpath("//div[contains(@class,\"_highlighter-box_619e8 _inspected\")]"));
        if (header.isDisplayed()) {
        	System.out.println("Test is pass");
        	System.out.println(header.getText());
        }
 
}

}

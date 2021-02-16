package utitity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BDDFramework.Amazon.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utility  {
	
	public AndroidDriver<AndroidElement>  driver;
	Properties prop = new Properties();
	public Utility(AndroidDriver<AndroidElement>  driver) {
		this.driver = driver;
	}
	
	public void WaitTillVisibilty(WebElement webelement){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void WaitTillInVisibilty(WebElement webelement){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.invisibilityOf(webelement));
	}
		
	
}



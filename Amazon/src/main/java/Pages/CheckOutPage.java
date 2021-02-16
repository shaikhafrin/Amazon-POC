package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
//
	
	public AndroidDriver<AndroidElement>  driver;
	public CheckOutPage(AndroidDriver<AndroidElement>  driver){
		this.driver=driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver),this);
	}


	@AndroidFindBy(xpath = "//*[@text='TCL 32S327 32-Inch 1080p Roku Smart LED TV']")
	public WebElement checkitem_title; 
	

	@AndroidFindBy(xpath = "//*[@text='168']")
	public WebElement checkitem_Price; 
}

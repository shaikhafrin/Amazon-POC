package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AmazonTitle {
	public AndroidDriver<AndroidElement>  driver;
	public AmazonTitle(AndroidDriver<AndroidElement>  driver){
		this.driver=driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(className="android.widget.ImageView")
	public WebElement amazone_name;
	
	public void checkTitle(){
		
	}
}

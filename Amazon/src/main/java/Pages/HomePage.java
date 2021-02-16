package Pages;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BDDFramework.Amazon.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utitity.Utility;

public class HomePage  {
	public AndroidDriver<AndroidElement>  driver;
	public HomePage(AndroidDriver<AndroidElement>  driver){
		this.driver=driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement search_box;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")
	public WebElement listhome;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	public List<WebElement> list; 

	
	public void sendItem() throws IOException, InterruptedException{
		Utility utilhome = new Utility(driver);
		ItemsPage itemhome = new ItemsPage(driver);
		search_box.click();
		Thread.sleep(3000);
		//utilhome.WaitTillVisibilty(search_box);
		search_box.sendKeys("65-inch TV");
		Thread.sleep(3000);
		utilhome.WaitTillVisibilty(listhome);
		listhome.click();
		Thread.sleep(10000);
		WebDriverWait waitin = new WebDriverWait(driver, 20);
		
	
			}
		//search_box.sendKeys(Keys.ENTER);
	
	
}

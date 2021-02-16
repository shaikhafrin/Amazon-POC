package Pages;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.beans.Visibility;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utitity.Utility;

public class ItemsPage {
	public AndroidDriver<AndroidElement>  driver;
	public ItemsPage(AndroidDriver<AndroidElement>  driver){
		this.driver=driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver),this);
	}
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	public List<WebElement> list; 
	
	@AndroidFindBy(xpath = "//*[@text = 'Add to Cart']")
	public WebElement addToCart; 
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image")
	public WebElement checkout_btn; 

	@AndroidFindBy(xpath = "//*[@text='TCL 32S327 32-Inch 1080p Roku Smart LED TV']")
	public WebElement item_title; 
	

	@AndroidFindBy(xpath = "//*[@text='168']")
	public WebElement item_Price; 

	
	
	public void selectRandomItem(List<WebElement> list) throws InterruptedException{
		
		System.out.println(list.size());
		Random rand = new Random(); 
        WebElement randomitem= list.get(rand.nextInt(list.size()));
        addToCart.click();
        checkout_btn.click();
        
        
        
		/*for(int i =0 ;i<list.size();i++){
			Utility utilitem = new Utility(driver);
			utilitem.WaitTillVisibilty(list.get(i));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(list.get(i)));
			Thread.sleep(3000);
			TouchAction t = new TouchAction(driver);
			
			t.tap(tapOptions().withElement(element(list.get(i)))).perform();
			if(list.get(i).getText().contains("SAMSUNG")){
				list.get(i).click();
			}
		}*/
}
	
    
	
}

package BDDFramework.Amazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.AmazonTitle;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.ItemsPage;
import Pages.SignIn;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utitity.Utility;

public class Operations extends BaseClass {
	public static AndroidDriver<AndroidElement>  driver;
	
	public Operations() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		service=startServer();
		startEmulator();
		//capabilities();
		buyTv();
	}
	public static void buyTv() throws IOException, InterruptedException{
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SignIn _signin = new SignIn(driver);
		Utility _util = new Utility(driver);
		AmazonTitle _amazon = new AmazonTitle(driver);
		HomePage _home= new HomePage(driver);
		ItemsPage _item =  new ItemsPage(driver);
		CheckOutPage _checkout = new CheckOutPage(driver);
		
		//Thread.sleep(10000);
		_util.WaitTillInVisibilty(_amazon.amazone_name);
		_util.WaitTillVisibilty(_signin.signin);
	    _signin.performeSignIn();
		_home.sendItem();
	    _item.selectRandomItem(_item.list);
	    Assert.assertEquals(_item.item_title.toString(), _checkout.checkitem_title.toString());
	    Assert.assertEquals(_item.item_Price.toString(), _checkout.checkitem_Price.toString());
		Thread.sleep(10000);
		service.stop();
	}
}

package Pages;

import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utitity.Utility;

public class SignIn {
	
	public AndroidDriver<AndroidElement>  driver;
	public SignIn(AndroidDriver<AndroidElement>  driver){
		this.driver=driver;
		PageFactory.initElements( new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	public WebElement signin;
	
	@AndroidFindBy(xpath="//*[@text='US +1']")
	public WebElement US;
	
	@AndroidFindBy(id="ap_email_login")
	public WebElement signin_option;
	
	@AndroidFindBy(id="auth-signin-show-password-checkbox")
	public WebElement showpwd_checkbox;

	@AndroidFindBy(id="ap_password")
	public WebElement ap_password_btn;
	

	@AndroidFindBy(id="continue")
	public WebElement continue_btn;
	
	
	@AndroidFindBy(id="signInSubmit")
	public WebElement signin_btn;
	
	public void performeSignIn(){
		
		/* Scanner sc_one = new Scanner(System.in);  // Create a Scanner object
		 System.out.println("Enter amazon email or mobile number");
		 String amz_username = sc_one.nextLine();
		 
		 Scanner sc_two = new Scanner(System.in);  // Create a Scanner object
		 System.out.println("Enter amazon password");
		 String amz_pwd = sc_one.nextLine();   
		 */
		 
		Utility utilsign = new Utility(driver);
	    signin.click();
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(signin_option));
		//signin_option.click();
		signin_option.sendKeys("8275452404");
		US.click();
		WebElement india=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""+"India + 91"+"\").instance(0))"));
		india.click();
		continue_btn.click();
		showpwd_checkbox.click();
		ap_password_btn.sendKeys("Ayesha29");
		signin_btn.click();
	}

}

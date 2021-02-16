package BDDFramework.Amazon;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.ServerSocket;
	import java.net.URL;
	import java.util.Properties;

	import org.openqa.selenium.remote.DesiredCapabilities;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.service.local.AppiumDriverLocalService;

	public class BaseClass {
		
		
		public static AppiumDriverLocalService service;
		public static AppiumDriverLocalService startServer(){
			if(!checkIfserverIsRunning(4723)){
				service=AppiumDriverLocalService.buildDefaultService();
				service.start();
				
			}
			return service;
		}
		public static void startEmulator() throws IOException, InterruptedException{
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Resources\\startEmulator.bat");
			Thread.sleep(5000);
		}
		public static AndroidDriver<AndroidElement> capabilities() throws IOException {
			

			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\global.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			File appdir = new File("Resources");
			File fs = new File(appdir, prop.getProperty("appname"));	
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device"));
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("automation-name"));
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			return driver;

		}
		
		public static boolean checkIfserverIsRunning(int port){
			boolean isServerRunning=false;
			ServerSocket serverSocket;
			try{
				serverSocket = new ServerSocket(port);
				serverSocket.close();
			}
			catch(IOException e){
				isServerRunning=true;
			}
			finally {
				{
					serverSocket=null;
				}
			}
			return isServerRunning;
			
		}

	}



package userDefinedlibraries;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * INSTANTIATION OF THE CHROME BROWSER AND MOZILA FIREFOX BROWSERS
 * 
 * First it invoke the browser
 * Then navigate the URL
 * Perform the required task
 * And close the browser 
 */

public class DriverSetup {
		public static WebDriver driver;
		public static String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		
		//LAUNCHING THE BROWSER AS PER BROWSER TYPE
		public static WebDriver getWebDriver(String browser) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\AlertHandling\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();				        	        
		    }
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\AlertHandling\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();				        	        
		    } 
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//SET TIMEUNIT FOR PAGE LOADING
			//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			
			//NAVIGATE TO URL
			driver.get(url);
			driver.manage().deleteAllCookies();
			return driver;	
		}	
		
		//CLOSING THE DRIVERS AND IT'S SESSION
		public static void closeDriver() {
			driver.quit();
		}

	}



package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	static WebDriver driver;
	static WebElement element;
	
	//TO LOCATE THE NEXT BUTTON
	public static WebElement NextButton (WebDriver driver) {
		//JavascriptExcutor js=((JavascriptExecutor)driver);
		element = driver.findElement(By.name("next"));
		return element;
	}

}

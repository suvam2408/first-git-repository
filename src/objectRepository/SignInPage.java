package objectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignInPage {
	static WebDriver driver;
	static WebElement element;
	
//TO LOCATE THE SIGNIN BUTTON
 public static WebElement SignInButton (WebDriver driver) {
	element = driver.findElement(By.name("proceed"));
	return element;
	}
 
//TO LOCATE THE FORGOT PASSWORD LINK
 public static WebElement ForgotPassword (WebDriver driver) {
	element = driver.findElement(By.linkText("Forgot Password?"));
	return element;
}


}

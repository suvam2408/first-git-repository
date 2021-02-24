package userDefinedlibraries;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;



public class ScreenShot {
	static WebDriver driver;
	
	//TO TAKE SCREENSHOT OF USING ROBOT CLASS
	public static void robotScreenshot() throws HeadlessException, AWTException, IOException{
	
	BufferedImage image = new Robot()
			.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	//Copy the screenshot to desired location using copyFile method and image type is jpg
    ImageIO.write(image, "jpg",
    		new File("C:\\Users\\user\\eclipse-workspace\\AlertHandling\\ScreenShot\\"+ System.currentTimeMillis() +".jpg"));
    
    }
}

	




package testScenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
//import org.openqa.selenium.NoAlertPresentException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import objectRepository.SignInPage;
import objectRepository.ForgotPasswordPage;
import userDefinedlibraries.DriverSetup;
import userDefinedlibraries.ExcelReadWrite;
import userDefinedlibraries.ScreenShot;
//import org.openqa.selenium.TimeoutException;


/*
 * Project:Alert Handling
 * Name:Poulami Sarkar
 * Employee Id:885624
 * 
 * Project Description:
 *                     1.Handle the alert when user clicks on “Sign in” button without filling any information 
                       2.Handle alert when user clicks on “Forgot Password” link
 */




public class CaseStudyOfAlert {
	public static XSSFSheet sheet;
	public static String browser;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String category1;
    public static String category2;
	static WebDriver driver;
	static WebElement element;
	String actualMsg1,actualMsg2;
	
	
	
	//OPENING THE BROWSER
	@Parameters("browser")
	 @BeforeClass
	public void createDriver(String browser)
    {
    		driver=DriverSetup.getWebDriver(browser);   
    }
	
	
	//READING THE DATA FROM AN EXCEL FILE
	@Test (priority=1)
	public void excelRead() throws IOException,FileNotFoundException
    {
    	ExcelReadWrite.readexcel();
    }
	
	
	//CLICKING ON SIGNIN BUTTON AND HANDLE THE ALERT FOR SIGNIN BUTTON
	@Test (priority=2)
	public void testSignButtonAlert() {
		try {
		SignInPage.SignInButton(driver).click();
		WebDriverWait wait=new WebDriverWait(driver,30); //WAIT UNTIL ALERT IS PRESENT
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert=driver.switchTo().alert();
		String actualMsg1=alert.getText();
		String expected1=ExcelReadWrite.category1; 
		
		//VERIFY THE ALERT MESSAGE
		Assert.assertEquals(actualMsg1,expected1); 
		ExcelReadWrite.writeExcel("sheet1",0,3,actualMsg1);
		System.out.println("The correct message from alert for click on sign in button is: "+actualMsg1); //PRINT THE OUTPUT TO CONSOLE
		try {
			//TAKE A SCREENSHOT OF ALERT
			ScreenShot.robotScreenshot();
		} catch (HeadlessException | AWTException | IOException e) {
			e.printStackTrace();
		}
		alert.accept();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
	
	//CLICKING ON FORGOT PASSWORD LINK
	@Test (priority=3)
	public void testForgotPassword(){
		SignInPage.ForgotPassword(driver).click();
	}
	
	
	
	//CLICKING ON NEXT BUTTON AND HANDLE THE ALERT FOR NEXT BUTTON 
	@Test (priority=4)
	public void testNextButtonAlert() {
		ForgotPasswordPage.NextButton(driver).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20); //WAIT UNTIL ALERT IS PRESENT
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String actualMsg2=alert.getText();
		String expected2=ExcelReadWrite.category2;
		
		//VERIFY THE ALERT MESSAGE
		Assert.assertEquals(actualMsg2,expected2);
		ExcelReadWrite.writeExcel("sheet1",1,3,actualMsg2);
		System.out.println("The correct message from alert for click on next button is: "+actualMsg2); //PRINT THE OUTPUT TO CONSOLE
		try {
			//TAKE A SCREENSHOT OF ALERT
			ScreenShot.robotScreenshot();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		alert.accept();
		}
	
	
	//CLOSING THE BROWSER
	@AfterClass
	public void closeBrowser(){
		DriverSetup.closeDriver();
	}
	

}

package com.class06.Alerts_Frames;
/*
 * go to http://166.62.36.207/syntaxpractice/bootstrap-iframe.html
verify the logo is displayed on the first frame 
verify the button is enabled on the second frame

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTask {
	public static String url = "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//switch to Frame
		driver.switchTo().frame("FrameOne");
		
		//find the logo web element
		WebElement logo = driver.findElement(By.id("hide"));
		
		//verify the logo is displayed on the first frame 
		boolean isLogoDisplayed = logo.isDisplayed();
		System.out.println("Is logo displayed? " + isLogoDisplayed);
		
		//get out from frame on the webpage
		driver.switchTo().defaultContent();
		
		// switch to another frame
		driver.switchTo().frame(1);
		
		//find the button web element
		WebElement enrollTodayButton = driver.findElement(By.cssSelector("a[class = 'enroll-btn']"));
		//verify the button is enabled on the second frame
		
		boolean isButtonEnabled = enrollTodayButton.isEnabled();
		System.out.println("Is enroll today button enabled? " + isButtonEnabled);
		
	}

}

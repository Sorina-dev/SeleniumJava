package com.syntax.class04;
import org.openqa.selenium.By;
/*
 * HRMS Application Negative Login: 
Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.

 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	driver.findElement(By.cssSelector("input[id=\"txtUsername\"]")).sendKeys("Admin");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[id=\"btnLogin\"]")).click();
	Thread.sleep(1000);
	WebElement displayMessage = driver.findElement(By.cssSelector("span[id='spanMessage']"));
	Thread.sleep(1000);
	if(displayMessage.isDisplayed()) {
		String textdisplayMessage = displayMessage.getText();
		System.out.println(textdisplayMessage);
		Thread.sleep(1000);
	if(textdisplayMessage.equals("Password cannot be empty")) {
		System.out.println("Error message with text “Password cannot be empty” is displayed");
	}
	}
}
}

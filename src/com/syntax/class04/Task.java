package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username and password (username - Admin, password - Hum@nhrm123)
Click on login button
Then verify Syntax Logo is displayed.
 */
public class Task {
	 public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	    
	    public static void main(String[] args) throws InterruptedException {
			
	    	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	    	
	    	driver.get(url);
	    	driver.findElement(By.xpath("//span[text()='Username']")).sendKeys("Admin");
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//span[text()='Password']")).sendKeys("Hum@nhrm123");
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//input[@value=\"LOGIN\"]")).click();
	    	Thread.sleep(2000);
	    	WebElement logo = driver.findElement(By.cssSelector("alt=\"OrangeHRM\""));
	    	Thread.sleep(2000);
	    	if(!logo.isDisplayed()) {
	    		System.out.println("The Syntax logo displayed is " +logo.isDisplayed());
	    	}else {
	    		System.out.println("The Syntax logo displayed is " +logo.isDisplayed());
	    	}
            
}
}
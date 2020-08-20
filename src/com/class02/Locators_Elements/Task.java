package com.class02.Locators_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//navigate to website; insert the username and password and click on button enter
// get the title of website

public class Task {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    
	WebDriver driver = new ChromeDriver();
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
	
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");//if using class name there would be duplicates in DOM
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	Thread.sleep(5000);
	System.out.println(driver.getTitle());
//	String actualTitle = driver.getTitle();
//	String expectedTitle = "Web Orders";
//	if(actualTitle.equalsIgnoreCase(expectedTitle)) {
//		System.out.println("This is the right title");
//	} else {
//		System.out.println("This is WRONG title");
//	}
	Thread.sleep(3000);
	driver.findElement(By.linkText("Logout")).click();


}
}

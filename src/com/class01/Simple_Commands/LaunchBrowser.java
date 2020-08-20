package com.class01.Simple_Commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
    
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://google.com"); //https:www.google.com 
	String url = driver.getCurrentUrl();
	System.out.println(url);
	String title = driver.getTitle();
	System.out.println(title);
}
}

package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AuthenticationAlerts {
	
	public static String url = "http://test:test@abcdatabase.com/basicauth";
	//after slashes// insert:username:password + @ + the url after slashes

public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

WebDriver driver = new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
Thread.sleep(2000);

}
}

package com.class01.Simple_Commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
	public static void main(String[] args) throws InterruptedException {//thread sleep imported
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	       
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:www.amazon.com");
		driver.navigate().to("http://facebook.com");//one object for one tab (page on internet)
		driver.navigate().back();
		driver.navigate().forward();
		driver.manage().window().maximize(); // for windows to get the full screen
		driver.close(); //to close one tab only
		//driver.quit(); // to close the browser
		//driver.navigate().refresh(); // to refresh the page
		//Thread.sleep(2000); //its 2 sec its pausing for 2 sec after some action
	}
}

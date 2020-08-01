package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
       
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:www.amazon.com");//got to the browser
		String url = driver.getCurrentUrl(); // validate if you landed on correct url
		System.out.println(url);
		String title = driver.getTitle();//validate if your page title is correct
		System.out.println(title);
		//System.out.println(driver.getPageSource());   // to get the page source we also can 
		                           
	}

}

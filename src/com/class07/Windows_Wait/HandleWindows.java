package com.class07.Windows_Wait;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static String url = "http://accounts.google.com/signup";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		String mainPageHandle = driver.getWindowHandle();
		System.out.println(mainPageHandle); //this is the unique identifier for the tab
		
		WebElement helplink = driver.findElement(By.linkText("Ajutor")); //opened the new tab
		helplink.click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();// there are already two windows or tabs, Set cuz there is no duplicates
		System.out.println(allWindowHandles.size());//how many tabs
		
		//use iterator to get to other windows/tabs
		Iterator<String> it = allWindowHandles.iterator();//going to iterate without a loop
		mainPageHandle = it.next(); //1st window    //forward one by one
		String childHandle = it.next(); //2nd window
		System.out.println(childHandle); 
		
		Thread.sleep(2000);
		driver.switchTo().window(mainPageHandle); //method to go to the 1st window
		
    //    driver.close(); //it will close only a tab
		//you need to switch to child tab after you closed the tab
		
	      driver.quit(); //browser will close completely
	}

}

package com.class10.TackingScreenshots_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));
		//Action object
		Actions action = new Actions(driver);//action class works with keyboard
		action.moveToElement(accountsAndLists).perform(); //action always should end with perform method
		
	}
}

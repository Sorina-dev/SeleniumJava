package com.class04.RadioButton_CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *  Amazon link count: 
Open chrome browser
Go to “https://www.amazon.com/”
Get all links
Get number of links that has text
Print to console only the links that has text
 */
public class Task2{
	
	public static String url = "https://www.amazon.com/"; 
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		for(WebElement link : list) {
			String linkText = link.getText();
			String fullLink = link.getAttribute("href");
			if(!linkText.isEmpty()) {
				System.out.println(linkText + "      "+ fullLink);
			}
		}
		
		
	}
}

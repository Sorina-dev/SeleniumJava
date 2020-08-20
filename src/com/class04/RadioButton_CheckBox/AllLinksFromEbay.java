package com.class04.RadioButton_CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksFromEbay {
public static String url = "http://ebay.com";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> allLinks = driver.findElements(By.tagName("a")); //for links "a" name of tag
		System.out.println(allLinks.size());
		for (WebElement link : allLinks) {
			String linkText = link.getText();
			String fullLink = link.getAttribute("href"); //"href" -- name of tag
			if(!linkText.isEmpty()) {
				System.out.println(linkText + "      " + fullLink);
			}
			
		}
	}
}
package com.class04.RadioButton_CheckBox;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html
Select any radiobutton and the age group ---> use List and loop 
Click on get values 
Verify the text in the page -- do not hardcode the values and compare
 */
public class HW1 {
public static void main(String[] args)throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html");
	List<WebElement> radiobtns =driver.findElements(By.xpath("//input[@type='radio']"));
	
	for (WebElement btn : radiobtns) {
		 if(btn.isEnabled()) {
				String checkBox = btn.getAttribute("value");
				if(checkBox.equalsIgnoreCase("Male")) {
					btn.click();
					Thread.sleep(1000);
					break;
				}
	}
}
	WebElement element = driver.findElement(By.cssSelector("button[id=\"buttoncheck\"]"));
	element.click();
	
	for(WebElement btn : radiobtns) {
		if(btn.isEnabled()) {
			String checkBox = btn.getAttribute("value");
			if(checkBox.equals("5 - 15")) {
				btn.click();
				Thread.sleep(1000);
				break;
			}
		}
	}
	WebElement element1 = driver.findElement(By.xpath("//button[text()='Get values']"));
	element1.click();
}
}

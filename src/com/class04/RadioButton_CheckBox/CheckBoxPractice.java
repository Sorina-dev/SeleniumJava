package com.class04.RadioButton_CheckBox;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {
public static String url = "http://166.62.36.207/syntaxpractice/basic-checkbox-demo.html";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> optionCheckBoxes = driver.findElements(By.xpath("//input[@class = 'cb1-element']"));
		int options = optionCheckBoxes.size();
		System.out.println(options);
		
		for (WebElement checkBoxOption : optionCheckBoxes) {
			if(checkBoxOption.isEnabled()) {
				String checkBoxValue = checkBoxOption.getAttribute("value");
				if(checkBoxValue.equals("Option-2")) {
					checkBoxOption.click();
					Thread.sleep(1000);
					break;
				}
				
			}

		}

	}
}

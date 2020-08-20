package com.class04.RadioButton_CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithRadioButtonsAndCheckBoxes {
	
	public static String url = "https://www.amazon.com/"; 
	
public static void main(String[] args) {
	//as example
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	
	// Store all the elements of the same category in the list of WebElements. 
	List<WebElement> list = driver.findElements(By.name("radioButton")); 
	// Create a boolean variable to store true/false.
	Boolean is_selected = list.get(0).isSelected();
	// If 'is_selected' is true that means the first radio button is selected.
	if (is_selected == true) { 
		// If the first radio button is selected by default then, select the second radio button.
		list.get(1).click(); } else {
			// If the first radio button is not selected then, click the first radio button.
			list.get(0).click();
	}
	
}
}

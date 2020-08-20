package com.class05.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingAmazonDD {
	
	public static String url = "https://www.amazon.com/";
public static void main(String[] args) {
	
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();
 
	  driver.get(url);
	  WebElement categoriesDD = driver.findElement(By.id("searchDropdownBox"));
	  Select select = new Select(categoriesDD);
	
	  List<WebElement> options = select.getOptions();
	  
	 System.out.println(options.size());
	  // print all logo text options
	  for (WebElement option : options) {
		  String text = option.getText();
		  System.out.println(text);
	}
	  
	  select.selectByValue("search-alias=fashion-mens-intl-ship");//selected an option by value
	  
}
}

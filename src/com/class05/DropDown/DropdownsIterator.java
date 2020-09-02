package com.class05.DropDown;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsIterator {
	public static String url = "https://www.amazon.com/";
public static void main(String[] args) {
	
	 System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();
	  driver.get(url);
	  WebElement categoriesDD = driver.findElement(By.id("searchDropdownBox"));
	  
	  Select select = new Select(categoriesDD);
	  List<WebElement> options = select.getOptions();//multi selector dropdown only
	  
	  Iterator<WebElement> it = options.iterator();
	    while(it.hasNext()) {
	    	WebElement option = it.next();
	    	String optionText = option.getText();
	    	System.out.println(optionText);
	    }
	    
	    boolean isMultiple = select.isMultiple();
	    System.out.println(isMultiple);
	    
	    
}
}

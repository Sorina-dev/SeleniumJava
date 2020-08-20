package com.class05.DropDown;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */
public class HW2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		WebElement categories = driver.findElement(By.id("gh-cat")); 
		Select sel = new Select(categories);
	//get all the categories
		List<WebElement> categoriesList = sel.getOptions();
	//print them in the console	
		Iterator <WebElement> it = categoriesList.iterator();
		  while(it.hasNext()) {
			  WebElement option = it.next();
			  String optionText = option.getText();
			  System.out.println(optionText);
		  }
		//select Computers/Tables & Networking  
		sel.selectByValue("58058");
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		
		//verify the header
		WebElement header = driver.findElement(By.className("b-pageheader__text")); //Computers, Tablets & Network Hardware
		String headerText = header.getText();
		if(!headerText.equals("Computers, Tablets & Network Hardware")) {
			System.out.println("It's the wrong header");
		}else {
			System.out.println("It's the right header");
		}
		
	}
}

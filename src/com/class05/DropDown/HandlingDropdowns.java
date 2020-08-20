package com.class05.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {
	
	public static String url = "http://166.62.36.207/syntaxpractice/basic-select-dropdown-demo.html";
public static void main(String[] args) throws InterruptedException {
	
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();
      driver.get(url);
      WebElement daysDD = driver.findElement(By.id("select-demo"));
      Select select = new Select(daysDD);
      //1st way of selecting
      select.selectByIndex(2); //cuz there is also Please select that is disabled and its at 0 index
      //2nd way of selecting
      Thread.sleep(2000);
      select.selectByVisibleText("Wednesday");//written in black in the DOM
      //3rd way of selecting
      Thread.sleep(2000);
      select.selectByValue("Sunday"); // value text
      
      List <WebElement> options = select.getOptions(); //getting all the options and store them inside the List
      int size = options.size();
      System.out.println(size);
      //there are 8 options , cuz there is the disabled "Please select"
      
      for(int i = 0; i < size; i++) { //to loop each option
    	  select.selectByIndex(i);
    	  Thread.sleep(1000);
      }
      
      
	
}
}

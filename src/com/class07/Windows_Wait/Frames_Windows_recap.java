package com.class07.Windows_Wait;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.class04.RadioButton_CheckBox.CommonMethods;

public class Frames_Windows_recap extends CommonMethods {
public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.espn.com/");
		
		// we want to click on "Learn More" button
		
		// we should take selenium's attention to iframe
		
		// 1. create a WebElement of iframe
		
		// We have 3 overloded methods to take selenium's attentin to iframe
		
		//  .frame(int index)
		//  .frame(String name)
		//  .frame(WebElement element)
		
		WebElement iframe1=driver.findElement(By.id("google_ads_iframe_/21783347309/espn.com/frontpage/index_3"));
		
//		driver.switchTo().frame(iframe1);
		
//		driver.switchTo().frame(1);
		
		driver.switchTo().frame("google_ads_iframe_/21783347309/espn.com/frontpage/index_3");
		
		driver.findElement(By.id("image-138321319566")).click();
		
		// If we want to work on an element on main frame we have to take selenium's attention 
		// to main frame
		
		driver.switchTo().defaultContent();  // --> Very Important
		
		// if we want to work on another iframe  -- cannot switch from ifrmae to another iframe
		// 1. We need to go back to default content
		// 2. switch to the next iframe  
		
		// How to handle windows
		// getWindowHandles() method --> Set of String of the window handles of the all pages
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		
		String mainWindowHandle=it.next();
		
		System.out.println("Main Handle: "+ mainWindowHandle);
		
		String childWindowHandle=it.next();
		
		System.out.println("Child Window Handle : "+ childWindowHandle);
		
		// take selenium's attention to child window
		
		driver.switchTo().window(childWindowHandle);
		
		Thread.sleep(3000);
		driver.close();
	}
}

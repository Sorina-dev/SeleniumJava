package com.class04.RadioButton_CheckBox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends CommonMethods{
public static void main(String[] args) throws InterruptedException {
		
		setUp("firefox", "https://demoqa.com/browser-windows");
		
		String mainWindow=driver.getWindowHandle();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("messageWindowButton")).click();
		
		// to get main and child window handles we use getWindowHandles() method
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();

		
		while(it.hasNext()) {
			String childWindow=it.next();
			
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
			}
		}
		
		
		WebElement body=driver.findElement(By.tagName("body"));
		
		String text=body.getText();
		System.out.println(text);
		
		Thread.sleep(3000);
		driver.quit();
	}
}

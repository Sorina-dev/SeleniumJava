package com.class06.Alerts_Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.class04.RadioButton_CheckBox.CommonMethods;

public class AlertsRecap extends CommonMethods{
public static void main(String[] args) throws InterruptedException {
		
		
		// why to handle alerts in Selenium --> Execution will stop and we will get 
		// UnhandledAlertException
		
		// How to handle alert --> We are using Alert interface
		
		setUp("chrome", SyntaxPrctice_URL);
		
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		// 1. switch to the alert box
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		// Methods used for Alerts
		// accept();
		// dismiss();
		// getText();
		// sendKeys();
		
		String text=alert.getText();
		System.out.println(text);
		
		alert.accept();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}

package com.class06.Alerts_Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//maximize the window and put on sleep in order to work
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// handling simple alert
       //find the alert element
		WebElement simpleAlertButton = driver.findElement(By.id("alert")); 
		simpleAlertButton.click();
		//call the alert interface
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		//handling confirmation alert
		WebElement confirmationAlertButton = driver.findElement(By.id("confirm"));
		confirmationAlertButton.click();
		Thread.sleep(5000);
//		Alert confirmAlert = driver.switchTo().alert();
//		confirmAlert.dismiss();
		String confirmAlertText = alert.getText(); //getting the text
		System.out.println(confirmAlertText);
		alert.dismiss();
		
		//handling prompt alert
		WebElement promptAlertButton = driver.findElement(By.id("prompt"));
		promptAlertButton.click();
		Thread.sleep(5000);
		alert.sendKeys("Syntax");
		Thread.sleep(5000);
		alert.accept();
		
		

	}
}

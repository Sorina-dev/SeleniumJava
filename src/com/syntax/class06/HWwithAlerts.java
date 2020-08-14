package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Go to http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html
click on each button and handle the alert accordingly
 */
public class HWwithAlerts {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//button[@class ='btn btn-default']")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
	alert.dismiss();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
	String alertText = alert.getText();
	System.out.println(alertText);
	Thread.sleep(1000);
	alert.sendKeys("Sorina");
	Thread.sleep(1000);
	alert.accept();
	String textAfter = driver.findElement(By.xpath("//p[starts-with(text(),'You have entered')]")).getText();
	System.out.println(textAfter);
}
}

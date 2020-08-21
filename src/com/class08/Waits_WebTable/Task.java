package com.class08.Waits_WebTable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {
	static String url = "http://www.seleniumframework.com/Practiceform/";
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get(url);
    driver.manage().window().maximize();
    
    WebElement button = driver.findElement(By.id("timingAlert"));
    button.click();
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.alertIsPresent());
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
    
}
}

package com.class11.JavascriptExecutor_AdvancedXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		//to perform Scroll Up
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		//to perform Scroll Down
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -500)");
		Thread.sleep(2000);
		
		//to scroll an application to specified element
		WebElement backToTop = driver.findElement(By.xpath("//span[text() = 'Back to top']"));
		js.executeScript("arguments[0].scrollIntoView(true);", backToTop);
	}

}

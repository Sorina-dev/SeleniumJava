package com.class08.Waits_WebTable;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P {
  static String url = "https://phptravels.com/demo/";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement linkButton = driver.findElement(By.xpath("//a[@href='//www.phptravels.net']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='//www.phptravels.net']")));
		linkButton.click();
		
	//	String mainPage = driver.getWindowHandle();
		
		Set<String> allPages = driver.getWindowHandles();
		for(String childpage :allPages) {
			driver.switchTo().window(childpage);
			System.out.println(childpage);
			driver.manage().window().maximize();
		}
	
		

	}

}

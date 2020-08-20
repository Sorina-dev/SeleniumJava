package com.class07.Windows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {
  public static String url = "http://166.62.36.207/syntaxpractice/index.html";
	public static void main(String[] args) {
  

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//implicit wait	so the CE appeares after 20 sec, if there is one
		WebElement homeButton = driver.findElement(By.xpath("//a[text()='Home']"));//then clicks the button
		homeButton.click();
		
		
	}

}

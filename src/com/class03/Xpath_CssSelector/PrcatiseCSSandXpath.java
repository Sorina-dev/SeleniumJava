package com.class03.Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrcatiseCSSandXpath {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.findElement(By.cssSelector("a#btn_basic_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder^= 'Please enter']")).sendKeys("batch 7 rock!!!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick ='showInput();']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#sum1")).sendKeys("3");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='sum2']")).sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Get Total']")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}
}

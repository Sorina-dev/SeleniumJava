package com.class07.Windows_Wait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify the title is displayed
Print out the title of the main page
 */
public class HomeWork {
	
	public static String url = "https://demoqa.com/browser-windows";
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//1st child tab
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.id("tabButton")).click();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator <String> it = allWindows.iterator();
    	mainWindow = it.next();
		String child1 = it.next();
		driver.switchTo().window(child1);
    	Thread.sleep(2000);
		String child1Text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(child1Text);
		driver.close();
		
		//2nd childTab
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("windowButton")).click();
		Set<String> allWindows1 = driver.getWindowHandles();
		for(String child :allWindows1) {
			driver.switchTo().window(child);
		}
		driver.manage().window().maximize();
		String child2Text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(child2Text);
		
		//3rd child tab
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("messageWindowButton")).click();
		Thread.sleep(2000);
		Set<String> allWindows2 = driver.getWindowHandles();
		Iterator<String> it1 = allWindows2.iterator();
		child1 = it1.next();
		String child2 = it1.next();
		Thread.sleep(2000);
		String child3 = it1.next();
		driver.switchTo().window(child3);
//		Thread.sleep(4000);
//		driver.manage().window().maximize();
//		Thread.sleep(4000);
//		String child3Text = driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]")).getText();
//    	System.out.println(child3Text);
		driver.close();
    	
		//check if the logo is displayed and print it
    	driver.switchTo().window(mainWindow);
    	Thread.sleep(2000);
		WebElement logoText = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
		Thread.sleep(2000);
		String title = driver.getTitle();
	
		if(!logoText.isDisplayed()) {
			System.out.println("The title is not displayed");
		}else {
			System.out.println("The title is displayed: " + title);
		}
    	
    driver.quit();
		
		
	}
}

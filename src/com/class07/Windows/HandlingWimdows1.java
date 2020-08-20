package com.class07.Windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWimdows1 {
	public static String url = "http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		String mainPageHandle = driver.getWindowHandle();

		Thread.sleep(2000);
		WebElement instaButton = driver.findElement(By.xpath("//a[@class='btn btn-primary followeasy']"));
		Thread.sleep(2000);
		WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
		Thread.sleep(2000);
		WebElement instandFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));
		Thread.sleep(2000);
		instaButton.click();
		fbButton.click();
		instandFbButton.click(); // they are smaller windows and the focus still remains on the main window

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		Iterator<String> it = allWindowHandles.iterator();
		// have to switch to child tab as the focus is still on the main page
		while (it.hasNext()) {
			String childHandle = it.next();
			if (!childHandle.equals(mainPageHandle)) { // For skip main page
				driver.switchTo().window(childHandle);
				System.out.println(driver.getTitle()); // printed the title of 3 child windows
				driver.close(); // we closed 3 child windows, cuz we skipped the main page
			}

		}
        //after closing all child windows we cannot click a child w. 
		//instaButton.click();
		// we need to switch back to main page as the focus is not there anymore
		// although it is open
		driver.switchTo().window(mainPageHandle);
		instaButton.click();

	}
}

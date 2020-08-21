package com.class08.Waits_WebTable;






import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		//import org.openqa.selenium.support.ui.Wait;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//import org.openqa.selenium.support.ui.FluentWait;
				.withTimeout(Duration.ofSeconds(10))//import java.time.Duration;
				.pollingEvery(Duration.ofSeconds(10))//import java.time.Duration;
				.ignoring(NoSuchElementException.class);//import org.openqa.selenium.NoSuchElementException;
		
	}

}

package com.class04.RadioButton_CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//get the Logo Text if its displayed.If its is "Web Orders", then is the right logo.
public class ClearCommand {
    public static String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";
    
    public static void main(String[] args) throws InterruptedException {
		
    	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get(url);
		WebElement userNameTextBox = driver.findElement(By.id("ctl00_MainContent_username"));
		userNameTextBox.sendKeys("Tester");
		WebElement passwordTextBox = driver.findElement(By.name("ctl00$MainContent$password"));
		passwordTextBox.sendKeys("test");
		Thread.sleep(2000);
		WebElement loginButton = driver.findElement(By.className("button"));
		loginButton.click();
//		userNameTextBox.clear();
//		passwordTextBox.clear();
		
		WebElement logo = driver.findElement(By.xpath("//h1[text() = 'Web Orders']"));
		if(logo.isDisplayed()) {
			String logoText = logo.getText();
			if(logoText.equals("Web Orders")) {
				System.out.println("This is the right logo");
			} else {
				System.out.println("This is the wrong logo");
			}
		} 
		
	}
	}


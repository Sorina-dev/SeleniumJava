package com.class08.Waits_WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	public static String url = "http://syntaxtechs.com/selenium-practice/dynamic-data-loading-demo.php";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
        driver.manage().window().maximize();
		WebElement getNewUserButon = driver.findElement(By.id("save"));
		getNewUserButon.click();
		
		//juts to wait for the element to be visible
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'First Name :')]")));//expected, then ctrl+space choose the class with plurals
		
		WebElement firstName = driver.findElement(By.xpath("//p[contains(text(),'First Name :')]"));
		String firstNametext = firstName.getText();
		System.out.println(firstNametext);
		
		driver.close();
	}

}

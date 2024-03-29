package com.class08.Waits_WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDEmo2 {
	public static String url = "http://syntaxtechs.com/selenium-practice/dynamic-elements-loading.php";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
        driver.manage().window().maximize();
  
        WebElement startButton = driver.findElement(By.id("startButton"));
        startButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Welcome')]")));
		
		WebElement textElement = driver.findElement(By.xpath("//h4[contains(text(), 'Welcome')]"));
		String text = textElement.getText();
		System.out.println(text);
        
	}

}

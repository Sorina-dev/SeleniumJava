package com.class08.Waits_WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable verify the textbox is enabled
enter text and click disable
verify the textbox is disabled
 */
public class HomeWork {
  static String url = "https://the-internet.herokuapp.com/dynamic_controls";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//click on checkbox and click on remove
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();
		WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeBtn.click();
		
		//verify the text
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));
		WebElement message = driver.findElement(By.id("message"));
		String messageText = message.getText();
		boolean messageDisplayed = message.isDisplayed();
		if(!messageDisplayed) {
			System.out.println("Text message is not displayed");
		}else{
			System.out.println("The text message is displayed =>" +messageText);
		}
		
		//click on enable verify the textbox is enabled
		WebElement enableBtn = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		enableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='swapInput()']")));
		
		WebElement inputTextField = driver.findElement(By.xpath("//input[@type='text']"));
		boolean textFieldisEnabled = inputTextField.isEnabled();
		System.out.println("The textBox is enabled = "+textFieldisEnabled );
		
		//enter text and click disable
		inputTextField.sendKeys("My name is");
		WebElement disableBtn = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		disableBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='swapInput()']")));
		
     	//verify the textbox is disabled
		WebElement inputTextFieldAfter = driver.findElement(By.xpath("//input[@type='text']"));
		boolean textFieldisDisabled = inputTextField.isEnabled();
		System.out.println("The textBox is disabled = "+textFieldisDisabled );

		driver.close();
	}

}

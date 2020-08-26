package com.class10.TackingScreenshots_ActionClass;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomeWork {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	String url = "https://artoftesting.com/samplesiteforselenium";
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//get the text
	WebElement pageText =driver.findElement(By.id("idOfDiv"));
	String text = pageText.getText();
	//got to link by actions class
	
	Actions action = new Actions(driver);
	WebElement linkText = driver.findElement(By.xpath("//a[@href='https://www.google.com/']"));
	action.moveToElement(linkText).click(linkText).perform();
	
	//close the newTab
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	String mainWindow =it.next();
	String childWindow = it.next();
	driver.switchTo().window(childWindow);
	driver.close();
	driver.switchTo().window(mainWindow);
	
	//input the text in the box
	WebElement textBox = driver.findElement(By.id("fname"));
	textBox.sendKeys(text);
	
	//submit via actions class
	WebElement submitBtn = driver.findElement(By.id("idOfButton"));
	action.moveToElement(submitBtn).click(submitBtn).perform();
	 
	//double-click button
	WebElement doubleClick = driver.findElement(By.id("dblClkBtn"));
	action.moveToElement(doubleClick).doubleClick(doubleClick).perform();
	//switch to alarm
	Alert alarm = driver.switchTo().alert();
	alarm.accept();
	
	//radio Buttons 
	List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
	for(WebElement btn : radioBtns) {
		if(btn.isEnabled()) {
			String btnValue = btn.getAttribute("value");
			if(btnValue.equals("female")) {
				btn.click();
				break;
			}
		}
		
	}
	//checkBox
	List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	for(WebElement box : checkBoxes) {
		  if(box.isEnabled()) {
			  String boxValue = box.getAttribute("value");
			  if(boxValue.equals("Automation")) {
				  box.click();
				  break;
			  }
		  }
	}
	//dropdown
	WebElement dropDown = driver.findElement(By.id("testingDropdown"));
	Select select = new Select(dropDown);
	select.selectByValue("Performance");
	
    //simple alert
	WebElement simpleAlert = driver.findElement(By.xpath("//button[text() = 'Generate Alert Box']"));
	action.moveToElement(simpleAlert).click(simpleAlert).perform();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	//confirm alert
	WebElement confirmAlert = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
	action.moveToElement(confirmAlert).click(confirmAlert).perform();
    driver.switchTo().alert().accept();
	Thread.sleep(2000);
	//drag and drop
	WebElement drop = driver.findElement(By.xpath("//div[@ondrop='if (!window.__cfRLUnblockHandlers) return false; drop(event)']"));
	WebElement drag = driver.findElement(By.id("sourceImage"));
	action.dragAndDrop(drag, drop).perform();
	Thread.sleep(2000);
	driver.close();

	
	
	
}
}

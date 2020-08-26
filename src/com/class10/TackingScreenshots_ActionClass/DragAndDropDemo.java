package com.class10.TackingScreenshots_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//to frame
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		//create action object
		Actions action = new Actions(driver);	    
		action.clickAndHold(draggable).moveToElement(droppable).release().build().perform(); //when there is a chain of methods in action,build(), then perform()
		//action.dragAndDrop(draggable, droppable).perform(); // or method
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
}

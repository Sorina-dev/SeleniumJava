package com.class09.TablePagination_TableCalendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalendar3 {

	public static void main(String[] args) {
		//set up
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.spirit.com/");
        
        //click to open calendar
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("departDate")));
        driver.findElement(By.id("departDate")).click();
        
        //capture month that is currently displayed
        String xPath = "//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//span[@class='ui-datepicker-month']";
        String month = driver.findElement(By.xpath(xPath)).getText();
        System.out.println(month);
        
        //loop untill specific month is selected
        if(!month.equals("January")) {
        	do {
        		driver.findElement(By.xpath("//span[text()='Next']")).click();
        	}while(!driver.findElement(By.xpath(xPath)).getText().equals("January"));
        }
        //get all cells from table
        String xPathCells = "//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody//td";
	    List<WebElement> cells = driver.findElements(By.xpath(xPathCells));
	    //loop through each cell, get text and compare to the specific date
	    for(WebElement cell:cells) {
	    	String data = cell.getText();
	    	if(data.equals("17")) {
	    		cell.click();
	    		break;
	    	}
	    }
	}

}

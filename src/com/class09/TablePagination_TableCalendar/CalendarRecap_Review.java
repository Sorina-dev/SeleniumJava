package com.class09.TablePagination_TableCalendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.class04.RadioButton_CheckBox.CommonMethods;

public class CalendarRecap_Review extends CommonMethods {
public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		
		// sendKeys()
		// use table
		
		// 1. sendKeys
		
		
		Thread.sleep(3000);
		
		WebElement fromCal=driver.findElement(By.id("calFromDate"));
		
		fromCal.click();
		
//		fromCal.clear();
//		fromCal.sendKeys("2019-05-06");
		
		// create an object of Select class for month select
		
		WebElement months=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		
		Select mSelect=new Select(months);
		mSelect.selectByVisibleText("May");
		
		
		// create an object of Select class for year select
		
		
		WebElement years=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		Select ySelect=new Select(years);
		ySelect.selectByVisibleText("2019");
		
		// Select the table and find rows on it
		
		Thread.sleep(2000);
		
		List<WebElement> days=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement day:days) {
			if(day.getText().equals("19")) {
				day.click();
			}
		}

	}
}

package com.class05.DropDown;

import org.openqa.selenium.By;
/*
 * Go to facebook sign up page
Fill out the whole form
Click signup
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW1 {
	public static String url = "https://www.facebook.com/reg/?rs=6";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		driver.findElement(By.name("firstname")).sendKeys("Elena");
		driver.findElement(By.name("lastname")).sendKeys("Bors");
		driver.findElement(By.name("reg_email__")).sendKeys("elenaBorsa@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("elenaBorsa@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Dghje675");

		WebElement monthDD = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select selectMonth = new Select(monthDD);
		selectMonth.selectByValue("1");
		Thread.sleep(1000);

		WebElement dayDD = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select selectDay = new Select(dayDD);
		selectDay.selectByValue("20");
		Thread.sleep(1000);

		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		selectYear.selectByValue("1987");
		Thread.sleep(1000);
		
		WebElement checkBoxSex = driver.findElement(By.name("sex"));
		if(checkBoxSex.isEnabled()) {
			String checkBoxSexValue = checkBoxSex.getAttribute("value");
			checkBoxSexValue.equals("1");
			checkBoxSex.click();
		}

		driver.findElement(By.name("websubmit")).click();
		
		
		
	}
}

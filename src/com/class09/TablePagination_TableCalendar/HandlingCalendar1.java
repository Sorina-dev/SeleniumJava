package com.class09.TablePagination_TableCalendar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalendar1 {
	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		// login into HRMS
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();
		
		//Wait until Leave link becomes clickable
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Leave")));
		
		//navigate to the Leave page
		WebElement leave = driver.findElement(By.linkText("Leave"));
		leave.click();
		WebElement leaveList = driver.findElement(By.linkText("Leave List"));
		leaveList.click();
		
		//click on calendar
		WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
		fromCalendar.click();
		//select the month handling dropdown
		WebElement mDD = driver.findElement(By.className("ui-datepicker-month")); 
		Select monthDD = new Select(mDD);
		monthDD.selectByVisibleText("Oct");
		//select the year handling dropdown
		WebElement yDD = driver.findElement(By.className("ui-datepicker-year"));
		Select yearDD = new Select(yDD);
		yearDD.selectByVisibleText("2021");
		//get all cells from the table
		List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		//loop through each cell
		for(WebElement fromDate : fromDates) {
			//retrieve text of each cell and check if it matches expected values
			if(fromDate.getText().equals("15")) {
				//once found click and break
				fromDate.click();
				break;
			}
		}
   driver.quit();
	}
}

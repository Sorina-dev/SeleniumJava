package com.class09.TablePagination_TableCalendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Go to aa.com/homePage.do
select depart date
select return date 
select destination 
click on search 
quit the browser
 */
public class HomeWork {

	public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.aa.com/homePage.do?locale=en_US");
    driver.manage().window().maximize();
    
    WebElement OriginAirport = driver.findElement(By.xpath("//input[@ id = 'reservationFlightSearchForm.originAirport']"));
    OriginAirport.sendKeys("KIV");
    
    WebElement DestinationAirport = driver.findElement(By.xpath("//input[@ id='reservationFlightSearchForm.destinationAirport']"));
    DestinationAirport.sendKeys("WAS");
    
    WebElement dropdown = driver.findElement(By.xpath("//select[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
    Select select= new Select(dropdown);
   select.selectByVisibleText("2");
	 //locate the calendar and click on it
   WebElement departCalendar = driver.findElement(By.id("aa-leavingOn"));
   departCalendar.click();
   //depart month 
   WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
   String departMonth =month.getText();
   
  while(!departMonth.equals("December")) {
	   WebElement next =  driver.findElement(By.xpath("//a[@title= 'Next']"));
	  next.click();
	  month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
	  departMonth =month.getText();
  }
  //date
  List<WebElement> tableData = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
   for(WebElement date: tableData) {
	   if(date.getText().equals("13")) {
		   date.click();
		   break;
	   }
   }
   //return month
   WebElement returnCalendar = driver.findElement(By.id("aa-returningFrom"));
   returnCalendar.click();
	WebElement month2 = driver.findElement(By.className("ui-datepicker-month"));
	String returnMonth = month2.getText();
	WebElement next2 = driver.findElement(By.xpath("//a[@title='Next']"));
	while(!returnMonth.equals("January")) {
		next2.click();
		month2 = driver.findElement(By.className("ui-datepicker-month"));
		returnMonth = month2.getText();
	}//return date
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")));
	List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	for(WebElement date:dates) {
		if(date.getText().equals("1")) {}
		date.click();
		break;
	}
	WebElement submitBtn = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
	submitBtn.click();
	
	}

}

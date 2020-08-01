package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1. go to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
2. Fill out the sign up form
3. Click on register
4. close the browser
 */
public class Homework {
  public static void main(String[] args) throws InterruptedException {
	
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.navigate().to("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
	  driver.findElement(By.id("customer.firstName")).sendKeys("Sorina");
	  driver.findElement(By.name("customer.lastName")).sendKeys("Cristian");
	  driver.findElement(By.id("customer.address.street")).sendKeys("Costiujeni 14-4, ap.8");
	  driver.findElement(By.name("customer.address.city")).sendKeys("Chisinau");
	  driver.findElement(By.id("customer.address.state")).sendKeys("Chisinau");
	  driver.findElement(By.name("customer.address.zipCode")).sendKeys("2019");
	  driver.findElement(By.id("customer.phoneNumber")).sendKeys("+373-60228711");
	  driver.findElement(By.name("customer.ssn")).sendKeys("237447629");
	  driver.findElement(By.id("customer.username")).sendKeys("Sorina");
	  driver.findElement(By.id("customer.password")).sendKeys("Sorina675");
	  driver.findElement(By.name("repeatedPassword")).sendKeys("Sorina675");
	  driver.findElement(By.className("button")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.name("username")).sendKeys("Sorina");
	  driver.findElement(By.name("password")).sendKeys("Sorina675");
	  driver.findElement(By.className("button")).click();
	  Thread.sleep(2000);
	  driver.close();
	  
	  
}
}

package com.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Class {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
		//manage the page
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://18.232.148.34/humanresources/symfony/web/index.php/auth/login");
		
		//loggin
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#txtUsername")));
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		
		//go to Qualification section
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click(); //admin buton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']/b")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewPimModule']/b")));
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")));
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Qualifications")));
		driver.findElement(By.linkText("Qualifications")).click();
		
		//add license
		driver.findElement(By.id("addLicense")).click();
		WebElement licenseDD = driver.findElement(By.id("license_code"));
		licenseDD.click();
		Select select = new Select(licenseDD);
		select.selectByIndex(1);
		driver.findElement(By.cssSelector("input#license_license_no")).sendKeys("73487");
		driver.findElement(By.xpath("//input[@id='license_date']/following-sibling::img")).click();
		WebElement issuedYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		issuedYear.click();
		Select selectIssuedYear = new Select(issuedYear);
		selectIssuedYear.selectByValue("2019");
		WebElement issuedMonth = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		issuedMonth.click();
		Select selectMonth = new Select(issuedMonth);
		selectMonth.selectByVisibleText("Apr");
		
		List<WebElement> issuedDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement date : issuedDates) {
			if(date.getText().equals("10")) {
				date.click();
				break;
			}
		}
		
        driver.findElement(By.xpath("//input[@id='license_renewal_date']/following-sibling::img")).click();	
        WebElement expiryYear = driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        expiryYear.click();
        
        
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

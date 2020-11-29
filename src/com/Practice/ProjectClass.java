package com.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectClass {

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
		WebElement loginBtn= driver.findElement(By.id("btnLogin"));
		loginBtn.click();
		
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		driver.findElement(By.cssSelector("a#menu_admin_Qualifications")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewLicenses']")).click();
		driver.findElement(By.cssSelector("input#btnAdd")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#license_name")));
	    driver.findElement(By.cssSelector("input#license_name")).sendKeys("MIT license");
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
		List<WebElement> rowsRecordListTable = driver.findElements(By.xpath("//table[@id='recordsListTable']/tbody/tr"));
		for(int i = 1; i < rowsRecordListTable.size(); i++) {
			String rowText = rowsRecordListTable.get(i).getText();
			if(rowText.contains("MIT license")) {
				System.out.println("License is added succesufully");
				break;
			}

		}
		
	}
	
}

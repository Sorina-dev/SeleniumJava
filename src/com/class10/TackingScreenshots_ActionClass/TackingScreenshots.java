
package com.class10.TackingScreenshots_ActionClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TackingScreenshots {
	public static String url = "http://18.232.148.34/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		//Step 1. Convert web driver object to TakeScreenshot interface
		// a class //downcasting //interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		//Step 2. Call getScreenshotAs method to create image file
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // the screenshot is taken
		
		//Step 3. Move image file to new destination
		 File DestFile=new File("screenshots\\HRMS\\adminLogin.png");

		//Step 4. Copy file at destination  
		try {
			FileUtils.copyFile(sourceFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.quit();
		
		// in order to check if its there, refresh, restart.., then try to create a new
		// folder with the name
		// you used to create in your program and eclipse will inform you that it is
		// this folder already created
		// refresh again and check

	}

}

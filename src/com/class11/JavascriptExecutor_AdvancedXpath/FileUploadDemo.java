package com.class11.JavascriptExecutor_AdvancedXpath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
		fileUpload.click();
		WebElement chooseFile = driver.findElement(By.id("file-upload"));

		// enter the file path onto the file-selection input field
		chooseFile.sendKeys("C:\\Users\\crist\\eclipse-workspace\\SeleniumJavaBatch7\\excelfiles\\SampleTestData.xlsx");
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();

		// to upload file using Robot class
		Robot robot = new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(200);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// to download file using Robot class
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyRelease(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);

	}
}

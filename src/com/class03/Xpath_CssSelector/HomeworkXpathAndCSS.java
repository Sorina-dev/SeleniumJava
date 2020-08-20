package com.class03.Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Go to http://166.62.36.207/syntaxpractice/index.html
Click on start practicing button
Click on proceed next button
Click on “Input form validations”
Fill out the form and click on send -- skip - dropdown for state and radio button
 */
public class HomeworkXpathAndCSS {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a#btn_inter_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Input Form with Validations']")).click(); //
		driver.findElement(By.cssSelector("input[name = 'first_name']")).sendKeys("Sorina");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Cristian");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[data-bv-field='email']")).sendKeys("cristiansorina@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='(845)555-1212']")).sendKeys("867-456-6578");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("Costiujeni 14-4");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"city\"]")).sendKeys("Chisinau");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder=\"Zip Code\"]")).sendKeys("2019");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Website')]")).sendKeys("www.beauty.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea[name=\"comment\"]")).sendKeys("Nice to meet you!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick=\"resetForm();\"]")).click();

	}
}

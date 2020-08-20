package com.class06.Alerts_Frames;
import org.openqa.selenium.By;
/*
 * verify the logo is displayed on the first frame
verify the button is enabled on the second frame
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {
	public static String url = "http://www.uitestpractice.com/Students/Switchto";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//switch to frame by index
		driver.switchTo().frame(0);
		//find element from frame
		WebElement textBox = driver.findElement(By.id("name"));
		//input text into frame
		textBox.sendKeys("Batch 7");
        // get out from frame
		driver.switchTo().defaultContent();
		
		
		WebElement clickOnLinkText = driver.findElement(By.xpath("//h3[text() = 'click on the below link: ']"));
		String text = clickOnLinkText.getText();
		System.out.println(text);
		//switch on frame by name
		driver.switchTo().frame("iframe_a");
		//clear the input text
		textBox.clear();
		//input another text
		textBox.sendKeys("Syntax");
		// get out from frame
		driver.switchTo().defaultContent();
		
		
		//switch on frame by name
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
		driver.switchTo().frame(iframe);
		textBox.clear();
		textBox.sendKeys("Wassup");
	}
}

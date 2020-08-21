package com.class07.Windows_Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static String url = "http://www.uitestpractice.com/Students/Contact";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//to wait otherwise it wont find the elements //always should be after we navigate or get the url
		WebElement link = driver.findElement(By.xpath("//a[text()='This is a Ajax link']"));
		link.click(); //selenium cannot see the link as it is intersepted need to maximize the window
		WebElement paragraph = driver.findElement(By.className("ContactUs"));
		String text = paragraph.getText();
		System.out.println(text); //CE: Element click Intercepted Exception, so need to put some wait
		
		driver.close();
	}

}

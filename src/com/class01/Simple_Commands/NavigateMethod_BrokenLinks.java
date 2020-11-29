package com.class01.Simple_Commands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod_BrokenLinks {
	public static void main(String[] args) throws InterruptedException, IOException {//thread sleep imported
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	       
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:www.amazon.com");
		driver.navigate().to("http://facebook.com");//one object for one tab (page on internet)
		driver.navigate().back();
		driver.navigate().forward();
		driver.manage().window().maximize(); // for windows to get the full screen
		driver.close(); //to close one tab only
		//driver.quit(); // to close the browser
		//driver.navigate().refresh(); // to refresh the page
		//Thread.sleep(2000); //its 2 sec its pausing for 2 sec after some action
		
		
		//Collect all the links from the webpage. All the links are associated with the Tag ‘a‘.
		//Create a list of type WebElement to store all the Link elements in it.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 for (int i=0; i<links.size(); i++) {
		 String linkURL = links.get(i).getAttribute("href");
		 if (linkURL!= null) {
			 URL obj = new URL(linkURL);
			// Now Create a Connection using URL object( i.e ., link)
			 //Connect using the Connect Method.
			 HttpURLConnection conn = ((HttpURLConnection)
					 obj.openConnection());
			 //Use getResponseCode () to get response code. eg 200
			 int rCode = conn.getResponseCode();
			 if (rCode == 200) {
			 System.out.println(i+ " Link is valid------" + linkURL);
			 } else {
			System.out.println(i+ " Link is broken------" + linkURL);
			 }
			 }else {
			System.out.println(links.get(i).getText());
			System.out.println(i+ " Link is broken ********" + linkURL);
		 }
	}
	}
}

package com.class04.RadioButton_CheckBox;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksFromEbay {
public static String url = "http://ebay.com";
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		List<WebElement> allLinks = driver.findElements(By.tagName("a")); //for links "a" name of tag
		System.out.println(allLinks.size());
		for (WebElement link : allLinks) {
			String linkText = link.getText();
			String fullLink = link.getAttribute("href"); //"href" -- name of tag
			if(!linkText.isEmpty()) {
				System.out.println(linkText + "      " + fullLink);
			}
			
		}
		//------------- BROKEN LINKS ------------------------
		
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

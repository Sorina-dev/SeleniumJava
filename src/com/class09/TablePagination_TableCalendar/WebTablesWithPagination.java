package com.class09.TablePagination_TableCalendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesWithPagination {
	public static String url = "http://syntaxtechs.com/selenium-practice/table-pagination-demo.php";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
        driver.manage().window().maximize();
        
        //get the whole rows text and print it one
        List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
        WebElement next = driver.findElement(By.xpath("//a[@class='next_link']"));
        boolean flag = true;
        
        while(flag) {// created it only to break it after and if it doesnt find the if condition it will go out of the loop and click next
        	for(WebElement row:rows) {
        		String rowText = row.getText();
        		if(rowText.contains("Archy J")) {
        			flag = false; // need to break the while loop too, it should be placed before break
        			System.out.println(rowText);
        			break;  //break the for each loop
        			
        		}
        	}
        	next.click();//after we get all rows and print the necessary one, in the while loop
        }
        
        driver.quit();

	}

}

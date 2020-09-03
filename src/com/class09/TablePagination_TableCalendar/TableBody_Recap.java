package com.class09.TablePagination_TableCalendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.class04.RadioButton_CheckBox.CommonMethods;

public class TableBody_Recap extends CommonMethods  {
	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// 1. login OrangeHRM

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// 2. Navigate to Employee List Page

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		// 3. Delete employee with id=1255
		
		// save all information under Id column inside a List<WebElement>
		
		List<WebElement> ids=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")); //table/tbody/tr/td  the cell 2/the link a 
		
		Thread.sleep(2000);
		
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]/input"));

		System.out.println(checkBoxes.size());
		
//		for(int i=1; i<=ids.size(); i++) {
//			String id=ids.get(i).getText();
//			System.out.println(id);
//			if(id.equals("0009")) {
//				checkBoxes.get(i-1).click();
//				Thread.sleep(1000);
//				driver.findElement(By.id("btnDelete")).click();
//				Thread.sleep(1000);
//				driver.findElement(By.id("dialogDeleteBtn")).click();
//				break;
//			}
//		}
		
		
		// How many Full Time Permanent employee do we have?
		
		List<WebElement> cells=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		int count=0;
		
		for(WebElement cell:cells) {
			
			System.out.println(cell.getText());
			if(cell.getText().equals("Full-Time Permanent")) {
				count+=1;
			}
		}
		
		System.out.println("Number of Full-Time Permanent Employees is : "+ count);
		
		Thread.sleep(3000);
		
		driver.quit();

	}
}

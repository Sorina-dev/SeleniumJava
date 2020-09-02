package com.class05.DropDown;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.class04.RadioButton_CheckBox.CommonMethods;

public class DropDown_MultipleSelections_recap extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		// dropdown --> a menu with more than one options and in which we can choose only one option
		
		// multiple selection --> similar to dropdown except we can perform multiple selections
		
		// how to handle drowdowns
		// 1. Select class --> if the tagNama is select 
		// 2. findElements()
		
		// Scenarion : validate how many departments on ebay
		// 1. Print out number of available departments
		// 2. Print out all department names
		// 3. select "Consumer Electronics"
		
		// 1. step open chrome browser and navigate to "https://www.ebay.com/"
		
		setUp("chrome", "https://www.ebay.com/");
		
		// 2. step --> We need find locator of dropdow --> select tag
		
		WebElement departments=driver.findElement(By.id("gh-cat"));
		
		// 3. Create an object Select class
		
		Select depSelect=new Select(departments);
		
		// 4. getOptions() --> returns all available options inside a List<WebElements>
		
		List<WebElement> options=depSelect.getOptions();
		
		// how can we find the number of elements inside a list
		
		int numOfOptions=options.size();
		System.out.println("Number of Departments : "+numOfOptions);
		
		// 5. Print out all department names
		
		Iterator<WebElement> dIt=options.iterator();
		
		while(dIt.hasNext()) {
			WebElement option=dIt.next();
			System.out.println(option.getText());
		}
		
		// select "Consumer Electronics" department
		
		// 1. depSelect.selectByIndex(index);
		// 2. depSelect.selectByValue(value);
		// 3. depSelect.selectByVisibleText(text);
		
		Thread.sleep(2000);
		
//		depSelect.selectByIndex(1);
//		depSelect.selectByValue("293"); // value of the value attribute
//		depSelect.selectByVisibleText("Business & Industrial");
		
		
		// 2. Way --> findElements
		
		List<WebElement> deptList=driver.findElements(By.xpath("//div[@id='gh-cat-box']/select/option"));
		
//		for(WebElement dept:deptList) {
//			dept.click();
//			if(dept.isSelected()) {
//				System.out.println("Department selection test PASS");
//			}else {
//				System.out.println("Department selection test FAIL");
//			}
//			Thread.sleep(500);
//		}
		
		// How to select a specific department -egg. "Cell Phones & Accessories"
		
		for(WebElement dept:deptList) {
			if(dept.getText().equals("Cell Phones & Accessories")) {
				dept.click();
				if(dept.isSelected()) {
					System.out.println(dept.getText()+ " department is selected");
				}else {
					System.out.println("Test fail");
				}
				break;
			}
		}
		
		// we have deselect methods which Select class provide
		// deselect methods works with dropdowns??
		
		// isMultiple()  --> Returns us a boolean whether we can choose more than one option
		
		// deselectAll()
		// deselectByIndex(int index);
		// deselectByValue(String value);
		// deselectByVisibleText(String text);
		
		
		
		
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}

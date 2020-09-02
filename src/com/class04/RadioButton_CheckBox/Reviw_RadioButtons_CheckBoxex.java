package com.class04.RadioButton_CheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Reviw_RadioButtons_CheckBoxex extends CommonMethods{
public static void main(String[] args) throws InterruptedException {
		
		/* 1. Radio buttons and check boxes
		 * 2. Dropdowns and multiple selections
		 * 3. Handling Alert in Selenim
		 * 4. Handling frames and windows in selenim
		 * 5. Wait in Selenium (Synchronization in Selenium)
		 */
		
		/* it is a button or buttons in which we can select only one option
		 * check box --> a wen element that we can perform multiple selections
		 */
		
		setUp("chrome", SyntaxPrctice_URL);
		
		// Navigate to radio button practice page
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		// 1. Find the locator of requested button and click on it
		// 2. use findElements() to save all options as List WebElements and 
		// select requested option by iterating list
		
		// Find the locator of requested button and click on it
		
		WebElement femaleBtn=driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
		
//		System.out.println("Is female button selected : "+femaleBtn.isSelected());
		
		Thread.sleep(2000);
		
//		femaleBtn.click();
		
		WebElement checkBtn=driver.findElement(By.id("buttoncheck"));
//		checkBtn.click();
		
		WebElement msg=driver.findElement(By.cssSelector("p.radiobutton"));
		
		String msgText=msg.getText();
		
//		if(msgText.contains("Female")) {
//			System.out.println("Female button selection test PASS");
//		}else {
//			System.out.println("Female button selection test FAIL");
//		}
		
		
		/* //p[@class='radiobutton']
		p[class='radiobutton']
		p.radiobutton    */
		
		// 2nd way --> use findElements and save WebElements of all options into a List
		
		List<WebElement> genderBtns=driver.findElements(By.xpath("//input[@name='optradio']"));
		
		for(WebElement btn:genderBtns) {
			btn.click();
			checkBtn.click();
			msgText=msg.getText();
			String buttonText=btn.getAttribute("value");
			
			if(msgText.contains(buttonText)) {
				System.out.println(buttonText+ " selection test PASS");
			}else {
				System.out.println(buttonText+ " selection test FAIL");
			}
			Thread.sleep(1000);
		}
		
		
		Thread.sleep(3000);
		driver.quit();
		
		//
	}
}

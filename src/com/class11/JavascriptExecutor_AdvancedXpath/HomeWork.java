package com.class11.JavascriptExecutor_AdvancedXpath;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		// get the table and delete the last row
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		for (WebElement row : rows) {
			String rowText = row.getText();
			// System.out.println(rowText);
			if (rowText.contains("Donlad")) {
			//	WebDriverWait wait = new WebDriverWait (driver,20);
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[6]/td[4]")));
				WebElement col = driver.findElement(By.xpath("//tbody/tr[6]/td[4]"));
				String deleteText = col.getText();
				System.out.println(deleteText);
				if (deleteText.contains("DELETE")) {
					col.click();
					
				}
				break;
			}
		}

		//AjaxCall
		WebElement ajaxCall = driver.findElement(By.linkText("AjaxCall"));
		ajaxCall.click();
		WebElement link = driver.findElement(By.linkText("This is a Ajax link"));
		link.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ContactUs']/child::p")));
		WebElement textBox = driver.findElement(By.xpath("//div[@class='ContactUs']/child::p"));
		String text = textBox.getText();
		System.out.println(text);
		System.out.println("*****************************************");
		
		//Form    
		WebElement formBtn = driver.findElement(By.linkText("Form"));
		formBtn.click();
		driver.findElement(By.id("firstname")).sendKeys("Maria");
		driver.findElement(By.id("lastname")).sendKeys("Smith");
		List<WebElement> radioBtns = driver.findElements(By.xpath("//label[@class=\"radio-inline\"]"));
		for(WebElement radioBtn : radioBtns) {
			if(radioBtn.isEnabled()) {
				String btn = radioBtn.getText();
				if(btn.contains("Married")) {
					radioBtn.click();
					break;
					}
				
			}
		}
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i = 0; i<=checkboxes.size(); i++) {
			if(checkboxes.get(i).isEnabled()) {
				String value = checkboxes.get(i).getAttribute("value");
				if(value.equals("dance")) {
				   driver.findElement(By.xpath("//input[@type='checkbox']")).click();
					break;
				}
			}
		}
		
		WebElement countryDD = driver.findElement(By.id("sel1"));
		Select select = new Select(countryDD);
		select.selectByVisibleText("Canada");
		
		driver.findElement(By.id("datepicker")).click();
		WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
		Select select1 = new Select(monthDD);
		select1.selectByValue("4");
		
		WebElement yearDD = driver.findElement(By.className("ui-datepicker-year"));
		Select select2 = new Select(yearDD);
		select2.selectByValue("1974");
		
		List <WebElement> calendarDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement date:calendarDates) {
			String dateText =date.getText();
			if(dateText.equals("15")) {
				date.click();
				break;
			}
		}
		
		driver.findElement(By.id("phonenumber")).sendKeys("8972345678");
		driver.findElement(By.id("username")).sendKeys("MariaSTH");
		driver.findElement(By.id("email")).sendKeys("mariasmith@gmail.com");
		driver.findElement(By.id("comment")).sendKeys("I am a student");
		driver.findElement(By.id("pwd")).sendKeys("Maria@577");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Control
		//drag & drop
		driver.findElement(By.linkText("Controls")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		//alert
//		WebElement dbClickBtn = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
//		action.doubleClick(dbClickBtn);
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		String alertText = alert.getText();
//		System.out.println("Alert text ="+ alertText);
//		alert.accept();
//		
		//iframe
		driver.switchTo().frame("iframe_a");
		driver.findElement(By.id("name")).sendKeys("Maria/Smith");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@target='iframe_a']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click')]")).click();
		String mainTab = driver.getWindowHandle();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allTabs = driver.getWindowHandles();
		for(String tab:allTabs) {
			if(!tab.equals(mainTab)) {
				driver.switchTo().window(tab);
				String newTabTitle = driver.getTitle();
				System.out.println("New windw title = "+ newTabTitle);
				driver.close();
				driver.switchTo().window(mainTab);
			}
		}
		
		//Widgets
		//upload file
		driver.findElement(By.xpath("//a[text()='Widgets']")).click();		
		driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\crist\\eclipse-workspace\\SeleniumJavaBatch7\\excelfiles\\SampleTestData.xlsx");
		driver.findElement(By.xpath("//input[@value='Upload']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ContactUs']/child::p")));
		String uploadText = driver.findElement(By.xpath("//div[@class='ContactUs']/child::p")).getText();
		System.out.println("Upload text = " +uploadText);
		
		//Actions
		driver.findElement(By.linkText("Actions")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='click']")));
		WebElement clickBtn = driver.findElement(By.cssSelector("button[name='click']"));
		wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
		action.click(clickBtn).perform();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alerText = alert.getText();
		System.out.println("Alert one-click  message = "+ alerText);
		alert.accept();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Click Me !']/following-sibling::button")));
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Click Me !']/following-sibling::button"));
		action.doubleClick(doubleClickBtn).perform();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		String alertText = alert1.getText();
		System.out.println("Alert double-click message = "+ alertText);
		alert.accept();
		
		//drag & drop
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("draggable")));
		WebElement drag = driver.findElement(By.id("draggable"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("droppable")));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("div2")));
		WebElement dropColoredSquare = driver.findElement(By.id("div2"));
		action.dragAndDrop(drag, dropColoredSquare).perform();
		
		//click and hold
		List<WebElement> tNumbers = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		
		for(WebElement number: tNumbers) {
			action.clickAndHold(tNumbers.get(0)).perform();
			action.clickAndHold(tNumbers.get(11)).release().build().perform();
		}
		
		//Switch To
		driver.findElement(By.linkText("Switch to")).click();
		//simple alert
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert")));
		WebElement simpleAlert = driver.findElement(By.id("alert"));
		action.click(simpleAlert).perform();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertSimple = driver.switchTo().alert();
		String alertSText = alertSimple.getText();
		System.out.println("Simple alert mesage = " + alertSText);
		alertSimple.accept();
		//confirm alert
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm")));
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		action.click(confirmAlert).perform();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertConf = driver.switchTo().alert();
		String confirmAlertText = alertSimple.getText();
		System.out.println("Confirm alert mesage = " + confirmAlertText);
		alertConf.dismiss();
		//prompt alert
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt")));
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		action.click(promptAlert).perform();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertPrompt = driver.switchTo().alert();
		alertPrompt.sendKeys("Maria Smith");
		alertConf.accept();
		
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		WebElement launchModal = driver.findElement(By.xpath("//button[@id='basicAuthentication']/preceding-sibling::button[1]"));
		launchModal.click();
		driver.findElement(By.cssSelector("div[class='modal-body']")).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Ok']")));
		WebElement ok = driver.findElement(By.xpath("//button[text()='Ok']"));
		ok.click();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.switchTo().frame("iframe_a");
		WebElement nameInput = driver.findElement(By.id("name"));
		nameInput.sendKeys("Maria");
		driver.switchTo().defaultContent();
		
		//Select page
		WebElement selectPage = driver.findElement(By.linkText("Select"));
		selectPage.click();
		
		WebElement DD = driver.findElement(By.id("countriesSingle"));
		Select dd = new Select(DD);
		dd.selectByVisibleText("England");
		
		WebElement multipleSelect =driver.findElement(By.id("countriesMultiple"));
		Select multi = new Select(multipleSelect);
		
		List<WebElement> options = multi.getOptions();
		for(WebElement option : options) {
			String textOption = option.getText();
			multi.selectByVisibleText(textOption);
			Thread.sleep(1000);
			}
	//Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots\\HRMS\\HomeWork.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	

}

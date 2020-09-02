package com.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Pages.DashboardPage;
import com.Pages.LoginPageWithFindBy;
import com.Utils.BaseClass;

public class LoginTestWithFindBy {

	public static void main(String[] args) {
		BaseClass.setUp();
		LoginPageWithFindBy login = new LoginPageWithFindBy(); //create object of the class of elements in order to call them
		DashboardPage dashboard = new DashboardPage();
		
		login.userNametextBox.sendKeys("Admin");
		login.passworduserTextBox.sendKeys("Hum@nhrm123");
		login.loginBtn.click();
		                                                        //take screenshot
		TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshots\\HRMS\\dashboard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String adminText = dashboard.welcomeAdmin.getText();
		System.out.println(adminText);
		
		BaseClass.tearDown();
		
	}

}

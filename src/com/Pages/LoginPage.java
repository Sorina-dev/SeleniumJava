package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Utils.BaseClass;
/*
 * we only locate the webElements
 */
public class LoginPage extends BaseClass{ //extend the BaseClass for driver object

	public WebElement username = driver.findElement(By.id("txtUsername"));
	public WebElement password = driver.findElement(By.id("txtPassword"));
	public WebElement loginButton = driver.findElement(By.id("btnLogin"));
	
}

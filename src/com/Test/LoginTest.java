package com.Test;

import com.Pages.LoginPage;
import com.Utils.BaseClass;

public class LoginTest {
public static void main(String[] args) {
	//call the static method from BaseClass
	BaseClass.setUp(); //navigate to the page
	
	//have to create an object of the loginPage in order to have access to the webelements as they are not static
	LoginPage loginPage = new LoginPage(); 
	
	loginPage.username.sendKeys("Admin");
	loginPage.password.sendKeys("Hum@nhrm123");
	loginPage.loginButton.click();
	
	//call the static method from BaseClass
	BaseClass.tearDown(); //quilt the browser
}
}

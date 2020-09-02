package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.BaseClass;

public class LoginPageWithFindBy extends BaseClass{ //@withFindBy annotation
//this way is preffered for locating the Web elements 
	//we just identify the webelement
	@FindBy(id = "txtusername")          //import it from Selenium library
	public WebElement userNametextBox;       // cuz we wont use driver.findelement() this is basic and simple
	
	//@FindBy(id = "txtusername") public WebElement userNametextBox;         // or can be put like this
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement  passworduserTextBox;
	
	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;
	
//	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")           //this is for List of WebElement like Table
//	public List<WebElement> table;
	
	//now we initialize the webelements by constructor
	public LoginPageWithFindBy() {   //PageFactory is from Selenium; initElements-method
		PageFactory.initElements(driver, this); //the last choose with driver, page -> this-- access to variables from the same class
	}
	
	
	
}

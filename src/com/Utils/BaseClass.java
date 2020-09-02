package com.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
public static WebDriver driver; // variables and methods should be static and public to be accessed just by classname and( variable or mehtod)
 /*
  * if we want to descrive a method we should use it before the method, its called a javadoc
  */


       /*
        * this method navigates to hrms website
        * @return <-- driver
        * @author Syntax
        */
    public static WebDriver setUp() {
	
    	
    	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe"); //if it doesn't work we can check with user.dir...
    	driver = new ChromeDriver(); //launch the Browser it opens empty page
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //to wait globally
    	driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
    	 
    	return driver;  //return object of the driver 	
}

    /*
     * this method quits the browser
     */
    public static void tearDown() {
    	if(driver != null) {//if you get a nullpointer exception, the driver is not initialized
    	driver.quit();       //only when the driver is initialized only then driver will quit, not if not initialized
    	}
    }
    
    
    
    
}

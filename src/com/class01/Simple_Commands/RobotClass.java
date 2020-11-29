package com.class01.Simple_Commands;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class RobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {

		// System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("https:www.amazon.com");// got to the browser
		String url = driver.getCurrentUrl(); // validate if you landed on correct url
		System.out.println(url);
		String title = driver.getTitle();// validate if your page title is correct
		System.out.println(title);
		// System.out.println(driver.getPageSource()); // to get the page source we also
		// can

		
		
		// --------- ROBOT CLASS -------------------------
		Robot robot = new Robot(); // Robot class throws AWT Exception
		Thread.sleep(2000); // Thread.sleep throws InterruptedException
		robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard to navigate and select Save radio button

		Thread.sleep(2000); // sleep has only been used to showcase each event separately
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		// press enter key of keyboard to perform above selected action

		robot.keyPress(KeyEvent.VK_DOWN); // This method with press down arrow key of Keyboard
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK); // This method will press the right click of your mouse.
		robot.mouseMove(630, 420); // This will move mouse pointer to the specified X and Y
									// coordinates. robot.mouseMove(point.getX(), point.getY());

		robot.keyRelease(KeyEvent.VK_DOWN); // This method with release down arrow key of Keyboard
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK); // This method will release the right click of your mouse
		robot.delay(1500); // delay is to make code wait for mentioned milliseconds before executing next
							// step

	}

}

package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC3 extends CommonMethods {
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 3: Verify element is enabled Open chrome browser Go to
		 * “https://the-internet.herokuapp.com/” Click on “Click on the “Dynamic
		 * Controls” link Click on enable button Enter “Hello” and verify text is
		 * entered successfully Close the browser
		 */
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[@onclick=\"swapInput()\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		WebElement inputBar = driver.findElement(By.cssSelector("input[type='text']"));
		inputBar.sendKeys("Hello");
		String msg = inputBar.getAttribute("value");
		if (inputBar.isEnabled()) {
			System.out.println("TC passed. Text entered = " + msg);
		} else {
			System.out.println("TC failed");
		}
		Thread.sleep(3000);
		driver.quit();
	} 

}

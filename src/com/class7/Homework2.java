package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Homework2  extends CommonMethods{
	
	
	/*
	 * Open chrome browser
		Go to “https://the-internet.herokuapp.com/”
		Click on “Click on the “Dynamic Controls” link
		Click on enable button
		Enter “Hello” and verify text is entered successfully
		Close the browser
	 */

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		boolean enabled=driver.findElement(By.cssSelector("input[type='text']")).isEnabled();
		
		if(enabled) {
			System.out.println("It is enabled!");
		}else {
			System.out.println("It is disabled!");
		}
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));
		
		WebElement woohoo=driver.findElement(By.xpath("//input[@type='text']"));
		woohoo.sendKeys("WooHoo!");
		boolean woo=woohoo.isDisplayed();
		if(woo) {
			System.out.println("testCase passed");
		}else {
			System.out.println("testCase failed");
		}
		driver.close();
		
	}

}

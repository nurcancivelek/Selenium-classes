package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TestCase1  extends CommonMethods{
	/*
	 * TC 1: Verify element is present

Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Loading” link
Click on “Example 1...” and click on “Start”
Verify element with text “Hello World!” is displayed
Close the browser

Collapse

	 */
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 1:")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		boolean hello=driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		if(hello) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		Thread.sleep(2000);
		driver.close();
		
		
		
	}

}

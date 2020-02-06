package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;


public class TestCase1 extends CommonMethods {
	
	/*
	 * TC 1: JavaScript alert text verification
	 * 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Alerts & Modals” links
	 * 4.Click on “Javascript Alerts” links
	 * 5.Click on button in “Java Script Alert Box” section
	 * 6.Verify alert box with text “I am an alert box!” is present
	 * 7.Click on button in “Java Script Confirm Box” section
	 * 8.Verify alert box with text “Press a button!” is present
	 * 9.Click on button in “Java Script Alert Box” section
	 * 10.Enter text in the alert box11.Quit browser
	 */
	public static final String Syntax_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("Chrome", Syntax_URL);
		//driver.manage().window().fullscreen();
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("Alert text:   "+alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert2=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
		
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Alert alert3=driver.switchTo().alert();
		Thread.sleep(2000);
		alert3.sendKeys("nurcan");

		System.out.println("Alert text:   "+alert3.getText());
		Thread.sleep(2000);
		alert.accept();
//		
		boolean isDisplayed=driver.findElement(By.id("prompt-demo")).isDisplayed();
		System.out.println(isDisplayed);
		driver.close();
		
		//driver.close();
		
	}

}

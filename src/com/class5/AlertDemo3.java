package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.class4.CommonMethods2;

//import com.utils.CommonMethods;

public class AlertDemo3 extends CommonMethods2{

	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		//The method is opening syntax Practice website using chrome browser
		CommonMethods2.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		Thread.sleep(2000);
		//find the element Alerts and Modals and clicking on it
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		
		//finding Javascript Alerts and clicking on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		//finding the second alert button and click on it
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(2000);
		
		//handle the alert.
		Alert alert=driver.switchTo().alert();
		
		//Send some text to alert box
		alert.sendKeys("Weqas");
		
		alert.accept();
		boolean isDisplayed=driver.findElement(By.id("prompt-demo")).isDisplayed();
		System.out.println(isDisplayed);
		driver.close();
	}
}

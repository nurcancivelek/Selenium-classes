package com.class4;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
public class Homework1 extends CommonMethods{

	/*
	 * TC 1: Syntax Demo input boxes count: 
	 * 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Input Forms” links
	 * 4.Click on “Simple Form Demo” links
	 * 5.Get all input boxes from the page
	 * 6.Enter “Hello” to each text box
	 * 7.Close browser
	 */
	
	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.cssSelector("input#user-message")).sendKeys("Hello");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default' and text()='Show Message']")).click();
		
		driver.findElement(By.id("sum1")).sendKeys("1");
		driver.findElement(By.id("sum2")).sendKeys("2");
		driver.findElement(By.xpath("//button[@class='btn btn-default' and text()='Get Total']")).click();
		driver.close();
		

	}

}

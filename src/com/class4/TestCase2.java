package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase2 extends CommonMethods2 {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * TC 2: Radio Buttons Practice  
		Open chrome browser
		Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
		Click on “Input Forms” links
		Click on “Radio Buttons Demo” links
		Click on any radio button in “Radio Button Demo” section.
		Verify correct checkbox is clicked
		Click on any radio button in “Group Radio Buttons Demo” section.
		Verify correct checkbox is clicked
		Quit browser

		 */

		CommonMethods2.setUp("chrome", Constants.Syntax_URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Input Forms']/following::a[3]")).click();
		Thread.sleep(3000);
		WebElement femaleRB=driver.findElement(By.xpath("//input[@name=optradio]"));
		femaleRB.click();
		System.out.println(femaleRB.isSelected());
		
		
		
	}

}

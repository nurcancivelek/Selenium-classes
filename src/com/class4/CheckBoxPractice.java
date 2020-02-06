package com.class4;



import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxPractice extends CommonMethods2 {
	
	/*
	 * TC 1: Checkbox Practice 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Input Forms” links
	 * 4.Click on “Checkbox Demo” links
	 * 5.Click on checkbox inside a single demo section
	 * 6.Verify checkbox has been clicked successfully
	 * 7.Click on all checkboxes 1 by 1 in Multiple Checkbox Demo section.
	 * 8.Quit browser
	 */
	
	public static final String Syntax_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods2.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		WebElement singleCheckbox=driver.findElement(By.cssSelector("input#isAgeSelected"));
		
		if(!singleCheckbox.isSelected());
		singleCheckbox.click();
		Thread.sleep(1000);
		
		List<WebElement>multiCheckbox=driver.findElements(By.xpath("//input[@class='cb1-element']"));
		
		Iterator<WebElement> it=multiCheckbox.iterator();
		while(it.hasNext()) {
			it.next().click();
			Thread.sleep(1000);
		}
		driver.close();
	}

}

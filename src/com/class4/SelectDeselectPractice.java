package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class SelectDeselectPractice extends CommonMethods{
	/*
	 * TC 2: Select and Deselect values
	 * 5.Open chrome browser
	 * 6.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 7.Click on “Input Forms” links
	 * 8.Click on “Select Dropdown List” links
	 * 9.Select value from “Select List Demo” section
	 * 10.Verify value has been selected
	 * 11.Select 4 options from “Multi Select List Demo”
	 * 12.Deselect 1 of the option from the dd
	 * 13.Quit browser
	 */
	public static final String Syntax_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) {
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Select Dropdown List")).click();
		WebElement dropdown= driver.findElement(By.id("select-demo"));
		
		Select select=new Select(dropdown);
		select.selectByIndex(4);
		System.out.println(dropdown.isSelected());
		
		WebElement multi= driver.findElement(By.id("multi-select"));
		
		Select select2=new Select(multi);
		select2.selectByIndex(1);
		select2.selectByValue("California");
		select2.selectByVisibleText("New York");
		select2.selectByVisibleText("New Jersey");
		select2.deselectByVisibleText("New York");

		
		
	}



}

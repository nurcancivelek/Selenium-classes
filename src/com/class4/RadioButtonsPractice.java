package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsPractice {
	
	/*
	 * TC 2: Radio Buttons Practice 
	 * 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Input Forms” links
	 * 4.Click on “Radio Buttons Demo” links
	 * 5.Click on any radio button in “Radio Button Demo” section.
	 * 6.Verify correct radio is clicked
	 * 7.Click on any radio button in “Group Radio Buttons Demo” section.
	 * 8.Verify correct checkbox is clicked
	 * 9.Quit browser
	 */

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		WebElement female=driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']"));
		System.out.println(female.isSelected());
		female.click();
		System.out.println(female.isSelected());
		
		WebElement groupf=driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
		System.out.println(groupf.isSelected());
		groupf.click();
		System.out.println(groupf.isSelected());
		
		driver.findElement(By.xpath("//input[@value='5 - 15']")).click();

	}

}

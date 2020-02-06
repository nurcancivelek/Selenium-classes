package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * HRMS Application Login: 
			Open chrome browser
			Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
			Enter valid username and password
			Click on login button
			Then verify Syntax Logo is displayed.

		 */
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		WebElement userName=driver.findElement(By.xpath("//input[@name='txtUsername']"));
		userName.sendKeys("VanEarl");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("VanEarl@&12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//for logo:
		//http://166.62.36.207/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155
		
		WebElement logo=driver.findElement(By.xpath("//img[contains(@src, '5acde3dbd3adc6.90334155')]"));
		System.out.println(logo.isDisplayed());

	}

		

	}



package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("nur");
		driver.findElement(By.name("lastName")).sendKeys("can");
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.findElement(By.name("userName")).sendKeys("123@gmail.com");
		driver.findElement(By.name("email")).sendKeys("123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456789");
		driver.findElement(By.name("register")).click();
		
		

		
		
		

	}

}

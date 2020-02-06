package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		//driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']")).click();
		
	}

}

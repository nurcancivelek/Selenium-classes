package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asels2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ebay.com");
		
		String expectedTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			driver.findElement(By.linkText("My eBay")).click();
			Thread.sleep(3000);
			driver.findElement(By.partialLinkText("Create an")).click();
			
		}else {
			System.out.println("Titles are not matching");
		}
		
	}

}

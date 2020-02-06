package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		//driver.get("https/www.google.com");
		driver.get("https:/www.amazon.com");
		String actualTitle=driver.getTitle();
		final String expectedTitle="Amazon.com: Online Shopping for Electronics, "
				+ "Apparel, Computers, Books, DVDs & more";
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("title is correct");
		}else {
			System.out.println("title is NOT correct");
		}
		
		
	}

}

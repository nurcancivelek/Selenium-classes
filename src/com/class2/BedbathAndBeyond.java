package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BedbathAndBeyond {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.bedbathandbeyond.com");
		
		driver.findElement(By.cssSelector("span[class^=Header]")).click();
	}

}

package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yahoo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.yahoo.com");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Mail")).click();
		driver.findElement(By.cssSelector("input#login-username")).sendKeys("nrcnc");
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		driver.close();
	}

}

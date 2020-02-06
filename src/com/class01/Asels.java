package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asels {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://facebook.com");
		
	//verify the title if it is correct!@
		String expectedTitle="Facebook - Log In or Sign Up";
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			driver.findElement(By.name("email")).sendKeys("vcivelek@yahoo.com");
			driver.findElement(By.name("pass")).sendKeys("1453mate");
			driver.findElement(By.cssSelector("input[type='submit']")).click();
			
		}else {
			System.out.println("Titles are not matching");
		}
		
		
	}

}

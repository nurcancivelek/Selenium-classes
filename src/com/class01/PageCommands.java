package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("http:/google.com");
		final String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		//System.out.println(actualTitle);
		if(expectedTitle.contentEquals(actualTitle)) {
			System.out.println("I am on the right page");
		}else {
			System.err.println("The actual and expected title did not match");
		}
		System.out.println(actualTitle);
        driver.close();

		
	}

}

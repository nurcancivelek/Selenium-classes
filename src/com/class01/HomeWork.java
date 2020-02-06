package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://facebook.com");
		if(driver.getTitle().equals("Facebook - Log In or Sign Up")) {
			System.out.println("login page - passed");
		}else {
			System.out.println("login page - failed");
		}
		
		
		
	}

}

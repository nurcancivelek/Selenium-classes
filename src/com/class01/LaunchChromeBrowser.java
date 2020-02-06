package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchChromeBrowser {

	public static void main(String[] args) {
		//system is a class. setProperty(); is a static method
		
								//KEY						VALUE
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//webdriver is an interface so we cannot create an object of an interface
		//thats why we create chromedriver or gecko driver....
		ChromeDriver driver1=new ChromeDriver();//works only for chrome. for
		//firefox,we need to create another object.
		WebDriver driver= new ChromeDriver();
		
		//get(String) method is to go to that web site
		//http--> hypertext transfer protocol
		driver.get("https://google.com");	
		//Thread.sleep(2000);
		
		//browser navigation commands to, back, forward
		driver.navigate().to("http:/www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		//driver.getTitle()==returns a string. gets the title of the webpage
		
		//driver.close();
		
		
	}
}

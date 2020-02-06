package com.class3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {

	public static void main(String[] args)  {

		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("the size of the list of the links: "+links.size());
		
		for(WebElement amazonlinks : links) {
			String amazonAllLinks= amazonlinks.getText();
		
			if(!amazonAllLinks.isEmpty()) {
				System.out.println(amazonAllLinks);
			}
		}
		
		
		
	}

}

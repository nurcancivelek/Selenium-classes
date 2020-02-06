package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommands {

	
		

		public static void main(String[] args) throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	        WebDriver driver=new ChromeDriver();
	        
	        //http--> hypertext transfer protocol 
	        driver.get("http://google.com");
	        Thread.sleep(1000);
	        
	        //browser navigation commands.
	        
	        //it will navigate to a given url
	        driver.navigate().to("http://www.facebook.com");
	        driver.findElement(By.linkText("Forgot account?")).click();
	        driver.navigate().to("http://www.facebook.com");
	        driver.navigate().forward();
	        //it will navigate one step forward.
	        Thread.sleep(2000);
	        
	        
	        
//	        //it will navigate back
	        driver.navigate().back();
	        Thread.sleep(2000);
	        driver.navigate().refresh();
	        
	    }


	}



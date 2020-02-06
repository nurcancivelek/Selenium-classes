package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
	     
		 WebDriver driver=new ChromeDriver();
	     
	    driver.navigate().to("https://www.syntaxtechs.com/");
	    driver.navigate().to("https://www.google.com/");
	    driver.navigate().back();
	    driver.navigate().refresh();
	     
	    String expectedTitle="Syntax";
	    String actualTitle=driver.getTitle();
	     
	    if(expectedTitle.equals(actualTitle)) {
	      System.out.println("The actual and expected Title matched");
	    }else {
	      System.err.println("The actual and expected Title did not match");
	    }	      
	    driver.close();

}
}

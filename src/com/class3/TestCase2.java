package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
	
	/*
	 * TC 2: HRMS Application Negative Login:
	 *  1.Open chrome browser2
	 *  .Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	 *  3.Enter valid username
	 *  4.Leave password field empty
	 *  5.Verify error message with text “Password cannot be empty” is displayed.
	 */

	//public static final String URL="http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		//driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		String errorMessage=error.getText();
		if(errorMessage.contentEquals("Password cannot be empty")){
			System.out.println("correct error msg is displayed");
		}else {
			System.out.println("this arror msg is not ok");
		}
		

	}

}

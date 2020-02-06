package com.class2;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class XpathDemo {

		public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

			WebDriver driver = new ChromeDriver();

			driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login\\\\n");

			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
			
			driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
			
			driver.findElement(By.xpath("//input[@value='LOGIN']")).click();


			//input[@type='text']
			//form[starts-with(@action,'/human resource')]
			//h1[text()='A place where knowledge becomes a career']
			//h1[contains(text(),'Syntax')]
			//input[@type='hidden' and @name='actionID']
			//input[@type='hidden' or @name='actionID']

		}

}

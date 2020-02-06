package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class AddEmployee extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Add Employee
		Open chrome browser
		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
		Login into the application
		Add Employee
		Log out 
		Quit the browser
		 */
		
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		//driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Nur");
		driver.findElement(By.id("lastName")).sendKeys("Can");
		driver.findElement(By.id("employeeId")).sendKeys("12345");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(1000);
		driver.close();
	}
}

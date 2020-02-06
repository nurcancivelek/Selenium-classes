package com.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HW extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.id("txtUsername")).sendKeys("Syntax");
		driver.findElement(By.id("txtPassword")).sendKeys("Syntax123!");
		driver.findElement(By.id("btnLogin")).submit();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait4=new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Employee']")));
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Fatma");
		
		driver.findElement(By.name("lastName")).sendKeys("HZ");
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).submit();
		
		driver.findElement(By.xpath("//a[text()='Welcome Syntax']")).click();
		
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
		
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
		}
	}
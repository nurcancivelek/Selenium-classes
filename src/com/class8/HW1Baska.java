package com.class8;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW1Baska extends CommonMethods {
	
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//***GOTO ADD PAGE***
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Employee']")));
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		//***ADD EMPLOYEE***
		driver.findElement(By.id("firstName")).sendKeys("Kesin");
		driver.findElement(By.id("middleName")).sendKeys("Bilgi");
		driver.findElement(By.id("lastName")).sendKeys("Yayalim");
		driver.findElement(By.id("employeeId")).sendKeys("27513");
		driver.findElement(By.id("btnSave")).click();
		
		//***REFRESH EMPLOYEE LIST***
		WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		driver.manage().window().maximize();
		//***FIND and DELETE ADDED EMPLOYEE***
		String targettext="Kesin Bilgi Yayalim";
		WebDriverWait wait5=new WebDriverWait(driver, 10);
		wait5.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='table hover']/tbody/tr")));
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i=0; i<rows.size(); i++) {
			String target=rows.get(i).getText();
			if(target.contains(targettext)) {
				driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr[" + (i+1) + "]/td[1]")).click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		Thread.sleep(3000);
		
		//***VERIFY DELETE***
		List<WebElement> checkrows= driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr"));
		for (int i=1; i<checkrows.size(); i++) {
			String target=checkrows.get(i).getText();
	
		if(target.contains(targettext)) {
				System.out.println(targettext + " delete failure");
		}
		else {
			System.out.println(targettext  + " has been deleted");
			break;
		}
		}
		
		Thread.sleep(4000);
		driver.quit();
	}
}



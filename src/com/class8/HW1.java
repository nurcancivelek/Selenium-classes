package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW1 extends CommonMethods {
	/*
	 * TC 1: Delete Employee

		Open chrome browser
		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
		Login into the application
		Add Employee
		Verify Employee has been added
		Go to Employee List
		Delete added Employee
		Quit the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add Employee")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		driver.findElement(By.id("firstName")).sendKeys("Kesinnn");
		driver.findElement(By.id("middleName")).sendKeys("Bilginnn");
		driver.findElement(By.id("lastName")).sendKeys("Yayalimnnn");
		driver.findElement(By.id("employeeId")).sendKeys("275133");
		driver.findElement(By.id("btnSave")).click();
		String id="27513";
		if(driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed()){
		id= driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		System.out.println(id+" is added!");
		}else {
			System.out.println("Employee is not added");
		}

		driver.findElement(By.linkText("Employee List")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
		//String expectedValue="Kesin Bilgi";
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));	
		int i=0;
		for(i=1; i<rows.size(); i++) {
			WebElement row=rows.get(i);
			if(row.getText().contains("27513")) {
				WebElement cb=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]"));
						//row.findElement(By.tagName("input"));
				cb.click();
				if(!cb.isSelected()) {
					cb.click();
				}
//					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
//					System.out.println("button clicked");
//					break;
				
			WebElement dlt=driver.findElement(By.id("btnDelete"));
			if(dlt.isEnabled()) {
			dlt.click();
			Thread.sleep(6000);
			driver.findElement(By.id("dialogDeleteBtn")).click();
			System.out.println(id+" employee is deleted");
			}
			else {
				System.out.println(id+" employee not deleted");
			}
			break;
	}else {
		if(i==rows.size()-1) {
			driver.findElement(By.xpath("//a[text()='Next']")).click();
			i=0;
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
			rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			
	        }
		 }
	  }
   }
}
			
			
		
		
		



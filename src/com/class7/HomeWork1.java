package com.class7;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class HomeWork1 extends CommonMethods {

	public static void main(String[] args) {
		/*
		 * TC 2: Verify element is clickable

		Open chrome browser
		Go to “https://the-internet.herokuapp.com/”
		Click on “Click on the “Dynamic Controls” link
		Select checkbox and click Remove
		Click on Add button and verify “It’s back!” text is displayed
		Close the browser 
		 */

		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		WebElement selected=driver.findElement(By.cssSelector("input[type='checkbox']"));
		System.out.println(selected.isSelected());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		//call method getScrrenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/elementClickable2.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		boolean hello=driver.findElement(By.id("message")).isDisplayed();
		if(hello) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		
		driver.close();
		
	}

}

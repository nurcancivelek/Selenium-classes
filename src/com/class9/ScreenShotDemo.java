package com.class9;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ScreenShotDemo extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", Constants.HRMS_URL);
		String userName="Admin";
		String password="Hum@nhrm123";
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		String welcomeText= driver.findElement(By.id("welcome")).getText();
		
		if (welcomeText.contains(userName)) {
			System.out.println("Test pass");
		}else {
			System.out.println("test fail");
		}
		//how to take screenshot using selenium?
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		//call method getScrrenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/AdminLogin.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		driver.quit();
		
	}
}

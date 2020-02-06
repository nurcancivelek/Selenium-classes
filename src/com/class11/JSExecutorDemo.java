package com.class11;

import org.openqa.selenium.*;
import com.utils.CommonMethods;
import com.utils.Constants;
/*
 * navigate to the hrms 
 * enter uid and pwd
 * click on login btn using JSexecutor
 */

public class JSExecutorDemo extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='green'", loginBtn);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,22050)");
		Thread.sleep(5000);
		driver.quit();
	}
}
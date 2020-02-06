package com.class9;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Alert extends CommonMethods {
	
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.toolsqa.com/automation-practice-switch-windows/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("timingAlert")));
		driver.findElement(By.id("timingAlert")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = (Alert) driver.switchTo().alert();
		((org.openqa.selenium.Alert) alert).accept();
		Thread.sleep(5000);
		driver.quit();
	}

}

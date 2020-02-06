package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC1 extends CommonMethods {
	
	public static void main(String[] args) {
//		TC 1: HRMS Login
//
//		Navigate to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
//		Login to the application by writing xpath based on “parent and child relation”

		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();
		
		Actions act=new Actions(driver);
		WebElement pim=driver.findElement(By.linkText("PIM"));
		act.moveToElement(pim).perform();
		WebElement add=driver.findElement(By.linkText("Add Employee"));
		act.click(add).perform();
		
	}

}

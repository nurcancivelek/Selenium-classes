package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import com.class10.SouthWest;
import com.utils.CommonMethods;

public class Homework  extends CommonMethods{
	
	public static void main(String[] args) {
		setUp("chrome","http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys("/Users/vcivelek/Desktop/Selenium1.pdf");
		driver.findElement(By.xpath("//button[@class='gwt-Button']")).click();
		
		Alert alert=driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println(alerttext);
		alert.accept();
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		//call method getScrrenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/fileupload.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
//		WebElement uploaded = driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
//        if (uploaded.isDisplayed()) {
//            System.out.println("file successfully uploaded");
//        } else {
//            System.out.println("File is not uploaded");
//        }
        driver.quit();

		
	}

}

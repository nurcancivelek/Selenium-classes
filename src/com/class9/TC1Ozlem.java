package com.class9;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.utils.CommonMethods;
public class TC1Ozlem extends CommonMethods {
//	TC 1: Table headers and rows verification
//	1.Open chrome browser
//	2.Go to “https://www.aa.com/homePage.do”
//		3.Enter From and To
//		4.Select departure as May 14 of 2020
//		5.Select arrival as November 8 of 2020
//		6.Verify “Choose flights” text is displayed
//		7.Close browser
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.aa.com/homePage.do");
		switchToFrame(driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/ul/li[1]/a")));
		driver.findElement(By.xpath("//*[@id=\'reservationFlightSearchForm.destinationAirport\']")).click();
		driver.findElement(By.xpath("//*[@id=\'reservationFlightSearchForm.destinationAirport\']")).sendKeys("NYC");
		Thread.sleep(2000);
		// choose depart day-- easy way
		driver.findElement(By.xpath("//*[@id=\"aa-leavingOn\"]")).sendKeys("05/14/2020");
		// choose return date--serious way
		driver.findElement(By.xpath("//input[@id='aa-returningFrom']")).click();
		List<WebElement> ay = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
		for (WebElement mon : ay) {
			if (mon.getText().equalsIgnoreCase("November")) {
				mon.click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> num = driver.findElements(By.xpath("/html/body/div[8]/div[1]/table/tbody"));
		for (WebElement no : num) {
			if (no.getText().equalsIgnoreCase("8")) {
				no.click();
				break;
			}
		}
		Thread.sleep(3000);
		TakesScreenshot shot = (TakesScreenshot) driver;
		File shoot = shot.getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		try {
			FileUtils.copyFile(shoot, new File("screenshots/americanA.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
		driver.close();
	}
}

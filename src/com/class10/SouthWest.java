package com.class10;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
public class SouthWest extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.southwest.com");
		driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode")).sendKeys("RDU");
		driver.findElement(By.id("LandingAirBookingSearchForm_destinationAirportCode")).sendKeys("LAX");
		
		driver.findElement(By.id("LandingAirBookingSearchForm_departureDate")).click();
		
		boolean flag=false;
		
		while(!flag) {
			String depmonth=driver.findElement(By.xpath("//div[@class='calendar-month']/div[1]")).getText();
			System.out.println(depmonth);
			if(depmonth.equals("June 2020")) {
				
				List<WebElement> days= driver.findElements(By.xpath("//div[@class='calendar-month']/div[10]"));
				for(WebElement day:days) {
					String dayText = day.getText();
					if(dayText.equals("15")) {
						day.click();
						flag=true;
						break;
					}
				}
				
			}else {
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			}
		}
		
		driver.findElement(By.id("LandingAirBookingSearchForm_returnDate")).click();
		while(!flag) {
			String month=driver.findElement(By.xpath("//div[@class='calendar-month calendar-month_last-month']/div[1]")).getText();
			System.out.println(month);
			if(month.equals("August 2020")) {
				
				List<WebElement> days= driver.findElements(By.xpath("//div[@class='calendar-month']/div[10]"));
				for(WebElement day:days) {
					String dayText = day.getText();
					if(dayText.equals("25")) {
						day.click();
						flag=true;
						break;
					}
				}
				break;
			}else {
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			}
		}
		
		
		
	}

}

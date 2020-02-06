package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class AmericanAirlines extends CommonMethods{
	
	public static void main(String[] args) {
		
		setUp("chrome", "https://www.aa.com/homePage.do");
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
		
		driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("LAX");
		driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("OGG");
		Select select=new Select(driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount")));
		select.selectByVisibleText("4");
		
		driver.findElement(By.id("aa-leavingOn")).click();
		
		boolean flag=false;
		
		// From
		while(!flag) {
			String month=driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div")).getText();
			System.out.println(month);
			if(month.equals("June 2020")) {
				List<WebElement> daysOfMonth=driver.findElements(By.xpath("//div[contains(@class, 'ui-corner-left')]/following-sibling::table/tbody/tr/td"));
				for(WebElement days:daysOfMonth) {
					String daysText=days.getText();
					if(daysText.equals("15")) {
						days.click();
						flag=true;
						break;
					}
				}
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}			
		}
		
		driver.findElement(By.id("aa-returningFrom")).click();
		flag=false;
		// To
		while(!flag) {
			String month=driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-right')]/div")).getText();
			System.out.println(month);
			if(month.equals("August 2020")) {
				List<WebElement> daysOfMonth=driver.findElements(By.xpath("//div[contains(@class, 'ui-corner-right')]/following-sibling::table/tbody/tr/td"));
				for(WebElement days:daysOfMonth) {
					String daysText=days.getText();
					if(daysText.equals("15")) {
						days.click();
						flag=true;
						break;
					}
				}
			}else {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}			
		}
		
		driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
		
		String sorry= driver.findElement(By.xpath("//div[@class='outerContainer']")).getText();
		System.out.println(sorry);
		if (sorry.contains("We're working on our site")) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
		
		
	}

}

package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookDD {
	
	/*
	 * TC 1: Facebook dropdown verification
	 * 1.Open chrome browser
	 * 2.Go to “https://www.facebook.com”
	 * 3.Verify:●month dd has 12 month options●day dd has 31 day options●year dd has 115 year options
	 * 4.Select your date of birth
	 * 5.Quit browser
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println("months::");
		WebElement month=driver.findElement(By.id("month"));
		Select select=new Select(month);
		//System.out.println(month.getText());
		List<WebElement> options = select.getOptions();
		Thread.sleep(1000);
		select.selectByVisibleText("Apr");
		
		
		System.out.println("days;;");
		
		System.out.println(options.size());
		WebElement day=driver.findElement(By.id("day"));
		Select selectd=new Select(day);
		List<WebElement> days = selectd.getOptions();
		System.out.println(days.size());
		Thread.sleep(1000);
		selectd.selectByVisibleText("1");
		System.out.println("years::");
		WebElement year=driver.findElement(By.id("year"));
		Select selecty=new Select(year);
		List<WebElement> years = selecty.getOptions();
		System.out.println(years.size());
		Thread.sleep(2000);
		selecty.selectByVisibleText("1981");
		Thread.sleep(2000);
		driver.close();

	}

}

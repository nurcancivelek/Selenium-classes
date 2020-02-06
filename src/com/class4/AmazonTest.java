package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonTest {
	/*
	 * TC 1: Amazon Department List Verification
	 * 1.Open chrome browser
	 * 2.Go to “http://amazon.com/”
	 * 3.Verify how many department options available.●Print each department ●Select Computers
	 * 4.Quit browser
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com/");
		WebElement links=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(links);
		List<WebElement> amazonlinks=select.getOptions();
		System.out.println(amazonlinks.size());
		System.out.println(links.getText());
		
		
		select.selectByVisibleText("Computers");
		
//		for(WebElement element:amazonlinks) {
//			String comps=element.getText();
//			System.out.println(comps);
//			if(comps.equals("Computers")) {
//				element.click();
//				Thread.sleep(1000);
//			}

	//}
	}
}

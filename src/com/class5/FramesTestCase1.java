package com.class5;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class FramesTestCase1  extends CommonMethods{
	/*
	 * TC 1: Syntax Frame verification
	 * 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Others” link
	 * 4.Click on “Iframe” link
	 * 5.Click on the “Home” link inside the one frame
	 * 6.Verify “Syntax logo” is displayed in another frame
	 * 7.Quit browser
	 */

	public static final String Syntax_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Syntax_URL);
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		String inFrame=driver.findElement(By.xpath("//h4[text()='Practice Selenium Automation Testing Online']")).getText();
		
		System.out.println("indise frame 1:"+inFrame);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(1);
		boolean syntax=driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div/a/img")).isDisplayed();
		
	}
}

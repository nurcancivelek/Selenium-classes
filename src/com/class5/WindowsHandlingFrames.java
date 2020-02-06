package com.class5;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.class4.CommonMethods2;

public class WindowsHandlingFrames extends CommonMethods2{
	
	/*
	 * TC 1: Windows Handling
	 * 1.Open chrome browser
	 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
	 * 3.Click on “Javascript Alerts” link
	 * 4.Click on “Window Popup Modal” link
	 * 5.Click on the “ Follow On Instagram” button
	 * 6.Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos”
	 * 7.Click on the “Like us On Facebook ” button
	 * 8.Verify title of the page is “Go to Facebook Home” 
	 * 9.Quit the browser
	 * NOTE: Selenium execution could be too fast, please use Thread.sleep
	 */

	public static final String Syntax_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		CommonMethods2.setUp("chrome", Syntax_URL);
		driver.findElement(By.linkText("Alerts & Modals")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Window Popup Modal")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Follow On Instagram")).click();
		
		Thread.sleep(2000);
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println(allWindows.size());
		
		Iterator<String> it=allWindows.iterator();
		String parent=it.next();
		String child=it.next();
		
		driver.switchTo().window(child);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		//driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[2]/a/button")).click();
		//driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		driver.findElement(By.linkText("like us On Facebook")).click();
		
		Thread.sleep(2000);
		Set<String> allWindows2=driver.getWindowHandles();
		System.out.println(allWindows2.size());
		
		Iterator<String> it2=allWindows2.iterator();
		String parent2=it2.next();
		String child2=it2.next();
		driver.switchTo().window(child2);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}
}

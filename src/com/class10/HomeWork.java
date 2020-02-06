package com.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class HomeWork  extends CommonMethods{
	
//	TC 1: Drag and Drop verification1.Open chrome browser
//	2.Go to “https://jqueryui.com/”
//	3.Click on “Droppable” link
//	4.Using mouse drag “Drag me to my target” to the “Drop Here”
//	5.Close the browser
	
	public static void main(String[] args) {
		setUp("chrome", "https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(drag,drop).perform();
		
		if(drop.findElement(By.xpath("//div[@id='droppable']/p")).getText().equals("Dropped!")) {
			System.out.println("dragged and dropped!");
		}else {
			System.out.println("no drag no drop!");
			
		}
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		//call method getScrrenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/drapndrop.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		
		
		
		
		
	}

}

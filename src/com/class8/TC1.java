package com.class8;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class TC1 extends CommonMethods {

	public static void main(String[] args) {
		
		/*
		 * TC 1: Table headers and rows verification

		Open chrome browser
		Go to “http://166.62.36.207/syntaxpractice/”
		Click on “Table” link
		Click on “ITable Data Search” link
		Verify second table consist of 4 rows and 5 columns
		Print name of all column headers 
		Print data of all rows
		Quit Browser

		 */

		setUp("chrome", "http://166.62.36.207/syntaxpractice/" );
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("# of row in the table is= "+rows.size());
		for(WebElement row:rows) {
			System.out.println(row.getText());
		}
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		System.out.println("# of columns in the table is= "+cols.size());
		for(WebElement col: cols) {
			System.out.println(col.getText());
		}
		/*
		 * xpath("//table[@class='table']/tbody/tr/td" 1. //table[@class='table'] -
		 * table element 2. /tbody - from table going inside tbody 3. tr/ from tbody
		 * going into rows (not specific row) 4. /td - going into table data --> cell
		 */
		System.out.println("---------Printing cell by cell using for each loop------------");
		List<WebElement> cells=driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
		System.out.println("# of cells in the table is= "+rows.size());
		for(WebElement cell:cells) {
			System.out.println(cell.getText());
		}
		TakesScreenshot ts=(TakesScreenshot) driver;
		//call method getScrrenshotAs and specify output type
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen,  new File("screenshots/HRMS/Table.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------Printing data cell by cell using for loop---------");
		for(int i=1; i<=rows.size(); i++) {//conrolling rows
			for(int y=1; y<=cols.size(); y++) {//controlling columns
				WebElement cellText=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]"));
				System.out.println(cellText.getText());
				
				//String celltext =..... yazip sonuna .getText() de olur. o zaman sout(cellText yazariz saace)
				//String cellText=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]")).getText();
				//System.out.println(cellText);
				//gibi.....
			}
		}
	}			
}



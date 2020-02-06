package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo2 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", Constants.Syntax_URL);
		//navigate to the table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//find how many rows of data table has
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("# of row in the table is= "+rows.size());
		
		System.out.println("Printing row data----------");
		Iterator<WebElement> rowsIt=rows.iterator();
		while(rowsIt.hasNext()) {
			String rowData=rowsIt.next().getText();
			System.out.println(rowData);
		}
		
		//number of columns
		List<WebElement> columns=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("# of columns in the table is= "+columns.size());
		
		System.out.println("Printing column headers--------");
		for(WebElement col: columns) {
			String header=col.getText();
			System.out.println(header);
		}
		
	}

}

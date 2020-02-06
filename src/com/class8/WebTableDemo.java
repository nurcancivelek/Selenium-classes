package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/table-search-filter-demo.html");
		//get number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("# of the rows "+rows.size());
		System.out.println("-----row data-----");
		Iterator<WebElement> it=rows.iterator();
		while(it.hasNext()) {
			String rowtext=it.next().getText();
			System.out.println(rowtext);
			
		}
		//get number of columns
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='table']/head/tr/th"));
		System.out.println("# of columns : "+cols.size());
		System.out.println("------columns headers------");
		for(WebElement col:cols) {
			String coltext=col.getText();
			System.out.println(coltext);
		}
		driver.close();
	}

}

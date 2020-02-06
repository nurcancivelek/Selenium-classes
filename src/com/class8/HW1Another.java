package com.class8;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.CommonMethods;
public class HW1Another extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).submit();
        driver.findElement(By.xpath("//b[text()='PIM']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_pim_addEmployee"))));
        
        
        
        
//        for(int i=0;i<250;i++) {        
//	        //Adding a new Employee
//	        driver.findElement(By.id("menu_pim_addEmployee")).click();
//	        driver.findElement(By.id("firstName")).sendKeys("Ali_"+i);
//	        driver.findElement(By.id("lastName")).sendKeys("Veli_"+i);
//	        String eID = driver.findElement(By.id("employeeId")).getAttribute("value");
//	        System.out.println("An employee with id " + eID + " is added.");
//	        driver.findElement(By.id("btnSave")).click();
//        }
        
        //Deleting the employee     
//        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
//        boolean isFound = false;
//        while(!isFound) {
//            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));
//            
//            for(int i=1;i<rows.size();i++) {
//                WebElement row = driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+(i)+"]/td[2]"));
//            
//                String eIDRow = row.getText();
//                
//                if(eIDRow.equals(eID)) {
//                    
//                    driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+i+"]/td[1]")).click();
//                    driver.findElement(By.id("btnDelete")).submit();
//                    System.out.println("The employee with id " + eIDRow + " is deleted.");
//                    isFound = true;
//                    break;
//                }
//            }
//            
//            driver.findElement(By.xpath("//a[text()='Next']")).click();
//        }
        
//        driver.quit();
        
    }
}
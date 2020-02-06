package com.class8;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.CommonMethods;
import com.utils.Constants;
public class HW1Tilda extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        // open chrome browser, go to HRMS Link
        setUp("Chrome", Constants.HRMS_URL);
        // add scroller to find delete button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // enter username
        driver.findElement(By.id("txtUsername")).sendKeys("Syntax");
        // enter password
        driver.findElement(By.id("txtPassword")).sendKeys("Syntax123!");
        // click login
        driver.findElement(By.id("btnLogin")).click();
        // click on PIM
        driver.findElement(By.linkText("PIM")).click();
        // add wait webdriver
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // initialize
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Add Employee"))));
        // click on Add Employee
        driver.findElement(By.linkText("Add Employee")).click();
        // add name and lastName
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("yyyyyy");
        driver.findElement(By.id("lastName")).sendKeys("xxxxxx");
        driver.findElement(By.id("employeeId")).clear();
        driver.findElement(By.id("employeeId")).sendKeys("99999999");
        // click save
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2000);
        // personal Details page shows, means employee was added
        if (driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed()) {
            String idEntered = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
            System.out.println("Employee with ID: " + idEntered + " is entered Successfully");
        } else {
            System.out.println("Employee was not entered");
        }
        // find the added employee from the list then delete
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        String nameSent = "John Smith";
        String idSent = "99999999";
        String rowText="";
        int rowsPerPage = 0;
        do {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            rowsPerPage = tableRows.size();
            for (int i = 1; i <= tableRows.size(); i++) {
                rowText = tableRows.get(i - 1).getText();
                if (rowText.contains(idSent)) {
                //add wait
                    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")));
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
                    Thread.sleep(2000);
                    WebElement delBtn = driver.findElement(By.xpath("//input[@id='btnDelete']"));
                    js.executeScript("arguments[0].scrollIntoView();", delBtn);
                    delBtn.click();
                    Thread.sleep(2000);
//                      Alert alert1=driver.switchTo().alert();
//                      alert1.accept();
                    driver.findElement(By.id("dialogDeleteBtn")).click();
                    System.out.println("Employee deleted!");
                    break;
                }
            }
            driver.findElement(By.xpath("//a[text()='Next']")).click();
        } while (!rowText.contains(idSent) );
        // click welcome menu to find logout button
//      driver.findElement(By.id("welcome")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.linkText("Logout")).click();
//      Thread.sleep(2000);
        driver.close();
    }
}
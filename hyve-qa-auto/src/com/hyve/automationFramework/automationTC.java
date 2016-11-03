package com.hyve.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.hyve.pageObjects.Home_Page;

import com.hyve.utility.Constant;

import com.hyve.utility.ExcelUtils;

import com.hyve.appModules.SignIn_Action;

public class automationTC {
	
	private static WebDriver driver = null;
	 
	public static void main(String[] args) throws Exception {

    //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method

    ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

    driver = new FirefoxDriver();
    
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get(Constant.URL);

    SignIn_Action.Execute(driver);
        
    System.out.println("Login Successfully, now it is the time to Log Off buddy.");
    
    //driver.findElement(By.className("logout-header")).click();

    Home_Page.lnk_LogOut(driver).click();
       
    //driver.quit();

    //This is to send the PASS value to the Excel sheet in the result column.

    ExcelUtils.setCellData("Pass", 1, 3);

	}

}

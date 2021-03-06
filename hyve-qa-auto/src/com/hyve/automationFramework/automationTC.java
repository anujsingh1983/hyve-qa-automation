package com.hyve.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.hyve.pageObjects.Home_Page;
import com.hyve.priceVerification.LoginPriceVerification;
import com.hyve.utility.Constant;
import com.hyve.pageObjects.productHyve;
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

   // SignIn_Action.Execute(driver);
    LoginPriceVerification.Execute(driver);
        
    System.out.println("Login Successfully, now it is the time to Log Off buddy.");
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    //driver.findElement(By.className("logout-header")).click();
    
    productHyve.storm(driver).click();
    productHyve.Buy_storm(driver).click();
    String StormPrice = driver.findElement(By.xpath("//div[@class='price-rate']")).getText();
    System.out.println(StormPrice);

   // Home_Page.lnk_LogOut(driver).click();
    
    //System.out.println("Logout Successfully.");
       
    //driver.quit();

    //This is to send the PASS value to the Excel sheet in the result column.

    ExcelUtils.setCellData("Pass", 1, 3);
    ExcelUtils.setCellData(StormPrice, 1, 4);

	}

}
